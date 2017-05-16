--对ddl进行监控

DROP TABLE VJSP_MONITOR_SQL_LOG;
CREATE TABLE VJSP_MONITOR_SQL_LOG(
  ID VARCHAR2(40) PRIMARY KEY,
  SQL_LOG VARCHAR2(4000),
  OPERATION VARCHAR2(200),
  CDATE TIMESTAMP
);
--字符串分割表类型
CREATE OR REPLACE TYPE VJSP_MONITOR_SPLITSTR_TYPE IS TABLE OF VARCHAR2 (4000);

--字符串分割
CREATE OR REPLACE FUNCTION VJSP_MONITOR_SPLITSTR
(
 V_SRC VARCHAR2,
 V_SPLITCHAR VARCHAR2:=','
)
RETURN VJSP_MONITOR_SPLITSTR_TYPE PIPELINED
IS
V_STR VARCHAR2(4000):=V_SRC;
V_S  VARCHAR2(4000);
V_INDEX INTEGER;
BEGIN
   LOOP
   V_INDEX:= INSTR(V_STR,V_SPLITCHAR);
   EXIT WHEN NVL(V_INDEX,0)<=0;
   V_S := SUBSTR(V_STR,1,V_INDEX-1);
   PIPE ROW(V_S);
   V_STR :=  SUBSTR(V_STR,V_INDEX+1);
   END LOOP;
   PIPE ROW(V_STR);
   RETURN;
  END
  ;



--监控所有dll语句
CREATE OR REPLACE TRIGGER VJSP_MONITOR_DLL_TRIGGER
  AFTER DDL ON DATABASE
DECLARE
  sql_text ora_name_list_t;
  n PLS_INTEGER;
  v_stmt VARCHAR2(4000);
BEGIN
  n := ora_sql_txt(sql_text);
  FOR i IN 1..n LOOP
    v_stmt := v_stmt || sql_text(i);
  END LOOP;
    INSERT INTO SQL_LOG(ID,SQL_LOG,CDATE,OPERATION) VALUES(F_GETNID(),v_stmt,SYSDATE,'DDL');
  EXCEPTION
  WHEN OTHERS THEN
     DBMS_OUTPUT.PUT_LINE('ERROT:'||V_STMT);
END;


--函数--参数:表名大写
--返回值:表的更新语句,前置条件:表必须有主键
CREATE OR REPLACE FUNCTION VJSP_MONITOR_GETSQL_UPDATE
(V_TABLE_NAME IN VARCHAR2)
RETURN VARCHAR2 IS
  V_SQL  VARCHAR2(4000):='';
  V_SET VARCHAR2(4000):='';
    V_WHERE VARCHAR2(4000):='';
BEGIN
  FOR V_CUR1 IN (SELECT T1.COLUMN_NAME ,CASE WHEN EXISTS(SELECT 1 FROM   user_cons_columns A, user_constraints B WHERE A.constraint_name = B.constraint_name  AND B.constraint_type='P' AND A.column_name=T1.COLUMN_NAME AND A.table_name=T1.TABLE_NAME) THEN 1 ELSE 0 END PK_BJ
FROM USER_TAB_COLUMNS T1
WHERE T1.TABLE_NAME=V_TABLE_NAME ORDER BY T1.COLUMN_ID  )
LOOP
    V_SET := V_SET||V_CUR1.COLUMN_NAME||'=:NEW.'||V_CUR1.COLUMN_NAME||',';
    IF V_CUR1.PK_BJ = 1 THEN
    V_WHERE := V_WHERE||V_CUR1.COLUMN_NAME||'=:NEW.'||V_CUR1.COLUMN_NAME||' AND ';
    END IF;
  END LOOP;
  V_SET:=rtrim(rtrim(V_SET),',');
  V_WHERE:=rtrim(rtrim(V_WHERE),'AND');
 V_SQL:= 'UPDATE '||V_TABLE_NAME||' SET '||V_SET||' WHERE '||V_WHERE;
  RETURN V_SQL;
END;
/

--获得删除语句
CREATE OR REPLACE FUNCTION VJSP_MONITOR_GETSQL_DELETE
(V_TABLE_NAME IN VARCHAR2)
RETURN VARCHAR2 IS
  V_SQL  VARCHAR2(4000):='';
    V_WHERE VARCHAR2(4000):='';
BEGIN
  FOR V_CUR1 IN (SELECT A.column_name FROM user_cons_columns A, user_constraints B WHERE A.constraint_name = B.constraint_name  AND B.constraint_type='P' AND A.table_name=V_TABLE_NAME)
LOOP
    V_WHERE := V_WHERE||V_CUR1.COLUMN_NAME||'=:OLD.'||V_CUR1.COLUMN_NAME||' AND ';
  END LOOP;
  V_WHERE:=rtrim(rtrim(V_WHERE),'AND');
 V_SQL:= 'DELETE FROM '||V_TABLE_NAME||' WHERE '||V_WHERE;
  RETURN V_SQL;
END;
/
--获得insert语句
CREATE OR REPLACE FUNCTION VJSP_MONITOR_GETSQL_INSERT
(V_TABLE_NAME IN VARCHAR2)
RETURN VARCHAR2 IS
  V_SQL  VARCHAR2(4000):='';
  V_COLUMNS VARCHAR2(4000):='';
    V_VALUES VARCHAR2(4000):='';
BEGIN
  FOR V_CUR1 IN (SELECT T1.COLUMN_NAME FROM USER_TAB_COLUMNS T1 WHERE T1.TABLE_NAME=V_TABLE_NAME ORDER BY T1.COLUMN_ID  )
LOOP
    V_COLUMNS := V_COLUMNS||V_CUR1.COLUMN_NAME||',';
    V_VALUES := V_VALUES||':NEW.'||V_CUR1.COLUMN_NAME||',';
  END LOOP;
  V_COLUMNS:=rtrim(rtrim(V_COLUMNS),',');
  V_VALUES:=rtrim(rtrim(V_VALUES),',');
 V_SQL:= 'INSERT INTO '||V_TABLE_NAME||'('||V_COLUMNS||') VALUES ('||V_VALUES||')';
  RETURN V_SQL;
END;

---执行trigger的存储过程

CREATE OR REPLACE PROCEDURE VJSP_MONITOR_CREATE_TRIGGER(V_TABLE_NAMES IN VARCHAR2)
IS
V_TABLE_NAME VARCHAR2(200):='';
V_TRIGGER_SQL  VARCHAR2(4000):='';
V_TRIGGER_COUNT  VARCHAR2(200):='';
BEGIN
    FOR CUR1 IN (SELECT COLUMN_VALUE AS TABLE_NAME FROM TABLE(VJSP_MONITOR_SPLITSTR(V_TABLE_NAMES)))
      LOOP
        V_TABLE_NAME :=CUR1.TABLE_NAME;
        --删除原有触发器
        select count(1) INTO V_TRIGGER_COUNT from user_triggers where table_name =V_TABLE_NAME  AND TRIGGER_NAME='VJSP_MONITOR_TRIGGER_'||V_TABLE_NAME;
        IF V_TRIGGER_COUNT>0 THEN
           dbms_utility.exec_ddl_statement( 'DROP TRIGGER VJSP_MONITOR_TRIGGER_'||V_TABLE_NAME);
        END IF;
        --创建新的触发器
     V_TRIGGER_SQL:= 'CREATE OR REPLACE TRIGGER VJSP_MONITOR_TRIGGER_CITY
     AFTER INSERT OR DELETE OR UPDATE ON CITY
     FOR EACH ROW
     DECLARE
     V_SQL VARCHAR2(4000):="";
     V_OPER VARCHAR2(200);
     V_TABLE_NAME VARCHAR2(200):="'||V_TABLE_NAME||'";
  BEGIN
     CASE
       WHEN INSERTING THEN
         V_OPER := "INSERTING";
         V_SQL := VJSP_MONITOR_GETSQL_INSERT(V_TABLE_NAME);
      WHEN UPDATING THEN
         V_OPER :="UPDATING";
         V_SQL := VJSP_MONITOR_GETSQL_UPDATE(V_TABLE_NAME);
      WHEN DELETING THEN
        V_OPER := "DELETING";
        V_SQL := VJSP_MONITOR_GETSQL_DELETE(V_TABLE_NAME);
    END CASE;
         INSERT INTO VJSP_MONITOR_SQL_LOG(ID,SQL_LOG,CDATE,OPERATION) VALUES(F_GETNID(),V_SQL,SYSDATE,V_OPER);
    EXCEPTION
      WHEN OTHERS THEN
                dbms_output.put_line("ERROR");  --DO NOTHING
  END;';
     -- dbms_utility.exec_ddl_statement(V_TRIGGER_SQL);
     DBMS_OUTPUT.PUT_LINE(V_TRIGGER_SQL);

      END LOOP;
END;




select t.id,t.sql_log,t.operation,to_char(t.cdate,'yyyy-mm-dd hh24:mi:ss') from vjsp_monitor_sql_log t order by cdate;
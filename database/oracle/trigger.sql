CREATE OR REPLACE PROCEDURE insert_row_proc AUTHID CURRENT_USER AS
  no_remote_db EXCEPTION;  -- declare exception
  PRAGMA EXCEPTION_INIT (no_remote_db, -20000);
                           -- assign error code to exception
BEGIN
  INSERT INTO employees@remote (
    employee_id, first_name, last_name, email, hire_date, job_id
  )
  VALUES (
    99, 'Jane', 'Doe', 'jane.doe@example.com', SYSDATE, 'ST_MAN'
  );
EXCEPTION
  WHEN OTHERS THEN
    INSERT INTO emp_log (Emp_id, Log_date, New_salary, Action)
      VALUES (99, SYSDATE, NULL, 'Could not insert row.');

  RAISE_APPLICATION_ERROR (-20000, 'Remote database is unavailable.');
END;
/

CREATE OR REPLACE TRIGGER employees_tr
  AFTER INSERT ON employees
  FOR EACH ROW
BEGIN
  insert_row_proc;
END;
/

DROP TABLE SQL_LOG;
CREATE TABLE SQL_LOG(
  ID VARCHAR2(40) PRIMARY KEY,
  SQL_LOG VARCHAR2(4000),
  OPERATION VARCHAR2(200),
  CDATE TIMESTAMP
);

create OR REPLACE trigger city_insert
AFTER INSERT OR DELETE OR UPDATE ON CITY
FOR EACH ROW
  DECLARE
    V_SQL VARCHAR2(4000):='';
  BEGIN
    CASE WHEN INSERTING THEN
      V_SQL:=:NEW.ID||'--'||:NEW.NAME;
      INSERT INTO SQL_LOG(ID,SQL_LOG,CDATE,OPERATION) VALUES(F_GETNID(),V_SQL,SYSDATE,'INSERTING');

      WHEN UPDATING THEN
      V_SQL:=:NEW.ID||'--'||:NEW.NAME;
      INSERT INTO SQL_LOG(ID,SQL_LOG,CDATE,OPERATION) VALUES(F_GETNID(),V_SQL,SYSDATE,'UPDATING');
      WHEN DELETING THEN
      V_SQL:=:OLD.ID||'--'||:OLD.NAME;
      INSERT INTO SQL_LOG(ID,SQL_LOG,CDATE,OPERATION) VALUES(F_GETNID(),V_SQL,SYSDATE,'DELETING');
    END CASE;
  END;

CREATE OR REPLACE TRIGGER city_insert
AFTER INSERT OR DELETE OR UPDATE ON CITY
FOR EACH ROW
  DECLARE
      MYEXCEPTION EXCEPTION;
    PRAGMA EXCEPTION_INIT(MYEXCEPTION,-20001);
    V_SQL VARCHAR2(4000):='';
    V_OPER VARCHAR2(200);
    V_TABLE_NAME VARCHAR2(200):='CITY';
  BEGIN
    CASE WHEN INSERTING THEN
      V_OPER := 'INSERTING';
      SELECT 'INSERT INTO '||V_TABLE_NAME||'('||WM_CONCAT(T1.COLUMN_NAME)||') VALUES('||WM_CONCAT(':NEW.'||T1.COLUMN_NAME)||')' INTO V_SQL  FROM USER_TAB_COLUMNS T1 WHERE T1.TABLE_NAME=V_TABLE_NAME;


      WHEN UPDATING THEN
      V_OPER := 'UPDATING';
      SELECT PART1||PART2 INTO V_SQL FROM
        (SELECT 'UPDATE   '||V_TABLE_NAME||' SET '|| WM_CONCAT(T1.COLUMN_NAME||'=:NEW.'||T1.COLUMN_NAME) as PART1  FROM USER_TAB_COLUMNS T1 WHERE T1.TABLE_NAME=V_TABLE_NAME) ljl.section1_6.A,
        (select ' where '||replace(wm_concat(cu.column_name||'=:NEW.'||cu.column_name),',',' and ')||'' AS PART2 from user_cons_columns cu, user_constraints au where cu.constraint_name = au.constraint_name and au.constraint_type = 'P' and au.table_name = V_TABLE_NAME)ljl.section1_6.B;

      WHEN DELETING THEN
      V_OPER := 'DELETING';
      select ' DELETE FROM  '||V_TABLE_NAME||' WHERE '||replace(wm_concat(cu.column_name||'=:OLD.'||cu.column_name),',',' and ') INTO V_SQL from user_cons_columns cu, user_constraints au where cu.constraint_name = au.constraint_name and au.constraint_type = 'P' and au.table_name = V_TABLE_NAME;

    END CASE;
    INSERT INTO SQL_LOG(ID,SQL_LOG,CDATE,OPERATION) VALUES(F_GETNID(),V_SQL,SYSDATE,V_OPER);
    EXCEPTION
    WHEN MYEXCEPTION THEN
    RAISE_APPLICATION_ERROR(-20001,'TRIGGER EXCUTION ERROR');
    WHEN OTHERS THEN
    dbms_output.put_line('ERROR');  --DO NOTHING

  END;

SELECT T1.COLUMN_NAME ,CASE WHEN EXISTS(SELECT 1 FROM   user_cons_columns ljl.section1_6.A, user_constraints ljl.section1_6.B WHERE ljl.section1_6.A.constraint_name = ljl.section1_6.B.constraint_name  AND ljl.section1_6.B.constraint_type='P' AND ljl.section1_6.A.column_name=T1.COLUMN_NAME AND ljl.section1_6.A.table_name=T1.TABLE_NAME) THEN 1 ELSE 0 END PK_BJ
FROM USER_TAB_COLUMNS T1
WHERE T1.TABLE_NAME='WEBORDER_DETAIL' ORDER BY T1.COLUMN_ID

SELECT T1.COLUMN_NAME,DECODE(NVL(T2.column_name,'0'),'0',0,1) PK_BJ  FROM USER_TAB_COLUMNS T1
  LEFT JOIN (SELECT ljl.section1_6.A.column_name,ljl.section1_6.A.table_name FROM  user_cons_columns ljl.section1_6.A, user_constraints ljl.section1_6.B WHERE ljl.section1_6.A.constraint_name = ljl.section1_6.B.constraint_name  AND ljl.section1_6.B.constraint_type='P'
            ) T2
    ON T1.TABLE_NAME= T2.TABLE_NAME AND T1.COLUMN_NAME = T2.COLUMN_NAME
WHERE T1.TABLE_NAME='WEBORDER_DETAIL' ORDER BY T1.COLUMN_ID ;
CREATE OR REPLACE TRIGGER VJSP_MONITOR_TRIGGER_CITY AFTER INSERT OR DELETE OR UPDATE ON CITY FOR EACH ROW

DECLARE
       V_SQL VARCHAR2(4000):='';
       V_OPER VARCHAR2(200);
       V_TABLE_NAME VARCHAR2(200):='CITY';
       l_cursor NUMBER;
       l_insertline1 VARCHAR2(4000):='';
           l_insertline2 VARCHAR2(4000):='';
             l_column_list       VARCHAR2(32767);
  l_value_list        VARCHAR2(32767);
  ignore number;
       BEGIN
           CASE
           WHEN INSERTING THEN
                V_OPER := 'INSERTING';

                WHEN UPDATING THEN
                V_OPER := 'UPDATING';

           WHEN DELETING THEN
                V_OPER := 'DELETING';

                END CASE;
           V_SQL:='SELECT '''|| :NEW.ID||''' ID,'''||:NEW.NAME||''' NAME,'''||TO_CHAR(:NEW.CDATE,'YYYY-MM-DD')||''' CDATE FROM DUAL';
            INSERT INTO VJSP_MONITOR_SQL_LOG(ID,SQL_LOG,CDATE,OPERATION) VALUES(F_GETNID(),V_SQL,SYSDATE,V_OPER);

           l_cursor := dbms_sql.open_cursor;
             DBMS_SQL.PARSE(l_cursor,V_SQL, DBMS_SQL.native);
                DBMS_SQL.DEFINE_COLUMN(l_cursor, 1, l_value_list, 32767);
                  ignore := DBMS_SQL.EXECUTE(l_cursor);
                  LOOP
    IF DBMS_SQL.FETCH_ROWS(l_cursor)>0 THEN
      DBMS_SQL.COLUMN_VALUE(l_cursor, 1, l_value_list);
      l_insertline1:='INSERT INTO '||V_TABLE_NAME||' ('||l_column_list||')';
      l_insertline2:=' VALUES ('||l_value_list||');';
      V_SQL:= l_insertline1||l_insertline2;
       INSERT INTO VJSP_MONITOR_SQL_LOG(ID,SQL_LOG,CDATE,OPERATION) VALUES(F_GETNID(),V_SQL,SYSDATE,V_OPER);
    ELSE
      EXIT;
    END IF;
  END LOOP;

           END;

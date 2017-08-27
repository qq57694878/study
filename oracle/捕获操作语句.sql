CREATE OR REPLACE TRIGGER my_dll_trigger
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
  IF substr(rtrim(rtrim( rtrim(rtrim(rtrim(v_stmt),chr(10)),chr(13)),chr(10)),chr(13)), -1)<>';' THEN
     v_stmt := v_stmt||';';
    end if;
        v_stmt := v_stmt||';';
    INSERT INTO SQL_LOG(ID,SQL_LOG,CDATE,OPERATION) VALUES(F_GETNID(),v_stmt,SYSDATE,'DDL');
END;
create or replace procedure execsql
(
name varchar2
)
is
type org_type  is table of t_org%rowtype;
v_orgdata org_type;

v_sql varchar2(4000);
begin
  v_sql:=v_sql||'select * from t_org where name like :1';
  execute immediate v_sql
  bulk collect into v_orgdata
  using '%'||name||'%';
  for i in 1..v_orgdata.count
    loop
      dbms_output.put_line(v_orgdata(i).name||v_orgdata(i).id);
      end loop;

  end;

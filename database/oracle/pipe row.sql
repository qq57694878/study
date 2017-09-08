CREATE OR REPLACE TYPE strsplit_type IS TABLE OF VARCHAR2 (4000);


create or replace function fun_strsplit
(
 src varchar2,
 splitchar varchar2:=','
)
return strsplit_type pipelined
is
v_str varchar2(4000):=src;
v_s  varchar2(4000);
v_index integer;
begin
   loop
   v_index:= instr(v_str,splitchar);
   exit when nvl(v_index,0)<=0;
   v_s := substr(v_str,1,v_index-1);
   pipe row(v_s);
   v_str :=  substr(v_str,v_index+1);
   end loop;
   pipe row(v_str);
   return;
  end
  ;


select column_value from table(fun_strsplit('1,2,3,'))
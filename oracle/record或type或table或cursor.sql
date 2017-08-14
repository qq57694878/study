create or replace procedure test1
is
cursor c1 is select *  from emp;
type emptype  is table of emp%rowtype;
type arrtype is varray(10) of NUMBER(10);
empdata emptype;
arrdata arrtype;
v1 c1%rowtype;
cursor c2 is select * from scott.dept;
    CURSOR c_1 is select empno,ename,job,sal from emp;
     TYPE myrecord IS RECORD(empno emp.empno%type,ename emp.ename%type,
job emp.job%type,sal emp.sal%type);     --定义一个名为myrecoed的PL/sql记录类型;
     TYPE mytable IS TABLE OF myrecord index by binary_integer;
          n number:=1;
     tab_1 mytable; --为mytable类型实例化一个tab_1对象;
type curtype is ref cursor;-- return emp%rowtype;
cu_3 curtype;
   r emp%rowtype;
   cur_4 sys_refcursor;
begin
  open cur_4 for 'select * from emp';
  fetch cur_4 into r;
  while cur_4%found loop
        dbms_output.put_line(' '||r.ename||' '||r.sal);    --输出结果,需要 set serverout on 才能显示.
         fetch cur_4 into r;
    end loop;
  close cur_4;
  open cu_3 for select * from emp;
   loop
     fetch cu_3 into r;
     exit when cu_3%notfound;
     dbms_output.put_line(cu_3%rowcount||' '||r.ename||' '||r.sal);    --输出结果,需要 set serverout on 才能显示.
   fetch cu_3 into r;
     END LOOP;

  arrdata:=arrtype(1,2,3,4,5,6,7,8,9,0);
     open c1;
     if c1%isopen then
          CLOSE c1;
     end if;
     open c1;
       loop
         fetch c1 into v1;
         exit when c1%notfound;
         dbms_output.put_line(v1.ename||','||v1.empno);
         end loop;

       for i in c2
         loop
              dbms_output.put_line(i.deptno||','||i.dname);
           end loop;
       select * bulk collect into empdata from emp;
       for i in 1..empdata.count
         loop
             dbms_output.put_line(empdata(i).ename||'-----');
           end loop;
       if sql%rowcount >0 then
                   dbms_output.put_line(sql%rowcount);
                   else
                     dbms_output.put_line('not fond');
         end if;
         for i in 1 .. arrdata.count
           loop
             dbms_output.put_line(to_char(arrdata(i)));
             end loop;

          --赋值
          for i in c_1
          loop
               tab_1(n).empno:=i.empno;
               tab_1(n).ename:=i.ename;
               tab_1(n).job:=i.job;
               tab_1(n).sal:=i.sal;
               n:=n+1;
          end loop;
          n:=1;
          --输出
          for i in n..tab_1.count
          loop
                dbms_output.put_line(i||' '||tab_1(i).empno
                ||' '||tab_1(i).ename||' '||tab_1(i).job||' '||tab_1(i).sal);
          end loop;
            for i in (select * from emp)
          loop
            dbms_output.put_line('hhahahahahah:'||i.ename||' '||i.job||' '||i.sal);
          end loop;

end test1;



create or replace procedure empval(o out sys_refcursor) is
begin
open o for select * from emp;
end;
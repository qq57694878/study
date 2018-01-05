create table t_org(
id number(10) primary key,
name varchar2(100),
pid number(10)
);
insert into t_org(id,name,pid)values(1,'大公司',0);
insert into t_org(id,name,pid)values(2,'国内业务一部',1);
insert into t_org(id,name,pid)values(3,'国内业务二部',1);
insert into t_org(id,name,pid)values(4,'国际业务一部',1);

insert into t_org(id,name,pid)values(5,'地税项目组',2);
insert into t_org(id,name,pid)values(6,'社保项目组',2);
insert into t_org(id,name,pid)values(7,'对日项目一组',4);
insert into t_org(id,name,pid)values(8,'欧美项目组',4);
commit;
select t.*,level,row_number()  over(partition by pid order by id)
from t_org t
connect by prior id = pid
start with pid =0;
--GROUP BY t.tablespace_name;
create tablespace test datafile '/data/oracle/oradata/orcl/test.dbf' size 100M autoextend on next 10M maxsize unlimited;
-- Create the user
create user test
  identified by test
  default tablespace test
  temporary tablespace TEMP
  profile DEFAULT;



grant connect,create view ,resource  to test;

--grant unlimited tablespace to test;


--管理员授权

　　grant create session to test;--授予test户创建session的权限，即登陆权限

　　grant unlimited session to test;--授予test用户使用表空间的权限

　　grant create table to test;--授予创建表的权限

　　grant drop table to test;--授予删除表的权限

　　grant insert table to test;--插入表的权限

　　grant update table to test;--修改表的权限

　　grant all to public;--这条比较重要，授予所有权限(all)给所有用户(public)

--oralce对权限管理比较严谨，普通用户之间也是默认不能互相访问的

　　grant select on TEST to test;--授予test用户查看指定表的权限

　　grant drop on TEST to test;--授予删除表的权限

　　grant insert on TEST to test;--授予插入的权限

　　grant update on TEST to test;--授予修改表的权限

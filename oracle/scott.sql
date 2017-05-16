----------------------------------------------------
-- Export file for user SCOTT                     --
-- Created by Administrator on 2017/5/8, 14:02:03 --
----------------------------------------------------

create table BONUS
(
  ename VARCHAR2(10),
  job   VARCHAR2(9),
  sal   NUMBER,
  comm  NUMBER
);

create table DEPT
(
  deptno NUMBER(2) not null,
  dname  VARCHAR2(14),
  loc    VARCHAR2(13)
);
alter table DEPT
  add constraint PK_DEPT primary key (DEPTNO);

create table EMP
(
  empno    NUMBER(4) not null,
  ename    VARCHAR2(10),
  job      VARCHAR2(9),
  mgr      NUMBER(4),
  hiredate DATE,
  sal      NUMBER(7,2),
  comm     NUMBER(7,2),
  deptno   NUMBER(2)
);
alter table SCOTT.EMP
  add constraint PK_EMP primary key (EMPNO);
alter table SCOTT.EMP
  add constraint FK_DEPTNO foreign key (DEPTNO)
  references SCOTT.DEPT (DEPTNO);

create table SCOTT.SALGRADE
(
  grade NUMBER,
  losal NUMBER,
  hisal NUMBER
);

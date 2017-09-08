
        create or replace synonym EMP
        for SCOTT.EMP;

        -- Create the synonym
        create or replace synonym BONUS
        for SCOTT.BONUS;

        -- Create the synonym
        create or replace synonym SALGRADE
        for SCOTT.SALGRADE;

        -- Create the synonym
        create or replace synonym DEPT
        for SCOTT.DEPT;

        create table city(
id varchar2(40),
name varchar2(100)
);

create table class(
id varchar2(40),
name varchar2(100)
);
create table T_COURSE
(
  cid       NUMBER(10) not null,
  name      VARCHAR2(100),
  teacherid NUMBER(10)
)
;
comment on column T_COURSE.cid
  is '课程id';
comment on column T_COURSE.name
  is '课程名';
comment on column T_COURSE.teacherid
  is '老师id';
alter table T_COURSE
  add primary key (CID);


create table T_SC
(
  stuid NUMBER(10) not null,
  cid   NUMBER(10) not null,
  score NUMBER(10)
)
;
comment on column T_SC.stuid
  is '学生id';
comment on column T_SC.cid
  is '课程id';
comment on column T_SC.score
  is '成绩';
alter table T_SC
  add constraint PK_T_SC primary key (STUID, CID);


create table T_STUDENT
(
  stuid NUMBER(10) not null,
  name  VARCHAR2(100),
  age   NUMBER(3),
  sex   CHAR(1)
)
;
comment on column T_STUDENT.stuid
  is '学生id';
comment on column T_STUDENT.name
  is '学生姓名';
comment on column T_STUDENT.age
  is '学生年龄';
comment on column T_STUDENT.sex
  is '学生性别';
alter table T_STUDENT
  add primary key (STUID);


create table T_TEACHER
(
  tid   NUMBER(10) not null,
  tname VARCHAR2(100)
)
;
comment on column T_TEACHER.tid
  is '老师id';
comment on column T_TEACHER.tname
  is '老师姓名';
alter table T_TEACHER
  add primary key (TID);

insert into T_COURSE (cid, name, teacherid)
values (111, '数学', 11111);
insert into T_COURSE (cid, name, teacherid)
values (112, '语文', 11112);
commit;

insert into T_SC (stuid, cid, score)
values (1, 112, 97);
insert into T_SC (stuid, cid, score)
values (2, 111, 96);
insert into T_SC (stuid, cid, score)
values (1, 111, 99);
insert into T_SC (stuid, cid, score)
values (2, 112, 98);
commit;

insert into T_STUDENT (stuid, name, age, sex)
values (1, '小李', 30, '1');
insert into T_STUDENT (stuid, name, age, sex)
values (2, '小徐', 29, '0');
commit;

insert into T_TEACHER (tid, tname)
values (11111, '赵老师');
insert into T_TEACHER (tid, tname)
values (11112, '孙老师');
commit;
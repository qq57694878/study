alter table test01 add constraint PK_TEST01 primary key(ID) ;
alter table test01 add constraint FK_TEST01_PID FOREIGN key REFERENCES  TEST.CITY(ID);
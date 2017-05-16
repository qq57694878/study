-- Create table
create table TEST.T_ORG
(
  id   NUMBER(10) not null,
  name VARCHAR2(100),
  pid  NUMBER(10)
);
-- Create/Recreate primary, unique and foreign key constraints
alter table TEST.T_ORG
  add primary key (ID)
 ;

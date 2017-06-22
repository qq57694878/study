-- Create table
create table TB_TOB_CHANNEL
(
  id           VARCHAR2(40) not null,
  channel_name VARCHAR2(500),
  channel_desc VARCHAR2(2000),
  qy_bj        CHAR(1)
);
-- Add comments to the table
comment on table TB_TOB_CHANNEL
is 'toB订单渠道表';
-- Add comments to the columns
comment on column TB_TOB_CHANNEL.id
is '主键';
comment on column TB_TOB_CHANNEL.channel_name
is '渠道名称';
comment on column TB_TOB_CHANNEL.channel_desc
is '渠道描述';
comment on column TB_TOB_CHANNEL.qy_bj
is '启用标记1:启用,0:禁用';
-- Create/Recreate primary, unique and foreign key constraints
alter table TB_TOB_CHANNEL
  add constraint PK_TB_TOB_CHANNEL primary key (ID);

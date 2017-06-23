drop table VJSP_WORK_REQ cascade constraints;

/*==============================================================*/
/* Table: VJSP_WORK_REQ                                         */
/*==============================================================*/
create table VJSP_WORK_REQ
(
  REQ_ID               VARCHAR2(40)         not null,
  DOCCODE              VARCHAR2(80),
  TITLE                VARCHAR2(1000),
  APPLYER              VARCHAR2(200),
  APPLY_DEPT           VARCHAR2(500),
  APPLY_TIME           DATE,
  PRIORITY             NUMBER,
  CONTENT              VARCHAR2(4000),
  ATTACHMENT           VARCHAR2(4000),
  STATUS               NUMBER,
  DEL_FLAG             NUMBER               default 0,
  CREATE_TIME          DATE                 default SYSDATE,
  CREATER_ID           VARCHAR2(40),
  CREATER_NAME         VARCHAR2(200),
  DEPT_ID              VARCHAR2(40),
  DEPT_NAME            VARCHAR2(200),
  REVISER_ID           VARCHAR2(40),
  REVISER_NAME         VARCHAR2(200),
  REVISER_TIME         DATE,
  GSNM                 VARCHAR2(40),
  constraint PK_VJSP_WORK_REQ primary key (REQ_ID)
);

comment on table VJSP_WORK_REQ is
'工作请示单';

comment on column VJSP_WORK_REQ.REQ_ID is
'主键';

comment on column VJSP_WORK_REQ.DOCCODE is
'编号';

comment on column VJSP_WORK_REQ.TITLE is
'流程标题';

comment on column VJSP_WORK_REQ.APPLYER is
'请示人';

comment on column VJSP_WORK_REQ.APPLY_DEPT is
'请示部门';

comment on column VJSP_WORK_REQ.APPLY_TIME is
'请示日期';

comment on column VJSP_WORK_REQ.PRIORITY is
'优先级';

comment on column VJSP_WORK_REQ.CONTENT is
'请示事项
请示事项摘要说明';

comment on column VJSP_WORK_REQ.ATTACHMENT is
'附件';

comment on column VJSP_WORK_REQ.STATUS is
'状态';

comment on column VJSP_WORK_REQ.DEL_FLAG is
'删除状态';

comment on column VJSP_WORK_REQ.CREATE_TIME is
'创建时间';

comment on column VJSP_WORK_REQ.CREATER_ID is
'创建人ID';

comment on column VJSP_WORK_REQ.CREATER_NAME is
'创建人名称';

comment on column VJSP_WORK_REQ.DEPT_ID is
'部门ID';

comment on column VJSP_WORK_REQ.DEPT_NAME is
'部门名称';

comment on column VJSP_WORK_REQ.REVISER_ID is
'修改人ID';

comment on column VJSP_WORK_REQ.REVISER_NAME is
'修改人名称';

comment on column VJSP_WORK_REQ.REVISER_TIME is
'修改时间';

comment on column VJSP_WORK_REQ.GSNM is
'公司编码';



drop table VJSP_BUSINESS_CARD cascade constraints;

/*==============================================================*/
/* Table: VJSP_BUSINESS_CARD                                    */
/*==============================================================*/
create table VJSP_BUSINESS_CARD
(
  CARD_ID              VARCHAR2(40)         not null,
  DOCCODE              VARCHAR2(80),
  TITLE                VARCHAR2(1000),
  APPLYER              VARCHAR2(200),
  APPLY_DEPT           VARCHAR2(500),
  APPLY_TIME           DATE,
  PRIORITY             NUMBER(1),
  CH_NAME              VARCHAR2(200),
  EN_NAME              VARCHAR2(200),
  CARD_DEPT            VARCHAR2(200),
  POST                 VARCHAR2(200),
  TEL                  VARCHAR2(200),
  PHONE_NUM            VARCHAR2(100),
  FAX                  VARCHAR2(200),
  EMAIL                VARCHAR2(200),
  ADDRESS              VARCHAR2(300),
  PRINT_NUM            NUMBER(5),
  REMARK               VARCHAR2(2000),
  STATUS               NUMBER,
  DEL_FLAG             NUMBER               default 0,
  CREATE_TIME          DATE                 default SYSDATE,
  CREATER_ID           VARCHAR2(40),
  CREATER_NAME         VARCHAR2(200),
  DEPT_ID              VARCHAR2(40),
  DEPT_NAME            VARCHAR2(200),
  REVISER_ID           VARCHAR2(40),
  REVISER_NAME         VARCHAR2(200),
  REVISER_TIME         DATE,
  GSNM                 VARCHAR2(40),
  constraint PK_VJSP_BUSINESS_CARD primary key (CARD_ID)
);

comment on table VJSP_BUSINESS_CARD is
'名片申请单';

comment on column VJSP_BUSINESS_CARD.CARD_ID is
'主键';

comment on column VJSP_BUSINESS_CARD.DOCCODE is
'编号';

comment on column VJSP_BUSINESS_CARD.TITLE is
'流程标题';

comment on column VJSP_BUSINESS_CARD.APPLYER is
'请示人';

comment on column VJSP_BUSINESS_CARD.APPLY_DEPT is
'请示部门';

comment on column VJSP_BUSINESS_CARD.APPLY_TIME is
'请示日期';

comment on column VJSP_BUSINESS_CARD.PRIORITY is
'优先级';

comment on column VJSP_BUSINESS_CARD.CH_NAME is
'中文姓名';

comment on column VJSP_BUSINESS_CARD.EN_NAME is
'英文姓名';

comment on column VJSP_BUSINESS_CARD.CARD_DEPT is
'部门';

comment on column VJSP_BUSINESS_CARD.POST is
'名片职务';

comment on column VJSP_BUSINESS_CARD.TEL is
'办公电话';

comment on column VJSP_BUSINESS_CARD.PHONE_NUM is
'手机号码';

comment on column VJSP_BUSINESS_CARD.FAX is
'传真电话';

comment on column VJSP_BUSINESS_CARD.EMAIL is
'电子邮件';

comment on column VJSP_BUSINESS_CARD.ADDRESS is
'办公地址';

comment on column VJSP_BUSINESS_CARD.PRINT_NUM is
'印制数量';

comment on column VJSP_BUSINESS_CARD.REMARK is
'申请说明';

comment on column VJSP_BUSINESS_CARD.STATUS is
'状态';

comment on column VJSP_BUSINESS_CARD.DEL_FLAG is
'删除状态';

comment on column VJSP_BUSINESS_CARD.CREATE_TIME is
'创建时间';

comment on column VJSP_BUSINESS_CARD.CREATER_ID is
'创建人ID';

comment on column VJSP_BUSINESS_CARD.CREATER_NAME is
'创建人名称';

comment on column VJSP_BUSINESS_CARD.DEPT_ID is
'部门ID';

comment on column VJSP_BUSINESS_CARD.DEPT_NAME is
'部门名称';

comment on column VJSP_BUSINESS_CARD.REVISER_ID is
'修改人ID';

comment on column VJSP_BUSINESS_CARD.REVISER_NAME is
'修改人名称';

comment on column VJSP_BUSINESS_CARD.REVISER_TIME is
'修改时间';

comment on column VJSP_BUSINESS_CARD.GSNM is
'公司编码';



drop table VJSP_MEETING_SUM cascade constraints;

/*==============================================================*/
/* Table: VJSP_MEETING_SUM                                      */
/*==============================================================*/
create table VJSP_MEETING_SUM
(
  SUM_ID               VARCHAR2(40)         not null,
  DOCCODE              VARCHAR2(80),
  TITLE                VARCHAR2(1000),
  APPLYER              VARCHAR2(200),
  APPLY_DEPT           VARCHAR2(500),
  APPLY_TIME           DATE,
  PRIORITY             NUMBER,
  ATTACHMENT           VARCHAR2(4000),
  SUBJECT              VARCHAR2(1000),
  MEETING_TIME         date,
  MEETING_PLACE        VARCHAR2(1000),
  PARTICIPANT          VARCHAR2(2000),
  ISSUE                VARCHAR2(2000),
  DISCUSS              VARCHAR2(2000),
  FOLLW                VARCHAR2(2000),
  STATUS               NUMBER,
  DEL_FLAG             NUMBER               default 0,
  CREATE_TIME          DATE                 default SYSDATE,
  CREATER_ID           VARCHAR2(40),
  CREATER_NAME         VARCHAR2(200),
  DEPT_ID              VARCHAR2(40),
  DEPT_NAME            VARCHAR2(200),
  REVISER_ID           VARCHAR2(40),
  REVISER_NAME         VARCHAR2(200),
  REVISER_TIME         DATE,
  GSNM                 VARCHAR2(40),
  constraint PK_VJSP_MEETING_SUM primary key (SUM_ID)
);

comment on table VJSP_MEETING_SUM is
'会议纪要';

comment on column VJSP_MEETING_SUM.SUM_ID is
'主键';

comment on column VJSP_MEETING_SUM.DOCCODE is
'编号';

comment on column VJSP_MEETING_SUM.TITLE is
'流程标题';

comment on column VJSP_MEETING_SUM.APPLYER is
'报批人';

comment on column VJSP_MEETING_SUM.APPLY_DEPT is
'报批部门';

comment on column VJSP_MEETING_SUM.APPLY_TIME is
'报批日期';

comment on column VJSP_MEETING_SUM.PRIORITY is
'优先级';

comment on column VJSP_MEETING_SUM.ATTACHMENT is
'附件';

comment on column VJSP_MEETING_SUM.SUBJECT is
'会议名称';

comment on column VJSP_MEETING_SUM.MEETING_TIME is
'会议时间';

comment on column VJSP_MEETING_SUM.MEETING_PLACE is
'会议地点';

comment on column VJSP_MEETING_SUM.PARTICIPANT is
'参与者';

comment on column VJSP_MEETING_SUM.ISSUE is
'主要议题';

comment on column VJSP_MEETING_SUM.DISCUSS is
'讨论内容';

comment on column VJSP_MEETING_SUM.FOLLW is
'具体内容及结论';

comment on column VJSP_MEETING_SUM.STATUS is
'状态';

comment on column VJSP_MEETING_SUM.DEL_FLAG is
'删除状态';

comment on column VJSP_MEETING_SUM.CREATE_TIME is
'创建时间';

comment on column VJSP_MEETING_SUM.CREATER_ID is
'创建人ID';

comment on column VJSP_MEETING_SUM.CREATER_NAME is
'创建人名称';

comment on column VJSP_MEETING_SUM.DEPT_ID is
'部门ID';

comment on column VJSP_MEETING_SUM.DEPT_NAME is
'部门名称';

comment on column VJSP_MEETING_SUM.REVISER_ID is
'修改人ID';

comment on column VJSP_MEETING_SUM.REVISER_NAME is
'修改人名称';

comment on column VJSP_MEETING_SUM.REVISER_TIME is
'修改时间';

comment on column VJSP_MEETING_SUM.GSNM is
'公司编码';




drop table VJSP_CER_USE_REQ cascade constraints;

/*==============================================================*/
/* Table: VJSP_CER_USE_REQ                                      */
/*==============================================================*/
create table VJSP_CER_USE_REQ
(
  CER_REQ_ID           VARCHAR2(40)         not null,
  DOCCODE              VARCHAR2(80),
  TITLE                VARCHAR2(1000),
  APPLYER              VARCHAR2(200),
  APPLY_DEPT           VARCHAR2(500),
  APPLY_TIME           DATE,
  PRIORITY             NUMBER,
  CER_TYPE             VARCHAR2(50),
  CER_NAME             VARCHAR2(500),
  BACK_TIME            DATE,
  PURPOSE              VARCHAR2(2000),
  PULL_SITUATION       VARCHAR2(200),
  CREATE_TIME          DATE                 default SYSDATE,
  CREATER_ID           VARCHAR2(40),
  CREATER_NAME         VARCHAR2(200),
  STATUS               NUMBER,
  DEL_FLAG             NUMBER               default 0,
  DEPT_ID              VARCHAR2(40),
  DEPT_NAME            VARCHAR2(200),
  REVISER_ID           VARCHAR2(40),
  REVISER_NAME         VARCHAR2(200),
  REVISER_TIME         DATE,
  GSNM                 VARCHAR2(40),
  constraint PK_VJSP_CER_USE_REQ primary key (CER_REQ_ID)
);

comment on table VJSP_CER_USE_REQ is
'证照使用申请单';

comment on column VJSP_CER_USE_REQ.CER_REQ_ID is
'主键';

comment on column VJSP_CER_USE_REQ.DOCCODE is
'编号';

comment on column VJSP_CER_USE_REQ.TITLE is
'流程标题';

comment on column VJSP_CER_USE_REQ.APPLYER is
'申请人';

comment on column VJSP_CER_USE_REQ.APPLY_DEPT is
'申请部门';

comment on column VJSP_CER_USE_REQ.APPLY_TIME is
'申请日期';

comment on column VJSP_CER_USE_REQ.PRIORITY is
'优先级';

comment on column VJSP_CER_USE_REQ.CER_TYPE is
'证件类型';

comment on column VJSP_CER_USE_REQ.CER_NAME is
'证件名称';

comment on column VJSP_CER_USE_REQ.BACK_TIME is
'归还日期';

comment on column VJSP_CER_USE_REQ.PURPOSE is
'用证用途';

comment on column VJSP_CER_USE_REQ.PULL_SITUATION is
'证件领用情况';

comment on column VJSP_CER_USE_REQ.CREATE_TIME is
'创建日期';

comment on column VJSP_CER_USE_REQ.CREATER_ID is
'创建人ID';

comment on column VJSP_CER_USE_REQ.CREATER_NAME is
'创建人名称';

comment on column VJSP_CER_USE_REQ.STATUS is
'状态';

comment on column VJSP_CER_USE_REQ.DEL_FLAG is
'删除状态';

comment on column VJSP_CER_USE_REQ.DEPT_ID is
'部门ID';

comment on column VJSP_CER_USE_REQ.DEPT_NAME is
'部门名称';

comment on column VJSP_CER_USE_REQ.REVISER_ID is
'修改人ID';

comment on column VJSP_CER_USE_REQ.REVISER_NAME is
'修改人名称';

comment on column VJSP_CER_USE_REQ.REVISER_TIME is
'修改时间';

comment on column VJSP_CER_USE_REQ.GSNM is
'公司编码';



drop table VJSP_IT_SERVICE_REQ cascade constraints;

/*==============================================================*/
/* Table: VJSP_IT_SERVICE_REQ                                   */
/*==============================================================*/
create table VJSP_IT_SERVICE_REQ
(
  CER_REQ_ID           VARCHAR2(40)         not null,
  DOCCODE              VARCHAR2(80),
  TITLE                VARCHAR2(1000),
  APPLYER              VARCHAR2(200),
  APPLY_DEPT           VARCHAR2(500),
  APPLY_TIME           DATE,
  PRIORITY             NUMBER,
  REMARK               VARCHAR2(1000),
  CONTENT              VARCHAR2(4000),
  SERVICE_TYPE         NUMBER,
  SERVICE_WAY          NUMBER,
  CREATE_TIME          DATE                 default SYSDATE,
  CREATER_ID           VARCHAR2(40),
  CREATER_NAME         VARCHAR2(200),
  STATUS               NUMBER,
  DEL_FLAG             NUMBER               default 0,
  DEPT_ID              VARCHAR2(40),
  DEPT_NAME            VARCHAR2(200),
  REVISER_ID           VARCHAR2(40),
  REVISER_NAME         VARCHAR2(200),
  REVISER_TIME         DATE,
  GSNM                 VARCHAR2(40),
  constraint PK_VJSP_IT_SERVICE_REQ primary key (CER_REQ_ID)
);

comment on table VJSP_IT_SERVICE_REQ is
'IT服务申请单';

comment on column VJSP_IT_SERVICE_REQ.CER_REQ_ID is
'主键';

comment on column VJSP_IT_SERVICE_REQ.DOCCODE is
'编号';

comment on column VJSP_IT_SERVICE_REQ.TITLE is
'流程标题';

comment on column VJSP_IT_SERVICE_REQ.APPLYER is
'申请人';

comment on column VJSP_IT_SERVICE_REQ.APPLY_DEPT is
'申请部门';

comment on column VJSP_IT_SERVICE_REQ.APPLY_TIME is
'申请日期';

comment on column VJSP_IT_SERVICE_REQ.PRIORITY is
'优先级';

comment on column VJSP_IT_SERVICE_REQ.REMARK is
'特别说明';

comment on column VJSP_IT_SERVICE_REQ.CONTENT is
'服务内容';

comment on column VJSP_IT_SERVICE_REQ.SERVICE_TYPE is
'服务类别';

comment on column VJSP_IT_SERVICE_REQ.SERVICE_WAY is
'服务方式';

comment on column VJSP_IT_SERVICE_REQ.CREATE_TIME is
'创建日期';

comment on column VJSP_IT_SERVICE_REQ.CREATER_ID is
'创建人ID';

comment on column VJSP_IT_SERVICE_REQ.CREATER_NAME is
'创建人名称';

comment on column VJSP_IT_SERVICE_REQ.STATUS is
'状态';

comment on column VJSP_IT_SERVICE_REQ.DEL_FLAG is
'删除状态';

comment on column VJSP_IT_SERVICE_REQ.DEPT_ID is
'部门ID';

comment on column VJSP_IT_SERVICE_REQ.DEPT_NAME is
'部门名称';

comment on column VJSP_IT_SERVICE_REQ.REVISER_ID is
'修改人ID';

comment on column VJSP_IT_SERVICE_REQ.REVISER_NAME is
'修改人名称';

comment on column VJSP_IT_SERVICE_REQ.REVISER_TIME is
'修改时间';

comment on column VJSP_IT_SERVICE_REQ.GSNM is
'公司编码';


drop table VJSP_GIFT_REQ cascade constraints;

/*==============================================================*/
/* Table: VJSP_GIFT_REQ                                         */
/*==============================================================*/
create table VJSP_GIFT_REQ
(
  GIFT_REQ_ID          VARCHAR2(40)         not null,
  DOCCODE              VARCHAR2(80),
  TITLE                VARCHAR2(1000),
  APPLYER              VARCHAR2(200),
  APPLY_DEPT           VARCHAR2(500),
  APPLY_TIME           DATE,
  PRIORITY             NUMBER,
  CREATE_TIME          DATE                 default SYSDATE,
  CREATER_ID           VARCHAR2(40),
  CREATER_NAME         VARCHAR2(200),
  GOODS                VARCHAR2(500),
  NUM                  NUMBER,
  CONTENT              BLOB,
  STATUS               NUMBER,
  DEL_FLAG             NUMBER               default 0,
  DEPT_ID              VARCHAR2(40),
  DEPT_NAME            VARCHAR2(200),
  REVISER_ID           VARCHAR2(40),
  REVISER_NAME         VARCHAR2(200),
  REVISER_TIME         DATE,
  GSNM                 VARCHAR2(40),
  constraint PK_VJSP_GIFT_REQ primary key (GIFT_REQ_ID)
);

comment on table VJSP_GIFT_REQ is
'礼品申请单';

comment on column VJSP_GIFT_REQ.GIFT_REQ_ID is
'主键';

comment on column VJSP_GIFT_REQ.DOCCODE is
'编号';

comment on column VJSP_GIFT_REQ.TITLE is
'流程标题';

comment on column VJSP_GIFT_REQ.APPLYER is
'申请人';

comment on column VJSP_GIFT_REQ.APPLY_DEPT is
'申请部门';

comment on column VJSP_GIFT_REQ.APPLY_TIME is
'申请日期';

comment on column VJSP_GIFT_REQ.PRIORITY is
'优先级';

comment on column VJSP_GIFT_REQ.CREATE_TIME is
'创建日期';

comment on column VJSP_GIFT_REQ.CREATER_ID is
'创建人ID';

comment on column VJSP_GIFT_REQ.CREATER_NAME is
'创建人名称';

comment on column VJSP_GIFT_REQ.GOODS is
'申领物品';

comment on column VJSP_GIFT_REQ.NUM is
'数量';

comment on column VJSP_GIFT_REQ.CONTENT is
'说明';

comment on column VJSP_GIFT_REQ.STATUS is
'状态';

comment on column VJSP_GIFT_REQ.DEL_FLAG is
'删除状态';

comment on column VJSP_GIFT_REQ.DEPT_ID is
'部门ID';

comment on column VJSP_GIFT_REQ.DEPT_NAME is
'部门名称';

comment on column VJSP_GIFT_REQ.REVISER_ID is
'修改人ID';

comment on column VJSP_GIFT_REQ.REVISER_NAME is
'修改人名称';

comment on column VJSP_GIFT_REQ.REVISER_TIME is
'修改时间';

comment on column VJSP_GIFT_REQ.GSNM is
'公司编码';


alter table VJSP_GIFT_REQ_DETAIL
  drop constraint FK_VJSP_GIFT__REFERENCE_VJSP_GIFT_;

drop table VJSP_GIFT_REQ_DETAIL cascade constraints;

/*==============================================================*/
/* Table: VJSP_GIFT_REQ_DETAIL                                  */
/*==============================================================*/
create table VJSP_GIFT_REQ_DETAIL
(
  REQ_DET_ID           VARCHAR2(40)         not null,
  GIFT_REQ_ID          VARCHAR2(40),
  COMPANY              VARCHAR2(500),
  DEPT                 VARCHAR2(500),
  FULL_NAME            VARCHAR2(500),
  POST                 VARCHAR2(500),
  TEL                  VARCHAR2(500),
  MEMO                 VARCHAR2(1000),
  constraint PK_VJSP_GIFT_REQ_DETAIL primary key (REQ_DET_ID)
);

comment on table VJSP_GIFT_REQ_DETAIL is
'礼品申请单明细';

comment on column VJSP_GIFT_REQ_DETAIL.REQ_DET_ID is
'主键';

comment on column VJSP_GIFT_REQ_DETAIL.GIFT_REQ_ID is
'申请表主键';

comment on column VJSP_GIFT_REQ_DETAIL.COMPANY is
'单位';

comment on column VJSP_GIFT_REQ_DETAIL.DEPT is
'部门';

comment on column VJSP_GIFT_REQ_DETAIL.FULL_NAME is
'姓名';

comment on column VJSP_GIFT_REQ_DETAIL.POST is
'职务';

comment on column VJSP_GIFT_REQ_DETAIL.TEL is
'电话';

comment on column VJSP_GIFT_REQ_DETAIL.MEMO is
'业务往来说明';

alter table VJSP_GIFT_REQ_DETAIL
  add constraint FK_VJSP_GIFT__REFERENCE_VJSP_GIFT_ foreign key (GIFT_REQ_ID)
references VJSP_GIFT_REQ (GIFT_REQ_ID);



drop table VJSP_LIAISON cascade constraints;

/*==============================================================*/
/* Table: VJSP_LIAISON                                          */
/*==============================================================*/
create table VJSP_LIAISON
(
  LAN_ID               varchar2(32)         not null,
  DOCCODE              VARCHAR2(80),
  TITLE                VARCHAR2(1000),
  APPLYER              VARCHAR2(200),
  APPLY_DEPT           VARCHAR2(500),
  APPLY_TIME           DATE,
  PRIORITY             NUMBER,
  LAN_TIME             date,
  LAN_NUM              varchar2(80),
  LAN_CONTENT          varchar2(800),
  FROM_COMPANY         varchar2(200),
  TO_COMPANY           varchar2(200),
  REPLY_TIME           date,
  BACK_TIME            date,
  MAG_CONDITION        varchar2(800),
  STATUS               NUMBER,
  DEL_FLAG             NUMBER               default 0,
  CREATE_TIME          date                 default SYSDATE,
  CREATER_ID           VARCHAR2(40),
  CREATER_NAME         VARCHAR2(200),
  DEPT_ID              VARCHAR2(40),
  DEPT_NAME            VARCHAR2(200),
  REVISER_ID           VARCHAR2(40),
  REVISER_NAME         VARCHAR2(200),
  GSNM                 VARCHAR2(40),
  REVISER_TIME         DATE,
  constraint PK_VJSP_LIAISON primary key (LAN_ID)
);

comment on table VJSP_LIAISON is
'联络单';

comment on column VJSP_LIAISON.LAN_ID is
'主键';

comment on column VJSP_LIAISON.DOCCODE is
'编号';

comment on column VJSP_LIAISON.TITLE is
'流程标题';

comment on column VJSP_LIAISON.APPLYER is
'申请人';

comment on column VJSP_LIAISON.APPLY_DEPT is
'申请部门';

comment on column VJSP_LIAISON.APPLY_TIME is
'申请日期';

comment on column VJSP_LIAISON.PRIORITY is
'优先级';

comment on column VJSP_LIAISON.LAN_TIME is
'联络日期';

comment on column VJSP_LIAISON.LAN_NUM is
'编号';

comment on column VJSP_LIAISON.LAN_CONTENT is
'联络事项';

comment on column VJSP_LIAISON.FROM_COMPANY is
'发文单位';

comment on column VJSP_LIAISON.TO_COMPANY is
'收文单位';

comment on column VJSP_LIAISON.REPLY_TIME is
'要求回复时间';

comment on column VJSP_LIAISON.BACK_TIME is
'签回时间';

comment on column VJSP_LIAISON.MAG_CONDITION is
'处理情况';

comment on column VJSP_LIAISON.STATUS is
'状态';

comment on column VJSP_LIAISON.DEL_FLAG is
'删除状态';

comment on column VJSP_LIAISON.CREATE_TIME is
'创建时间';

comment on column VJSP_LIAISON.CREATER_ID is
'创建人ID';

comment on column VJSP_LIAISON.CREATER_NAME is
'创建人名称';

comment on column VJSP_LIAISON.DEPT_ID is
'部门ID';

comment on column VJSP_LIAISON.DEPT_NAME is
'部门名称';

comment on column VJSP_LIAISON.REVISER_ID is
'修改人ID';

comment on column VJSP_LIAISON.REVISER_NAME is
'修改人名称';

comment on column VJSP_LIAISON.GSNM is
'公司编码';

comment on column VJSP_LIAISON.REVISER_TIME is
'修改时间';


drop table VJSP_ASSETUSE cascade constraints;

/*==============================================================*/
/* Table: VJSP_ASSETUSE                                         */
/*==============================================================*/
create table VJSP_ASSETUSE
(
  USE_ID               varchar2(32)         not null,
  DOCCODE              VARCHAR2(80),
  TITLE                VARCHAR2(1000),
  APPLYER              VARCHAR2(200),
  APPLY_DEPT           VARCHAR2(500),
  APPLY_TIME           DATE,
  PRIORITY             NUMBER,
  CONTENT              VARCHAR2(2000),
  STATUS               NUMBER,
  DEL_FLAG             NUMBER               default 0,
  CREATE_TIME          date                 default SYSDATE,
  CREATER_ID           VARCHAR2(40),
  CREATER_NAME         VARCHAR2(200),
  DEPT_ID              VARCHAR2(40),
  DEPT_NAME            VARCHAR2(200),
  REVISER_ID           VARCHAR2(40),
  REVISER_NAME         VARCHAR2(200),
  GSNM                 VARCHAR2(40),
  REVISER_TIME         DATE,
  constraint PK_VJSP_ASSETUSE primary key (USE_ID)
);

comment on table VJSP_ASSETUSE is
'资产、办公用品领用单';

comment on column VJSP_ASSETUSE.USE_ID is
'主键';

comment on column VJSP_ASSETUSE.DOCCODE is
'编号';

comment on column VJSP_ASSETUSE.TITLE is
'流程标题';

comment on column VJSP_ASSETUSE.APPLYER is
'申请人';

comment on column VJSP_ASSETUSE.APPLY_DEPT is
'申请部门';

comment on column VJSP_ASSETUSE.APPLY_TIME is
'申请日期';

comment on column VJSP_ASSETUSE.PRIORITY is
'优先级';

comment on column VJSP_ASSETUSE.CONTENT is
'申请说明';

comment on column VJSP_ASSETUSE.STATUS is
'状态';

comment on column VJSP_ASSETUSE.DEL_FLAG is
'删除状态';

comment on column VJSP_ASSETUSE.CREATE_TIME is
'创建时间';

comment on column VJSP_ASSETUSE.CREATER_ID is
'创建人ID';

comment on column VJSP_ASSETUSE.CREATER_NAME is
'创建人名称';

comment on column VJSP_ASSETUSE.DEPT_ID is
'部门ID';

comment on column VJSP_ASSETUSE.DEPT_NAME is
'部门名称';

comment on column VJSP_ASSETUSE.REVISER_ID is
'修改人ID';

comment on column VJSP_ASSETUSE.REVISER_NAME is
'修改人名称';

comment on column VJSP_ASSETUSE.GSNM is
'公司编码';

comment on column VJSP_ASSETUSE.REVISER_TIME is
'修改时间';


alter table VJSP_ASSETUSE_DETAIL
  drop constraint FK_VJSP_ASSET_REFERENCE_VJSP_ASSET;

drop table VJSP_ASSETUSE_DETAIL cascade constraints;

/*==============================================================*/
/* Table: VJSP_ASSETUSE_DETAIL                                  */
/*==============================================================*/
create table VJSP_ASSETUSE_DETAIL
(
  DID                  varchar2(40)         not null,
  USE_ID               varchar2(40),
  DNAME                varchar2(200),
  DUNIT                varchar2(20),
  DAMOUNT              number,
  DTIME                DATE,
  DPRICE               number(8,2),
  DCODE                varchar2(40),
  constraint PK_VJSP_ASSETUSE_DETAIL primary key (DID)
);

comment on table VJSP_ASSETUSE_DETAIL is
'资产、办公用品领用单(子表)';

comment on column VJSP_ASSETUSE_DETAIL.DID is
'主键';

comment on column VJSP_ASSETUSE_DETAIL.USE_ID is
'主表ID';

comment on column VJSP_ASSETUSE_DETAIL.DNAME is
'物品名称';

comment on column VJSP_ASSETUSE_DETAIL.DUNIT is
'规格型号';

comment on column VJSP_ASSETUSE_DETAIL.DAMOUNT is
'领用数量';

comment on column VJSP_ASSETUSE_DETAIL.DTIME is
'领用日期';

comment on column VJSP_ASSETUSE_DETAIL.DPRICE is
'物品价格';

comment on column VJSP_ASSETUSE_DETAIL.DCODE is
'资产编号';

alter table VJSP_ASSETUSE_DETAIL
  add constraint FK_VJSP_ASSET_REFERENCE_VJSP_ASSET foreign key (USE_ID)
references VJSP_ASSETUSE (USE_ID);


drop table VJSP_CACHET cascade constraints;

/*==============================================================*/
/* Table: VJSP_CACHET                                           */
/*==============================================================*/
create table VJSP_CACHET
(
  CA_ID                varchar2(32)         not null,
  DOCCODE              VARCHAR2(80),
  TITLE                VARCHAR2(1000),
  APPLYER              VARCHAR2(200),
  APPLY_DEPT           VARCHAR2(500),
  APPLY_TIME           DATE,
  PRIORITY             NUMBER,
  CA_PTUSER            varchar2(100),
  BORROW_TIME          date,
  BORROW_TIMEEND       date,
  BORROW_REASON        varchar2(1000),
  BORROW_CA            number,
  STATUS               NUMBER,
  DEL_FLAG             NUMBER               default 0,
  CREATE_TIME          date                 default SYSDATE,
  CREATER_ID           VARCHAR2(40),
  CREATER_NAME         VARCHAR2(200),
  DEPT_ID              VARCHAR2(40),
  DEPT_NAME            VARCHAR2(200),
  REVISER_ID           VARCHAR2(40),
  REVISER_NAME         VARCHAR2(200),
  GSNM                 VARCHAR2(40),
  REVISER_TIME         DATE,
  constraint PK_VJSP_CACHET primary key (CA_ID)
);

comment on table VJSP_CACHET is
'公章外借申请';

comment on column VJSP_CACHET.CA_ID is
'主键';

comment on column VJSP_CACHET.DOCCODE is
'编号';

comment on column VJSP_CACHET.TITLE is
'流程标题';

comment on column VJSP_CACHET.APPLYER is
'申请人';

comment on column VJSP_CACHET.APPLY_DEPT is
'申请部门';

comment on column VJSP_CACHET.APPLY_TIME is
'申请日期';

comment on column VJSP_CACHET.PRIORITY is
'紧急程度';

comment on column VJSP_CACHET.CA_PTUSER is
'陪同人员';

comment on column VJSP_CACHET.BORROW_TIME is
'借出时间';

comment on column VJSP_CACHET.BORROW_TIMEEND is
'归还时间';

comment on column VJSP_CACHET.BORROW_REASON is
'借出缘由';

comment on column VJSP_CACHET.BORROW_CA is
'外借用章';

comment on column VJSP_CACHET.STATUS is
'状态';

comment on column VJSP_CACHET.DEL_FLAG is
'删除状态';

comment on column VJSP_CACHET.CREATE_TIME is
'创建时间';

comment on column VJSP_CACHET.CREATER_ID is
'创建人ID';

comment on column VJSP_CACHET.CREATER_NAME is
'创建人名称';

comment on column VJSP_CACHET.DEPT_ID is
'部门ID';

comment on column VJSP_CACHET.DEPT_NAME is
'部门名称';

comment on column VJSP_CACHET.REVISER_ID is
'修改人ID';

comment on column VJSP_CACHET.REVISER_NAME is
'修改人名称';

comment on column VJSP_CACHET.GSNM is
'公司编码';

comment on column VJSP_CACHET.REVISER_TIME is
'修改时间';


drop table VJSP_EXPRESS cascade constraints;

/*==============================================================*/
/* Table: VJSP_EXPRESS                                          */
/*==============================================================*/
create table VJSP_EXPRESS
(
  EXP_ID               varchar2(32)         not null,
  DOCCODE              VARCHAR2(80),
  TITLE                VARCHAR2(1000),
  APPLYER              VARCHAR2(200),
  APPLY_DEPT           VARCHAR2(500),
  APPLY_TIME           DATE,
  PRIORITY             NUMBER,
  EXP_GOODS            varchar2(500),
  EXP_PLACE            varchar2(500),
  EXP_TIME             date,
  EXP_AMOUNT           number,
  EXP_CONTEXT          varchar2(1000),
  STATUS               NUMBER,
  DEL_FLAG             NUMBER               default 0,
  CREATE_TIME          date                 default SYSDATE,
  CREATER_ID           VARCHAR2(40),
  CREATER_NAME         VARCHAR2(200),
  DEPT_ID              VARCHAR2(40),
  DEPT_NAME            VARCHAR2(200),
  REVISER_ID           VARCHAR2(40),
  REVISER_NAME         VARCHAR2(200),
  GSNM                 VARCHAR2(40),
  REVISER_TIME         DATE,
  constraint PK_VJSP_EXPRESS primary key (EXP_ID)
);

comment on table VJSP_EXPRESS is
'快递申请单';

comment on column VJSP_EXPRESS.EXP_ID is
'主键';

comment on column VJSP_EXPRESS.DOCCODE is
'编号';

comment on column VJSP_EXPRESS.TITLE is
'流程标题';

comment on column VJSP_EXPRESS.APPLYER is
'申请人';

comment on column VJSP_EXPRESS.APPLY_DEPT is
'申请部门';

comment on column VJSP_EXPRESS.APPLY_TIME is
'申请日期';

comment on column VJSP_EXPRESS.PRIORITY is
'紧急程度';

comment on column VJSP_EXPRESS.EXP_GOODS is
'快递物件';

comment on column VJSP_EXPRESS.EXP_PLACE is
'快递地点';

comment on column VJSP_EXPRESS.EXP_TIME is
'快递日期';

comment on column VJSP_EXPRESS.EXP_AMOUNT is
'快递数量';

comment on column VJSP_EXPRESS.EXP_CONTEXT is
'快递说明';

comment on column VJSP_EXPRESS.STATUS is
'状态';

comment on column VJSP_EXPRESS.DEL_FLAG is
'删除状态';

comment on column VJSP_EXPRESS.CREATE_TIME is
'创建时间';

comment on column VJSP_EXPRESS.CREATER_ID is
'创建人ID';

comment on column VJSP_EXPRESS.CREATER_NAME is
'创建人名称';

comment on column VJSP_EXPRESS.DEPT_ID is
'部门ID';

comment on column VJSP_EXPRESS.DEPT_NAME is
'部门名称';

comment on column VJSP_EXPRESS.REVISER_ID is
'修改人ID';

comment on column VJSP_EXPRESS.REVISER_NAME is
'修改人名称';

comment on column VJSP_EXPRESS.GSNM is
'公司编码';

comment on column VJSP_EXPRESS.REVISER_TIME is
'修改时间';


drop table VJSP_ASSET_CHECK cascade constraints;

/*==============================================================*/
/* Table: VJSP_ASSET_CHECK                                      */
/*==============================================================*/
create table VJSP_ASSET_CHECK
(
  ASSCH_ID             varchar2(32)         not null,
  DOCCODE              VARCHAR2(80),
  TITLE                VARCHAR2(1000),
  APPLYER              VARCHAR2(200),
  APPLY_DEPT           VARCHAR2(500),
  APPLY_TIME           DATE,
  PRIORITY             NUMBER,
  ASSET_NAME           varchar2(200),
  ASSET_MODEL          varchar2(200),
  MANUFACTURER         varchar2(200),
  ASSET_TYPE           varchar2(200),
  ASSET_NUM            varchar2(200),
  CHECKER              varchar2(200),
  POR_TIME             date,
  ASSET_MONEY          varchar2(20),
  ASSET_YEARS          varchar2(20),
  ADD_TIME             date,
  ASSET_PURPOSE        varchar2(200),
  ASSET_EXT            varchar2(200),
  ASSET_FUN            varchar2(200),
  ASSET_OTHER          varchar2(200),
  STATUS               NUMBER,
  DEL_FLAG             NUMBER               default 0,
  CREATE_TIME          date                 default SYSDATE,
  CREATER_ID           VARCHAR2(40),
  CREATER_NAME         VARCHAR2(200),
  DEPT_ID              VARCHAR2(40),
  DEPT_NAME            VARCHAR2(200),
  REVISER_ID           VARCHAR2(40),
  REVISER_NAME         VARCHAR2(200),
  GSNM                 VARCHAR2(40),
  REVISER_TIME         DATE,
  constraint PK_VJSP_ASSET_CHECK primary key (ASSCH_ID)
);

comment on table VJSP_ASSET_CHECK is
'资产验收单';

comment on column VJSP_ASSET_CHECK.ASSCH_ID is
'主键';

comment on column VJSP_ASSET_CHECK.DOCCODE is
'编号';

comment on column VJSP_ASSET_CHECK.TITLE is
'流程标题';

comment on column VJSP_ASSET_CHECK.APPLYER is
'申请人';

comment on column VJSP_ASSET_CHECK.APPLY_DEPT is
'申请部门';

comment on column VJSP_ASSET_CHECK.APPLY_TIME is
'申请日期';

comment on column VJSP_ASSET_CHECK.PRIORITY is
'紧急程度';

comment on column VJSP_ASSET_CHECK.ASSET_NAME is
'资产名称';

comment on column VJSP_ASSET_CHECK.ASSET_MODEL is
'资产型号';

comment on column VJSP_ASSET_CHECK.MANUFACTURER is
'生产厂商';

comment on column VJSP_ASSET_CHECK.ASSET_TYPE is
'资产类型';

comment on column VJSP_ASSET_CHECK.ASSET_NUM is
'资产编号';

comment on column VJSP_ASSET_CHECK.CHECKER is
'验收人员';

comment on column VJSP_ASSET_CHECK.POR_TIME is
'购置日期';

comment on column VJSP_ASSET_CHECK.ASSET_MONEY is
'资产原值';

comment on column VJSP_ASSET_CHECK.ASSET_YEARS is
'使用年限';

comment on column VJSP_ASSET_CHECK.ADD_TIME is
'录入日期';

comment on column VJSP_ASSET_CHECK.ASSET_PURPOSE is
'资产用途';

comment on column VJSP_ASSET_CHECK.ASSET_EXT is
'外观';

comment on column VJSP_ASSET_CHECK.ASSET_FUN is
'功能';

comment on column VJSP_ASSET_CHECK.ASSET_OTHER is
'其他';

comment on column VJSP_ASSET_CHECK.STATUS is
'状态';

comment on column VJSP_ASSET_CHECK.DEL_FLAG is
'删除状态';

comment on column VJSP_ASSET_CHECK.CREATE_TIME is
'创建时间';

comment on column VJSP_ASSET_CHECK.CREATER_ID is
'创建人ID';

comment on column VJSP_ASSET_CHECK.CREATER_NAME is
'创建人名称';

comment on column VJSP_ASSET_CHECK.DEPT_ID is
'部门ID';

comment on column VJSP_ASSET_CHECK.DEPT_NAME is
'部门名称';

comment on column VJSP_ASSET_CHECK.REVISER_ID is
'修改人ID';

comment on column VJSP_ASSET_CHECK.REVISER_NAME is
'修改人名称';

comment on column VJSP_ASSET_CHECK.GSNM is
'公司编码';

comment on column VJSP_ASSET_CHECK.REVISER_TIME is
'修改时间';


drop table VJSP_ASSET_SCRAP cascade constraints;

/*==============================================================*/
/* Table: VJSP_ASSET_SCRAP                                      */
/*==============================================================*/
create table VJSP_ASSET_SCRAP
(
  ASSSC_ID             varchar2(32)         not null,
  DOCCODE              VARCHAR2(80),
  TITLE                VARCHAR2(1000),
  APPLYER              VARCHAR2(200),
  APPLY_DEPT           VARCHAR2(500),
  APPLY_TIME           DATE,
  PRIORITY             NUMBER,
  ASSET_NAME           varchar2(200),
  ASSET_MODEL          varchar2(200),
  MANUFACTURER         varchar2(200),
  ASSET_TYPE           varchar2(200),
  ASSET_BH             varchar2(200),
  POR_TIME             date,
  ASSET_MONEY          varchar2(20),
  ASSET_YEARS          varchar2(20),
  EQU_BH               varchar2(200),
  APP_EQU              varchar2(200),
  USE_DEP              varchar2(200),
  ASSET_USER           varchar2(200),
  SCRAP_REASON         varchar2(2000),
  STATUS               NUMBER,
  DEL_FLAG             NUMBER               default 0,
  CREATE_TIME          date                 default SYSDATE,
  CREATER_ID           VARCHAR2(40),
  CREATER_NAME         VARCHAR2(200),
  DEPT_ID              VARCHAR2(40),
  DEPT_NAME            VARCHAR2(200),
  REVISER_ID           VARCHAR2(40),
  REVISER_NAME         VARCHAR2(200),
  GSNM                 VARCHAR2(40),
  REVISER_TIME         DATE,
  constraint PK_VJSP_ASSET_SCRAP primary key (ASSSC_ID)
);

comment on table VJSP_ASSET_SCRAP is
'资产报废申请单';

comment on column VJSP_ASSET_SCRAP.ASSSC_ID is
'主键';

comment on column VJSP_ASSET_SCRAP.DOCCODE is
'编号';

comment on column VJSP_ASSET_SCRAP.TITLE is
'流程标题';

comment on column VJSP_ASSET_SCRAP.APPLYER is
'申请人';

comment on column VJSP_ASSET_SCRAP.APPLY_DEPT is
'申请部门';

comment on column VJSP_ASSET_SCRAP.APPLY_TIME is
'申请日期';

comment on column VJSP_ASSET_SCRAP.PRIORITY is
'紧急程度';

comment on column VJSP_ASSET_SCRAP.ASSET_NAME is
'资产名称';

comment on column VJSP_ASSET_SCRAP.ASSET_MODEL is
'规格型号';

comment on column VJSP_ASSET_SCRAP.MANUFACTURER is
'生产厂商';

comment on column VJSP_ASSET_SCRAP.ASSET_TYPE is
'资产分类';

comment on column VJSP_ASSET_SCRAP.ASSET_BH is
'资产编号';

comment on column VJSP_ASSET_SCRAP.POR_TIME is
'购置日期';

comment on column VJSP_ASSET_SCRAP.ASSET_MONEY is
'资产原值';

comment on column VJSP_ASSET_SCRAP.ASSET_YEARS is
'使用年限';

comment on column VJSP_ASSET_SCRAP.EQU_BH is
'设备编号';

comment on column VJSP_ASSET_SCRAP.APP_EQU is
'附属设备';

comment on column VJSP_ASSET_SCRAP.USE_DEP is
'使用部门';

comment on column VJSP_ASSET_SCRAP.ASSET_USER is
'使用人';

comment on column VJSP_ASSET_SCRAP.SCRAP_REASON is
'报废原因';

comment on column VJSP_ASSET_SCRAP.STATUS is
'状态';

comment on column VJSP_ASSET_SCRAP.DEL_FLAG is
'删除状态';

comment on column VJSP_ASSET_SCRAP.CREATE_TIME is
'创建时间';

comment on column VJSP_ASSET_SCRAP.CREATER_ID is
'创建人ID';

comment on column VJSP_ASSET_SCRAP.CREATER_NAME is
'创建人名称';

comment on column VJSP_ASSET_SCRAP.DEPT_ID is
'部门ID';

comment on column VJSP_ASSET_SCRAP.DEPT_NAME is
'部门名称';

comment on column VJSP_ASSET_SCRAP.REVISER_ID is
'修改人ID';

comment on column VJSP_ASSET_SCRAP.REVISER_NAME is
'修改人名称';

comment on column VJSP_ASSET_SCRAP.GSNM is
'公司编码';

comment on column VJSP_ASSET_SCRAP.REVISER_TIME is
'修改时间';

drop table VJSP_ASSET_REPAIR cascade constraints;

/*==============================================================*/
/* Table: VJSP_ASSET_REPAIR                                     */
/*==============================================================*/
create table VJSP_ASSET_REPAIR
(
  ASSSC_ID             varchar2(32)         not null,
  DOCCODE              VARCHAR2(80),
  TITLE                VARCHAR2(1000),
  APPLYER              VARCHAR2(200),
  APPLY_DEPT           VARCHAR2(500),
  APPLY_TIME           DATE,
  PRIORITY             NUMBER,
  ASSET_BH             varchar2(200),
  ASSET_NAME           varchar2(200),
  ASSET_MODEL          varchar2(200),
  MANUFACTURER         varchar2(200),
  POR_TIME             date,
  ASSET_YEARS          varchar2(20),
  ASSET_USER           varchar2(200),
  REPAIR_CONTENT       varchar2(2000),
  PLACE                varchar2(500),
  PRE_COST             number(8,2),
  NEED_TIME            DATE,
  STATUS               NUMBER,
  DEL_FLAG             NUMBER               default 0,
  CREATE_TIME          date                 default SYSDATE,
  CREATER_ID           VARCHAR2(40),
  CREATER_NAME         VARCHAR2(200),
  DEPT_ID              VARCHAR2(40),
  DEPT_NAME            VARCHAR2(200),
  REVISER_ID           VARCHAR2(40),
  REVISER_NAME         VARCHAR2(200),
  GSNM                 VARCHAR2(40),
  REVISER_TIME         DATE,
  constraint PK_VJSP_ASSET_REPAIR primary key (ASSSC_ID)
);

comment on table VJSP_ASSET_REPAIR is
'资产维修申请单';

comment on column VJSP_ASSET_REPAIR.ASSSC_ID is
'主键';

comment on column VJSP_ASSET_REPAIR.DOCCODE is
'编号';

comment on column VJSP_ASSET_REPAIR.TITLE is
'流程标题';

comment on column VJSP_ASSET_REPAIR.APPLYER is
'申请人';

comment on column VJSP_ASSET_REPAIR.APPLY_DEPT is
'申请部门';

comment on column VJSP_ASSET_REPAIR.APPLY_TIME is
'申请日期';

comment on column VJSP_ASSET_REPAIR.PRIORITY is
'紧急程度';

comment on column VJSP_ASSET_REPAIR.ASSET_BH is
'资产编号';

comment on column VJSP_ASSET_REPAIR.ASSET_NAME is
'资产名称';

comment on column VJSP_ASSET_REPAIR.ASSET_MODEL is
'规格型号';

comment on column VJSP_ASSET_REPAIR.MANUFACTURER is
'生产厂商';

comment on column VJSP_ASSET_REPAIR.POR_TIME is
'购置日期';

comment on column VJSP_ASSET_REPAIR.ASSET_YEARS is
'使用年限';

comment on column VJSP_ASSET_REPAIR.ASSET_USER is
'使用人';

comment on column VJSP_ASSET_REPAIR.REPAIR_CONTENT is
'维修内容及原因';

comment on column VJSP_ASSET_REPAIR.PLACE is
'放置地点';

comment on column VJSP_ASSET_REPAIR.PRE_COST is
'预计维修费用';

comment on column VJSP_ASSET_REPAIR.NEED_TIME is
'要求修复日期';

comment on column VJSP_ASSET_REPAIR.STATUS is
'状态';

comment on column VJSP_ASSET_REPAIR.DEL_FLAG is
'删除状态';

comment on column VJSP_ASSET_REPAIR.CREATE_TIME is
'创建时间';

comment on column VJSP_ASSET_REPAIR.CREATER_ID is
'创建人ID';

comment on column VJSP_ASSET_REPAIR.CREATER_NAME is
'创建人名称';

comment on column VJSP_ASSET_REPAIR.DEPT_ID is
'部门ID';

comment on column VJSP_ASSET_REPAIR.DEPT_NAME is
'部门名称';

comment on column VJSP_ASSET_REPAIR.REVISER_ID is
'修改人ID';

comment on column VJSP_ASSET_REPAIR.REVISER_NAME is
'修改人名称';

comment on column VJSP_ASSET_REPAIR.GSNM is
'公司编码';

comment on column VJSP_ASSET_REPAIR.REVISER_TIME is
'修改时间';


drop table VJSP_OUT cascade constraints;

/*==============================================================*/
/* Table: VJSP_OUT                                              */
/*==============================================================*/
create table VJSP_OUT
(
  OUT_ID               varchar2(32)         not null,
  DOCCODE              VARCHAR2(80),
  TITLE                VARCHAR2(1000),
  APPLYER              VARCHAR2(200),
  APPLY_DEPT           VARCHAR2(500),
  APPLY_TIME           DATE,
  PRIORITY             NUMBER,
  OUT_REASON           varchar2(1000),
  OUT_TIME             date,
  OUT_TIMEEND          date,
  STATUS               NUMBER,
  DEL_FLAG             NUMBER               default 0,
  CREATE_TIME          date                 default SYSDATE,
  CREATER_ID           VARCHAR2(40),
  CREATER_NAME         VARCHAR2(200),
  DEPT_ID              VARCHAR2(40),
  DEPT_NAME            VARCHAR2(200),
  REVISER_ID           VARCHAR2(40),
  REVISER_NAME         VARCHAR2(200),
  GSNM                 VARCHAR2(40),
  REVISER_TIME         DATE,
  constraint PK_VJSP_OUT primary key (OUT_ID)
);

comment on table VJSP_OUT is
'外出申请单';

comment on column VJSP_OUT.OUT_ID is
'主键';

comment on column VJSP_OUT.DOCCODE is
'编号';

comment on column VJSP_OUT.TITLE is
'流程标题';

comment on column VJSP_OUT.APPLYER is
'申请人';

comment on column VJSP_OUT.APPLY_DEPT is
'申请部门';

comment on column VJSP_OUT.APPLY_TIME is
'申请日期';

comment on column VJSP_OUT.PRIORITY is
'优先级';

comment on column VJSP_OUT.OUT_REASON is
'外出事由';

comment on column VJSP_OUT.OUT_TIME is
'外出时间';

comment on column VJSP_OUT.OUT_TIMEEND is
'返回时间';

comment on column VJSP_OUT.STATUS is
'状态';

comment on column VJSP_OUT.DEL_FLAG is
'删除状态';

comment on column VJSP_OUT.CREATE_TIME is
'创建时间';

comment on column VJSP_OUT.CREATER_ID is
'创建人ID';

comment on column VJSP_OUT.CREATER_NAME is
'创建人名称';

comment on column VJSP_OUT.DEPT_ID is
'部门ID';

comment on column VJSP_OUT.DEPT_NAME is
'部门名称';

comment on column VJSP_OUT.REVISER_ID is
'修改人ID';

comment on column VJSP_OUT.REVISER_NAME is
'修改人名称';

comment on column VJSP_OUT.GSNM is
'公司编码';

comment on column VJSP_OUT.REVISER_TIME is
'修改时间';


drop table VJSP_LEAVE cascade constraints;

/*==============================================================*/
/* Table: VJSP_LEAVE                                            */
/*==============================================================*/
create table VJSP_LEAVE
(
  LEAVE_ID             varchar2(32)         not null,
  DOCCODE              VARCHAR2(80),
  TITLE                VARCHAR2(1000),
  APPLYER              VARCHAR2(200),
  APPLY_DEPT           VARCHAR2(500),
  APPLY_TIME           DATE,
  PRIORITY             NUMBER,
  LEAVE_REASON         varchar2(1000),
  LEAVE_TIME           date,
  LEAVE_TIMEEND        date,
  TOTAL_HOUR           NUMBER,
  LEAVE_QJTS           NUMBER,
  LEAVE_TYPE           number,
  PROXY_PERSON         varchar2(100),
  LXFS                 varchar2(100),
  STATUS               NUMBER,
  DEL_FLAG             NUMBER               default 0,
  CREATE_TIME          date                 default SYSDATE,
  CREATER_ID           VARCHAR2(40),
  CREATER_NAME         VARCHAR2(200),
  DEPT_ID              VARCHAR2(40),
  DEPT_NAME            VARCHAR2(200),
  REVISER_ID           VARCHAR2(40),
  REVISER_NAME         VARCHAR2(200),
  GSNM                 VARCHAR2(40),
  REVISER_TIME         DATE,
  constraint PK_VJSP_LEAVE primary key (LEAVE_ID)
);

comment on table VJSP_LEAVE is
'请假申请单';

comment on column VJSP_LEAVE.LEAVE_ID is
'主键';

comment on column VJSP_LEAVE.DOCCODE is
'编号';

comment on column VJSP_LEAVE.TITLE is
'流程标题';

comment on column VJSP_LEAVE.APPLYER is
'申请人';

comment on column VJSP_LEAVE.APPLY_DEPT is
'申请部门';

comment on column VJSP_LEAVE.APPLY_TIME is
'申请日期';

comment on column VJSP_LEAVE.PRIORITY is
'优先级';

comment on column VJSP_LEAVE.LEAVE_REASON is
'请假原因';

comment on column VJSP_LEAVE.LEAVE_TIME is
'请假时间(起)';

comment on column VJSP_LEAVE.LEAVE_TIMEEND is
'请假时间(止)';

comment on column VJSP_LEAVE.TOTAL_HOUR is
'合计时长';

comment on column VJSP_LEAVE.LEAVE_QJTS is
'请假天数';

comment on column VJSP_LEAVE.LEAVE_TYPE is
'请假类型';

comment on column VJSP_LEAVE.PROXY_PERSON is
'职务代理人';

comment on column VJSP_LEAVE.LXFS is
'紧急联系人联系方式';

comment on column VJSP_LEAVE.STATUS is
'状态';

comment on column VJSP_LEAVE.DEL_FLAG is
'删除状态';

comment on column VJSP_LEAVE.CREATE_TIME is
'创建时间';

comment on column VJSP_LEAVE.CREATER_ID is
'创建人ID';

comment on column VJSP_LEAVE.CREATER_NAME is
'创建人名称';

comment on column VJSP_LEAVE.DEPT_ID is
'部门ID';

comment on column VJSP_LEAVE.DEPT_NAME is
'部门名称';

comment on column VJSP_LEAVE.REVISER_ID is
'修改人ID';

comment on column VJSP_LEAVE.REVISER_NAME is
'修改人名称';

comment on column VJSP_LEAVE.GSNM is
'公司编码';

comment on column VJSP_LEAVE.REVISER_TIME is
'修改时间';


drop table VJSP_BUS_TRAVEL cascade constraints;

/*==============================================================*/
/* Table: VJSP_BUS_TRAVEL                                       */
/*==============================================================*/
create table VJSP_BUS_TRAVEL
(
  BT_ID                varchar2(32)         not null,
  DOCCODE              VARCHAR2(80),
  TITLE                VARCHAR2(1000),
  APPLYER              VARCHAR2(200),
  APPLY_DEPT           VARCHAR2(500),
  APPLY_TIME           DATE,
  PRIORITY             NUMBER,
  BT_PLACE             varchar2(500),
  BT_TIME              date,
  BT_TIMEEND           date,
  BT_DAYS              number,
  BT_VEHICLE           varchar2(500),
  BT_REASON            varchar2(500),
  BT_MONEY             varchar2(20),
  STATUS               NUMBER,
  DEL_FLAG             NUMBER               default 0,
  CREATE_TIME          date                 default SYSDATE,
  CREATER_ID           VARCHAR2(40),
  CREATER_NAME         VARCHAR2(200),
  DEPT_ID              VARCHAR2(40),
  DEPT_NAME            VARCHAR2(200),
  REVISER_ID           VARCHAR2(40),
  REVISER_NAME         VARCHAR2(200),
  GSNM                 VARCHAR2(40),
  REVISER_TIME         DATE,
  constraint PK_VJSP_BUS_TRAVEL primary key (BT_ID)
);

comment on table VJSP_BUS_TRAVEL is
'出差申请单';

comment on column VJSP_BUS_TRAVEL.BT_ID is
'主键';

comment on column VJSP_BUS_TRAVEL.DOCCODE is
'编号';

comment on column VJSP_BUS_TRAVEL.TITLE is
'流程标题';

comment on column VJSP_BUS_TRAVEL.APPLYER is
'申请人';

comment on column VJSP_BUS_TRAVEL.APPLY_DEPT is
'申请部门';

comment on column VJSP_BUS_TRAVEL.APPLY_TIME is
'申请日期';

comment on column VJSP_BUS_TRAVEL.PRIORITY is
'优先级';

comment on column VJSP_BUS_TRAVEL.BT_PLACE is
'出差地点';

comment on column VJSP_BUS_TRAVEL.BT_TIME is
'计划开始时间';

comment on column VJSP_BUS_TRAVEL.BT_TIMEEND is
'计划结束时间';

comment on column VJSP_BUS_TRAVEL.BT_DAYS is
'共计天数';

comment on column VJSP_BUS_TRAVEL.BT_VEHICLE is
'交通工具安排';

comment on column VJSP_BUS_TRAVEL.BT_REASON is
'出差事由';

comment on column VJSP_BUS_TRAVEL.BT_MONEY is
'费用预算';

comment on column VJSP_BUS_TRAVEL.STATUS is
'状态';

comment on column VJSP_BUS_TRAVEL.DEL_FLAG is
'删除状态';

comment on column VJSP_BUS_TRAVEL.CREATE_TIME is
'创建时间';

comment on column VJSP_BUS_TRAVEL.CREATER_ID is
'创建人ID';

comment on column VJSP_BUS_TRAVEL.CREATER_NAME is
'创建人名称';

comment on column VJSP_BUS_TRAVEL.DEPT_ID is
'部门ID';

comment on column VJSP_BUS_TRAVEL.DEPT_NAME is
'部门名称';

comment on column VJSP_BUS_TRAVEL.REVISER_ID is
'修改人ID';

comment on column VJSP_BUS_TRAVEL.REVISER_NAME is
'修改人名称';

comment on column VJSP_BUS_TRAVEL.GSNM is
'公司编码';

comment on column VJSP_BUS_TRAVEL.REVISER_TIME is
'修改时间';


drop table VJSP_ADDWORK cascade constraints;

/*==============================================================*/
/* Table: VJSP_ADDWORK                                          */
/*==============================================================*/
create table VJSP_ADDWORK
(
  AW_ID                varchar2(32)         not null,
  DOCCODE              VARCHAR2(80),
  TITLE                VARCHAR2(1000),
  APPLYER              VARCHAR2(200),
  APPLY_DEPT           VARCHAR2(500),
  APPLY_TIME           DATE,
  PRIORITY             NUMBER,
  AW_REASON            varchar2(1000),
  AW_TIME              date,
  AW_TIMEEND           date,
  AW_TS                varchar2(10),
  COM_WAY              NUMBER,
  COM_VALIDITY         DATE,
  AW_FRAME             NUMBER,
  STATUS               NUMBER,
  DEL_FLAG             NUMBER               default 0,
  CREATE_TIME          date                 default SYSDATE,
  CREATER_ID           VARCHAR2(40),
  CREATER_NAME         VARCHAR2(200),
  DEPT_ID              VARCHAR2(40),
  DEPT_NAME            VARCHAR2(200),
  REVISER_ID           VARCHAR2(40),
  REVISER_NAME         VARCHAR2(200),
  GSNM                 VARCHAR2(40),
  REVISER_TIME         DATE,
  constraint PK_VJSP_ADDWORK primary key (AW_ID)
);

comment on table VJSP_ADDWORK is
'加班申请单';

comment on column VJSP_ADDWORK.AW_ID is
'主键';

comment on column VJSP_ADDWORK.DOCCODE is
'编号';

comment on column VJSP_ADDWORK.TITLE is
'流程标题';

comment on column VJSP_ADDWORK.APPLYER is
'申请人';

comment on column VJSP_ADDWORK.APPLY_DEPT is
'申请部门';

comment on column VJSP_ADDWORK.APPLY_TIME is
'申请日期';

comment on column VJSP_ADDWORK.PRIORITY is
'优先级';

comment on column VJSP_ADDWORK.AW_REASON is
'加班原因';

comment on column VJSP_ADDWORK.AW_TIME is
'开始时间';

comment on column VJSP_ADDWORK.AW_TIMEEND is
'加班时间(止)';

comment on column VJSP_ADDWORK.AW_TS is
'加班天数';

comment on column VJSP_ADDWORK.COM_WAY is
'补偿形式';

comment on column VJSP_ADDWORK.COM_VALIDITY is
'补休有效期';

comment on column VJSP_ADDWORK.AW_FRAME is
'加班时段';

comment on column VJSP_ADDWORK.STATUS is
'状态';

comment on column VJSP_ADDWORK.DEL_FLAG is
'删除状态';

comment on column VJSP_ADDWORK.CREATE_TIME is
'创建时间';

comment on column VJSP_ADDWORK.CREATER_ID is
'创建人ID';

comment on column VJSP_ADDWORK.CREATER_NAME is
'创建人名称';

comment on column VJSP_ADDWORK.DEPT_ID is
'部门ID';

comment on column VJSP_ADDWORK.DEPT_NAME is
'部门名称';

comment on column VJSP_ADDWORK.REVISER_ID is
'修改人ID';

comment on column VJSP_ADDWORK.REVISER_NAME is
'修改人名称';

comment on column VJSP_ADDWORK.GSNM is
'公司编码';

comment on column VJSP_ADDWORK.REVISER_TIME is
'修改时间';










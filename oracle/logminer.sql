----------------------------------

alter database add supplemental log data;
select supplemental_log_data_min from v$database;
alter system set utl_file_dir ='D:/APP/ADMINISTRATOR/oradata/orcl/logminer' scope=spfile;
shutdown immediate
startup
show parameter utl_file_dir

 exec dbms_logmnr_d.build(DICTIONARY_FILENAME=>'dictionary.ora',DICTIONARY_LOCATION=>'D:/APP/ADMINISTRATOR/oradata/orcl/logminer');
  select t1.group#,t1.status,t2.member from v$log t1,v$logfile t2 where t1.GROUP#=t2.GROUP#;
exec dbms_logmnr.add_logfile(LOGFILENAME=>'D:\APP\ADMINISTRATOR\ORADATA\ORCL\REDO02.LOG',OPTIONS=>dbms_logmnr.new);
exec dbms_logmnr.start_logmnr(DICTFILENAME=>'D:/APP/ADMINISTRATOR/oradata/orcl/logminer/dictionary.ora');
select seg_owner,seg_name,operation,sql_redo from v$logmnr_contents where seg_owner='TEST';



---------------------------

 /data/oracle/oradata/orcl/redo01.log
alter database add supplemental log data;
select supplemental_log_data_min from v$database;
alter system set utl_file_dir ='/data/oracle/oradata/orcl/logminer' scope=spfile;
shutdown immediate
startup
show parameter utl_file_dir
CREATE DIRECTORY utlfile AS '/data/oracle/oradata/orcl/logminer';
 exec dbms_logmnr_d.build(DICTIONARY_FILENAME=>'dictionary.ora',DICTIONARY_LOCATION=>'/data/oracle/oradata/orcl/logminer');
  select t1.group#,t1.status,t2.member from v$log t1,v$logfile t2 where t1.GROUP#=t2.GROUP#;
exec dbms_logmnr.add_logfile(LOGFILENAME=>' /data/oracle/oradata/orcl/redo01.log',OPTIONS=>dbms_logmnr.new);
exec dbms_logmnr.start_logmnr(DICTFILENAME=>'/data/oracle/oradata/orcl/logminer/dictionary.ora');
select seg_owner,seg_name,operation,sql_redo from v$logmnr_contents where seg_owner='TEST';
exec dbms_logmnr.END ();

--日期格式化
select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') from dual;

		SELECT EXTRACT(YEAR FROM SYSDATE), EXTRACT(MONTH FROM SYSDATE)from dual;
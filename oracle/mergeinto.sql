        MERGE INTO t_org A
        USING (select 10 as id,'医疗事业部' as name,1 as pid from dual union all select 11 as id,'imazing box事业部' as name,1 as pid from dual) src
        ON (A.id = src.id)
        WHEN MATCHED THEN
            UPDATE SET name = src.name
            when not matched then
              insert (id,name,pid) values(src.id,src.name,src.pid);
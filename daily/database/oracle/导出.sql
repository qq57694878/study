create or replace procedure exp_data
(
  file_name in varchar2 --要导出的文件名,(包含路径,如:d:\test\exp_0003.txt)
 --,path_name in varchar2 --要导出文件的路径
 ,p_user    in varchar2 default SYS_CONTEXT('USERENV', 'CURRENT_USER') --要导出的用户,缺省为当前用户
 ,p_table   in varchar2 default '' --要导出的表,缺省为所有的表
 ,p_filed   in varchar2 default '*' --要导出的字段,逗号分隔,默认为所有字段
 ,p_sep     in varchar2 default ',' --字段分隔符,默认为逗号
 ,p_where   in varchar2 default ' ' --条件,注意要写'WHERE'
) AS
  /*
  描述:按指定条件导出指定表的指定列的数据到指定文件(增强了EXP工具,exp不能直接导出指定字段的数据)
  created by cryking 2013.03.03
  注意:1.本存储建议由SYS账户或具有SYSDBA权限的账户执行
       2.不要在其他事务中运行本存储过程
       3.null值导出后为'null'
      4.指定字段分隔符不能在导出的字段数据中有,否则会报错
  更新日志: 2013.03.04 by cryking
          1.可以不指定用户,缺省为当前用户,但需要当前用户拥有CREATE DIRECTORY的权限
          2.支持导出用户的所有表数据(外部表除外),支持导出所有用户的数据(指定P_USER为'ALL'时)
           2013.03.05 by cryking
          3.合并文件名和路径输入参数
           4.增加了导出文件中用户、表名、字段前[USER:][TABLE:][FILED:]标签,方便以后的导入

  */
  v_file UTL_FILE.file_type;
  TYPE t_filed IS TABLE OF varchar2(200) INDEX BY BINARY_INTEGER;
  v_fileds t_filed;
  v_sql    varchar2(30000);
  v_user   varchar2(20);
  v_path     varchar2(500);
  v_filename varchar2(50);
  i_cursor integer;
  v_col    varchar2(4000);
  i        integer;
  i_rows   integer := 1;
  exp_sep exception;

BEGIN
  --没有输入用户的情况
  if trim(p_user) is null then
    v_user := SYS_CONTEXT('USERENV', 'CURRENT_USER');
  else
    v_user := upper(p_user);
  end if;

  --获取路径
  select replace(file_name, regexp_REPLACE(file_name, '\\*[^\\*]*\\'), '')
    into v_path
    from dual;
  --获取文件名
  select regexp_REPLACE(file_name, '\\*[^\\*]*\\')
    into v_filename
    from dual;

  rollback; --防止在其他事务中运行本存储,先回滚之前的事务
  execute immediate 'create or replace directory EXPDIR as ''' || path_name ||
                    ''' '; --创建目录

  EXECUTE IMMEDIATE 'ALTER session SET nls_date_format=''yyyy-mm-dd hh24:mi:ss''';
  v_file := UTL_FILE.fopen('EXPDIR', file_name, 'w'); --创建文件

  IF TRIM(p_table) IS NULL THEN
    --导出当前用户所有表数据
    for x in (select OWNER, object_name
                from all_objects
               where object_type = 'TABLE'
                 AND OWNER = DECODE(v_user, 'ALL', OWNER, V_USER) --p_user为ALL的时候,导出所有用户数据
                 AND NOT EXISTS --排除外部表
               (SELECT 1
                        FROM user_external_tables
                       WHERE all_objects.object_name =
                             user_external_tables.TABLE_NAME)
               ORDER BY OWNER)
    LOOP
      execute immediate 'select column_name from all_tab_cols where owner = DECODE(''' ||
                        v_user || ''',''ALL'',OWNER,''' || v_user ||
                        ''') AND TABLE_NAME=''' || x.object_name || ''' ' BULK
                        COLLECT
        INTO v_fileds; --获得当前表的所有字段

      v_sql := 'select * from ' || v_user || '.' || x.object_name;
      dbms_output.put_LINE(v_sql);
      i_cursor := DBMS_SQL.OPEN_CURSOR; --获得游标
      DBMS_SQL.PARSE(i_cursor, v_sql, DBMS_SQL.NATIVE); --解析sql
      for j in 1 .. v_fileds.count
      loop
        --定义列
        DBMS_SQL.DEFINE_COLUMN(i_cursor, j, v_col, 4000);
        --dbms_output.put_LINE(v_col);
      end loop;
      i      := DBMS_SQL.EXECUTE(i_cursor);
      i_rows := 1;
      utl_file.put(v_file, '[USER:]' || x.OWNER); --写用户名到文件
      utl_file.put(v_file, '[TABLE:]' || x.object_name); --写表名到文件
       utl_file.new_line(v_file);
      utl_file.put(v_file, '[filed:]'); --写字段到文件
       for i in 1 .. v_fileds.count
          loop
            utl_file.put(v_file, v_fileds(i)); --写表头到文件
            utl_file.put(v_file, p_sep); --输出字段分隔符
          end loop;
          utl_file.new_line(v_file);

      while (DBMS_SQL.FETCH_ROWS(i_cursor)) > 0
      loop
        for k in 1 .. v_fileds.count
        loop
          DBMS_SQL.COLUMN_VALUE(i_cursor, k, v_col);
          if instr(v_col, p_sep) > 0 then
            raise exp_sep;
          end if;
          utl_file.putF(v_file,
                        case when v_col is null then 'null' else v_col end);
          utl_file.put(v_file, p_sep); --输出字段分隔符
        END LOOP;
        utl_file.new_line(v_file);
      END LOOP;

      DBMS_SQL.close_cursor(i_cursor);
    END LOOP;

  ELSE
    IF V_USER = 'ALL' THEN
      raise_application_error(-20002, '导出所有用户数据时,指定了表名');
    END IF;
    --导出指定表数据
    if p_filed = '*' OR TRIM(p_filed) IS NULL then
      select column_name bulk collect
        into v_fileds
        from all_tab_cols
       where owner = upper(v_user)
         and table_name = upper(p_table);
    else
      select * bulk collect
        into v_fileds
        from table(splitstr(p_filed, p_sep));
    end if;

    v_sql := 'select ' || p_filed || ' from ' || v_user || '.' || p_table || ' ' ||
             p_where;

    i_cursor := DBMS_SQL.OPEN_CURSOR; --获得游标
    DBMS_SQL.PARSE(i_cursor, v_sql, DBMS_SQL.NATIVE); --解析sql
    for j in 1 .. v_fileds.count
    loop
      --定义列
      DBMS_SQL.DEFINE_COLUMN(i_cursor, j, v_col, 4000);
    end loop;
    i := DBMS_SQL.EXECUTE(i_cursor);

    utl_file.put(v_file, '[filed:]'); --写字段到文件
    for i in 1 .. v_fileds.count
        loop
          utl_file.put(v_file, v_fileds(i)); --写表头到文件
          utl_file.put(v_file, p_sep); --输出字段分隔符
        end loop;
         utl_file.new_line(v_file);

    while (DBMS_SQL.FETCH_ROWS(i_cursor)) > 0
    loop

      for k in 1 .. v_fileds.count
      loop
        DBMS_SQL.COLUMN_VALUE(i_cursor, k, v_col);
        if instr(v_col, p_sep) > 0 then
          raise exp_sep;
        end if;
        utl_file.putF(v_file,
                      case when v_col is null then 'null' else v_col end);
        utl_file.put(v_file, p_sep); --输出字段分隔符
      END LOOP;
      utl_file.new_line(v_file);
    END LOOP;
    DBMS_SQL.close_cursor(i_cursor);
  END IF;
  UTL_FILE.fclose(v_file);
  DBMS_OUTPUT.put_line('导出数据成功完成!');

EXCEPTION
  when exp_sep then
    raise_application_error(-20001,
                            '导出的数据中包含了指定的字段分隔符:' || p_sep || ',请更换字段分隔符!');
    UTL_FILE.fclose(v_file);
  WHEN OTHERS THEN
    DBMS_OUTPUT.put_line('导出数据' || file_name || '失败');
    UTL_FILE.fclose(v_file);
    raise;
END exp_data;











--------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE genins_file(
    p_table     IN varchar2,
    p_output_folder IN VARCHAR2,
    p_output_file   IN VARCHAR2)
IS
--
  l_column_list       VARCHAR2(32767);
  l_value_list        VARCHAR2(32767);
  l_query             VARCHAR2(32767);
  l_cursor            NUMBER;
  ignore         NUMBER;
  l_insertline1          varchar2(32767);
  l_insertline2          varchar2(32767);
  cmn_file_handle       UTL_FILE.file_type;

  --

  FUNCTION get_cols(p_table VARCHAR2)
  RETURN VARCHAR2
  IS
    l_cols VARCHAR2(32767);
    CURSOR l_col_cur(c_table VARCHAR2) IS
            SELECT column_name
            FROM   user_tab_columns
            WHERE  table_name = upper(c_table)
            ORDER BY column_id;
  BEGIN
    l_cols := null;
    FOR rec IN l_col_cur(p_table)
    LOOP
      l_cols := l_cols || rec.column_name || ',';
    END LOOP;
    RETURN substr(l_cols,1,length(l_cols)-1);
  END;

  --

  FUNCTION get_query(p_table IN VARCHAR2)
  RETURN VARCHAR2
  IS
    l_query VARCHAR2(32767);
      CURSOR l_query_cur(c_table VARCHAR2) IS
        SELECT 'decode('||column_name||',null,''null'','||
               decode(data_type,'VARCHAR2','''''''''||'||column_name ||'||'''''''''
               ,'DATE','''''''''||to_char('||column_name||',''YYYY-MM-DD HH24:MI:SS'')||'''''''''
               ,column_name
               ) || ')' column_query
          FROM user_tab_columns
         WHERE table_name = upper(c_table)
        ORDER BY column_id;
  BEGIN
    l_query := 'SELECT ';
    FOR rec IN l_query_cur(p_table)
    LOOP
      l_query := l_query || rec.column_query || '||'',''||';
    END LOOP;
    l_query := substr(l_query,1,length(l_query)-7);
    RETURN l_query || ' FROM ' || p_table;
  END;

  --

BEGIN
  l_column_list  := get_cols(p_table);
  l_query        := get_query(p_table);
  l_cursor := dbms_sql.open_cursor;
  DBMS_SQL.PARSE(l_cursor, l_query, DBMS_SQL.native);
  DBMS_SQL.DEFINE_COLUMN(l_cursor, 1, l_value_list, 32767);
  ignore := DBMS_SQL.EXECUTE(l_cursor);

  --

  IF NOT UTL_FILE.IS_OPEN(cmn_file_handle) THEN
        cmn_file_handle := UTL_FILE.FOPEN (p_output_folder, p_output_file, 'a',32767);
  END IF;

  LOOP
    IF DBMS_SQL.FETCH_ROWS(l_cursor)>0 THEN
      DBMS_SQL.COLUMN_VALUE(l_cursor, 1, l_value_list);
      l_insertline1:='INSERT INTO '||p_table||' ('||l_column_list||')';
      l_insertline2:=' VALUES ('||l_value_list||');';
      UTL_FILE.put_line (cmn_file_handle, l_insertline1);
      UTL_FILE.put_line (cmn_file_handle, l_insertline2);
    ELSE
      EXIT;
    END IF;
  END LOOP;
  IF NOT UTL_FILE.IS_OPEN(cmn_file_handle) THEN
     UTL_FILE.FCLOSE (cmn_file_handle);
  END IF;
END;
/
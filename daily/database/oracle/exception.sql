CREATE OR REPLACE TRIGGER city_insert
AFTER INSERT OR DELETE OR UPDATE ON CITY
FOR EACH ROW

DECLARE
    MYEXCEPTION EXCEPTION;
    PRAGMA EXCEPTION_INIT(MYEXCEPTION,-20001);
    V_SQL VARCHAR2(4000):='';
  BEGIN
    CASE WHEN INSERTING THEN
      V_SQL:=:NEW.ID||'--'||:NEW.NAME;
      INSERT INTO SQL_LOG(ID,SQL_LOG,CDATE,OPERATION) VALUES(F_GETNID(),V_SQL,SYSDATE,'INSERTING');

      WHEN UPDATING THEN
      V_SQL:=:NEW.ID||'--'||:NEW.NAME;
      INSERT INTO SQL_LOG(ID,SQL_LOG,CDATE,OPERATION) VALUES(F_GETNID(),V_SQL,SYSDATE,'UPDATING');
      WHEN DELETING THEN
      V_SQL:=:OLD.ID||'--'||:OLD.NAME;
      INSERT INTO SQL_LOG(ID,SQL_LOG,CDATE,OPERATION) VALUES(F_GETNID(),V_SQL,SYSDATE,'DELETING');
    END CASE;
    EXCEPTION
      WHEN MYEXCEPTION THEN
          RAISE_APPLICATION_ERROR(-20001,'TRIGGER EXCUTION ERROR');
      WHEN OTHERS THEN
                dbms_output.put_line('ERROR');  --DO NOTHING

  END;

Oracle 存储过程异常处理
1、异常的优点
　　
　　如果没有异常，在程序中，应当检查每个命令的成功还是失败，如
　　BEGIN
　　SELECT ...
　　-- check for ’no data found’ error
　　SELECT ...
　　-- check for ’no data found’ error
　　SELECT ...
　　-- check for ’no data found’ error
　　这种实现的方法缺点在于错误处理没有与正常处理分开，可读性差，使用异常，可以方便处理错误，而且异常处理程序与正常的事务逻辑分开，提高了可读性，如
　　BEGIN
　　SELECT ...
　　SELECT ...
　　SELECT ...
　　...
　　EXCEPTION
　　WHEN NO_DATA_FOUND THEN -- catches all ’no data found’ errors
　　
　　2、异常的分类
　　
　　有两种类型的异常，一种为内部异常，一种为用户自定义异常，内部异常是执行期间返回到PL/SQL块的ORACLE错误或由PL/SQL代码的某操作引起的错误，如除数为零或内存溢出的情况。用户自定义异常由开发者显示定义，在PL/SQL块中传递信息以控制对于应用的错误处理。
　　
　　每当PL/SQL违背了ORACLE原则或超越了系统依赖的原则就会隐式的产生内部异常。因为每个ORACLE错误都有一个号码并且在PL/SQL中异常通过名字处理，ORACLE提供了预定义的内部异常。如SELECT INTO 语句不返回行时产生的ORACLE异常NO_DATA_FOUND。对于预定义异常，现将最常用的异常列举如下：
　　exception　 oracle error　 sqlcode value　 condition
　　no_data_found　　　　　　　　　　　　　 ora-01403　 +100　 select into 语句没有符合条件的记录返回
　　too_many_rows　 ora-01422　 -1422　 select into 语句符合条件的记录有多条返回
　　dup_val_on_index　 ora-00001　 -1　 对于数据库表中的某一列，该列已经被限制为唯一索引，程序试图存储两个重复的值
　　value_error　 ora-06502　 -6502　 在转换字符类型，截取或长度受限时，会发生该异常，如一个字符分配给一个变量，而该变量声明的长度比该字符短，就会引发该异常
　　storage_error　 ora-06500　 -6500　 内存溢出
　　zero_divide　 ora-01476　 -1476　 除数为零
　　case_not_found　 ora-06592　 -6530　 对于选择case语句，没有与之相匹配的条件，同时，也没有else语句捕获其他的条件
　　cursor_already_open　 ora-06511　 -6511　 程序试图打开一个已经打开的游标
　　timeout_on_resource　 ora-00051　 -51　 系统在等待某一资源，时间超时
　　
　　如果要处理未命名的内部异常，必须使用OTHERS异常处理器或PRAGMA EXCEPTION_INIT 。PRAGMA由编译器控制，或者是对于编译器的注释。PRAGMA在编译时处理，而不是在运行时处理。EXCEPTION_INIT告诉编译器将异常名与ORACLE错误码结合起来，这样可以通过名字引用任意的内部异常，并且可以通过名字为异常编写一适当的异常处理器。
　　
　　在子程序中使用EXCEPTION_INIT的语法如下：
　　PRAGMA EXCEPTION_INIT(exception_name, -Oracle_error_number);
　　
　　在该语法中，异常名是声明的异常，下例是其用法：
　　DECLARE
　　deadlock_detected EXCEPTION;
　　PRAGMA EXCEPTION_INIT(deadlock_detected, -60);
　　BEGIN
　　... -- Some operation that causes an ORA-00060 error
　　EXCEPTION
　　WHEN deadlock_detected THEN
　　-- handle the error
　　END;
　　
　　对于用户自定义异常，只能在PL/SQL块中的声明部分声明异常，异常的名字由EXCEPTION关键字引入：
　　reserved_loaned Exception
　　
　　产生异常后，控制传给了子程序的异常部分，将异常转向各自异常控制块，必须在代码中使用如下的结构处理错误：
　　Exception
　　When exception1 then
　　Sequence of statements;
　　When exception2 then
　　Sequence of statements;
　　When others then
　　
　　3、异常的抛出
　　
　　由三种方式抛出异常
　　
　　1． 通过PL/SQL运行时引擎
　　
　　2. 使用RAISE语句
　　
　　3. 调用RAISE_APPLICATION_ERROR存储过程
　　
　　当数据库或PL/SQL在运行时发生错误时，一个异常被PL/SQL运行时引擎自动抛出。异常也可以通过RAISE语句抛出
　　RAISE exception_name;
　　
　　显式抛出异常是程序员处理声明的异常的习惯用法，但RAISE不限于声明了的异常，它可以抛出任何任何异常。例如，你希望用TIMEOUT_ON_RESOURCE错误检测新的运行时异常处理器，你只需简单的在程序中使用下面的语句：
　　RAISE TIMEOUT_ON_RESOUCE;
　　
　　比如下面一个订单输入的例子，若当订单小于库存数量，则抛出异常，并且捕获该异常，处理异常
　　DECLARE
　　inventory_too_low EXCEPTION;
　　
　　---其他声明语句
　　BEGIN
　　IF order_rec.qty>inventory_rec.qty THEN
　　RAISE inventory_too_low;
　　END IF
　　EXCEPTION
　　WHEN inventory_too_low THEN
　　order_rec.staus:='backordered';
　　END;
　　
　　RAISE_APPLICATION_ERROR内建函数用于抛出一个异常并给异常赋予一个错误号以及错误信息。自定义异常的缺省错误号是+1,缺省信息是User_Defined_Exception。RAISE_APPLICATION_ERROR函数能够在pl/sql程序块的执行部分和异常部分调用，显式抛出带特殊错误号的命名异常。　 Raise_application_error(error_number,message[,true,false]))
　　
　　错误号的范围是-20,000到-20,999。错误信息是文本字符串，最多为2048字节。TRUE和FALSE表示是添加(TRUE)进错误堆(ERROR STACK)还是覆盖(overwrite)错误堆(FALSE)。缺省情况下是FALSE。
　　
　　如下代码所示：
　　IF product_not_found THEN
　　RAISE_APPLICATION_ERROR(-20123,'Invald product code' TRUE);
　　END IF;
　　
　　4、异常的处理
　　
　　PL/SQL程序块的异常部分包含了程序处理错误的代码，当异常被抛出时，一个异常陷阱就自动发生，程序控制离开执行部分转入异常部分,一旦程序进入异常部分就不能再回到同一块的执行部分。下面是异常部分的一般语法：
　　EXCEPTION
　　WHEN exception_name THEN
　　Code for handing exception_name
　　[WHEN another_exception THEN
　　Code for handing another_exception]
　　[WHEN others THEN
　　code for handing any other exception.]
　　
　　用户必须在独立的WHEN子串中为每个异常设计异常处理代码，WHEN OTHERS子串必须放置在最后面作为缺省处理器处理没有显式处理的异常。当异常发生时，控制转到异常部分，ORACLE查找当前异常相应的WHEN..THEN语句，捕捉异常，THEN之后的代码被执行，如果错误陷阱代码只是退出相应的嵌套块，那么程序将继续执行内部块END后面的语句。如果没有找到相应的异常陷阱，那么将执行WHEN OTHERS。在异常部分WHEN 子串没有数量限制。
　　EXCEPTION
　　WHEN inventory_too_low THEN
　　order_rec.staus:='backordered';
　　replenish_inventory(inventory_nbr=>
　　inventory_rec.sku,min_amount=>order_rec.qty-inventory_rec.qty);
　　WHEN discontinued_item THEN
　　--code for discontinued_item processing
　　WHEN zero_divide THEN
　　--code for zero_divide
　　WHEN OTHERS THEN
　　--code for any other exception
　　END;
　　
　　当异常抛出后，控制无条件转到异常部分，这就意味着控制不能回到异常发生的位置，当异常被处理和解决后，控制返回到上一层执行部分的下一条语句。
　　BEGIN
　　DECLARE
　　bad_credit exception;
　　BEGIN
　　RAISE bad_credit;
　　--发生异常，控制转向；
　　EXCEPTION
　　WHEN bad_credit THEN
　　dbms_output.put_line('bad_credit');
　　END;
　　--bad_credit异常处理后，控制转到这里
　　EXCEPTION
　　WHEN OTHERS THEN
　　
　　--控制不会从bad_credit异常转到这里
　　
　　--因为bad_credit已被处理
　　
　　END;
　　
　　当异常发生时，在块的内部没有该异常处理器时，控制将转到或传播到上一层块的异常处理部分。
　　
　　BEGIN
　　DECLARE ---内部块开始
　　
　　bad_credit exception;
　　BEGIN
　　RAISE bad_credit;
　　
　　--发生异常，控制转向；
　　EXCEPTION
　　WHEN ZERO_DIVIDE THEN --不能处理bad_credite异常
　　dbms_output.put_line('divide by zero error');
　　
　　END --结束内部块
　　
　　--控制不能到达这里，因为异常没有解决；
　　
　　--异常部分
　　
　　EXCEPTION
　　WHEN OTHERS THEN
　　--由于bad_credit没有解决，控制将转到这里
　　END;
　　
　　5、异常的传播
　　
　　没有处理的异常将沿检测异常调用程序传播到外面，当异常被处理并解决或到达程序最外层传播停止。在声明部分抛出的异常将控制转到上一层的异常部分。
　　
　　BEGIN
　　executable statements
　　BEGIN
　　today DATE:='SYADATE'; --ERRROR
　　
　　BEGIN --内部块开始
　　dbms_output.put_line('this line will not execute');
　　EXCEPTION
　　WHEN OTHERS THEN
　　
　　--异常不会在这里处理
　　
　　END;--内部块结束
　　EXCEPTION
　　WHEN OTHERS THEN
　　
　　处理异常
　　
　　END



-------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------



处理 oracle 系统自动生成系统异常外，可以使用 raise 来手动生成错误。

l         Raise exception;

l         Raise package.exception;

l         Raise;

以上是 raise 的三种使用方法。第一种用于生成当前程序中定义的异常或在 standard 中的系统异常。

       Declare

              Invalid_id exception;

              Id_values varchar(2);

       Begin

              Id_value:=id_for(‘smith’);

              If substr(id_value,1,1)!=’x’

              Then

                     Raise invalid_id;

              End if;

       Exception

              When invalid_id

              Then

                     Dbms_output.put_line(‘this is an invalid id!’);

       End;

这是一个生成自定义异常的例子，当然也可以生成系统异常：

       declare

              employee_id_in number;

       Begin

Select employee_id into employee_id_in from employ_list where employee_name=&n;

If employee_id_in=0

Then

       Raise zero_devided;

End if;

       Exception

              When zero_devided

              Then

                     Dbms_output.put_line(‘wrong!’);

       End;

有一些异常是定义在非标准包中的，如 UTL_FILE ， DBMS_SQL 以及程序员创建的包中异常。可以使用 raise 的第二种用法来生成异常。

       If day_overdue(isbn_in, browser_in) > 365

       Then

              Raise overdue_pkg.book_is_lost

       End if;

在最后一种 raise 的形式中，不带任何参数。这种情况只出现在希望将当前的异常传到外部程序时。

       Exception

              When no_data_found

              Then

                     Raise;

       End;



Pl.sql 使用 raise_application_error 过程来生成一个有具体描述的异常。当使用这个过程时，当前程序被中止，输入输出参数被置为原先的值，但任何 DML 对数据库所做的改动将被保留，可以在之后用 rollback 命令回滚。下面是该过程的原型：

       Procedure raise_application_error(

       Num binary_integer;

       Msg varchar2;

       Keeperrorstack Boolean default false

)

其中 num 是在 -20999 到 -20000 之间的任何数字（但事实上， DBMS_OUPUT 和 DBMS_DESCRIBLE 包使用了 -20005 到 -20000 的数字）； msg 是小于 2K 个字符的描述语，任何大于 2K 的字符都将被自动丢弃； keeperrorstack 默认为 false ，是指清空异常栈，再将当前异常入栈，如果指定 true 的话就直接将当前异常压入栈中。

    CREATE OR REPLACE PROCEDURE raise_by_language (code_in IN PLS_INTEGER)

    IS

       l_message error_table.error_string%TYPE;

    BEGIN

       SELECT error_string

         INTO l_message

         FROM error_table, v$nls_parameters v

        WHERE error_number = code_in

          AND string_language = v.VALUE

          AND v.parameter = 'NLS_LANGUAGE';



       RAISE_APPLICATION_ERROR (code_in, l_message);

    END;





ORACL内部异常：

ORA-00001: 违反唯一约束条件 (.)
ORA-00017: 请求会话以设置跟踪事件
ORA-00018: 超出最大会话数
ORA-00019: 超出最大会话许可数
ORA-00020: 超出最大进程数 ()
ORA-00021: 会话附属于其它某些进程；无法转换会话
ORA-00022: 无效的会话 ID；访问被拒绝
ORA-00023: 会话引用进程私用内存；无法分离会话
ORA-00024: 单一进程模式下不允许从多个进程注册
ORA-00025: 无法分配
ORA-00026: 丢失或无效的会话 ID
ORA-00027: 无法删去当前会话
ORA-00028: 您的会话己被删去
ORA-00029: 会话不是用户会话
ORA-00030: 用户会话 ID 不存在。
ORA-00031: 标记要删去的会话
ORA-00032: 无效的会话移植口令
ORA-00033: 当前的会话具有空的移植口令
ORA-00034: 无法在当前 PL/SQL 会话中
ORA-00035: LICENSE_MAX_USERS 不能小于当前用户数
ORA-00036: 超过递归 SQL () 级的最大值
ORA-00037: 无法转换到属于不同服务器组的会话
ORA-00038: 无法创建会话: 服务器组属于其它用户
ORA-00050: 获取入队时操作系统出错
ORA-00051: 等待资源超时
ORA-00052: 超出最大入队资源数 ()
ORA-00053: 超出最大入队数
ORA-00054: 资源正忙，要求指定 NOWAIT
ORA-00055: 超出 DML 锁的最大数
ORA-00056: 对象 '.' 上的 DDL 锁以不兼容模式挂起
ORA-00057: 超出临时表锁的最大数
ORA-00058: DB_BLOCK_SIZE 必须为才可安装此数据库 (非 )
ORA-00059: 超出 DB_FILES 的最大值
ORA-00060: 等待资源时检测到死锁
ORA-00061: 另一个例程设置了不同的 DML_LOCKS
ORA-00062: 无法获得 DML 全表锁定；DML_LOCKS 为 0
ORA-00063: 超出 LOG_FILES 的最大数
ORA-00064: 对象过大以至无法分配在此 O/S (，)
ORA-00065: FIXED_DATE 的初始化失败
ORA-00066: LOG_FILES 为  但需要成为  才可兼容
ORA-00067: 值  对参数  无效；至少必须为
ORA-00068: 值  对参数  无效，必须在  和  之间
ORA-00069: 无法获得锁定 -- 禁用了表锁定
ORA-00070: 命令无效
ORA-00071: 进程号必须介于 1 和  之间
ORA-00072: 进程""不活动
ORA-00073: 命令  介于  和  个参数之间时使用
ORA-00074: 未指定进程
ORA-00075: 在此例程未找到进程 ""
ORA-00076: 未找到转储
ORA-00077: 转储  无效
ORA-00078: 无法按名称转储变量
ORA-00079: 未找到变量
ORA-00080: 层次  指定的全局区域无效
ORA-00081: 地址范围 [，) 不可读
ORA-00082:  的内存大小不在有效集合 [1], [2], [4] 之内
ORA-00083: 警告: 可能损坏映射的 SGA
ORA-00084: 全局区域必须为 PGA, SGA 或 UGA
ORA-00085: 当前调用不存在
ORA-00086: 用户调用不存在
ORA-00087: 命令无法在远程例程上执行
ORA-00088: 共享服务器无法执行命令
ORA-00089: ORADEBUG 命令中无效的例程号
ORA-00090: 未能将内存分配给群集数据库 ORADEBUG 命令
ORA-00091: LARGE_POOL_SIZE 至少必须为
ORA-00092: LARGE_POOL_SIZE 必须大于 LARGE_POOL_MIN_ALLOC
ORA-00093:  必须介于  和  之间
ORA-00094:  要求整数值
ORA-00096: 值  对参数  无效，它必须来自  之间
ORA-00097: 使用 Oracle SQL 特性不在 SQL92  级中
ORA-00099: 等待资源时发生超时，可能是 PDML 死锁所致
ORA-00100: 未找到数据
ORA-00101: 系统参数 DISPATCHERS 的说明无效
ORA-00102: 调度程序无法使用网络协议
ORA-00103: 无效的网络协议；供调度程序备用
ORA-00104: 检测到死锁；全部公用服务器已锁定等待资源
ORA-00105: 未配置网络协议  的调度机制
ORA-00106: 无法在连接到调度程序时启动/关闭数据库
ORA-00107: 无法连接到 ORACLE 监听器进程
ORA-00108: 无法设置调度程序以同步进行连接
ORA-00111: 由于服务器数目限制在 , 所以没有启动所有服务器
ORA-00112: 仅能创建多达  (最多指定) 个调度程序
ORA-00113: 协议名  过长
ORA-00114: 缺少系统参数 SERVICE_NAMES 的值
ORA-00115: 连接被拒绝；调度程序连接表已满
ORA-00116: SERVICE_NAMES 名过长
ORA-00117: 系统参数 SERVICE_NAMES 的值超出范围
ORA-00118: 系统参数 DISPATCHERS 的值超出范围
ORA-00119: 系统参数  的说明无效
ORA-00120: 未启用或安装调度机制
ORA-00121: 在缺少 DISPATCHERS 的情况下指定了 SHARED_SERVERS
ORA-00122: 无法初始化网络配置
ORA-00123: 空闲公用服务器终止
ORA-00124: 在缺少 MAX_SHARED_SERVERS 的情况下指定了 DISPATCHERS
ORA-00125: 连接被拒绝；无效的演示文稿
ORA-00126: 连接被拒绝；无效的重复
ORA-00127: 调度进程  不存在
ORA-00128: 此命令需要调度进程名
ORA-00129: 监听程序地址验证失败 ''
ORA-00130: 监听程序地址 '' 无效
ORA-00131: 网络协议不支持注册 ''
ORA-00132: 语法错误或无法解析的网络名称 ''
ORA-00150: 重复的事务处理 ID
ORA-00151: 无效的事务处理 ID
ORA-00152: 当前会话与请求的会话不匹配
ORA-00153: XA 库中的内部错误
ORA-00154: 事务处理监视器中的协议错误
ORA-00155: 无法在全局事务处理之外执行工作
ORA-00160: 全局事务处理长度  超出了最大值 ()
ORA-00161: 事务处理的分支长度  非法 (允许的最大长度为 )
ORA-00162: 外部 dbid 的长度  超出了最大值 ()
ORA-00163: 内部数据库名长度  超出了最大值 ()
ORA-00164: 在分布式事务处理中不允许独立的事务处理
ORA-00165: 不允许对远程操作进行可移植分布式自治转换
ORA-00200: 无法创建控制文件
ORA-00201: 控制文件版本  与 ORACLE 版本  不兼容
ORA-00202: 控制文件: ''
ORA-00203: 使用错误的控制文件
ORA-00204: 读控制文件时出错 (块 ，# 块 )
ORA-00205: 标识控制文件出错，有关详情，请检查警告日志
ORA-00206: 写控制文件时出错 (块 ，# 块 )
ORA-00207: 控制文件不能用于同一数据库
ORA-00208: 控制文件的名称数超出限制
ORA-00209: 控制文件块大小不匹配，有关详情，请检查警告日志
ORA-00210: 无法打开指定的控制文件
ORA-00211: 控制文件与先前的控制文件不匹配
ORA-00212: 块大小  低于要求的最小大小 ( 字节)
ORA-00213: 不能重新使用控制文件；原文件大小为 ，还需
ORA-00214: 控制文件 '' 版本  与文件 '' 版本  不一致
ORA-00215: 必须至少存在一个控制文件
ORA-00216: 无法重新调整从 8.0.2 移植的控制文件大小
ORA-00217: 从 9.0.1 进行移植无法重新调整控制文件的大小
ORA-00218: 控制文件的块大小  与 DB_BLOCK_SIZE () 不匹配
ORA-00219: 要求的控制文件大小  超出了允许的最大值
ORA-00220: 第一个例程未安装控制文件，有关详情，请检查警告日志
ORA-00221: 写入控制文件出错
ORA-00222: 操作将重新使用当前已安装控制文件的名称
ORA-00223: 转换文件无效或版本不正确
ORA-00224: 控制文件重设大小尝试使用非法记录类型 ()
ORA-00225: 控制文件的预期大小  与实际大小  不同
ORA-00226: 备用控制文件打开时不允许进行操作
ORA-00227: 控制文件中检测到损坏的块: (块 ，# 块 )
ORA-00228: 备用控制文件名长度超出了最大长度
ORA-00229: 操作不允许: 已挂起快照控制文件入队
ORA-00230: 操作不允许: 无法使用快照控制文件入队
ORA-00231: 快照控制文件未命名
ORA-00232: 快照控制文件不存在, 已损坏或无法读取
ORA-00233: 控制文件副本已损坏或无法读取
ORA-00234: 标识或打开快照或复制控制文件时出错
ORA-00235: 控制文件固定表因并发更新而不一致
ORA-00236: 快照操作不允许: 挂上的控制文件为备份文件
ORA-00237: 快照操作不允许: 控制文件新近创建
ORA-00238: 操作将重用属于数据库一部分的文件名
ORA-00250: 未启动存档器
ORA-00251: LOG_ARCHIVE_DUPLEX_DEST 不能是与字符串  相同的目的地
ORA-00252: 日志  在线程  上为空，无法存档
ORA-00253: 字符限制在  以内，归档目的字符串  超出此限制
ORA-00254: 存档控制字符串 '' 时出错
ORA-00255: 存档日志  (线程 , 序列 # ) 时出错
ORA-00256: 无法翻译归档目的字符串
ORA-00257: 存档器错误。在释放之前仅限于内部连接
ORA-00258: NOARCHIVELOG 模式下的人工存档必须标识日志
ORA-00259: 日志  (打开线程 ) 为当前日志，无法存档
ORA-00260: 无法找到联机日志序列  (线程 )
ORA-00261: 正在存档或修改日志  (线程 )
ORA-00262: 当前日志  (关闭线程 ) 无法切换
ORA-00263: 线程  没有需要存档的记录
ORA-00264: 不要求恢复
ORA-00265: 要求例程恢复，无法设置 ARCHIVELOG 模式
ORA-00266: 需要存档日志文件名
ORA-00267: 无需存档日志文件名
ORA-00268: 指定的日志文件不存在 ''
ORA-00269: 指定的日志文件为线程  的一部分 (非 )
ORA-00270: 创建存档日志  时出错
ORA-00271: 没有需要存档的日志
ORA-00272: 写存档日志  时出错
ORA-00273: 未记录的直接加载数据的介质恢复
ORA-00274: 非法恢复选项
ORA-00275: 已经开始介质恢复
ORA-00276: CHANGE 关键字已指定但未给出更改编号
ORA-00277: UNTIL 恢复标志  的非法选项
ORA-00278: 此恢复不再需要日志文件 ''
ORA-00279: 更改  (在  生成) 对于线程  是必需的
ORA-00280: 更改  对于线程  是按序列 #  进行的
ORA-00281: 不能使用调度进程执行介质恢复
ORA-00282: UPI  调用不被支持，请使用 ALTER DATABASE RECOVER
ORA-00283: 恢复会话因错误而取消
ORA-00284: 恢复会话仍在进行
ORA-00285: TIME 未作为字符串常数给出
ORA-00286: 无可用成员，或成员无有效数据
ORA-00287: 未找到指定的更改编号  (在线程  中)
ORA-00288: 要继续恢复，请键入 ALTER DATABASE RECOVER CONTINUE
ORA-00289: 建议:
ORA-00290: 操作系统出现存档错误。请参阅下面的错误
ORA-00291: PARALLEL 选项要求数字值
ORA-00292: 未安装并行恢复功能
ORA-00293: 控制文件与重做日志不同步
ORA-00294: 无效的存档日志格式标识 ''
ORA-00295: 数据文件号  无效，必须介于 1 与  之间
ORA-00296: 已超出 RECOVER DATAFILE LIST 的最大文件数 ()
ORA-00297: 必须在 RECOVER DATAFILE START 之前指定 RECOVER DATAFILE LIST
ORA-00298: 丢失或无效的 TIMEOUT 间隔
ORA-00299: 必须在数据文件  上使用文件级介质恢复
ORA-00300: 指定的重做日志块大小  非法 - 超出限制
ORA-00301: 添加日志文件 '' 时出错 - 无法创建文件
ORA-00302: 日志超出限制
ORA-00303: 无法处理多次中断的重做
ORA-00304: 请求的 INSTANCE_NUMBER 在使用中
ORA-00305: 日志  (线程 ) 不一致；属于另一个数据库
ORA-00306: 此数据库中的例程限制
ORA-00307: 请求的 INSTANCE_NUMBER 超出限制，最大为
ORA-00308: 无法打开存档日志 ''
ORA-00309: 日志属于错误的数据库
ORA-00310: 存档日志包含序列 ；要求序列
ORA-00311: 无法从存档日志读取标题
ORA-00312: 联机日志  线程 : ''
ORA-00313: 无法打开日志组  (线程 ) 的成员
ORA-00314: 日志  (线程 )，预计序号  与  不匹配
ORA-00315: 日志  (线程 )，标题中的线程 #  错误
ORA-00316: 日志  (线程 )，标题中的类型  不是日志文件
ORA-00317: 标题中的文件类型  不是日志文件
ORA-00318: 日志  (线程 )，预计文件大小  与  不匹配
ORA-00319: 日志  (线程 ) 具有错误的日志重置状态
ORA-00320: 无法从日志  (线程 ) 读取文件标题
ORA-00321: 日志  (线程 )，无法更新日志文件标题
ORA-00322: 日志  (线程 ) 不是当前副本
ORA-00323: 线程  的当前日志不可用而所有其它日志均需要存档
ORA-00324: 日志文件 '' 的翻译名 '' 太长， 字符超出  限制
ORA-00325: 已归档线程  的日志，标题中的线程 #  错误
ORA-00326: 日志在更改  开始，需要更早的更改
ORA-00327: 日志  (线程 )，实际大小  小于需要的
ORA-00328: 归档日志在更改  结束，需要稍后的更改
ORA-00329: 归档日志在更改  开始，需要更改
ORA-00330: 归档日志在更改  结束，需要更改
ORA-00331: 日志版本  与 ORACLE 版本  不兼容
ORA-00332: 归档日志过小 - 可能未完全归档
ORA-00333: 重做日志读取块  计数  出错
ORA-00334: 归档日志: ''
ORA-00335: 联机日志 : 没有此编号的日志，日志不存在
ORA-00336: 大小为  的日志文件块数小于最小  块数
ORA-00337: 日志文件 '' 不存在且未指定大小
ORA-00338: 日志  (线程 ) 比控制文件更新
ORA-00339: 归档日志未包含任何重做
ORA-00340: 处理联机日志  (线程 ) 时出现 I/O 错误
ORA-00341: 日志  (线程 )，标题中的日志 #  错误
ORA-00342: 归档日志在上一个 RESETLOGS 之前创建程序包
ORA-00343: 错误过多，已关闭日志成员
ORA-00344: 无法重新创建联机日志 ''
ORA-00345: 重做日志写入块  计数  出错
ORA-00346: 日志成员标记为 STALE
ORA-00347: 日志  (线程 )，预计块大小  与  不匹配
ORA-00348: 单一进程重做失败；必须中止例程
ORA-00349: 无法获得 '' 的块大小
ORA-00350: 日志  (线程 ) 中需要归档
ORA-00351: recover-to 时间无效
ORA-00352: 线程  的所有日志均需要归档 - 无法启用
ORA-00353: 日志损坏接近块  更改  时间
ORA-00354: 损坏重做日志块标题
ORA-00355: 更改编号无次序
ORA-00356: 更改说明中的长度不一致
ORA-00357: 日志文件指定了过多成员，最大为
ORA-00358: 指定了过多文件成员，最大为
ORA-00359: 日志文件组  不存在
ORA-00360: 非日志文件成员:
ORA-00361: 无法删除最后一个日志成员  (组 )
ORA-00362: 组成组  中的有效日志文件要求输入成员
ORA-00363: 日志不是归档版本
ORA-00364: 无法将标题写入新日志成员
ORA-00365: 指定日志不是正确的下一个日志
ORA-00366: 日志  (线程 )，文件标题中的校验和错误
ORA-00367: 日志文件标题中的校验和错误
ORA-00368: 重做日志块中的校验和错误
ORA-00369: 线程  的当前日志不可用且其它日志已被清除
ORA-00370: Rcbchange 操作过程中可能出现死锁
ORA-00371: 共享池内存不足
ORA-00372: 此时无法修改文件
ORA-00373: 联机日志版本  与 ORACLE 版本  不兼容
ORA-00374: 参数 db_block_size =  无效; 它必须是  的倍数, 范围为 [..]
ORA-00375: 无法获得默认 db_block_size
ORA-00376: 此时无法读取文件
ORA-00377: 文件  的频繁备份导致写操作延迟
ORA-00378: 无法按指定创建缓冲池
ORA-00379: 缓冲池  中无法提供 K 块大小的空闲缓冲区
ORA-00380: 无法指定 db_k_cache_size, 因为 K 是标准块大小
ORA-00381: 无法将新参数和旧参数同时用于缓冲区高速缓存的大小说明
ORA-00382:  不是有效的块大小, 有效范围为 [..]
ORA-00383: DEFAULT 高速缓存的块大小  不能减少至零
ORA-00384: 没有足够的内存来增加高速缓存的大小
ORA-00385: cannot enable Very Large Memory with new buffer cache parameters
ORA-00390: 日志  (线程 ) 正被清除，无法成为当前日志
ORA-00391: 所有线程必须同时转换为新的日志格式
ORA-00392: 日志  (线程 ) 正被清除，不允许操作
ORA-00393: 脱机数据文件的恢复需要日志  (线程 )
ORA-00394: 在尝试存档时重新使用联机日志
ORA-00395: '克隆' 数据库的联机日志必须重命名
ORA-00396: 错误  需要退回到单次遍历恢复
ORA-00397: 对于文件  (块 ), 检测到写入丢失情况
ORA-00398: 由于重新配置而中止了线程恢复
ORA-00399: 重做日志中的更改说明已损坏
ORA-00400: 无效的版本值  (对于参数 )
ORA-00401: 此版本不支持参数  的值
ORA-00402: 版本  的数据库更改无法用于版本
ORA-00403:  () 不同于其它例程 ()
ORA-00404: 未找到转换文件: ''
ORA-00405: 兼容类型""
ORA-00406: COMPATIBLE 参数需要为  或更大
ORA-00407: 不允许从版本 . 到 . 滚动升级
ORA-00408: 参数  设置为 TRUE
ORA-00409: COMPATIBLE 必须是  或更高值才能使用 AUTO SEGMENT SPACE MANAGEMENT
ORA-00436: 没有 ORACLE 软件使用权，请与 Oracle 公司联系获得帮助
ORA-00437: 没有 ORACLE 软件功能使用权，请与 Oracle 公司联系获得帮助
ORA-00438: 未安装  选项
ORA-00439: 未启用特性:
ORA-00443: 背景进程 "" 未启动
ORA-00444: 背景进程 "" 启动时失败
ORA-00445: 背景进程 "" 在  秒之后仍没有启动
ORA-00446: 背景进程意外启动
ORA-00447: 背景进程出现致命错误
ORA-00448: 背景进程正常结束
ORA-00449: 背景进程 '' 因错误  异常终止
ORA-00470: LGWR 进程因错误而终止
ORA-00471: DBWR 进程因错误而终止
ORA-00472: PMON 进程因错误而终止
ORA-00473: ARCH 进程因错误而终止
ORA-00474: SMON 进程因错误而终止
ORA-00475: TRWR 进程因错误而终止
ORA-00476: RECO 进程因错误而终止
ORA-00477: SNP* 进程因错误而终止
ORA-00478: SMON 进程由于  错误终止
ORA-00480: LCK* 进程因错误而终止
ORA-00481: LMON 进程因错误而终止
ORA-00482: LMD* 进程因错误而终止
ORA-00483: 关闭进程过程中异常终止
ORA-00484: LMS* 进程因错误而终止
ORA-00485: DIAG 进程由于  错误终止
ORA-00486: 功能不可用
ORA-00568: 超出中断处理程序的最大数
ORA-00574: osndnt: $CANCEL 失败 (中断)
ORA-00575: osndnt: $QIO 失败 (发送 out-of-band 中断)
ORA-00576: 带内中断协议错误
ORA-00577: 带外中断协议错误
ORA-00578: 重置协议错误
ORA-00579: osndnt: 服务器收到连接请求格式不正确
ORA-00580: 协议版本不匹配
ORA-00581: osndnt: 无法分配上下文区域
ORA-00582: osndnt: 无法撤消分配上下文区域
ORA-00583: osndnt: $TRNLOG 失败
ORA-00584: 无法关闭连接
ORA-00585: 主机名称格式错误
ORA-00586: osndnt: LIB$ASN_WTH_MBX 失败
ORA-00587: 无法连接到远程主机
ORA-00588: 来自主机的信息过短
ORA-00589: 来自主机的信息数据长度错误
ORA-00590: 来自主机的信息类型错误
ORA-00591: 写入的字节数错误
ORA-00592: osndnt: $QIO 失败 (邮箱队列)
ORA-00593: osndnt: $DASSGN 失败 (网络设备)
ORA-00594: osndnt: $DASSGN 失败 (邮箱)
ORA-00595: osndnt: $QIO 失败 (接收)
ORA-00596: osndnt: $QIO 失败 (发送)
ORA-00597: osndnt: $QIO 失败 (邮箱队列)
ORA-00598: osndnt: $QIO IO 失败 (邮箱读取)
ORA-00600: 内部错误代码，参数: [], [], [], [], [], [], [], []
ORA-00601: 清除锁定冲突
ORA-00602: 内部编程异常错误
ORA-00603: ORACLE 服务器会话因致命错误而终止
ORA-00604: 递归 SQL 层  出现错误
ORA-00606: 内部错误代码
ORA-00607: 当更改数据块时出现内部错误
ORA-00701: 无法改变热启动数据库所需的对象
ORA-00702: 引导程序版本 '' 与版本 '' 不一致
ORA-00703: 超出行高速缓存例程锁的最大数
ORA-00704: 引导程序进程失败
ORA-00705: 启动过程中的状态不一致；请在关闭例程后重新启动
ORA-00706: 更改文件 '' 的格式时出错
ORA-00816: 错误信息无法转换
ORA-00900: 无效 SQL 语句
ORA-00901: 无效 CREATE 命令
ORA-00902: 无效数据类型
ORA-00903: 表名无效
ORA-00904: : 无效的标识符
ORA-00905: 缺少关键字
ORA-00906: 缺少左括号
ORA-00907: 缺少右括号
ORA-00908: 缺少 NULL 关键字
ORA-00909: 参数个数无效
ORA-00910: 指定的长度对于数据类型而言过长
ORA-00911: 无效字符
ORA-00913: 值过多
ORA-00914: 缺少 ADD 关键字
ORA-00915: 当前不允许网络访问字典表
ORA-00917: 缺少逗号
ORA-00918: 未明确定义列
ORA-00919: 无效函数
ORA-00920: 无效的关系运算符
ORA-00921: 未预期的 SQL 命令结尾
ORA-00922: 缺少或无效选项
ORA-00923: 未找到预期 FROM 关键字
ORA-00924: 缺少 BY 关键字
ORA-00925: 缺失 INTO 关键字
ORA-00926: 缺少 VALUES 关键字
ORA-00927: 缺少等号
ORA-00928: 缺少 SELECT 关键字
ORA-00929: 缺少句号
ORA-00930: 缺少星号
ORA-00931: 缺少标识
ORA-00932: 不一致的数据类型: 要求  得到的却是
ORA-00933: SQL 命令未正确结束
ORA-00934: 此处不允许使用分组函数
ORA-00935: 分组函数的嵌套太深
ORA-00936: 缺少表达式
ORA-00937: 非单组分组函数
ORA-00938: 函数没有足够的参数
ORA-00939: 函数的参数过多
ORA-00940: 无效的 ALTER 命令
ORA-00941: 群集名缺少
ORA-00942: 表或视图不存在
ORA-00943: 群集不存在
ORA-00944: 没有足够的聚簇列数
ORA-00945: 指定的聚簇列不存在
ORA-00946: 缺少 TO 关键字
ORA-00947: 没有足够的值
ORA-00948: 不再支持 ALTER CLUSTER 语句
ORA-00949: 非法引用远程数据库
ORA-00950: 无效 DROP 选项
ORA-00951: 群集非空
ORA-00952: 缺少 GROUP 关键字
ORA-00953: 缺少或无效索引名
ORA-00954: 缺少 IDENTIFIED 关键字
ORA-00955: 名称已由现有对象使用
ORA-00956: 缺少或无效审计选项
ORA-00957: 列名重复
ORA-00958: 缺少 CHECK 关键字
ORA-00959: 表空间''不存在
ORA-00960: 选择列表中的命名含糊
ORA-00961: 错误的日期/间隔值
ORA-00962: group-by / order-by 表达式过多
ORA-00963: 不支持的间隔类型
ORA-00964: 表名不在 FROM 列表中
ORA-00965: 列别名中不允许'*'
ORA-00966: 缺少 TABLE 关键字
ORA-00967: 缺少 WHERE 关键字
ORA-00968: 缺少 INDEX 关键字
ORA-00969: 缺少 ON 关键字
ORA-00970: 缺少 WITH 关键字
ORA-00971: 缺少 SET 关键字
ORA-00972: 标识过长
ORA-00973: 无效的行数估计
ORA-00974: 无效 PCTFREE 值 (百分比)
ORA-00975: 不允许日期 + 日期
ORA-00976: 此处不允许为 LEVEL, PRIOR 或 ROWNUM
ORA-00977: 重复的审计选项
ORA-00978: 嵌套分组函数没有 GROUT BY
ORA-00979: 不是 GROUP BY 表达式
ORA-00980: 同义词转换不再有效
ORA-00981: 不能将表和系统审计选项混在一起
ORA-00982: 缺少加号
ORA-00984: 列在此处不允许
ORA-00985: 无效的程序名
ORA-00986: 缺少或无效组名
ORA-00987: 缺少或无效用户名
ORA-00988: 缺少或无效口令
ORA-00989: 给出的用户名口令过多
ORA-00990: 缺少或无效权限
ORA-00991: 过程仅有 MAC 权限
ORA-00992: REVOKE 命令格式无效
ORA-00993: 缺少 GRANT 关键字
ORA-00994: 缺少 OPTION 关键字
ORA-00995: 缺少或无效同义词标识
ORA-00996: 连接运算符是 || 而不是 |
ORA-00997: 非法使用 LONG 数据类型
ORA-00998: 必须使用列别名命名此表达式
ORA-00999: 无效的视图名
ORA-01000: 超出打开游标的最大数
ORA-01001: 无效的游标
ORA-01002: 读取违反顺序
ORA-01003: 语句未进行语法分析
ORA-01004: 不支持默认用户名特性；登录被拒绝
ORA-01005: 未给出口令；登录被拒绝
ORA-01006: 赋值变量不存在
ORA-01007: 选择列表中没有变量
ORA-01008: 并非所有变量都已关联
ORA-01009: 缺少法定参数
ORA-01010: 无效的 OCI 操作
ORA-01011: 在与第 6 版服务器会话时不能使用第 7 版兼容模式
ORA-01012: 没有登录
ORA-01013: 用户请求取消当前的操作
ORA-01014: ORACLE 正在关闭过程中
ORA-01015: 循环登录请求
ORA-01016: 此函数仅可以在读取后调用
ORA-01017: 无效的用户名/口令；拒绝登录
ORA-01018: 列不具有 LONG 数据类型
ORA-01019: 无法在用户方分配内存
ORA-01020: 未知的上下文状态
ORA-01021: 指定的上下文大小无效
ORA-01022: 此配置中不支持数据库操作
ORA-01023: 未找到游标上下文 (无效的游标编号)
ORA-01024: OCI 调用中的数据类型无效
ORA-01025: UPI 参数超出范围
ORA-01026: 赋值列表中存在多个大小 > 4000 的缓冲区
ORA-01027: 在数据定义操作中不允许对变量赋值
ORA-01028: 内部双工错误
ORA-01029: 内部双工错误
ORA-01030: SELECT ...INTO 变量不存在
ORA-01031: 权限不足
ORA-01032: 没有这样的用户标识
ORA-01033: ORACLE 正在初始化或关闭过程中
ORA-01034: ORACLE 不可用
ORA-01035: ORACLE 只允许具有 RESTRICTED SESSION 权限的用户使用
ORA-01036: 非法的变量名/编号
ORA-01037: 超出最大游标内存
ORA-01038: 无法写入数据库文件版本  (使用 ORACLE 版本 )
ORA-01039: 视图基本对象的权限不足
ORA-01040: 口令中的字符无效；登录被拒绝
ORA-01041: 内部错误，hostdef 扩展名不存在
ORA-01042: 不允许使用打开游标分离会话
ORA-01043: 用户方内存损坏 [], [], [], []
ORA-01044: 缓冲区大小  (与变量关联) 超出了最大限制
ORA-01045: 用户  没有 CREATE SESSION 权限；登录被拒绝
ORA-01046: 无法获得扩展上下文区域的空间
ORA-01047: 以上错误出现在 schema=, package=, procedure= 中
ORA-01048: 给定的上下文中无法找到指定的过程
ORA-01049: 流动 RPC 中不支持按名称赋值
ORA-01050: 无法获得打开上下文区域的空间
ORA-01051: 延迟 rpc 缓冲区格式无效
ORA-01052: 未指定所需的目的 LOG_ARCHIVE_DUPLEX_DEST
ORA-01053: 无法读取用户存储地址
ORA-01054: 无法写入用户存储地址
ORA-01057: 用户出口中引用的 block.field 无效或有歧义
ORA-01058: 内部 New Upi 接口错误
ORA-01059: 在赋值或执行之前进行语法分析
ORA-01060: 不允许数组赋值或执行
ORA-01061: 无法使用第 7 版客户应用程序启动第 8 版服务器
ORA-01062: 无法分配定义缓冲区所需的内存
ORA-01070: 服务器使用 Oracle 的旧版本
ORA-01071: 无法不启动 ORACLE 而执行操作
ORA-01072: 无法停止 ORACLE；因为 ORACLE 不在运行
ORA-01073: 致命的连接错误: 不能识别的调用类型
ORA-01074: 无法关闭 ORACLE；请首先在注册会话中注销
ORA-01075: 您现在已登录
ORA-01076: 尚不支持每个进程的多次登录
ORA-01077: 背景进程初始化失败
ORA-01078: 处理系统参数失败
ORA-01079: ORALCE 数据库未正确创建，操作中止
ORA-01080: 关闭 ORACLE 时出错
ORA-01081: 无法启动已在运行的 ORACLE --- 请首先关闭
ORA-01082: 'row_locking = always' 要求事务处理处理选项
ORA-01083: 参数 "" 的值与其它例程序的相应参数值不一致。
ORA-01084: OCI 调用中的参数无效
ORA-01085: 延迟 rpc 到 ".." 之前的错误
ORA-01086: 从未创建保留点 ''
ORA-01087: 不能启动 ORALCE --- 现在已登录
ORA-01088: 不能在存在活动进程时关闭 ORACLE
ORA-01089: 正在进行紧急关闭 - 不允许进行任何操作
ORA-01090: 正在进行关闭 --- 不允许连接
ORA-01091: 强行启动出错
ORA-01092: ORACLE 例程终止。强行断开连接
ORA-01093: ALTER DATABASE CLOSE 仅允许在没有连接会话时使用
ORA-01094: ALTER DATABASE CLOSE 正在进行。不允许连接
ORA-01095: DML 语句处理了零个行
ORA-01096: 程序版本 () 与例程 () 不兼容
ORA-01097: 无法在事务处理过程中关闭 - 首先提交或返回
ORA-01098: 在 Long Insert 过程中出现程序接口错误
ORA-01099: 如果在单进程模式下启动，则无法在 SHARED 模式下安装数据库
ORA-01100: 数据库已安装
ORA-01101: 要创建的数据库当前正由其它例程安装
ORA-01102: 无法在 EXCLUSIVE 模式下安装数据库
ORA-01103: 控制文件中的数据库名 '' 不是 ''
ORA-01104: 控制文件数 () 不等于
ORA-01105: 安装与其它例程的安装不兼容
ORA-01106: 必须在卸下之前关闭数据库
ORA-01107: 必须安装数据库才可以进行介质恢复
ORA-01108: 文件  正处于备份或介质恢复过程中
ORA-01109: 数据库未打开
ORA-01110: 数据文件 : ''
ORA-01111: 数据文件  名称未知 - 请重命名以更正文件
ORA-01112: 未启动介质恢复
ORA-01113: 文件  需要介质恢复
ORA-01114: 将块写入文件  时出现 IO 错误 (块 # )
ORA-01115: 从文件  读取块时出现 IO 错误 (块 # )
ORA-01116: 打开数据库文件时出错
ORA-01117: 对文件 '' 添加非法块大小: ；限制为
ORA-01118: 无法添加任何其它数据库文件: 超出限制
ORA-01119: 创建数据库文件 '' 时出错
ORA-01120: 无法删除联机数据库文件
ORA-01121: 无法重命名数据库文件  - 文件在使用中或在恢复中
ORA-01122: 数据库文件  验证失败
ORA-01123: 无法启动联机备份；未启用介质恢复
ORA-01124: 无法恢复数据文件  - 文件在使用中或在恢复中
ORA-01125: 无法禁用介质恢复 - 文件  设置了联机备份
ORA-01126: 对于此操作，数据库必须以 EXCLUSIVE 模式安装且未打开
ORA-01127: 数据库名 '' 超出  个字符的限制
ORA-01128: 无法启动联机备份 - 文件  处于脱机状态
ORA-01129: 用户默认或临时表空间不存在
ORA-01130: 数据库文件版本  与 ORACLE 版本  不兼容
ORA-01131: DB_FILES 系统参数值  超出限制
ORA-01132: 数据库文件名 '' 的长度超出  个字符的限制
ORA-01133: 日志文件名 '' 的长度超出  个字符的限制
ORA-01134: 数据库已由其它例程独立安装
ORA-01135: DML/query 访问的文件  处于脱机状态
ORA-01136: 文件  ( 块) 的指定大小小于  块的原大小
ORA-01137: 数据文件  仍处于脱机过程中
ORA-01138: 数据库必须在此例程中打开或根本没有打开
ORA-01139: RESETLOGS 选项仅在不完全数据库恢复后有效
ORA-01140: 无法结束联机备份 - 所有文件均处于脱机状态
ORA-01141: 重命名数据文件  时出错 - 未找到新文件 ''
ORA-01142: 无法结束联机备份 - 没有文件在备份中
ORA-01143: 不能禁用介质恢复 - 文件  需要介质恢
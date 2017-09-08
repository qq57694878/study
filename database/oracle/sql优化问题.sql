1.对索引操作
  免对索引字段进行计算操作

◆避免在索引字段上使用not，<>，!=

◆避免在索引列上使用IS NULL和IS NOT NULL

◆避免在索引列上出现数据类型转换

◆避免在索引字段上使用函数

◆避免建立索引的列中使用空值。
2.能用UNION ALL的语句里，不要用UNION

3.使用 exist 和not exist代替 in和not in。

4.不要以字符格式声明数字，要以数字格式声明字符值。

5.在应用程序、包和过程中限制使用select * from table这种方式

6.用Where子句替换HAVING子句
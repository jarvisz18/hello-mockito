#### MySQL 基础知识

查看死锁与解锁

````shell script
-- 查看MySQL版本
select version();

-- 解除死锁方法一:
-- 1.查询在锁的事务
select * from information_schema.INNODB_TRX;

-- 2.杀死进程id(上面执行SQL结果集trx_mysql_thread_id列 )
-- kill trx_mysql_thread_id;

-- 解除死锁方法二:
--  查询是否锁表
show open tables where In_use > 0;
-- super权限查看所有线程
show processlist;
-- 杀死进程id kill id

-- 其他查看死锁命令
-- 查看当前的事务
select * from information_schema.INNODB_TRX;
-- 查看当前锁定的事务
select * from information_schema.INNODB_LOCKS;
-- 查看当前等待锁的事务
select * from information_schema.INNODB_LOCK_WAITS;

````
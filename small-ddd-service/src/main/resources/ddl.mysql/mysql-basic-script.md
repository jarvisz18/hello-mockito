#### MySQL 基础知识

查看死锁与解锁

````
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

case when语法
````shell script
SELECT std_id FROM GROUP
CASE WHEN COUNT(*) = 1 --只加入了一个社团的学生
THEN MAX(club_id)
ELSE MAX(CASE WHEN main_club_flg = 'Y'
    THEN club_id ELSE NULL END)
  END AS main_club StudentClub
BY std_id;
````
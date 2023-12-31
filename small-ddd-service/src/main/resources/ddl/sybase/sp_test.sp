if exists(select 1
          from sysobjects
          where name = 'sp_test')
    drop proc sp_test
if exists(select 1
          from sysobjects
          where name = 'tbl_name')
    drop table tbl_name
create table tbl_name
(
    id   int         not null primary key,
    col2 varchar(32) not null
)
insert into tbl_name
values (1, 'iihero')
insert into tbl_name
values (2, 'Sybase')
insert into tbl_name
values (3, 'ASE')
create proc sp_test(@id_min int, @num_t123 int output) with recompile
as
select @num_t123 = count(a.id)
from tbl_name a
where a.id >= @id_min -- 计算id大于等于参数@id_min的id数量存入参数@num_123中返回


declare @num_t123 int
    exec sp_test 1, @num_t123 output
select @num_t123;
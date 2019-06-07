create database db1

show databases

drop database db1

show databases


create database db2

show databases

use database db2

create table db2_table (id int)

show database db2

use database default

show database default

show table db2_table

use database db2

show table db2_table


select * from classroom where building = 'Chandler' and capacity > 10
select * from student where dept_name = 'Comp. Sci.' and tot_cred >= 85 or ID > '30000'

select * from student left outer join advisor on student.ID = advisor.s_ID
select * from student right outer join advisor on student.ID = advisor.s_ID

select * from (select * from student join advisor on student.ID = advisor.s_ID) as t join instructor on t.i_ID = instructor.ID

select * from instructor where not exists(select * from advisor where i_ID = ID)
select * from student where exists (select * from advisor where s_ID = ID)
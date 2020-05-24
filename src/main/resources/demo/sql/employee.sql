drop table if exists employee;
create table employee(
id int(11) auto_increment,
lastName varchar(50) not null,
email varchar(50) not null,
gender int(2) not null default 1 comment '1:未知、2：女、3：男',
d_id int(11) not null,
primary key(id)
);
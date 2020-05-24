drop table if exists department;
create table department(
id int(11) auto_increment,
name varchar(50) not null,
primary key(id)
);
insert into department(name) values("销售部");
insert into department(name) values("研发部");
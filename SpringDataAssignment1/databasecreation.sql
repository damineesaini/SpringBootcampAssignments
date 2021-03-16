create database ttn;

use ttn;

create table employee(
	id int primary key auto_increment,
    name varchar(15),
    age int,
    location varchar(15)
);

drop table employee;
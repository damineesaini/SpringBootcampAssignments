create database ttn;
use ttn;

create table user(
	id int primary key auto_increment,
	username varchar(15),
	password varchar(15),
	role varchar(10)
);

select * from user;
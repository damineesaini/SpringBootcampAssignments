create database springdata;

use springdata;

create table employeeTable(
	empId int primary key auto_increment,
    empFirstName varchar(10),
    empLastName varchar(10),
    empSalary double,
    empAge int
);

drop table employeeTable;

insert into employeeTable values(1,"amulya","singh",67000,23);
insert into employeeTable values(2,"sakshi","drall",70000,22);
insert into employeeTable values(3,"damini","saini",78000,22);

create table payment(
id int PRIMARY KEY,
pmode varchar(2),
amount decimal(8,3) ,
cardnumber varchar(20),
checknumber varchar(20)
);

drop table payment;

create table card(
id int PRIMARY KEY,
amount decimal(8,3),
cardnumber varchar(20)
);


create table paymentTable(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
amount decimal(8,3)
);

create table cardTable(
id int ,
cardnumber varchar(20),
 FOREIGN KEY (id)
REFERENCES paymentTable(id)
);
drop table cardTable;

create table bankcheckTable(
id int ,
checknumber varchar(20),
FOREIGN KEY (id)
REFERENCES paymentTable(id)
);

drop table bankcheckTable;

create table employee(
id int primary key auto_increment,
firstName varchar(10),
lastName varchar(10),
age int,
basicSalary double,
bonusSalary double,
taxAmount double,
specialAllowanceSalary double
);

drop table employee;
create database springdata;
use springdata;

create table author(
	id int primary key auto_increment,
    author_name varchar(15),
    street_number varchar(5),
    location varchar(15),
    state varchar(15)
);

drop table author;

create table subjects(
	id int primary key auto_increment,
    author_id int,
    subject_name varchar(20),
    foreign key (author_id)
    references author(id)
);

drop table subjects;

create table book(
	id int primary key auto_increment,
    author_id int,
    book_name varchar(20),
     FOREIGN KEY (author_id)
REFERENCES author(id)
);

drop table book;

create table book_table(
	id int primary key auto_increment,
    book_name varchar(20)
);


create table author_books(
author_id int,
book_id int,
FOREIGN KEY (author_id)
REFERENCES author(id),
FOREIGN KEY (book_id)
REFERENCES book_table(id)
);

drop table authors_books;
use ttn;

create table author(
	id int primary key auto_increment,
    authorName varchar(15),
    streetNumber varchar(5),
    location varchar(15),
    state varchar(15)
);

drop table author;

create table subjects(
	id int primary key auto_increment,
    authorId int,
    subjectName varchar(20),
    foreign key (authorId)
    references author(id)
);

drop table subjects;

create table book(
	id int primary key auto_increment,
    authorId int,
    bookName varchar(20),
     FOREIGN KEY (authorId)
REFERENCES author(id)
);

drop table book;

create table bookTable(
	id int primary key auto_increment,
    bookName varchar(20)
);


create table authors_books(
authorId int,
bookId int,
FOREIGN KEY (authorId)
REFERENCES author(id),
FOREIGN KEY (bookId)
REFERENCES bookTable(id)
);

drop table authors_books;
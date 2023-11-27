-- create student table
create table student (
                         id integer not null,
                         first_name varchar(100) not null,
                         last_name varchar(100) not null,
                         email varchar(100),
                         age int,
                         primary key (id)
);

-- create a sequence for student id
create sequence student_sequence as integer increment by 1;


-- create book table
create table book (
                      id integer not null,
                      name varchar(255) not null,
                      student_id integer,
                      primary key (id)
);

create sequence book_sequence as integer increment by 1;

alter table book add constraint FK_Book_RefStudent foreign key (student_id)
    references student (id) on delete restrict on update restrict;

-- branch many to many

-- create course table
create table course(
                       id integer not null,
                       name varchar(100) not null,
                       department varchar(100) not null,
                       primary key (id)
);

create sequence course_sequence as integer increment 1;


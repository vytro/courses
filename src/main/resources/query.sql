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



-- eager fetch
-- select b.*,s.*
-- from book b
--          left join student s on b.student_id = s.id
-- where b.id = 1;


-- branch many to many

-- create course table
create table course(
    id integer not null,
    name varchar(100) not null,
    department varchar(100) not null,
    primary key (id)
);

create sequence course_sequence as integer increment 1;

-- create enrollment table
create table enrollment(
    id bigint not null,
    grade integer not null,
    created_at timestamp not null,
    student_id integer,
    course_id integer,
    primary key (id)
);

create sequence enrollment_sequence as integer increment 1;

alter table enrollment add constraint FK_Enrollment_Ref_Student foreign key (student_id)
    references student (id) on delete restrict on update restrict;

alter table enrollment add constraint FK_Enrollment_Ref_Student foreign key (course_id)
    references course (id) on delete restrict on update restrict;

--add new column
ALTER TABLE book ADD COLUMN created_at timestamp;




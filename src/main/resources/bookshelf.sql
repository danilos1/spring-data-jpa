DROP TABLE IF EXISTS book, course, enrolment, student, student_id_card;

CREATE TABLE book (
    id SERIAL PRIMARY KEY NOT NULL,
    student_id int not null,
    book_name varchar(75) not null,
    created_at timestamp without time zone not null
);

CREATE TABLE course (
    id SERIAL PRIMARY KEY NOT NULL,
    name varchar(50) NOT NULL,
    department varchar(50) not null
);

CREATE TABLE enrolment (
    student_id int not null,
    course_id int not null,
    created_at timestamp without time zone not null
);

CREATE TABLE student (
    id serial primary key not null,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(50) unique not null,
    age int not null
);

CREATE TABLE student_id_card (
    id serial primary key not null,
    student_id int not null,
    card_number int unique not null
);

ALTER TABLE book ADD FOREIGN KEY (student_id) REFERENCES student (id);
ALTER TABLE enrolment ADD FOREIGN KEY (student_id) REFERENCES student (id);
ALTER TABLE enrolment ADD FOREIGN KEY (course_id) REFERENCES course (id);
ALTER TABLE student_id_card ADD FOREIGN KEY (student_id) REFERENCES student (id);

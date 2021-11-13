CREATE TABLE course(
    id int,
    fullname varchar(255),
    created_date timestamp,
    last_updated_date timestamp
);

CREATE TABLE student(
    id int,
    fullname varchar(255)
);

CREATE TABLE passport(
    id int,
    number varchar(255)
);

CREATE TABLE review(
    id int,
    rating varchar(255),
    description varchar(255)
);
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS _group;
DROP TABLE IF EXISTS db_change;
DROP TABLE IF EXISTS notification;

create table _group
(
    id bigint not null
        constraint _group_pkey
            primary key,
    year integer
);

create table course
(
    id bigint not null
        constraint course_pkey
            primary key,
    hours integer,
    name varchar(255),
    group_id bigint
        constraint fka366xmdtw86pk0pngbxskipia
            references _group
);

create table db_change
(
    id bigint not null
        constraint db_change_pkey
            primary key,
    entity_id bigint,
    entity_simple_name varchar(255),
    new_entity_string varchar(255),
    old_entity_string varchar(255),
    type integer
);

create table notification
(
    id bigint not null
        constraint notification_pkey
            primary key,
    email_address varchar(255),
    notification_condition integer
);

create table student
(
    id bigint not null
        constraint student_pkey
            primary key,
    dateofbirth date,
    firstname varchar(255),
    lastname varchar(255),
    group_id bigint
        constraint fkhhlnbwjq8c8u1yqa79js5gw5w
            references _group
);







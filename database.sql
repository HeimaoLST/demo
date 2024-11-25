create table admin
(
    uid      int auto_increment
        primary key,
    username longtext null,
    password longtext null
);

create table comment
(
    id        int auto_increment
        primary key,
    content   longtext             null,
    likecount int        default 0 null,
    authorid  int                  null,
    isadmin   tinyint(1) default 0 null
);

create table user
(
    uid      int auto_increment
        primary key,
    username longtext not null,
    password longtext not null
);



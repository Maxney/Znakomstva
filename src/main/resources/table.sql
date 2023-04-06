create table users
(
    idusers         bigint not null
        primary key,
    login           varchar(30),
    password        varchar(30),
    alias           varchar(30),
    age             integer,
    discription     varchar(300),
    searchinterests text[]
);

alter table users
    owner to postgres;

create table UserPhoto
(
    iduserphoto bigint not null
        primary key,
    iduser      bigint not null
        references users,
    adress      varchar(100)
);

alter table userPhoto
    owner to postgres;

create table LikeUser
(
    idlikeuser bigint not null
        primary key,
    iduser     bigint not null
        references Users,
    id_photo   bigint not null
        references UserPhoto
);

alter table LikeUser
    owner to postgres;

INSERT INTO users
VALUES (2,'login','password','alias',20,'discription','{search,interests}');

SELECT *
from users
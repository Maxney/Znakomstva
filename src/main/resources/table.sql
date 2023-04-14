create table users
(
    idusers         serial8 not null
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
    iduserphoto serial8 not null
        primary key,
    iduser      bigint not null
        references users,
    adress      varchar(100)
);

alter table userPhoto
    owner to postgres;

create table LikeUser
(
    idlikeuser serial8 not null
        primary key,
    iduser     bigint not null
        references Users,
    id_photo   bigint not null
        references UserPhoto
);

alter table LikeUser
    owner to postgres;

INSERT INTO users
VALUES (3,'aaaaa','bbbbb','xxxxx',22,'discriptionnnnn','{aaaaaaccc,cccccccffff}');

SELECT *
from users

DELETE FROM likeuser WHERE idlikeuser = 12
DELETE FROM LikeUser WHERE idlikeuser = 13
CREATE TABLE users(
    id int auto_increment primary key,
    login varchar(50) not null,
    senha varchar(255) not null,
    role varchar(50) not null
);
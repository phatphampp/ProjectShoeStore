create database ShoeStore;

use ShoeStore;

create table product
(
    id int AUTO_INCREMENT primary key,
    prodName nvarchar(50),
    description nvarchar(50),
    price int,
    image varchar(50)	
);

create table Account (
    id int AUTO_INCREMENT primary key,
    username varchar(20) not null UNIQUE,
    password varchar(50) not null,
    address varchar(255) not null,
    email varchar(128) not null,
    name varchar(255) not null,
    phone varchar(128) not null
    
);

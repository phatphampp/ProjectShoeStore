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

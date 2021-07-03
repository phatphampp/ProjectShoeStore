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

create table Orders (
    id int AUTO_INCREMENT primary key,
    amount double not null,
    customerId int,
    foreign key (customerId) references Account(id)
);

create table OrderDetail (
    orderId int,
    productId int,
    amount int not null,
    price int not null,
    quantity int not null,
    primary key (orderId, productId),
    foreign key (productId) references Product(id),
    foreign key (orderId) references Orders(id)
);
CREATE DATABASE dbusiness;

USE dbusiness;



/*
SQLITE


Drop table Product;
Drop table Category;
Drop table Product_Category;
Drop table User;
Drop table Country;
Drop table Purchase;

CREATE TABLE Product (
Id Integer Primary Key AUTOINCREMENT ,
Name Varchar(20) Not null ,
Price Decimal(15,2)
);

CREATE TABLE Category (
Id Integer Primary Key AUTOINCREMENT ,
Name varchar(20) Not null ,
Description Varchar(50) null
);

CREATE TABLE Product_Category (
 Product_Id Integer not null,
 Category_Id Integer not null,
 PRIMARY KEY (Product_id, Category_id),
 FOREIGN KEY(Product_Id) REFERENCES Product(Id),
 FOREIGN KEY(Category_Id) REFERENCES Category(Id)
);

CREATE TABLE User(
 Id Integer Primary key AUTOINCREMENT ,
 Login Varchar (30) NOT NULL,
 Name Varchar(80) NOT NULL ,
 Age INT(3) NULL,
 Phone Varchar(14) NULL ,
 Email Varchar(60) NOT NULL,
 Password Varchar(255) NOT NULL,
 Country_Id Integer Null,
 FOREIGN KEY(Country_Id) REFERENCES Country(Id)
);

CREATE TABLE Country(
 Id Integer Primary key AUTOINCREMENT ,
 Name Varchar(80) NOT NULL
);

Create Table  Purchase (
 Id Integer Primary Key AutoIncrement,
 Date DateTime not null,
 Total_Price double not null,
 Paid integer not null,
 User_Id integer not null,
 FOREIGN KEY(User_Id) REFERENCES User(Id)
);


*/
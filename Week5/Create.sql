create database AvtoShop;

use AvtoShop;

CREATE TABLE Position (
  position_ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  position VARCHAR(40) NOT NULL
);

CREATE TABLE Region (
  region_ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  region VARCHAR(40) NOT NULL
);

CREATE TABLE Reputation (
  reputation_ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  reputation VARCHAR(40) NOT NULL
);

CREATE TABLE Car_Type (
  type_ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  car_Type VARCHAR(40) NOT NULL
);

CREATE TABLE Price_List (
  price_ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  price DOUBLE NOT NULL
);

CREATE TABLE Customers (
  customer_ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  customer_name VARCHAR(40) NOT NULL,
  reputation INT UNSIGNED,
  adress VARCHAR(40) NOT NULL,
  email VARCHAR(20) NOT NULL,
  phone VARCHAR(15) NOT NULL,
  FOREIGN KEY (reputation)  REFERENCES Reputation (reputation_ID),
  UNIQUE(email, phone)
);

CREATE TABLE Emlpoyees (
  emlpoyee_ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  emlpoyee_name VARCHAR(40) NOT NULL,
  position_ID INT UNSIGNED,
  salary DOUBLE NOT NULL,
  adress VARCHAR(40) NOT NULL,
  email VARCHAR(20) NOT NULL,
  phone VARCHAR(15) NOT NULL,
  FOREIGN KEY (position_ID)  REFERENCES Position (position_ID),
  UNIQUE(email, phone)
);

CREATE TABLE Cars (
  car_ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  car_name VARCHAR(40) NOT NULL,
  type_ID INT UNSIGNED,
  color VARCHAR(40) NOT NULL,
  price_ID INT UNSIGNED,
  EngineDisplacement DOUBLE NOT NULL,
  FOREIGN KEY (type_ID)  REFERENCES Car_Type (type_ID),
  FOREIGN KEY (price_ID)  REFERENCES Price_List (price_ID)
);

CREATE TABLE Shipping (
  shipping_ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  shipping_type VARCHAR(40) NOT NULL,
  shipping_cost DOUBLE NOT NULL,
  region_ID INT UNSIGNED,
  FOREIGN KEY (region_ID)  REFERENCES Region (region_ID)
);

CREATE TABLE Orders (
  order_ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  customer_ID INT UNSIGNED,
  shipping_ID INT UNSIGNED,
  date_order DATE,
  status VARCHAR(40) NOT NULL,
  FOREIGN KEY (shipping_ID)  REFERENCES Shipping (shipping_ID),
  FOREIGN KEY (customer_ID)  REFERENCES Customers (customer_ID)
);

CREATE TABLE Order_details (
  order_ID INT UNSIGNED,
  car_ID INT UNSIGNED,
  price_ID INT UNSIGNED,
  FOREIGN KEY (order_ID)  REFERENCES Orders (order_ID),
  FOREIGN KEY (car_ID)  REFERENCES Cars (car_ID),
  FOREIGN KEY (price_ID)  REFERENCES Price_List (price_ID)
);

CREATE TABLE Contracts (
  contract_ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  order_ID INT UNSIGNED,
  employee_ID INT UNSIGNED,
  customer_ID INT UNSIGNED,
  car_ID INT UNSIGNED,
  price_ID INT UNSIGNED,
  shipping_ID INT UNSIGNED,
  date_order DATE,
  FOREIGN KEY (order_ID)  REFERENCES Orders (order_ID),
  FOREIGN KEY (employee_ID)  REFERENCES Emlpoyees (emlpoyee_ID),
  FOREIGN KEY (customer_ID)  REFERENCES Customers (customer_ID),
  FOREIGN KEY (car_ID)  REFERENCES Cars (car_ID),
  FOREIGN KEY (price_ID)  REFERENCES Price_List (price_ID),
  FOREIGN KEY (shipping_ID)  REFERENCES Shipping (shipping_ID)
);

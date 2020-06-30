create database AvtoShop;

use AvtoShop;

CREATE TABLE Customers (
  CustomerID NUMERIC,
  CustomerName VARCHAR(40),
  Reputation VARCHAR(40),
  Adress VARCHAR(40),
  Email VARCHAR(20),
  Number VARCHAR(15)
);

CREATE TABLE Emlpoyees (
  EmlpoyeeID NUMERIC,
  EmlpoyeeName VARCHAR(40),
  Position VARCHAR(40),
  Salary DOUBLE,
  Adress VARCHAR(40),
  Email VARCHAR(20),
  Number VARCHAR(15)
);

CREATE TABLE Cars (
  CarID NUMERIC,
  CarName VARCHAR(40),
  CarType VARCHAR(40),
  Color VARCHAR(40),
  EngineDisplacement DOUBLE
);

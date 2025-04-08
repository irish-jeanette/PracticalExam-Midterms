create user grocery identified by Changeme0;

alter user grocery quota unlimited on DATA;

alter user grocery quota unlimited on USERS;

grant create session to grocery with admin option;

grant connect to grocery;

alter session set current_schema = grocery;

drop table Items cascade constraints;
drop table Customers cascade constraints;
drop table Transaction cascade constraints;
drop table TransactionDetails cascade constraints;

create table Items (
  ItemID VARCHAR(10) PRIMARY KEY,
  ItemDesc varchar(100),
  UnitPrice number(10,2)
  );

create table Customers (
  CustomerID VARCHAR(10) PRIMARY KEY,
  CustomerName VARCHAR(100),
  Address VARCHAR(100),
  ContactNumber VARCHAR(15)
  );

create table Transactions (
  TransactionID INT PRIMARY KEY,
  CustomerID varchar(10),
  TransDate DATE
  );

create table TransactionDetails (
  TransactionID INT,
  ItemID VARCHAR(10),
  Quantity INT,
  Primary Key (TransactionID, ItemID)
  );

ALTER TABLE Transactions
ADD CONSTRAINT FK_Transactions_Customers
FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID);

ALTER TABLE TransactionDetails
ADD CONSTRAINT FK_Details_Transactions
FOREIGN KEY (TransactionID) REFERENCES Transactions(TransactionID);

ALTER TABLE TransactionDetails
ADD CONSTRAINT FK_Details_Items
FOREIGN KEY (ItemID) REFERENCES Items(ItemID);

INSERT INTO Items (ItemID, ItemDesc, UnitPrice) VALUES('01', 'Coocoo Cola', 50.00);
INSERT INTO Items (ItemID, ItemDesc, UnitPrice) VALUES('02', 'Gardenya', 25.00);
INSERT INTO Items (ItemID, ItemDesc, UnitPrice) VALUES('03', 'Stick U', 60.00);

INSERT INTO Customers (CustomerID, CustomerName, Address, ContactNumber) VALUES('C001', 'J. dela Cruz', 'Tagaytay', '09191112223');
INSERT INTO Customers (CustomerID, CustomerName, Address, ContactNumber) VALUES('C002', 'A. Ketchum', 'Silang', '09991119219');
INSERT INTO Customers (CustomerID, CustomerName, Address, ContactNumber) VALUES('C003', 'G. Viscon', 'Alfonso', NULL);

INSERT INTO Transactions (TransactionID, CustomerID, TransDate) VALUES(1, 'C001', '04-11-2024');
INSERT INTO Transactions (TransactionID, CustomerID, TransDate) VALUES(2, 'C002', '04-11-2024');
INSERT INTO Transactions (TransactionID, CustomerID, TransDate) VALUES(3, 'C003', '04-12-2024');
INSERT INTO Transactions (TransactionID, CustomerID, TransDate) VALUES(4, 'C001', '04-12-2024');

INSERT INTO TransactionDetails (TransactionID, ItemID, Quantity) VALUES(1, '01', 1);
INSERT INTO TransactionDetails (TransactionID, ItemID, Quantity) VALUES(1, '02', 2);
INSERT INTO TransactionDetails (TransactionID, ItemID, Quantity) VALUES(2, '01', 2);
INSERT INTO TransactionDetails (TransactionID, ItemID, Quantity) VALUES(3, '02', 1);
INSERT INTO TransactionDetails (TransactionID, ItemID, Quantity) VALUES(4, '03', 1);

CREATE database NCHostel;

use  NCHostel;

# DROP TABLE HOSTEL;
CREATE TABLE HOSTEL
	(
		HostID INT NOT NULL auto_increment,
		Name varchar(50) NOT NULL,
        Address varchar(50),
        Phone char(10),
        City VARCHAR(30),
        EmployeeID INT NOT NULL,
        CONSTRAINT PK_HOSTEL PRIMARY KEY(HostID) 
    );

#DROP TABLE EMPLOYEE
CREATE TABLE EMPLOYEE
	(
		EmployeeID INT NOT NULL,
        FirstName VARCHAR(50) NOT NULL,
        LastName VARCHAR(50) NOT NULL,
        Address VARCHAR(50) NOT NULL,
        Phone CHAR(10) NOT NULL,
        CONSTRAINT PK_EMPLOYEE PRIMARY KEY(EmployeeID)		
    );
    
#DROP TALE ROOM_TYPE
	CREATE TABLE RoomType 
    (
		RoomType CHAR(10) NOT NULL,
        RoomName VARCHAR(30) NOT NULL,
        Price DECIMAL(5,2) NOT NULL,
        CONSTRAINT PK_ROOM_TYPE PRIMARY KEY (RoomType)
    );
    
    #DROP TABLE ROOM
CREATE TABLE ROOM 
	(
		RoomID INT NOT NULL auto_increment,
        RoomType char(10) NOT NULL,
		RoomDescription VARCHAR(50),
        HotelID INT NOT NULL,
        CONSTRAINT PK_ROOM_ID PRIMARY KEY (RoomID)       
    );

#DROP TABLE BOOKING
CREATE TABLE BOOKING 
	(
		BookingID INT NOT NULL auto_increment,
        CustomerID INT NOT NULL,
        RoomID INT NOT NULL,
        BookingDate datetime NOT NULL,
        DateIN datetime NOT NULL,
        DateOUT datetime NOT NULL,
        Bill decimal (5,2) NOT null,
        CONSTRAINT PK_BOOKING_ID PRIMARY KEY (BookingID)
	);
    
#DROP TABLE CUSTMER
CREATE TABLE CUSTOMER 
	(
		CustomerID INT NOT NULL auto_increment,
        FirstName VARCHAR(50) NOT NULL,
        LastName VARCHAR(50) NOT NULL,
        Address VARCHAR(50) NOT NULL,
        Phone CHAR(10) NOT NULL,
        Passport CHAR(10) NOT NULL,
        CONSTRAINT PK_CUSTOMER_ID PRIMARY KEY (CustomerID)
    );
/*
	ALTER TABLE HOSTEL
    ADD CONSTRAINT FK_EMPLOYEE_ID
	FOREIGN KEY (EmployeeID) references EMPLOYEE(EmployeeID);
    
	ALTER TABLE ROOM
    ADD CONSTRAINT FK_HOSTEL_ID 
    FOREIGN KEY (HotelID) references hostel(HostID);
    
    ALTER TABLE ROOM
    ADD CONSTRAINT FK_ROOM_TYPE 
    FOREIGN KEY (RoomType) references RoomType(RoomType);
    
    ALTER TABLE BOOKING
	ADD CONSTRAINT FK_ROOM_ID 
    FOREIGN KEY (RoomID) references room(RoomID);
    
	ALTER TABLE BOOKING
	ADD CONSTRAINT FK_CUSTOMER_ID
    FOREIGN KEY (CustomerID) references CUSTOMER(CustomerID);
    
*/

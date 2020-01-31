/*  GROUP 10 Project 3 for CS3380
    
    Josh Hickman
    Max Loduca
    Robert Colman Loch
    12/01/19
    
*/

CREATE DATABASE Group10;

CREATE TABLE BRANCH(
    BranchID int,
    Routing bigint NOT NULL,
    Address varchar(50),
    Phone bigint,
    Name varchar(40) NOT NULL,
    PRIMARY KEY (BranchID),
    CONSTRAINT Check_Routing CHECK (Routing = 819000123),
    CONSTRAINT Check_Name CHECK (Name = "Group10 Credit Union")
);

CREATE TABLE MEMBER(
    MemberID int,
    Fname varchar(20) NOT NULL,
    Lname varchar(20) NOT NULL,
    SSN char(9) NOT NULL,
    Birthdate date NOT NULL,
    Address varchar(50) NOT NULL,
    Phone bigint,
    Salary float,
    PRIMARY KEY (MemberID)
);

CREATE TABLE OFFICER(
    OID int,
    Name varchar(20) NOT NULL,
    PRIMARY KEY (OID)
);

CREATE TABLE LOAN(
    LoanID bigint,
    MemberID int,
    Term int NOT NULL,
    Amount float NOT NULL,
    HomeLoanAddress varchar(50),
    VIN char(12),
    Make varchar(20),
    Model varchar(30),
    OID int,
    PRIMARY KEY (LoanID),
    FOREIGN KEY (MemberID) REFERENCES MEMBER (MemberID) ON DELETE CASCADE,
    FOREIGN KEY (OID) REFERENCES OFFICER (OID) ON DELETE RESTRICT
);

CREATE TABLE ACCOUNTS(
    Account bigint,
    BranchID int,
    MemberID int,
    Name varchar(30),
    Card char(16) UNIQUE,
    APR float,
    PRIMARY KEY (Account),
    FOREIGN KEY (MemberID) REFERENCES MEMBER (MemberID) ON DELETE CASCADE,
    FOREIGN KEY (BranchID) REFERENCES BRANCH (BranchID) ON DELETE CASCADE
);

CREATE TABLE TRANSACTIONS(
    Account bigint,
    TransactionNum bigint,
    TransactionTime time NOT NULL,
    TransactionDate date NOT NULL,
    Amount float NOT NULL,
    Comment varchar(100),
    PRIMARY KEY (Account, TransactionNUM),
    FOREIGN KEY (Account) REFERENCES ACCOUNTS (Account) ON DELETE CASCADE
);

CREATE TABLE COSIGNER(
    LoanID bigint,
    Phone bigint,
    Fname varchar(20) NOT NULL,
    Lname varchar(20) NOT NULL,
    Address varchar(40) NOT NULL,
    CreditScore int,
    PRIMARY KEY (LoanID, Phone),
    FOREIGN KEY (LoanID) REFERENCES LOAN (LoanID) ON DELETE CASCADE
);

CREATE TABLE COLLATERAL(
    LID bigint,
    CID int,
    Amount float NOT NULL,
    PRIMARY KEY (LID, CID),
    FOREIGN KEY (LID) REFERENCES LOAN (LoanID) ON DELETE CASCADE
);

INSERT INTO BRANCH
VALUES (001, 819000123, "123 Smithfield Pkwy, Houston, TX, 87632", 5556431234, "Group10 Credit Union"),
(002, 819000123, "6 N Cedar Ln, Houston, TX, 87632", 5556431556, "Group10 Credit Union"),
(003, 819000123, "56 Redrose St, Austin, TX, 84432", 5516772321, "Group10 Credit Union");

INSERT INTO MEMBER
VALUES (1135493, "John", "Smith", "456789123", "1990-01-01", "123 Love Dr, Mable, TX, 89892", 7652344456, 45000.00),
(2235291, "Steven", "Temple", "456123445", "1980-05-04", "6 French Dr, Houston, TX, 87632", 3948739847, 65000.00),
(9847833, "Jessica", "Smith", "567453221", "1991-10-08", "26 Carl Ln, Memphis, TN, 77283", 8723487341, 35000.00),
(3232233, "Thomas", "Davidson", "947854949", "1976-05-08", "2 Clove St, Huntington, MA, 23834", 3948759333, 115000.00),
(1978433, "Samantha", "White", "398745939", "1970-09-01", "13 Trenton St, Fort Worth, TX, 81234", 7178383001, 50000.00),
(6733829, "Ashley", "Bragg", "783838393", "1981-11-11", "11234 King Dr, Millworth, AK, 73763", 5674487765, 450000.00),
(3736437, "Paul", "Thorn", "398743993", "1973-08-10", "7834 Devon St, Ann Arbor, MI, 11455", 8348778883, 145000.00),
(3487399, "Jason", "Duckworth", "490373783", "1996-07-03", "121 6th St, Columbia, MO, 65201", 5735574372, 25000.00);

INSERT INTO OFFICER
VALUES (113, "Paul"),
(134, "Stacey"),
(084, "David");

INSERT INTO LOAN
VALUES (123456789, 1135493, 60, 43250.50, NULL, "9F24K2H2U290", "Dodge", "Ram", 113),
(553222134, 1135493, 360, 440000.00, "115 Sable Dr, Mable, TX, 89892", NULL, NULL, NULL, 113),
(373746262, 2235291, 48, 28250.50, NULL, "8DFWER98J3J3", "Ford", "Fusion", 084),
(762672761, 3736437, 72, 83250.50, NULL, "9F24K2H2U290", "Land Rover", "Range Rover Sport", 134),
(376287282, 9847833, 24, 6000.00, NULL, NULL, NULL, NULL, 134),
(232323442, 9847833, 360, 90000.00, "7 Louise Dr, Memphis, TN, 77283", NULL, NULL, NULL, 134),
(232839499, 6733829, 180, 2000000.00, "45 Sycamore Ln, Little Rock, AK, 72456", NULL, NULL, NULL, 084),
(647387382, 3232233, 48, 55000.00, NULL, "7S2373JHS27S", "Ford", "Explorer", 084),
(726376212, 1978433, 12, 3000.00, NULL, NULL, NULL, NULL, 113),
(978236276, 3487399, 24, 5500.00, NULL, NULL, NULL, NULL, 113);

INSERT INTO ACCOUNTS
VALUES (112345679987, 001, 1135493, "Checking", "4432654333211244", NULL),
(432348678009, 002, 2235291, "Savings", NULL, 0.03),
(678945679981, 001, 9847833, "Checking", "4432644033211456", NULL),
(553245679911, 003, 3232233, "Vacation Fund", NULL, 0.03),
(982634214567, 003, 1978433, "Personal", "4432611976551344", NULL),
(334567243233, 002, 6733829, "Rainy Day", NULL, 0.03),
(112345111111, 002, 3736437, NULL, "4432688912342233", NULL),
(444565732223, 001, 3487399, "Checking", "4432600011112222", NULL);

INSERT INTO TRANSACTIONS
VALUES (112345679987, 2382387, "11:30:45", "2017-01-05", 2500.00, "Opening Checking Account"),
(432348678009, 237238728, "13:34:50", "2015-05-10", 500.00, "Opening Savings Account"),
(678945679981, 5832872, "11:01:06", "2015-06-06", 1000.00, "Opening Checking Account"),
(553245679911, 8734872782, "09:49:01", "2019-01-11", 325.00, "Opening Savings Account"),
(982634214567, 3473872, "14:34:34", "2018-06-01", 900.00, "Opening Checking Account"),
(334567243233, 934738722222, "08:13:11", "2019-09-11", 32000.00, "Opening Savings Account"),
(112345111111, 3982329, "10:10:11", "2009-11-10", 500.00, "Opening Checking Account"),
(444565732223, 287232328, "13:23:56", "2011-09-02", 200.00, "Opening Checking Account"),
(334567243233, 934738748583, "10:18:51", "2019-12-12", -12000.00, NULL);

INSERT INTO COSIGNER
VALUES (123456789, 5734456584, "John", "Doe", "123 Shepard Ln, Columbia, MO, 65201", 700),
(232323442, 6363341234, "Pam", "Beverly", "4 Covington Ave, St Louis, MO, 63332", 760),
(978236276, 7782363344, "Thomas", "Smithers", "6 N Washburn Ave, Tulsa, OK, 88394", 800);

INSERT INTO COLLATERAL
VALUES (232839499, 3442, 650000.00),
(553222134, 1123, 35000.00),
(978236276, 4452, 5500.00);
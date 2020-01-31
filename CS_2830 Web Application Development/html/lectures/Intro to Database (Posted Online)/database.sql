-- This document was created by Professor Wergeles for CS2830 at University of Missouri 


-- [Terminology]
--  Database Management System: software running on a server that gives us database 
--		capabilities.
--  Database: a collection of data organized into tables.
--  Database Client: a tool that allows us to communicate with the DBMS.

--  Notes:
--    - Each database can hold multiple tables and each DBMS can manage multiple databases
--    - Within a database, each table must have a unique name
--    - We interact with the DBMS using Structure Query Language (SQL)

-- [Prerequisites]
-- 1. Run through "Checklist For Starting Your EC2 Instance" on Canvas 
--		https://missouri.instructure.com/courses/1663/pages/
--				checklist-for-starting-your-ec2-instance?module_item_id=140940


-- [Create and connect to your MySQL database]
-- 1. To create a new MySQL database, ssh into your amazon instance and run 
--		'sudo service mysqld start' in the command line (look at prerequisites) 
-- 2. Once the database is created, Go to EC2 Dashboard under the "Description" 
--		tab of the running EC2 will list a hostname
-- 3. Download and install a database client like MySQL Workbench: 
--			http://dev.mysql.com/downloads/workbench/
-- 4. Use the credentials from EC2 to add a new entry for your database
-- 			* Connection Name: EC2
-- 			* Connection Method: Standard TCP/IP over SSH
--		Parameters
--			* SSH Hostname: (EC2PublicDNS:22) 
--			* SSH Username: ec2-user
--			* SSH Key File: "locate your PEM file"
--			* MySQL Hostname: localhost
--			* MySQL Server Port: 3306
--			* Username: root
-- 5. To create a database, use the following command below, syntax: 
--			CREATE DATABASE dbName; 
SHOW DATABASES; 
CREATE DATABASE CS2830; 



-- [USE database]
-- Once connected, you'll need to tell your database management system which database you'd 
--		like to operate on. (Remember, there can be multiple databases within a DBMS).
-- You can see which databases are available by typing "SHOW databases".
-- You can select your database by typing "USE databasename".
SHOW DATABASES; 
USE CS2830; 

-- [SHOW TABLES]
--  From the MySQL command prompt, type "show tables" to show the tables in your database.
--  Type "DESCRIBE tableName" to list out the details for a given table.
SHOW TABLES;
DESCRIBE foodStock; 


-- [CREATE TABLE]
--  References:
--    - http://www.w3schools.com/sql/sql_create_table.asp
--    - http://dev.mysql.com/doc/refman/5.6/en/data-types.html
CREATE TABLE foodStock (
	id INT,
	name VARCHAR(50),
	quantity INT,
	cost FLOAT
);

-- [INSERT]
--  To add rows/records to the foodStock table, we use INSERT statements
--  http://www.w3schools.com/sql/sql_insert.asp
INSERT INTO foodstock VALUES (1, "Bitterballen", 12, 10);

-- In the example above, you will see syntax is strict
INSERT INTO foodStock VALUES (1, "Bitterballen", 12, 10);

-- see if record was successful
select * from foodStock; 
--or 
select count(*) from foodStock; 

--insert more records
INSERT INTO foodStock VALUES (2, "Poffertjes", 20, 3);
INSERT INTO foodStock VALUES (3, "Ribs", 1, 16.50);
INSERT INTO foodStock VALUES (4, "Sushi", 2, 20);

select * from foodStock; 

-- If we don't supply the right number/type of values, we will encounter an error
INSERT INTO foodStock VALUES ('Curry', 1, 20);
-- We can get around that error by specifying the columns that we want to fill.
-- In this case, id will be set to NULL
INSERT INTO foodStock (name, quantity, cost) VALUES ('Curry', 1, 20);
-- That means every time we insert a record into the table, we'll need to know what id to use.

select * from foodStock; 

-- Additionally, we can accidentally create records with the same id
INSERT INTO foodStock VALUES (5, 'Curry', 1, 20);
INSERT INTO foodStock VALUES (5, 'Herbs', 4, 20);

select * from foodStock; 

-- To help with those issues, we can define a set of rules. These are called constraints.
-- http://www.w3schools.com/sql/sql_constraints.asp
CREATE TABLE foodstock(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL UNIQUE,
  quantity INT UNSIGNED NOT NULL,
  cost FLOAT UNSIGNED NOT NULL
);

show tables; 


-- INSERT food again
INSERT INTO foodstock (name, quantity, cost) VALUES ("Bitterballen", 12, 10);

-- key words, such as create, table, insert, into, values are not case sensitive 
insert into foodstock (name, quantity, cost) values ("Poffertjes", 20, 3);
INSERT INTO foodstock (name, quantity, cost) VALUES ("Ribs", 1, 16.50);
INSERT INTO foodstock (name, quantity, cost) VALUES ("Sushi", 2, 20);
insert into foodstock (name, quantity, cost) values ("Herbs", 4, 20); 


-- [SELECT]
--  Once we have records in a table, we can search through them and retrieve specific information.
--  http://www.w3schools.com/sql/sql_select.asp

-- Return all the fields (*) of every record in "foodstock"
SELECT * FROM foodstock;

-- Return just the name field of every record
SELECT name FROM foodstock;

-- Return the name and quantity fields of every record
SELECT name, quantity FROM foodstock;

-- Return the name and quantity fields of records with cost of more than $10
SELECT name, quantity FROM foodstock WHERE cost > 10;


-- [UPDATE]
--  Change an existing record(s) in a table
--  http://www.w3schools.com/sql/sql_update.asp
UPDATE foodstock SET quantity = 20 WHERE id = 1;

select * from foodstock; 

desc foodstock; 

--Add new column after table exists 
alter table foodstock add purchaseDate datetime default null; 
desc foodstock; 

-- Update multiple parts
UPDATE foodstock SET quantity = 30, purchaseDate = NOW() WHERE id = 1;

-- see if the update worked
select * from foodstock; 

-- [DELETE]
--  Delete one or more records
--  http://www.w3schools.com/sql/sql_delete.asp
DELETE FROM foodstock WHERE id = 2;

-- see if delete worked
select * from foodstock; 


-- show tables
show tables; 

-- [DROP TABLE]
--  Removes the table and its records
--  http://www.w3schools.com/sql/sql_drop.asp

-- Delete first table
DROP TABLE foodStock;

-- see if it worked
show tables; 

-- this will fail because data and table have been deleted 
select * from foodStock; 

-- Set password for your mysql user 
SET PASSWORD FOR 'ec2-user'@'localhost' = PASSWORD('nick'); 

-- Grant regular user "ec2-user" to select, insert, and update the database. 
-- You should not use "root" when updating the database from the PHP.
-- You will use "ec2-user" instead that way it is harding to hack your database 
GRANT SELECT, INSERT, UPDATE ON CS2830.* TO ''@'localhost';

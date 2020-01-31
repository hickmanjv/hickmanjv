/*  GROUP 10 Query Code for Project 3 for CS3380
    
    Josh Hickman
    Max Loduca
    Robert Colman Loch
    12/01/19
    
*/


/* Insert into table */
SELECT * FROM BRANCH;
INSERT INTO BRANCH
VALUES(1, 82371811, "1 Hospital Dr, Columbia, MO, 65212", 5732222222, "Group10 Credit Union");

/* Insert into table */
SELECT * FROM BRANCH;
INSERT INTO BRANCH
VALUES(1, 819000123, "1 Hospital Dr, Columbia, MO, 65212", 5732222222, "Mizzou Credit Union");

/* Insert into table */
SELECT * FROM BRANCH;
INSERT INTO BRANCH
VALUES(1, 819000123, "1 Hospital Dr, Columbia, MO, 65212", 5732222222, "Group10 Credit Union");
SELECT * FROM BRANCH:

/* Insert into table */
SELECT * FROM COLLATERAL;
INSERT INTO COLLATERAL 
VALUES(123456789, 6543, 6625.00);
SELECT * FROM COLLATERAL;

/* Delete from table */
SELECT * FROM COLLATERAL;
DELETE FROM COLLATERAL WHERE LID = 123456789 AND CID = 6543;
SELECT * FROM COLLATERAL;

/* Update table */
SELECT * FROM COSIGNER;
UPDATE COSIGNER SET Fname = "Steven" WHERE Fname = "John";
SELECT * FROM COSIGNER;

/* Find the account balance of any MEMBER named Ashley */

SELECT SUM(T.Amount)
FROM ACCOUNTS A, MEMBER M, TRANSACTIONS T
WHERE M.Fname = "Ashley" AND M.MemberID = A.MemberID AND A.Account = T.Account;

/* Find all account balances and group by MemberID. Return balances, Fname and MemberID */

SELECT M.MemberID, M.Fname, SUM(T.Amount)
FROM ACCOUNTS A, MEMBER M, TRANSACTIONS T
WHERE M.MemberID = A.MemberID AND A.Account = T.Account
GROUP BY M.MemberID;

/* Count the number of transactions that withdraw money from an account */

SELECT COUNT(Amount)
FROM TRANSACTIONS
WHERE Amount < 0;

/* Return the list of members in alphabetical order */

SELECT Lname, Fname
FROM MEMBER
ORDER BY Lname ASC;

/* Return the names of all customers who have taken out a loan but don't have stacey as their loan officer*/

SELECT Fname, Lname
FROM MEMBER M, LOAN L
WHERE M.MemberID = L.MemberID AND NOT EXISTS (
  SELECT L.MemberID
  FROM OFFICER O
  WHERE O.Name = "Stacey" AND L.OID = O.OID
);
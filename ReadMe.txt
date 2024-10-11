
************************************************************************************************************************************************************************************************************************************************************************************************
create database carsales;
use carsales;
create table logindetails(Username varchar(20),passwrd varchar(20),FirstName varchar(20),LastName varchar(20),Car_Model varchar(20),Car_No varchar(20),Capacity varchar(20),Price varchar(20),Seats varchar(20),Driving_Range varchar(20),Tax varchar(20),Discount varchar(20));
SELECT *
FROM logindetails;

[Copy Paste above code inside your mysql]

************************************************************************************************************************************************************************************************************************************************************************************************

*************************************************************************************

[IF database already exists]

ALTER TABLE logindetails
ADD [Every col starting from Car_Model] varchar(rowsize);

*************************************************************************************
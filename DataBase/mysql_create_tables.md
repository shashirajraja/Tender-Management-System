#### NOTE:- The table that will be created here is empty , i.e no dummy data will be available.
#### Execute the following Queries iff :
- If You want to Create an empty table structure for this project, without any dummy database.
- If you don't want to execute the dummy database given <a href="https://github.com/shashirajraja/Tender-Management-System/blob/master/DataBase/tender.sql"/>Here inside DataBase/mysql_create_tables</a>
#### STEP 1: Login to administrator user opening MySQL Command Prompt or open cmd and execute the following: 
```mysql -u <username> -p ``` (Enter the password when asked)

#### STEP 2: Copy Paste and execute the following Queries:

```MySQL
create database tender;

commit;

use tender;

create table notice(id int(3) not null auto_increment, title varchar(35),info varchar(300), primary key(id));

alter table notice AUTO_INCREMENT = 1;


create table vendor(vid varchar(15) primary key,password varchar(20),vname varchar(30),vmob varchar(12),
		vemail varchar(40),company varchar(15),address varchar(100));


create table tender(tid varchar(15) primary key,tname varchar(40),ttype varchar(20),tprice int,
		    tdesc varchar(300),tdeadline date,tloc varchar(70));

create table bidder (bid varchar(15) primary key,vid varchar(15) references vendor(vid),tid varchar(15) references tender(tid),
		bidamount int,deadline date,status varchar(10));


create table tenderstatus(tid varchar(15) primary key references tender(tid),bid varchar(15) references bidder(bid),
		status varchar(15) not null,vid varchar(15) references vendor(vid));

INSERT INTO tender VALUES ('T20190725022124','Gandhi Setu Highway','maintainence',50000,'lkjhgfd','2019-07-19','Patna, Bihar'),('T20190725022416','MEGA CITY CONNECTING ROAD CONTRUCTION','construction',100000,'mega city road contruction','2019-09-14','Delhi'),('T20190725022601','KOKATA HALDIA BRIDGE CONTRUCTION','construction',5000000,'bridge contruction from kolkata to haldia','2019-07-28','KOLATA-HALDIA'),('T20190725101239','Game Development','software',150000,'We are going to start a project on game development using GPS specification. Interested condidates are required to bid as soon as possible','2019-07-19','Banglore, India'),('T20190725101322','Game Development','software',150000,'We are going to start a project on game development using GPS specification. Interested condidates are required to bid as soon as possible','2019-07-19','Banglore, India');


INSERT INTO notice VALUES (2,'Gandhi Setu Repairing','Repairing work is going to be started tommorow'),(3,'KOLKATA-HALDIA BRIDGE CONTRUCTION','ASSINGNED ENGINEER NEED TO REPORT AT THE CONSTRUCTION SITE BY TOMMOROW');

INSERT INTO vendor VALUES ('V20190725020951','12345','Ayush Vikas','07501 070485','ayush@gmail.com','Infosys','K-3, LANE NO-6 AYODHAYAPURI NEAR AIRTEL TOWER'),('V20190725022813','aaina','Ravi Rishu','12345679','ravi@gmail.com','Infosys','Dhanbad ,Jharkhand'),('V20190725023446','ayush','Ayush Vikas','6789054321','ayushvikasdutta1296@gmail.com','Infosys','siwan near durga mandir, bihar '),('V20190725100730','shashi','Shashi Raj','9234567689','shashi@gmail.com','Wipro','Jain , Colony Belhariya More, Tekari, Gaya, (Bihar) ');

INSERT INTO bidder VALUES ('B20190725022953','V20190725022813','T20190725022124',51000,'2019-07-19','Pending'),('B20190725023010','V20190725022813','T20190725022124',52000,'2019-07-19','Accepted'),('B20190725023248','V20190725022813','T20190725022416',100001,'2019-09-14','Rejected'),('B20190725023512','V20190725023446','T20190725022416',200000,'2019-09-14','Accepted'),('B20190725024125','V20190725023446','T20190725022601',5000001,'2019-07-28','Rejected'),('B20190725024243','V20190725022813','T20190725022601',6000000,'2019-07-28','Accepted'),('B20190725101444','V20190725100730','T20190725101322',1500000,'2019-07-19','Rejected'),('B20190725101519','V20190725023446','T20190725101239',150005,'2019-07-19','Rejected'),('B20190725101525','V20190725023446','T20190725101239',150050,'2019-07-19','Rejected'),('B20190725101554','V20190725022813','T20190725101322',160000,'2019-07-19','Accepted');

INSERT INTO tenderstatus VALUES ('T20190725022124','B20190725023010','Assigned','V20190725022813'),('T20190725022416','B20190725023512','Assigned','V20190725023446'),('T20190725022601','B20190725024243','Assigned','V20190725022813'),('T20190725101322','B20190725101554','Assigned','V20190725022813');

commit;

```

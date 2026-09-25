<a href="http://ec2-13-233-71-174.ap-south-1.compute.amazonaws.com:8080/tendermanagement/" alt="Tender Management System Java Project" target="_blank">**Tender Management System**</a><br><br>
- **Youtube VIDEO** for local setup of this project: https://www.youtube.com/watch?v=7CE3aY4e644
- **Youtube VIDEO** for Local Setup of similar project : https://youtu.be/mLFPodZO8Iw
### Login Credentials:
	User Login: shashi@gmail.com/shashi
	Admin Login: Admin/Admin
Whenever a company  requires a service / merchandise , a tender is floated. Company maintains an empaneled list of Vendors. An empaneled vendor can only bid for a tender. Every vendor can bid only once against   each tender. Against each tender there may be   bids from several vendors. The company will then select the most suitable bid and places the order to that vendor.
<!--
**Note: This Website is LIVE now <a href="http://ec2-13-233-71-174.ap-south-1.compute.amazonaws.com:8080/tendermanagement/" alt="Tender Management System Java Project" target="_blank">Click Here</a> to visit the live website.
-->
**There are 2 users in the system**

1.	Administrator and
2.	Vendor

**The Role of Administrator is**

1.	Create new Vendor.
2.	View all the vendors.
3.	Create new tenders.
4.	View All the Tenders.
5.	View All the Bids of a tender.
6.	Select a Bid.

**The Role of a Vendor is**
1.	View all the current Tenders.
2.	Place a Bid against a Tender.
3.	View status of a Bid(Whether Selected or Not)
4.	View his own Bid History.
<!--
<a href="http://ec2-13-233-71-174.ap-south-1.compute.amazonaws.com:8080/tendermanagement/" alt="Tender Management System Java Project" target="_blank" div color="red"> 
LIVE NOW &#x1F534
</a>
-->

### Technologies used:-
1. Front-End Development:
- Html
- Css
- Javascript
- BootStrap

2. Back-End Development
- Java
- JDBC
- Servlet
- JSP
- MySQL

### ==== Software And Tools Required ======
- : MySQL
- : Eclipse EE
- : Java JDK 8+
- : Tomcat v8.0
- : Apache Maven
- 
### ========== Dummy Database Initialization USing SQLDUMP =====================

STEPS: If you want to create table structure with dummy database, then follow the Steps given <a target="_blank" href="https://github.com/shashirajraja/Tender-Management-System/blob/master/DataBase/how-to-import-sql-dump-file.md">Here Inside DataBase/how-to-import-sql-dump-file</a>

### ================= Dummy Database Initialization USING QUERY =================

STEP 1: Open MySQL Command Prompt or MySQL Workbench

STEP 2: Login to the administrator user as : ```mysql -u <username> -p``` (Enter Password if asked)

STEP 3: Copy paste the following MySql Commands-
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

INSERT INTO vendor VALUES ('V20190725020951','piyush','Piyush Vikas','07501 070485','piyush@gmail.com','Infosys','K-3, LANE NO-6 AYODHAYAPURI NEAR AIRTEL TOWER'),('V20190725022813','ravi','Ravi Rishu','12345679','ravi@gmail.com','Infosys','Dhanbad ,Jharkhand'),('V20190725023446','ayush','Ayush Vikas','6789054321','ayush@gmail.com','Infosys','siwan near durga mandir, bihar '),('V20190725100730','shashi','Shashi Raj','9234567689','shashi@gmail.com','Wipro','Belhariya More, Kolkata, WB ');

INSERT INTO bidder VALUES ('B20190725022953','V20190725022813','T20190725022124',51000,'2019-07-19','Pending'),('B20190725023010','V20190725022813','T20190725022124',52000,'2019-07-19','Accepted'),('B20190725023248','V20190725022813','T20190725022416',100001,'2019-09-14','Rejected'),('B20190725023512','V20190725023446','T20190725022416',200000,'2019-09-14','Accepted'),('B20190725024125','V20190725023446','T20190725022601',5000001,'2019-07-28','Rejected'),('B20190725024243','V20190725022813','T20190725022601',6000000,'2019-07-28','Accepted'),('B20190725101444','V20190725100730','T20190725101322',1500000,'2019-07-19','Rejected'),('B20190725101519','V20190725023446','T20190725101239',150005,'2019-07-19','Rejected'),('B20190725101525','V20190725023446','T20190725101239',150050,'2019-07-19','Rejected'),('B20190725101554','V20190725022813','T20190725101322',160000,'2019-07-19','Accepted');

INSERT INTO tenderstatus VALUES ('T20190725022124','B20190725023010','Assigned','V20190725022813'),('T20190725022416','B20190725023512','Assigned','V20190725023446'),('T20190725022601','B20190725024243','Assigned','V20190725022813'),('T20190725101322','B20190725101554','Assigned','V20190725022813');

commit;

```
	
### ====== Importing and Running the Project Through Eclipse EE ===========
Step 0: Open Eclipse Enterprise Edition. [Install if not available]

Step 1: Click On File > Import > Git > Projects From Git > Clone Uri  > Paste The Repository Url: ```https://github.com/shashirajraja/Tender-Management-System.git``` > Next > Select Master Branch > Select Tender-Management-System\tendermanagement (Eclipse Project) > Next > Finish

Step 2.a: Go inside ```tendermanagement > Java Resources > dbdetails.properties``` and update the value of username and password according to your installed mysql admin credentials

Step 2.b: Right Click on Project > Run as > Maven Build > In the goals field enter "clean install" > apply > run

Step 3: Right click on Project > Maven > Update Project > Select Project Name > Select Force Update > Update

Step 4.1: [Only if Tomcat v8.0 is not Configured in Eclipse]: Right Click On Project > Run As > Run On Server > Select Tomcat v8.0 > (Select Tomcat V8.0 Installation Location If Asked) Next > Add <project-name> > Finish

Step 4.2: In The Server Tab > Double Click On Tomcat Server > Ports  > Change The Port Number For Http/1.1 To 8083 > Close And Save

Step 5: Right Click On Project > Run As > Run On Server > Select Tomcat V8.0 > Next > Add All> Done

Step 6: Check Running The Site At  <a Href="http://localhost:8083/tendermanagement/">http://localhost:8083/tendermanagement/</a> (Best Viewed in chrome desktop version)

Step 7: Default Username And Password For Admin Is "Admin" and "Admin" respectively. [Case-Sensitive]

Step 8: Default Username And Password For User Is "shashi@gmail.com" and "shashi" respectively.



#### "Suggestions and project Improvements are always Invited!"

<bold>Thanks a lot</bold><br/>
                                                                                                        Project Leader<br/>
                                                                                                         <b>Shashi Raj</b>

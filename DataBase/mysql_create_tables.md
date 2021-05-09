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

commit;

```

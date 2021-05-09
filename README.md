<a href="http://ec2-13-233-71-174.ap-south-1.compute.amazonaws.com:8080/tendermanagement/" alt="Tender Management System Java Project" target="_blank">**Tender Management System**</a>

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
### ========== Dummy Database Initialization ===========

STEPS: If you want to create table structure with dummy database, then follow the Steps given <a target="_blank" href="https://github.com/shashirajraja/Tender-Management-System/blob/master/DataBase/how-to-import-sql-dump-file.md">Here Inside DataBase/how-to-import-sql-dump-file</a>

STEPS: If you want to Create only table structure but no dummy database details, then follow the steps given <a target="_blank" href="https://github.com/shashirajraja/Tender-Management-System/blob/master/DataBase/mysql_create_tables.md"> Here Inside DataBase/mysql_create_tables</a>

	
### ====== Importing and Running the Project Through Eclipse EE ===========
Step 0: Open Eclipse Enterprise Edition. [Install if not available]

Step 1: Click On File > Import > Git > Projects From Git > Clone Uri  > Paste The Repository Url: ```https://github.com/shashirajraja/Tender-Management-System.git``` > Next > Select Master Branch > Select Tender-Management-System\tendermanagement (Eclipse Project) > Next > Finish

Step 2: Go inside ```tendermanagement > Java Resources > dbdetails.properties``` and update the value of username and password according to your installed mysql admin credentials

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

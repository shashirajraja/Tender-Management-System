#### STEPS FOR IMPORTING THE DUMMY DATABASE USING THE DUMP FILE AVAILABLE

STEP 1: Download the Sql Dump File Available inside <a href="https://github.com/shashirajraja/Tender-Management-System/blob/master/DataBase/tender.sql">DataBase/tender.sql</a> file. Or <a href="https://downgit.github.io/#/home?url=https://github.com/shashirajraja/Tender-Management-System/blob/master/DataBase/tender.sql">Click Here to Download the tender.sql file.</a>

STEP 2: Go to the downloaded file location and unzip the file if zipped

STEP 3: Open Command prompt (cmd) in that file location 

STEP 4: Enter the following cmd into the command prompt and enter the password for the root user if asked:

```mysql -u root -p tender < tender.sql``` 

(If your mysql database admininstrator username is not "root" then replace "root" with your dba admin user-name,

eg: ```mysql -u <username> -p tender < tender.sql```)

STEP 5: Done

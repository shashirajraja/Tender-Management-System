-- MySQL dump 10.13  Distrib 5.1.45, for Win32 (ia32)
--
-- Host: localhost    Database: tender
-- ------------------------------------------------------
-- Server version	5.1.45-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `approvedtender`
--

DROP TABLE IF EXISTS `approvedtender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `approvedtender` (
  `id` varchar(5) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `approvedtender`
--

LOCK TABLES `approvedtender` WRITE;
/*!40000 ALTER TABLE `approvedtender` DISABLE KEYS */;
INSERT INTO `approvedtender` VALUES ('A123','Electric Poles'),('A15TY','Site Maintenance'),('CS120','Construction works'),('1253d','Deadline Correction');
/*!40000 ALTER TABLE `approvedtender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bidder`
--

DROP TABLE IF EXISTS `bidder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bidder` (
  `bid` varchar(15) NOT NULL,
  `vid` varchar(15) DEFAULT NULL,
  `tid` varchar(15) DEFAULT NULL,
  `bidamount` int(11) DEFAULT NULL,
  `deadline` date DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bidder`
--

LOCK TABLES `bidder` WRITE;
/*!40000 ALTER TABLE `bidder` DISABLE KEYS */;
INSERT INTO `bidder` VALUES ('B20190724010229','V20190721030329','T20190720024623',5000,'2019-07-10','Rejected'),('B20190724010825','V20190721030329','T20190720024623',5000,'2019-07-10','Rejected'),('B20190724011040','V20190721030329','T20190720024623',5000,'2019-07-10','Rejected'),('B20190724011106','V20190721030329','T20190720065725',1000,'2019-07-09','Accepted'),('B20190724013722','V20190719052915','T20190720075547',100000,'2019-07-24','Pending'),('B20190724013903','V20190719052915','T20190720075547',100000,'2019-07-24','Pending'),('B20190724013949','V20190721030329','T20190720065725',1005,'2019-07-24','Accepted'),('B20190724014835','V20190719052915','T20190720075547',50000,'2019-07-24','Pending'),('B20190724015023','V20190719052915','T20190720075547',50000,'2019-07-24','Pending'),('B20190724015204','V20190719052915','T20190720075547',50000,'2019-07-11','Pending'),('B20190724015444','V20190721030329','T20190720034951',15005,'2019-07-24','Rejected'),('B20190724022909','V20190721030329','T20190720065929',14000,'2019-07-24','Accepted'),('B20190724024254','V20190721030329','T20190720085433',120000,'2019-07-24','Accepted'),('B20190724042551','V20190721030329','T20190720024623',6000,'2019-07-24','Accepted');
/*!40000 ALTER TABLE `bidder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `galary`
--

DROP TABLE IF EXISTS `galary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `galary` (
  `imageid` int(11) DEFAULT NULL,
  `images` blob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `galary`
--

LOCK TABLES `galary` WRITE;
/*!40000 ALTER TABLE `galary` DISABLE KEYS */;
INSERT INTO `galary` VALUES (1002,NULL);
/*!40000 ALTER TABLE `galary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `title` varchar(25) DEFAULT NULL,
  `info` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (100,'Electric Poles','The registration for the tender is live now go on bidding and start getting approved easily and now here is the new project'),(101,'Site Maintenance Updated','The Site has been successfully updated , thanks for your yogdan'),(104,'Heighest Bid','Hurray! We got  a highest bid of rs 1.5 crore of all time'),(105,'Heighest Bid','Hurray! We got  a highest bid of rs 2 crore of all time'),(106,'New Comers Welcome','Hey New comers You are generally Welcomed'),(107,'Website Updation','We are Going to Lauch a New Website for the tender management in a very managed and updated version of this website'),(108,'Salary Increment','All Employees Salary has been increased by 90%'),(110,'Thanks','Thanks for Testing our new website');
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tender`
--

DROP TABLE IF EXISTS `tender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tender` (
  `tid` varchar(15) NOT NULL DEFAULT '',
  `tname` varchar(20) DEFAULT NULL,
  `ttype` varchar(20) DEFAULT NULL,
  `tprice` int(11) DEFAULT NULL,
  `tdesc` varchar(300) DEFAULT NULL,
  `tdeadline` date DEFAULT NULL,
  `tloc` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tender`
--

LOCK TABLES `tender` WRITE;
/*!40000 ALTER TABLE `tender` DISABLE KEYS */;
INSERT INTO `tender` VALUES ('T20190720024623','Pool Construction','construction',5266,'cghjkl','2019-07-09','Haldia'),('T20190720024833','vouchsafe pvt','maintainence',50000,'Error in handling the site developed.','2019-07-09','Haldia'),('T20190720031036','vouchsafe pvt','maintainence',50000,'Error in handling the site developed.','2019-07-09','Haldia'),('T20190720034951','Software Updation','software',15000,'There is some error in the database and we are goind tosolve the error urgent so you are all requested to apply for this tender asfast aa possible','2019-07-23','Haldia'),('T20190720065725','Computer Generation','research',1000,'Haldia is here and where are your going on to form the text','2019-07-09','Haldia'),('T20190720065929','Computer Generation','research',1000,'Haldia is here and where are your going on to form the text','2019-07-09','Haldia'),('T20190720075452','Web Designing','software',10000,'The website development for online banking system in which the user can transact money from their wallet account to their bank account','2019-07-11','Kolkata'),('T20190720075547','Web Designing','software',10000,'The website development for online banking system in which the user can transact money from their wallet account to their bank account','2019-07-11','Kolkata'),('T20190720075655','Web Designing','software',10000,'The website development for online banking system in which the user can transact money from their wallet account to their bank account','2019-07-11','Kolkata'),('T20190720085433','Website Selling','buisness',12000,'Sell this Website in any part of the world at any cost greater than 50 thousand and we will pay you the base amount. \r\nNote that you have to sell this site in the given time deadline.','2019-07-18','India');
/*!40000 ALTER TABLE `tender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tenderstatus`
--

DROP TABLE IF EXISTS `tenderstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tenderstatus` (
  `tid` varchar(15) NOT NULL,
  `bid` varchar(15) DEFAULT NULL,
  `status` varchar(15) NOT NULL,
  `vid` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenderstatus`
--

LOCK TABLES `tenderstatus` WRITE;
/*!40000 ALTER TABLE `tenderstatus` DISABLE KEYS */;
INSERT INTO `tenderstatus` VALUES ('T20190720024623','B20190724042551','Assigned','V20190721030329'),('T20190720065725','B20190724013949','Assigned','V20190721030329'),('T20190720065929','B20190724022909','Assigned','V20190721030329'),('T20190720085433','B20190724024254','Assigned','V20190721030329');
/*!40000 ALTER TABLE `tenderstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendor` (
  `vid` varchar(15) NOT NULL DEFAULT '',
  `password` varchar(20) DEFAULT NULL,
  `vname` varchar(20) DEFAULT NULL,
  `vmob` varchar(12) DEFAULT NULL,
  `vemail` varchar(30) DEFAULT NULL,
  `company` varchar(15) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor`
--

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
INSERT INTO `vendor` VALUES ('V1234567891011','oracle','Shashi','9575232333','abc@gmail.com','Oracle','Tekari'),('V20190719044448','asdfghh','Shashi','9575232333','abc@gmail.com','Java','Tekari'),('V20190719044624','asdfghh','Shashi','9575232333','abc@gmail.com','Java','Tekari'),('V20190719044657','asdfghh','Shashi','9575232333','abc@gmail.com','Java','Tekari'),('V20190719044725','asdfghh','Shashi','9575232333','abc@gmail.com','Java','Tekari'),('V20190719044845','asdfghh','Shashi','9575232333','abc@gmail.com','Java','Tekari'),('V20190719044940','kjhjkk','Shashi','9575232333','abc@gmail.com','Java','Tekari'),('V20190719045037','kjhj','Shashi','9575232333','abc@gmail.com','Oracle','Tekari'),('V20190719045105','kjhj','Shashi','9575232333','abc@gmail.com','Oracle','Tekari'),('V20190719045233','hjghjk','Shashi','9575232333','abc@gmail.com','Java','Tekari'),('V20190719045256','jkhgfghj','Shashi','9575232333','abc@gmail.com','Java','Tekari'),('V20190719045323','jkhgfghj','Shashi','9575232333','abc@gmail.com','Java','Tekari'),('V20190719045521','jkhgfghj','Shashi','9575232333','abc@gmail.com','Java','Tekari'),('V20190719050134','jkhgfghj','Shashi','9575232333','abc@gmail.com','Java','Tekari'),('V20190719050140','jkhgfghj','Shashi','9575232333','abc@gmail.com','Java','Tekari'),('V20190719050301','jkhgfghj','Shashi','9575232333','abc@gmail.com','Java','Tekari'),('V20190719051431','hgfdghj','Shashi','9575232333','abc@gmahfghgil.com','Java','Tekari'),('V20190719051515','hgfdghj','Shashi','9575232333','abc@gmahfghgil.com','Java','Tekari'),('V20190719051752','hgfdghj','Shashi','9575232333','abc@gmahfghgil.com','Java','Tekari'),('V20190719051837','hgfdghj','Shashi','9575232333','abc@gmahfghgil.com','Java','Tekari'),('V20190719051918','hgfdghj','Shashi','9575232333','abc@gmahfghgil.com','Java','Tekari'),('V20190719051943','hgfdghj','Shashi','9575232333','abc@gmahfghgil.com','Java','Tekari'),('V20190719052915','lkjhg','Shashi','9575232333','abc@gmail.com','Java','Tekari'),('V20190719053014','kjhgf','Shashi','9575232333','abc@gmail.com','Java','Tekari'),('V20190719055403','jkhgf','Shashi','9575232333','shashiraj.972@gmail.com','Oracle','Tekari'),('V20190720094424','hjgf','Shashi','9575232333','shasi@gmail.com','Java','Tekari'),('V20190720095011','raj','Raj','9547462318','shashi@gmail.com','Oracle','Gaya Bihar'),('V20190720101650','12345','shikha','911332103','d@gmail.com','fuehfweu','k8hh8j'),('V20190721024109','123456','Shilpi','8522','shilpi@gmail.com','Oracle','jhgfghj'),('V20190721030329','a','Aman Raj','954785622','a@gmail.com','A','A     '),('V20190721083429','v','v','9547456231','v@gmail.com','Infosys','Banglore'),('V20190723103736','infy','Infy','9536214582','abc@infy.com','Infosys','Pune');
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-24 14:13:58

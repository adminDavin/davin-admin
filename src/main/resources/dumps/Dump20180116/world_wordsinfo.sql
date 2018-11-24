-- MySQL dump 10.13  Distrib 5.7.18, for Win64 (x86_64)
--
-- Host: localhost    Database: world
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `wordsinfo`
--

DROP TABLE IF EXISTS `wordsinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wordsinfo` (
  `wordsId` int(18) NOT NULL AUTO_INCREMENT,
  `docId` varchar(256) DEFAULT NULL,
  `userId` int(8) DEFAULT NULL,
  `textContent` varchar(256) DEFAULT NULL,
  `initPage` int(8) DEFAULT NULL,
  `pageNum` int(12) DEFAULT NULL,
  `state` int(1) NOT NULL DEFAULT '0' COMMENT '0 正常  1 用户删除 2 管理员删除 3 自动失效',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updateTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`wordsId`),
  KEY `wordsInfoUserDocu` (`state`,`userId`,`docId`),
  KEY `wordsInfoDocuWords` (`docId`,`textContent`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wordsinfo`
--

LOCK TABLES `wordsinfo` WRITE;
/*!40000 ALTER TABLE `wordsinfo` DISABLE KEYS */;
INSERT INTO `wordsinfo` VALUES (2,'130',1,'tribute sign',1,9,0,'2017-12-15 05:34:13','0000-00-00 00:00:00'),(3,'130',1,'s the re',1,9,0,'2017-12-15 05:37:36','0000-00-00 00:00:00'),(4,'130',1,'rding is ac',1,9,0,'2017-12-15 05:37:41','0000-00-00 00:00:00'),(5,'130',1,'nitor checks',1,9,0,'2017-12-15 05:37:43','0000-00-00 00:00:00'),(6,'129',1,'nthesizes inter-preter JavaScript call stac',1,9,0,'2017-12-15 05:38:35','0000-00-00 00:00:00'),(7,'129',1,'es as needed. Finally, it copies theimported variables back from the trace acti',1,9,0,'2017-12-15 05:38:36','0000-00-00 00:00:00'),(8,'129',1,'programs',3,1,0,'2017-12-15 06:02:38','0000-00-00 00:00:00'),(9,'129',1,'mpiler for JavaScript based on our technique and we\r\nhave',3,1,0,'2017-12-15 06:02:39','0000-00-00 00:00:00'),(10,'129',1,'Design,',3,1,0,'2017-12-15 06:02:40','0000-00-00 00:00:00'),(11,'129',1,'-in-time',3,1,0,'2017-12-15 06:02:41','0000-00-00 00:00:00'),(12,'129',1,',',3,1,0,'2017-12-15 06:02:42','0000-00-00 00:00:00'),(13,'129',1,'certain',3,1,0,'2017-12-15 06:02:43','0000-00-00 00:00:00'),(14,'129',1,'alternative paths through nested loops. We have implemented\r\na dynamic compiler for JavaScript based',1,1,0,'2017-12-15 06:04:10','0000-00-00 00:00:00'),(15,'129',1,'piler for JavaS',0,1,0,'2017-12-15 06:04:14','0000-00-00 00:00:00'),(16,'129',1,'Trace',0,1,0,'2017-12-15 06:04:16','0000-00-00 00:00:00'),(17,'129',1,'code gener',0,1,0,'2017-12-15 06:04:20','0000-00-00 00:00:00'),(18,'129',1,'Introduction',0,1,0,'2017-12-15 06:04:21','0000-00-00 00:00:00'),(19,'129',1,'Trace-based',0,1,0,'2017-12-15 06:04:28','0000-00-00 00:00:00'),(20,'129',1,'Just-',0,1,0,'2017-12-15 06:05:03','0000-00-00 00:00:00'),(21,'131',1,'va SE prod',3,1,0,'2017-12-16 04:20:41','0000-00-00 00:00:00'),(22,'131',1,'bes the',3,1,0,'2017-12-16 04:21:00','0000-00-00 00:00:00'),(23,'131',1,'dded products, and the features available with them. It contains the following sections:',3,1,0,'2017-12-16 04:21:01','0000-00-00 00:00:00'),(24,'134',1,'(OJWC), and Oracle Java',1,2,0,'2017-12-16 04:23:09','0000-00-00 00:00:00'),(25,'134',1,'mbedded, Oracle J',1,2,0,'2017-12-16 04:23:11','0000-00-00 00:00:00'),(26,'134',1,'the scope of theJava',1,2,0,'2017-12-16 04:23:12','0000-00-00 00:00:00'),(27,'134',1,', Oracle Ja',1,2,0,'2017-12-16 04:23:15','0000-00-00 00:00:00'),(28,'132',1,'t be accepted prior todownload.Any commercial o',1,2,0,'2017-12-16 04:23:31','0000-00-00 00:00:00'),(31,'134',1,'ed prior todownload.',1,2,0,'2017-12-16 04:24:18','0000-00-00 00:00:00'),(32,'133',1,'le Java SE for embedded use cases, that is, for cases outside the scope of theJava BCLA.De',1,2,0,'2017-12-16 04:24:33','0000-00-00 00:00:00'),(33,'133',1,'uctsis governed',1,2,0,'2017-12-16 04:25:02','0000-00-00 00:00:00'),(34,'133',1,'Embedded, Oracle Java ME Embedded Client (OJEC), Oracle Java Wireless Client (OJ',1,2,0,'2017-12-16 04:26:04','0000-00-00 00:00:00'),(35,'133',1,'nt (OJWC',1,2,0,'2017-12-16 04:27:37','0000-00-00 00:00:00'),(36,'133',1,'mbedded',1,2,0,'2017-12-16 04:27:52','0000-00-00 00:00:00'),(40,'133',1,'Wireless',1,2,0,'2017-12-16 05:49:11','0000-00-00 00:00:00'),(41,'133',1,'Wireless Client (OJWC), and Oracle Java SE for embed',1,2,0,'2017-12-16 05:49:11','0000-00-00 00:00:00'),(42,'133',1,'less Client (O',1,2,0,'2017-12-16 05:54:28','0000-00-00 00:00:00'),(44,'133',1,'undefined',1,5,0,'2017-12-16 06:45:10','0000-00-00 00:00:00'),(45,'134',1,'undefined',6,6,0,'2017-12-16 06:45:46','0000-00-00 00:00:00'),(46,'137',1,'undefined',3,1,0,'2017-12-16 13:09:19','0000-00-00 00:00:00'),(47,'138',1,'undefined',3,1,0,'2017-12-16 13:10:59','0000-00-00 00:00:00'),(48,'138',1,'国籍',4,1,0,'2017-12-16 13:34:00','0000-00-00 00:00:00'),(49,'134',1,'ndent Soft',3,6,0,'2017-12-16 13:34:39','0000-00-00 00:00:00'),(50,'134',1,'censed',3,6,0,'2017-12-16 13:35:35','0000-00-00 00:00:00'),(51,'133',1,'is and fea',4,6,0,'2017-12-16 13:36:11','0000-00-00 00:00:00'),(52,'131',1,'been',0,6,0,'2017-12-16 13:53:06','0000-00-00 00:00:00'),(53,'133',1,'Software',8,6,0,'2017-12-16 13:59:02','0000-00-00 00:00:00'),(54,'133',1,'Oracle',8,6,0,'2017-12-16 13:59:15','0000-00-00 00:00:00'),(55,'133',1,'oftware',0,6,0,'2017-12-16 14:11:25','0000-00-00 00:00:00'),(57,'142',1,'强',0,1,0,'2017-12-16 14:36:26','0000-00-00 00:00:00'),(58,'142',1,'中级',0,1,0,'2017-12-16 14:36:29','0000-00-00 00:00:00'),(59,'142',1,'15168223268',0,1,0,'2017-12-16 14:36:30','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `wordsinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-16 21:08:51

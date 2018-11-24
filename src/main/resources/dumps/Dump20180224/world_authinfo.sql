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
-- Table structure for table `authinfo`
--

DROP TABLE IF EXISTS `authinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authinfo` (
  `authId` int(8) NOT NULL AUTO_INCREMENT,
  `authKey` varchar(64) NOT NULL,
  `desc` varchar(128) NOT NULL,
  `state` int(1) NOT NULL DEFAULT '0',
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `expireDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`authId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authinfo`
--

LOCK TABLES `authinfo` WRITE;
/*!40000 ALTER TABLE `authinfo` DISABLE KEYS */;
INSERT INTO `authinfo` VALUES (2,'updateUserStatus','更新用户权限',0,'2018-01-14 07:06:59','2018-01-14 07:06:59'),(3,'deleteUser','删除用户权限',0,'2018-01-15 13:05:22','2018-01-15 13:05:22'),(4,'addRole','添加角色权限',0,'2018-02-22 05:08:33','2018-02-22 05:08:33'),(5,'modifyRole','修改角色权限',0,'2018-02-22 05:08:33','2018-02-22 05:08:33'),(6,'deleteRole','删除角色权限',0,'2018-02-22 05:08:33','2018-02-22 05:08:33'),(7,'addManager','添加管理员权限',0,'2018-02-22 05:08:33','2018-02-22 05:08:33'),(8,'modifyManager','修改管理员权限',0,'2018-02-22 05:08:33','2018-02-22 05:08:33'),(9,'deleteManager','删除管理员权限',0,'2018-02-22 05:08:33','2018-02-22 05:08:33');
/*!40000 ALTER TABLE `authinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-24 17:44:51

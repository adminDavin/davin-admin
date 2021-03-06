-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
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
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userinfo` (
  `userId` int(8) NOT NULL AUTO_INCREMENT,
  `organize` varchar(128) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `namePin` varchar(64) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL COMMENT '1 男  0 女',
  `email` varchar(64) NOT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `zoneqq` varchar(16) DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  `state` int(1) DEFAULT '0' COMMENT '0：注册用户 1： 审核中用户 2 ：审核成功用户 3： 审核失败用户  5： 管理员用户',
  `applyDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `acceptDate` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `accepterId` int(8) DEFAULT NULL,
  `remark` varchar(512) DEFAULT NULL,
  `birthDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (1,'zhangdawei','zhangdawei','zhangdawei',1,'zhangdawei','zhangdawei','zhangdawei','zhangdawei',0,'2017-11-23 11:20:47','2017-11-23 11:20:47',NULL,'zhangdawei','2017-12-24 05:05:49'),(2,NULL,NULL,NULL,NULL,'745854511@qq.com',NULL,NULL,NULL,0,'2017-12-24 13:17:15','0000-00-00 00:00:00',NULL,NULL,'2017-12-24 13:17:15'),(3,NULL,NULL,NULL,NULL,'7458545111@qq.com',NULL,NULL,NULL,0,'2017-12-24 13:30:08','0000-00-00 00:00:00',NULL,NULL,'2017-12-24 13:30:08'),(4,NULL,NULL,NULL,NULL,'711111@qq.com',NULL,NULL,NULL,0,'2017-12-24 13:34:32','0000-00-00 00:00:00',NULL,NULL,'2017-12-24 13:34:32');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-24 23:27:46

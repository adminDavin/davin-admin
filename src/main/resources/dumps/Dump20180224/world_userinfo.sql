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
  `state` int(1) DEFAULT '0' COMMENT '0：注册用户 1： 审核中用户 2 ：审核成功用户 3： 审核失败用户  5： 管理员用户  6：信息已填写 用户尚未审核',
  `applyDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `acceptDate` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `accepterId` int(8) DEFAULT NULL,
  `accepter` varchar(64) DEFAULT NULL,
  `remark` varchar(512) DEFAULT NULL,
  `birthDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (1,'张大伟','zhangdawei','在v重新注册v啊打发十分',1,'zhangdawei','张大伟','zhangdawei','zhangdawei',5,'2018-01-14 12:51:03','2018-01-14 12:49:37',1,NULL,'zhangdaweifasdfsadfsd','2018-01-14 12:51:03'),(2,'张大伟',NULL,NULL,NULL,'745854511@qq.com','张大伟',NULL,NULL,9,'2018-02-22 02:49:36','2018-02-22 02:49:36',1,'zhangdawei',NULL,'2018-02-22 02:49:36'),(3,'张大伟',NULL,NULL,NULL,'7458545111@qq.com','张大伟',NULL,NULL,9,'2018-01-15 13:06:22','2018-01-15 13:06:22',1,'zhangdawei',NULL,'2018-01-15 13:06:22'),(4,'张大伟',NULL,NULL,NULL,'711111@qq.com','张大伟',NULL,NULL,9,'2018-02-22 02:49:44','2018-02-22 02:49:44',1,'zhangdawei',NULL,'2018-02-22 02:49:44'),(5,'张大伟',NULL,NULL,NULL,'123456l@qq.com','张大伟',NULL,NULL,9,'2018-01-15 13:06:27','2018-01-15 13:06:27',1,'zhangdawei',NULL,'2018-01-15 13:06:27'),(6,'张大伟',NULL,NULL,NULL,'123456lq@qq.com','张大伟',NULL,NULL,3,'2018-01-14 13:11:49','2018-01-14 13:11:49',1,'zhangdawei',NULL,'2018-01-14 13:11:49'),(7,'张大伟',NULL,NULL,NULL,'12312412412@qq.com','张大伟',NULL,NULL,9,'2018-02-23 08:07:13','2018-02-23 08:07:13',1,'zhangdawei',NULL,'2018-02-23 08:07:13'),(8,'张大伟',NULL,NULL,NULL,'124321431@qq.com','张大伟',NULL,NULL,9,'2018-02-24 00:50:06','2018-02-24 00:50:06',1,'zhangdawei',NULL,'2018-02-24 00:50:06'),(9,'张大伟',NULL,NULL,NULL,'sdfsadf@qq.com','张大伟',NULL,NULL,2,'2018-01-15 12:27:50','2018-01-15 12:27:50',1,'zhangdawei',NULL,'2018-01-15 12:27:50'),(10,'张大伟',NULL,NULL,NULL,'sdfsaddf@qq.com','张大伟',NULL,NULL,5,'2018-02-24 03:11:20','2018-02-24 03:11:20',1,'zhangdawei',NULL,'2018-02-24 03:11:20'),(11,'张大伟',NULL,NULL,NULL,'sdfsadcddf@qq.com','张大伟',NULL,NULL,9,'2018-02-23 09:10:12','2018-02-23 09:10:12',1,'zhangdawei',NULL,'2018-02-23 09:10:12'),(12,'张大伟',NULL,'',0,'QAZw@sxQ.com','张大伟',NULL,'',9,'2018-02-23 09:06:39','2018-02-23 09:06:39',1,'zhangdawei','申请备注','2018-02-23 09:06:39'),(13,'张大伟',NULL,NULL,NULL,'QAZwsx1124','张大伟',NULL,NULL,2,'2018-01-15 12:28:06','2018-01-15 12:28:06',1,'zhangdawei',NULL,'2018-01-15 12:28:06'),(14,'张大伟','sfdsdf','sadsada',0,'1234@qq.com','张大伟',NULL,'cZXc',2,'2018-01-15 12:28:09','2018-01-15 12:28:09',1,'zhangdawei','申请备注','2018-01-15 12:28:09'),(15,'张大伟','张大伟','zhangdawei',0,'Qww@qq.co','张大伟',NULL,'西京学院',2,'2018-01-15 12:28:13','2018-01-15 12:28:13',1,'zhangdawei','申请备注','2018-01-15 12:28:13'),(16,'西京学院','张大伟','zhangdawei',0,'7222@qq.com','18758268513',NULL,'西安111',2,'2018-01-15 12:43:46','2018-01-15 12:43:46',1,'zhangdawei','申请备注','2018-01-15 12:43:46');
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

-- Dump completed on 2018-02-24 17:44:51

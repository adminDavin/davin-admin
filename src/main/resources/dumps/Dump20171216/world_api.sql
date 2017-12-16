-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: world
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `api`
--

DROP TABLE IF EXISTS `api`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `api` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `action` varchar(128) DEFAULT NULL,
  `description` varchar(2048) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `api`
--

LOCK TABLES `api` WRITE;
/*!40000 ALTER TABLE `api` DISABLE KEYS */;
INSERT INTO `api` VALUES (52,'AllocatePublicNetworkAddress','dd','2017-11-14 07:24:27'),(53,'DeleteCluster','删除集群实例','2017-11-14 07:24:28'),(54,'DescribeClusterAttribute','描述集群属性','2017-11-14 07:24:28'),(55,'DescribeClusterList','获取集群列表','2017-11-14 07:24:28'),(56,'CreateCluster','创建集群实例','2017-11-14 07:24:28'),(57,'DescribeRegions','获取集群所在区域','2017-11-14 07:24:28'),(58,'DescribeSubDomain','获取子域','2017-11-14 07:24:28'),(59,'ListClusterServiceConfig','获取集群服务配置','2017-11-14 07:24:28'),(60,'ListClusterServiceConfigHistory','获取集群服务配置历史列表','2017-11-14 07:24:28'),(61,'ModifyClusterName','修改集群名称','2017-11-14 07:24:28'),(62,'ModifyClusterSecurityIpList','修改集群安全IP列表','2017-11-14 07:24:28'),(63,'ModifyClusterNetType','修改网络类型','2017-11-14 07:24:28'),(64,'ModifyRestartCluster','重启集群实例','2017-11-14 07:24:28'),(65,'ModifyUIProxyAccountPassword','修改集群UI代理账号的密码','2017-11-14 07:24:28'),(66,'ModifyClusterServiceConfig','修改集群服务配置','2017-11-14 07:24:28'),(67,'ReleasePublicNetworkAddress','获取公网地址','2017-11-14 07:24:28'),(68,'ResizeCluster','重置集群大小','2017-11-14 07:24:28');
/*!40000 ALTER TABLE `api` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-16 10:21:46

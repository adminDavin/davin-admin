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
-- Table structure for table `documentinfo`
--

DROP TABLE IF EXISTS `documentinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `documentinfo` (
  `docId` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `originalName` varchar(256) DEFAULT NULL,
  `uuid` varchar(256) DEFAULT NULL,
  `userId` int(8) DEFAULT NULL,
  `state` int(1) NOT NULL DEFAULT '0' COMMENT '0 文档正常 1 文档丢失 2 文档失效',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `expireTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `Remark` varchar(512) DEFAULT 'null',
  PRIMARY KEY (`docId`),
  KEY `documentUuidIndex` (`uuid`),
  KEY `documentUserIdIndex` (`userId`),
  KEY `documentNameIndex` (`name`),
  KEY `documentStateIndex` (`state`),
  KEY `documentOrginalIndex` (`originalName`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documentinfo`
--

LOCK TABLES `documentinfo` WRITE;
/*!40000 ALTER TABLE `documentinfo` DISABLE KEYS */;
INSERT INTO `documentinfo` VALUES (96,'ASDFASDF','4ec960419df6462ba7e40ae555696bb0.pdf','da89e6d6ee55463b892e9222af1f687b',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(97,'SDFASDf','3cae52e763be4fb3a0c98580d98fc065.pdf','52cf30788c2543ffa554e189b602d4f0',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(98,'ASDFASDF','05c5c974d6aa4df3a6fc2cf13aee5718.pdf','1714ad19729944ad95156be43d9e2e1e',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(99,'adfsadf','3cae52e763be4fb3a0c98580d98fc065.pdf','3a865f0c20264a19831f88706277ed12',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(100,'asdfsa','2e1f860db43d4acc8fa939f5e0324b0f.pdf','73c54258eac34eefad996634cfb602b5',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(101,'asdfsdaf','2e1f860db43d4acc8fa939f5e0324b0f.pdf','ba1694bad0164de99b0e7d64c4caa353',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(102,'asdfsadf','1c5107f9f79842dabf3756a4430c70cb.pdf','6eea971b00264cb78fd3206f1f3cbab2',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(103,'asdfsadf','2e1f860db43d4acc8fa939f5e0324b0f.pdf','199759757b9c4d599f1d0534f5516ad0',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(104,'asdfsaf','2e1f860db43d4acc8fa939f5e0324b0f.pdf','d2dc8344a1fe40368dbf560ad09e1aea',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(105,'asdfsdf','3e6ae03aeb8f4981a12a247d345710e6.pdf','69d51d0be6e64c6285fc212527f5daa9',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(106,'asdfsadf','3cae52e763be4fb3a0c98580d98fc065.pdf','ba50b56a606c4b3fbf3a07f17b240b5a',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(107,'dsdddddddddd','1c5107f9f79842dabf3756a4430c70cb.pdf','94a72aee537a404aadea1d5f65691f06',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(108,'ASDFASDfasdf','2e1f860db43d4acc8fa939f5e0324b0f.pdf','e9eaf165dfca43fa96f1d52e646447fc',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(109,'dddddddddddddddddddddddddddddddddddddddddddddddd','3cae52e763be4fb3a0c98580d98fc065.pdf','0cab48811d7d4c49b7aef060babfd019',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(110,'awfasdfasdf','1ad2ce7af99a4e7ea9d637b2a9272a6f.pdf','1fb8a863773c44d89ba2e76411747baa',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(111,'asdfasdf','1ad2ce7af99a4e7ea9d637b2a9272a6f.pdf','c69128c1833b40948caae992f1f3b9ae',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(112,'asfasd','3a865f0c20264a19831f88706277ed12.pdf','9641f45de986477d95b07e68a6b0b571',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(113,'asfdsda','1fb8a863773c44d89ba2e76411747baa.pdf','353e915e1e864dc4bab745e7e8099832',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(114,'asfsad','3a865f0c20264a19831f88706277ed12.pdf','a2c7cde208094a8f99af1d34bcbff5e6',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(115,'afdsaf','1c5107f9f79842dabf3756a4430c70cb.pdf','4a17babd82ac46ca80f9b4468b68ca0e',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(116,'asdfsa','2e1f860db43d4acc8fa939f5e0324b0f.pdf','c627f393e29d438d8bfa5ba6e5ea48f9',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(117,'asdfadf','3a865f0c20264a19831f88706277ed12.pdf','a4bbb7f186704e5398b3e8add8113002',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(118,'fsadf','3cae52e763be4fb3a0c98580d98fc065.pdf','2116dee761554ae4a95bdbcbef7dbae6',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(119,'sadadfas','3cae52e763be4fb3a0c98580d98fc065.pdf','2b1bef9a82e847b28577dc60a2876902',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(120,'FCsdfasd','3cae52e763be4fb3a0c98580d98fc065.pdf','885ffdc1822240228f359decb62eb0b7',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(121,'asdfadf','2e1f860db43d4acc8fa939f5e0324b0f.pdf','94bd7dcb2ee043e3bf46c8349061f14f',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(122,'sadfasdf','2e1f860db43d4acc8fa939f5e0324b0f.pdf','db655e16d74f4867a43ee4bad3875fb2',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(123,'asdfsadf','1fb8a863773c44d89ba2e76411747baa.pdf','8bd4151329b5456cbeefd8188db50b4d',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(124,'sadasda','1fb8a863773c44d89ba2e76411747baa.pdf','ec45b5dbc43c437c91d3da132650f249',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(125,'ASDFASDf','1fb8a863773c44d89ba2e76411747baa.pdf','73744e006d874b5783cee7570efb33ad',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(126,'ASDFASDF','3a865f0c20264a19831f88706277ed12.pdf','0c076bdc6dfe44c0b3f97d504782564b',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(127,'asdfsafas','1fb8a863773c44d89ba2e76411747baa.pdf','e2cad4d951d8431ea50948464714a72a',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(128,'afasdfasd','1ad2ce7af99a4e7ea9d637b2a9272a6f.pdf','576adb563d9d4cf3a7f5205ed97ddc0d',1,2,'2017-12-15 05:06:00','2017-12-15 05:06:00','0000-00-00 00:00:00','null'),(129,'asfddsaf','1c5107f9f79842dabf3756a4430c70cb.pdf','36d73e09f72a43fdb6e367f95896d8d1',1,0,'2017-12-15 05:07:39','2017-12-15 05:07:39','0000-00-00 00:00:00','null'),(130,'sadfsadf','1a4fe6308b6b459a823442829f3c7a70.pdf','b6c32b7cf2f1497ba6bb6a21bc3ee07b',1,0,'2017-12-15 05:30:41','2017-12-15 05:30:41','0000-00-00 00:00:00','null'),(131,'asdfsadfa','C:\\Project\\king-words\\davin-admin\\src\\main\\webapp\\pdf-directory\\java-se-product-editions-397069.pdf','6367dcac94e9497b8e714856ba80fd38',1,0,'2017-12-16 04:20:16','2017-12-16 04:20:16','0000-00-00 00:00:00','null'),(132,'safdsadfsad','C:\\Project\\king-words\\davin-admin\\src\\main\\webapp\\pdf-directory\\java-se-product-editions-397069.pdf','37e015d7a2004160a225439b2baeccbd',1,0,'2017-12-16 04:21:12','2017-12-16 04:21:12','0000-00-00 00:00:00','null'),(133,'asfdfa','C:\\Project\\king-words\\davin-admin\\src\\main\\webapp\\pdf-directory\\java-se-product-editions-397069.pdf','08bf229c6d5640e5ac68c0b731f99098',1,0,'2017-12-16 04:22:06','2017-12-16 04:22:06','0000-00-00 00:00:00','null'),(134,'sadfsadfas','java-se-product-editions-397069.pdf','13b58d3e177d42e096e261b43fd1401b',1,0,'2017-12-16 04:23:04','2017-12-16 04:23:04','0000-00-00 00:00:00','null'),(135,'18758268513','C:\\Project\\king-words\\davin-admin\\src\\main\\webapp\\pdf-directory\\java-se-product-editions-397069.pdf','de6e0dd21d6b4ac5aa732fbb11fb0a1d',1,0,'2017-12-16 12:50:32','2017-12-16 12:50:32','0000-00-00 00:00:00','null'),(136,'18758268513','C:\\Users\\administor\\Documents\\张大伟简历.docx','699e3008f1f74a969c9e450dbcfa80e4',1,0,'2017-12-16 12:51:30','2017-12-16 12:51:30','0000-00-00 00:00:00','null'),(137,'X\'f\'cXzfds','C:\\Users\\administor\\Documents\\张大伟简历.docx','b4711ad077df42048fb9c45b4be99b25',1,0,'2017-12-16 13:08:23','2017-12-16 13:08:23','0000-00-00 00:00:00','null'),(138,'啊士大夫的撒','C:\\Users\\administor\\Documents\\张大伟简历.docx','ec9b0a27f1b748c98cbc5792e783d1dd',1,0,'2017-12-16 13:10:29','2017-12-16 13:10:29','0000-00-00 00:00:00','null'),(139,'','java-se-product-editions-397069.pdf','ea175fd4de7c405ea3b0043c72311b8a',1,0,'2017-12-16 14:19:04','2017-12-16 14:19:04','0000-00-00 00:00:00','null'),(140,'','java-se-product-editions-397069.pdf','91b62e40e0cb4d0588bbe541b192751b',1,0,'2017-12-16 14:27:57','2017-12-16 14:27:57','0000-00-00 00:00:00','null'),(141,'sfadfsadfds','张大伟简历.docx','0ef3bf3902784a0a8e2a0626f081d2f9',1,0,'2017-12-16 14:32:49','2017-12-16 14:32:49','0000-00-00 00:00:00','null'),(142,'sfadfds','应聘人员列表.xlsx','a88d6dc7643d4048827638e115333d8a',1,0,'2017-12-16 14:36:09','2017-12-16 14:36:09','0000-00-00 00:00:00','null');
/*!40000 ALTER TABLE `documentinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-29 10:12:06

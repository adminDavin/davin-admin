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
-- Table structure for table `openapiresult`
--

DROP TABLE IF EXISTS `openapiresult`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `openapiresult` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `tag_name` varchar(128) DEFAULT NULL,
  `action` varchar(128) DEFAULT NULL,
  `required` varchar(32) DEFAULT NULL,
  `type` varchar(32) DEFAULT NULL,
  `description` varchar(512) DEFAULT NULL,
  `is_common` int(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `ind_action_apiresult` (`action`)
) ENGINE=InnoDB AUTO_INCREMENT=233 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `openapiresult`
--

LOCK TABLES `openapiresult` WRITE;
/*!40000 ALTER TABLE `openapiresult` DISABLE KEYS */;
INSERT INTO `openapiresult` VALUES (175,'requestId','RequestId','AllocatePublicNetworkAddress','no','String','request Id',0,'2017-11-14 07:24:27'),(176,'requestId','RequestId','DeleteCluster','no','String','request Id',0,'2017-11-14 07:24:27'),(177,'requestId','RequestId','CreateCluster','no','String','request Id',0,'2017-11-14 07:24:27'),(178,'data.clusterId','ClusterId','CreateCluster','no','String','集群产品ID',0,'2017-11-14 07:24:27'),(179,'data.orderId','OrderId','CreateCluster','no','String','订单ID',0,'2017-11-14 07:24:27'),(180,'requestId','RequestId','DescribeClusterList','no','String','request Id',0,'2017-11-14 07:24:27'),(181,'data.pageNumber','PageNumber','DescribeClusterList','no','Integer','当前页',0,'2017-11-14 07:24:27'),(182,'data.totalRecordCount','TotalRecordCount','DescribeClusterList','no','Integer','总记录数',0,'2017-11-14 07:24:27'),(183,'data.pageRecordCount','PageRecordCount','DescribeClusterList','no','Integer','总页数',0,'2017-11-14 07:24:27'),(184,'data.clusterList','ClusterList','DescribeClusterList','no','Cluster','集群产品列表',0,'2017-11-14 07:24:27'),(185,'requestId','RequestId','DescribeClusterAttribute','no','String','request Id',0,'2017-11-14 07:24:27'),(186,'data.clusterId','ClusterId','DescribeClusterAttribute','no','String','集群产品ID',0,'2017-11-14 07:24:27'),(187,'data.clusterName','ClusterName','DescribeClusterAttribute','no','String','集群产品名称',0,'2017-11-14 07:24:27'),(188,'data.mainVersion','MainVersion','DescribeClusterAttribute','no','String','主版本号',0,'2017-11-14 07:24:27'),(189,'data.status','Status','DescribeClusterAttribute','no','String','请求状态',0,'2017-11-14 07:24:27'),(190,'data.lockMode','LockMode','DescribeClusterAttribute','no','String','锁状态：Unlock ManualLock LockByExpiration LockByRestoration LockByDiskQuota LockReadInstanceByDiskQuota',0,'2017-11-14 07:24:27'),(191,'data.haType','HaType','DescribeClusterAttribute','no','String','高可用类型',0,'2017-11-14 07:24:27'),(192,'data.masterInstanceType','MasterInstanceType','DescribeClusterAttribute','no','String','主节点实例类型',0,'2017-11-14 07:24:27'),(193,'data.masterDiskType','MasterDiskType','DescribeClusterAttribute','no','String','主节点磁盘类型',0,'2017-11-14 07:24:27'),(194,'data.masterDiskSize','MasterDiskSize','DescribeClusterAttribute','no','Integer','主节点磁盘大小',0,'2017-11-14 07:24:27'),(195,'data.coreInstanceType','CoreInstanceType','DescribeClusterAttribute','no','String','core节点实例类型',0,'2017-11-14 07:24:27'),(196,'data.coreInstanceQuantity','CoreInstanceQuantity','DescribeClusterAttribute','no','Integer','core节点数量',0,'2017-11-14 07:24:27'),(197,'data.coreDiskType','CoreDiskType','DescribeClusterAttribute','no','String','core节点磁盘类型',0,'2017-11-14 07:24:27'),(198,'data.coreDiskSize','CoreDiskSize','DescribeClusterAttribute','no','String','core节点磁盘大小',0,'2017-11-14 07:24:27'),(199,'data.coreDiskQuantity','CoreDiskQuantity','DescribeClusterAttribute','no','Integer','core节点磁盘数量',0,'2017-11-14 07:24:27'),(200,'data.payType','PayType','DescribeClusterAttribute','no','String','付费类型：后付费（Postpaid）先付费（Prepaid）',0,'2017-11-14 07:24:27'),(201,'data.autoRenew','AutoRenew','DescribeClusterAttribute','no','String','自动重建',0,'2017-11-14 07:24:27'),(202,'data.createTime','CreateTime','DescribeClusterAttribute','no','String','集群创建时间',0,'2017-11-14 07:24:27'),(203,'data.expiredTime','ExpireTime','DescribeClusterAttribute','no','String','集群失效时间',0,'2017-11-14 07:24:27'),(204,'data.regionId','RegionId','DescribeClusterAttribute','no','String','RegionId',0,'2017-11-14 07:24:27'),(205,'data.zoneId','ZoneId','DescribeClusterAttribute','no','String','ZoneId',0,'2017-11-14 07:24:27'),(206,'data.nodeList','NodeList','DescribeClusterAttribute','no','List','节点列表',0,'2017-11-14 07:24:27'),(207,'data.connectionInfo','ConnectionInfo','DescribeClusterAttribute','no','Struct','连接信息',0,'2017-11-14 07:24:27'),(208,'data.netInfo','NetInfo','DescribeClusterAttribute','no','Struct','网络信息',0,'2017-11-14 07:24:27'),(209,'requestId','RequestId','DescribeRegions','no','String','request Id',0,'2017-11-14 07:24:28'),(210,'data.regions','Regions','DescribeRegions','no','List','区域列表',0,'2017-11-14 07:24:28'),(211,'requestId','RequestId','DescribeSubDomain','no','String','request Id',0,'2017-11-14 07:24:28'),(212,'data','SubDomain','DescribeSubDomain','no','String','子域名称',0,'2017-11-14 07:24:28'),(213,'requestId','RequestId','ListClusterServiceConfigHistory','no','String','request Id',0,'2017-11-14 07:24:28'),(214,'data.pageNumber','PageNumber','ListClusterServiceConfigHistory','no','Integer','当前页',0,'2017-11-14 07:24:28'),(215,'data.totalRecordCount','TotalRecordCount','ListClusterServiceConfigHistory','no','Integer','总记录数',0,'2017-11-14 07:24:28'),(216,'data.pageSize','PageRecordCount','ListClusterServiceConfigHistory','no','Integer','总页数',0,'2017-11-14 07:24:28'),(217,'data.configItemList','ConfigHistoryList','ListClusterServiceConfigHistory','no','List','配置历史信息列表',0,'2017-11-14 07:24:28'),(218,'requestId','RequestId','ModifyClusterName','no','String','request Id',0,'2017-11-14 07:24:28'),(219,'requestId','RequestId','ListClusterServiceConfig','no','String','request Id',0,'2017-11-14 07:24:28'),(220,'data.pageNumber','PageNumber','ListClusterServiceConfig','no','Integer','当前页',0,'2017-11-14 07:24:28'),(221,'data.totalRecordCount','TotalRecordCount','ListClusterServiceConfig','no','Integer','总记录数',0,'2017-11-14 07:24:28'),(222,'data.pageSize','PageRecordCount','ListClusterServiceConfig','no','Integer','总页数',0,'2017-11-14 07:24:28'),(223,'data.clusterId','ClusterId','ListClusterServiceConfig','no','String','集群产品ID',0,'2017-11-14 07:24:28'),(224,'data.clusterName','ClusterName','ListClusterServiceConfig','no','String','集群产品名称',0,'2017-11-14 07:24:28'),(225,'data.configItems','ConfigList','ListClusterServiceConfig','no','List','配置信息列表',0,'2017-11-14 07:24:28'),(226,'requestId','RequestId','ModifyClusterSecurityIpList','no','String','request Id',0,'2017-11-14 07:24:28'),(227,'requestId','RequestId','ModifyClusterNetType','no','String','request Id',0,'2017-11-14 07:24:28'),(228,'requestId','RequestId','ModifyRestartCluster','no','String','request Id',0,'2017-11-14 07:24:28'),(229,'requestId','RequestId','ModifyUIProxyAccountPassword','no','String','request Id',0,'2017-11-14 07:24:28'),(230,'requestId','RequestId','ModifyClusterServiceConfig','no','String','request Id',0,'2017-11-14 07:24:28'),(231,'requestId','RequestId','ReleasePublicNetworkAddress','no','String','request Id',0,'2017-11-14 07:24:28'),(232,'requestId','RequestId','ResizeCluster','no','String','request Id',0,'2017-11-14 07:24:28');
/*!40000 ALTER TABLE `openapiresult` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-16 10:21:45

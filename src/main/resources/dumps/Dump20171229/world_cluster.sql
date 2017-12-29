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
-- Table structure for table `cluster`
--

DROP TABLE IF EXISTS `cluster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cluster` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_created` bigint(20) unsigned NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(20) unsigned NOT NULL COMMENT '修改时间',
  `region_id` varchar(64) NOT NULL COMMENT '物理位置，对用于业务location region',
  `zone_id` varchar(255) NOT NULL COMMENT '物理位置可用区，对用于业务location zoneId',
  `ali_uid` varchar(64) NOT NULL COMMENT 'ali_uid',
  `ali_bid` varchar(64) NOT NULL COMMENT '渠道',
  `cluster_id` varchar(128) NOT NULL COMMENT '集群ID',
  `cluster_name` varchar(255) NOT NULL COMMENT '集群名称',
  `cluster_status` varchar(64) NOT NULL COMMENT '实例状态',
  `main_version` varchar(128) NOT NULL COMMENT 'HBase的主版本信息',
  `ha_type` varchar(32) NOT NULL COMMENT '是否ha集群',
  `master_instance_type` varchar(255) NOT NULL COMMENT 'master节点实例类型',
  `master_disk_type` varchar(255) NOT NULL COMMENT 'master节点磁盘类型',
  `master_disk_size` int(11) NOT NULL COMMENT 'master节点单块磁盘大小',
  `core_instance_type` varchar(255) NOT NULL COMMENT 'Core节点实例类型，ecs机型信息',
  `core_instance_quantity` int(11) NOT NULL COMMENT 'Core节点实例个数',
  `core_disk_type` varchar(255) NOT NULL COMMENT 'Core节点的磁盘类型：cloud，sdd',
  `core_disk_size` int(11) NOT NULL COMMENT 'Core节点的单块磁盘大小',
  `core_disk_quantity` int(11) NOT NULL COMMENT 'Core节点的磁盘块数',
  `pay_type` varchar(64) NOT NULL COMMENT '付费类型：Postpaid：按量付费\\；Prypaid:预付费',
  `auto_renew` smallint(6) DEFAULT '0' COMMENT '0-非自动续费|1-自动续费',
  `net_type` varchar(64) NOT NULL COMMENT 'VPC|Classic',
  `vpc_id` varchar(255) DEFAULT NULL COMMENT 'VPCID',
  `vswitch_id` varchar(255) DEFAULT NULL COMMENT 'VSwitch ID',
  `expire_time` bigint(20) unsigned DEFAULT NULL COMMENT '到期时间',
  `sub_domain` varchar(255) DEFAULT NULL COMMENT '茅台需要的集群',
  `cloud_instance_ip` varchar(255) DEFAULT NULL COMMENT 'vpc ip',
  `end_time` bigint(20) unsigned DEFAULT NULL COMMENT 'end time',
  `is_deleted` smallint(6) DEFAULT '0' COMMENT '0-未删除|1-已删除',
  `lock_mode` varchar(64) DEFAULT NULL COMMENT '集群的锁定模式（欠费、过期）',
  `lock_reason` varchar(1024) DEFAULT NULL COMMENT '集群锁定原因',
  `net_tunnel_type` varchar(127) DEFAULT NULL COMMENT '网络类型通道：ALB_TUNNEL、USER_VPC_TUNNEL',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_cluster_id` (`cluster_id`),
  UNIQUE KEY `uk_ali_uid_cluster_id` (`ali_uid`,`cluster_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='HBase数据库实例表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cluster`
--

LOCK TABLES `cluster` WRITE;
/*!40000 ALTER TABLE `cluster` DISABLE KEYS */;
/*!40000 ALTER TABLE `cluster` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-29 10:12:04

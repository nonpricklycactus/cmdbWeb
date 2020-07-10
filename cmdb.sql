/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.19 : Database - cmdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cmdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cmdb`;

/*Table structure for table `cpuinfo` */

DROP TABLE IF EXISTS `cpuinfo`;

CREATE TABLE `cpuinfo` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键，自动增长',
  `sn` varchar(128) DEFAULT NULL COMMENT 'sn号',
  `sever_id` varchar(12) DEFAULT NULL COMMENT '所属服务器id号（外键）',
  `manufactory` varchar(32) DEFAULT NULL COMMENT '制造商',
  `model` varchar(128) DEFAULT NULL COMMENT 'CPU型号',
  PRIMARY KEY (`id`),
  KEY `cpu_server_key` (`sever_id`),
  CONSTRAINT `cpu_server_key` FOREIGN KEY (`sever_id`) REFERENCES `serverinfo` (`server_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `cpuinfo` */

insert  into `cpuinfo`(`id`,`sn`,`sever_id`,`manufactory`,`model`) values (2,'6SVVSP7673TF','20TZONW6DFXF','123','asda'),(3,'89AYI348P74M','3M2M01MX04P8','Intel','Intel(R) Core(TM) i7-4720HQ CPU @ 2.60GHz'),(4,'OELXO7274DE1','OVV49580KABQ','Intel','Intel(R) Core(TM) i7-4720HQ CPU @ 2.60GHz'),(5,'XVW5J8X56EUM','ZN888HMV1M21','Intel','Intel(R) Core(TM) i7-4720HQ CPU @ 2.60GHz'),(6,'LX711RI64J48','XKTH6Q20TYJY','Intel','Intel(R) Core(TM) i7-4720HQ CPU @ 2.60GHz'),(7,'63YX48059W5O','B760P49U9903','Intel','Intel(R) Core(TM) i7-4720HQ CPU @ 2.60GHz'),(8,'79L67G0J3BK6','8TO45B8SUB18','Intel','Intel(R) Core(TM) i7-4720HQ CPU @ 2.60GHz');

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键，自动增长',
  `depname` varchar(128) NOT NULL COMMENT '部门名称',
  `description` varchar(128) DEFAULT NULL COMMENT '		部门描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`id`,`depname`,`description`) values (1,'运维','负责服务器维护'),(2,'开发','负责软件开发'),(3,'公关','负责公司宣传');

/*Table structure for table `diskinfo` */

DROP TABLE IF EXISTS `diskinfo`;

CREATE TABLE `diskinfo` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键，自动增长',
  `sn` varchar(128) DEFAULT NULL COMMENT 'sn号',
  `sever_id` varchar(12) DEFAULT NULL COMMENT '所属服务器id号（外键）',
  `manufactory` varchar(32) DEFAULT NULL COMMENT '制造商',
  `model` varchar(128) DEFAULT NULL COMMENT '磁盘型号',
  `capacity` varchar(64) DEFAULT NULL COMMENT '磁盘容量',
  `iface_type` varchar(28) DEFAULT NULL COMMENT '接口类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `disk_server_key` (`sever_id`),
  CONSTRAINT `disk_server_key` FOREIGN KEY (`sever_id`) REFERENCES `serverinfo` (`server_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `diskinfo` */

insert  into `diskinfo`(`id`,`sn`,`sever_id`,`manufactory`,`model`,`capacity`,`iface_type`,`create_time`,`update_time`) values (2,'5ZB63G53N92C','ANHU35LM9RFG','sad','adsad','sad','sad','2020-05-12 14:22:58','2020-05-14 14:57:25'),(3,'SZB0Z1NB4ZJ4','20TZONW6DFXF','Western Digital Re','WDC WD4000FYYZ-36UL1B0','19G/1002M','SATA 3.0, 6.0 Gb/s','2020-05-12 15:41:16','2020-05-12 15:41:16'),(4,'F9F8R61OJ96U','3M2M01MX04P8','Western Digital Re','WDC WD4000FYYZ-36UL1B0','19G/1002M','SATA 3.0, 6.0 Gb/s','2020-05-12 15:43:32','2020-05-12 15:43:32'),(5,'78Q9009V3NU7','OVV49580KABQ','Western Digital Re','WDC WD4000FYYZ-36UL1B0','19G/1002M','SATA 3.0, 6.0 Gb/s','2020-05-12 15:46:31','2020-05-12 15:46:31'),(6,'WNC97DDZ0J51','ZN888HMV1M21','Western Digital Re','WDC WD4000FYYZ-36UL1B0','19G/1003M','SATA 3.0, 6.0 Gb/s','2020-05-16 09:49:44','2020-05-16 09:49:44'),(7,'GW5291EU381D','XKTH6Q20TYJY','Western Digital Re','WDC WD4000FYYZ-36UL1B0','19G/1003M','SATA 3.0, 6.0 Gb/s','2020-05-16 09:59:15','2020-05-16 09:59:15'),(8,'N4E3XED885A0','B760P49U9903','Western Digital Re','WDC WD4000FYYZ-36UL1B0','19G/1003M','SATA 3.0, 6.0 Gb/s','2020-05-16 11:06:51','2020-05-16 11:06:51'),(9,'L49CT28W3A10','8TO45B8SUB18','Western Digital Re','WDC WD4000FYYZ-36UL1B0','19G/1003M','SATA 3.0, 6.0 Gb/s','2020-06-06 11:31:18','2020-06-06 11:31:18');

/*Table structure for table `ermfunction` */

DROP TABLE IF EXISTS `ermfunction`;

CREATE TABLE `ermfunction` (
  `functionid` int(12) NOT NULL AUTO_INCREMENT,
  `url` varchar(225) DEFAULT NULL COMMENT '功能菜单',
  PRIMARY KEY (`functionid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `ermfunction` */

insert  into `ermfunction`(`functionid`,`url`) values (14,'/data/navs.json'),(15,'/data/navs02.json');

/*Table structure for table `ermrole` */

DROP TABLE IF EXISTS `ermrole`;

CREATE TABLE `ermrole` (
  `roleid` int(12) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `rolename` varchar(255) NOT NULL COMMENT '权限名',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `ermrole` */

insert  into `ermrole`(`roleid`,`rolename`,`remarks`) values (1,'超级管理员',NULL),(2,'管理员',NULL),(3,'普通用户',NULL);

/*Table structure for table `ermrolefunction` */

DROP TABLE IF EXISTS `ermrolefunction`;

CREATE TABLE `ermrolefunction` (
  `rolefunctionid` int(12) NOT NULL AUTO_INCREMENT,
  `roleid` int(12) DEFAULT NULL COMMENT '权限id',
  `functionid` int(12) DEFAULT NULL COMMENT '功能id',
  PRIMARY KEY (`rolefunctionid`),
  KEY `rolefunction_key` (`roleid`),
  KEY `functionrole_key` (`functionid`),
  CONSTRAINT `functionrole_key` FOREIGN KEY (`functionid`) REFERENCES `ermfunction` (`functionid`),
  CONSTRAINT `rolefunction_key` FOREIGN KEY (`roleid`) REFERENCES `ermrole` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `ermrolefunction` */

insert  into `ermrolefunction`(`rolefunctionid`,`roleid`,`functionid`) values (1,1,14),(2,2,14),(3,3,15);

/*Table structure for table `ermroleuser` */

DROP TABLE IF EXISTS `ermroleuser`;

CREATE TABLE `ermroleuser` (
  `ermroleuserid` int(12) NOT NULL AUTO_INCREMENT,
  `roleid` int(12) DEFAULT NULL,
  `userid` int(12) DEFAULT NULL,
  PRIMARY KEY (`ermroleuserid`),
  KEY `roleuser_key` (`roleid`),
  KEY `userrole_key` (`userid`),
  CONSTRAINT `roleuser_key` FOREIGN KEY (`roleid`) REFERENCES `ermrole` (`roleid`),
  CONSTRAINT `userrole_key` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `ermroleuser` */

insert  into `ermroleuser`(`ermroleuserid`,`roleid`,`userid`) values (1,1,1),(2,2,2),(3,3,3),(4,3,4);

/*Table structure for table `eventlog` */

DROP TABLE IF EXISTS `eventlog`;

CREATE TABLE `eventlog` (
  `uuid` int(12) NOT NULL COMMENT '主键，自动增长',
  `post_data` varchar(128) DEFAULT NULL COMMENT '请求数据',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `detail` varchar(128) DEFAULT NULL COMMENT '		详细描述',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `eventlog` */

/*Table structure for table `maintainence` */

DROP TABLE IF EXISTS `maintainence`;

CREATE TABLE `maintainence` (
  `id` int(12) NOT NULL COMMENT '主键，自动增长',
  `name` varchar(50) DEFAULT NULL COMMENT '事件名称',
  `maintain_type` varchar(50) DEFAULT NULL COMMENT '变更类型',
  `description` varchar(128) DEFAULT NULL COMMENT '事件描述',
  `event_start` datetime DEFAULT NULL COMMENT '事件开始时间',
  `event_end` datetime DEFAULT NULL COMMENT '时间结束时间',
  `applicant` varchar(50) DEFAULT NULL COMMENT '发起人',
  `device_sn` varchar(128) DEFAULT NULL COMMENT '设备SN号，外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `maintainence` */

/*Table structure for table `memoryinfo` */

DROP TABLE IF EXISTS `memoryinfo`;

CREATE TABLE `memoryinfo` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键，自动增长',
  `sn` varchar(128) DEFAULT NULL COMMENT 'sn号',
  `sever_id` varchar(12) DEFAULT NULL COMMENT '所属服务器id号（外键）',
  `manufactory` varchar(32) DEFAULT NULL COMMENT '制造商',
  `model` varchar(128) DEFAULT NULL COMMENT '内存型号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `memory_server_key` (`sever_id`),
  CONSTRAINT `memory_server_key` FOREIGN KEY (`sever_id`) REFERENCES `serverinfo` (`server_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `memoryinfo` */

insert  into `memoryinfo`(`id`,`sn`,`sever_id`,`manufactory`,`model`,`create_time`,`update_time`) values (1,'O9F29FZ4RK26','ANHU35LM9RFG','Kingston','DDR4','2020-05-12 15:09:18','2020-06-06 11:32:18'),(2,'Y213S0YC3TI9','20TZONW6DFXF','Kingston','DDR4','2020-05-12 15:41:16','2020-05-12 15:41:16'),(3,'J854AZ156797','3M2M01MX04P8','Kingston','DDR4','2020-05-12 15:43:32','2020-05-12 15:43:32'),(4,'Y20UDLLI5Y69','OVV49580KABQ','Kingston','DDR4','2020-05-12 15:46:31','2020-05-12 15:46:31'),(5,'92Q10O93K950','ZN888HMV1M21','Kingston','DDR4','2020-05-16 09:49:44','2020-05-16 09:49:44'),(6,'00CIAB9A942T','XKTH6Q20TYJY','Kingston','DDR4','2020-05-16 09:59:15','2020-05-16 09:59:15'),(7,'6HXKAWZMXD12','B760P49U9903','Kingston','DDR4','2020-05-16 11:06:51','2020-05-16 11:06:51'),(8,'2VF2M36825D3','8TO45B8SUB18','Kingston','DDR4','2020-06-06 11:31:18','2020-06-06 11:31:18');

/*Table structure for table `networkinfo` */

DROP TABLE IF EXISTS `networkinfo`;

CREATE TABLE `networkinfo` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `sn` varchar(128) DEFAULT NULL,
  `sever_id` varchar(12) DEFAULT NULL,
  `manufactory` varchar(32) DEFAULT NULL COMMENT '制造商',
  `model` varchar(128) DEFAULT NULL COMMENT '网卡型号',
  `mac_address` varchar(128) DEFAULT NULL COMMENT 'Mac地址',
  PRIMARY KEY (`id`),
  KEY `network_server_key` (`sever_id`),
  CONSTRAINT `network_server_key` FOREIGN KEY (`sever_id`) REFERENCES `serverinfo` (`server_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `networkinfo` */

insert  into `networkinfo`(`id`,`sn`,`sever_id`,`manufactory`,`model`,`mac_address`) values (1,'UE89GG38025R','ANHU35LM9RFG','AMD','Advanced Micro Devices, Inc. [AMD] 79c970 [PCnet32 LANCE] (rev 10)','00:0c:29:36:cd:81'),(2,'094N8M6PXPP6','20TZONW6DFXF','AMD','Advanced Micro Devices, Inc. [AMD] 79c970 [PCnet32 LANCE] (rev 10)','00:0c:29:36:cd:81'),(3,'6NESA3WV9KIM','3M2M01MX04P8','AMD','Advanced Micro Devices, Inc. [AMD] 79c970 [PCnet32 LANCE] (rev 10)','00:0c:29:36:cd:81'),(4,'5942W979683R','OVV49580KABQ','AMD','Advanced Micro Devices, Inc. [AMD] 79c970 [PCnet32 LANCE] (rev 10)','00:0c:29:36:cd:81'),(5,'0X0L7MSSVB6T','ZN888HMV1M21','AMD','Advanced Micro Devices, Inc. [AMD] 79c970 [PCnet32 LANCE] (rev 10)','00:0c:29:36:cd:81'),(6,'8747MY8TJ770','XKTH6Q20TYJY','AMD','Advanced Micro Devices, Inc. [AMD] 79c970 [PCnet32 LANCE] (rev 10)','00:0c:29:36:cd:81'),(7,'U7KE5U2AJ6W9','B760P49U9903','AMD','Advanced Micro Devices, Inc. [AMD] 79c970 [PCnet32 LANCE] (rev 10)','00:0c:29:36:cd:81'),(8,'62P651513241','8TO45B8SUB18','AMD','Advanced Micro Devices, Inc. [AMD] 79c970 [PCnet32 LANCE] (rev 10)','00:0c:29:36:cd:81');

/*Table structure for table `serverinfo` */

DROP TABLE IF EXISTS `serverinfo`;

CREATE TABLE `serverinfo` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键，自动增长',
  `hostname` varchar(50) DEFAULT NULL COMMENT '主机名',
  `server_id` varchar(15) DEFAULT NULL COMMENT '服务器编号',
  `device_type` varchar(64) DEFAULT NULL COMMENT '服务器型号',
  `system_version` varchar(64) DEFAULT NULL COMMENT '系统版本',
  `system_kernel` varchar(64) DEFAULT NULL COMMENT '系统内核',
  `hard_disk` varchar(64) DEFAULT NULL COMMENT '硬盘容量',
  `memory` varchar(30) DEFAULT NULL COMMENT '内存容量',
  `physical_cpu_cores` varchar(64) DEFAULT NULL COMMENT 'CPU内核数',
  `system_ip` varchar(64) DEFAULT NULL COMMENT 'Ip地址',
  `check_time` datetime DEFAULT NULL COMMENT '获取时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `server_id` (`server_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `serverinfo` */

insert  into `serverinfo`(`id`,`hostname`,`server_id`,`device_type`,`system_version`,`system_kernel`,`hard_disk`,`memory`,`physical_cpu_cores`,`system_ip`,`check_time`) values (19,'ubuntu2','ANHU35LM9RFG','Dell Inc. PowerEdge R720','Ubuntu 16.04.1 LTS','Linux ubuntu 4.4.0-31-generic','19G/1002M','1023468 kB','1','192.168.23.0','2020-05-11 18:39:51'),(21,'ubuntu','396L36GX28DI','Dell Inc. PowerEdge R720','Ubuntu 16.04.1 LTS','Linux ubuntu 4.4.0-31-generic','19G/1002M','1023468 kB','1','192.168.23.0','2020-05-11 19:33:45'),(22,'ubuntu','50RGVA5KB64Y','Dell Inc. PowerEdge R720','Ubuntu 16.04.1 LTS','Linux ubuntu 4.4.0-31-generic','19G/1002M','1023468 kB','1','192.168.23.0','2020-05-12 13:58:21'),(23,'ubuntu','20TZONW6DFXF','Dell Inc. PowerEdge R720','Ubuntu 16.04.1 LTS','Linux ubuntu 4.4.0-31-generic','19G/1002M','1023468 kB','1','192.168.23.0','2020-05-12 15:41:13'),(24,'ubuntu','3M2M01MX04P8','Dell Inc. PowerEdge R720','Ubuntu 16.04.1 LTS','Linux ubuntu 4.4.0-31-generic','19G/1002M','1023468 kB','1','192.168.23.0','2020-05-12 15:43:29'),(25,'ubuntu','OVV49580KABQ','Dell Inc. PowerEdge R720','Ubuntu 16.04.1 LTS','Linux ubuntu 4.4.0-31-generic','19G/1002M','1023468 kB','1','192.168.23.0','2020-05-12 15:46:29'),(26,'ubuntu','ZN888HMV1M21','Dell Inc. PowerEdge R720','Ubuntu 16.04.1 LTS','Linux ubuntu 4.4.0-31-generic','19G/1003M','1023468 kB','1','192.168.23.0','2020-05-16 09:49:42'),(27,'ubuntu','XKTH6Q20TYJY','Dell Inc. PowerEdge R720','Ubuntu 16.04.1 LTS','Linux ubuntu 4.4.0-31-generic','19G/1003M','1023468 kB','1','192.168.23.0','2020-05-16 09:59:12'),(28,'ubuntu','B760P49U9903','Dell Inc. PowerEdge R720','Ubuntu 16.04.1 LTS','Linux ubuntu 4.4.0-31-generic','19G/1003M','1023468 kB','1','192.168.23.0','2020-05-16 11:06:48'),(29,'ubuntu','8TO45B8SUB18','Dell Inc. PowerEdge R720','Ubuntu 16.04.1 LTS','Linux ubuntu 4.4.0-31-generic','19G/1003M','1023468 kB','1','192.168.23.0','2020-06-06 11:31:16');

/*Table structure for table `severuser` */

DROP TABLE IF EXISTS `severuser`;

CREATE TABLE `severuser` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键，自动增长',
  `server_id` varchar(12) DEFAULT NULL,
  `user_id` int(12) DEFAULT NULL COMMENT '系统拥有者',
  `user` varchar(128) DEFAULT NULL COMMENT '系统用户名',
  `password` varchar(128) DEFAULT NULL COMMENT '系统密码',
  `ipaddr` varchar(128) DEFAULT NULL COMMENT 'Ip地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `user_key` (`user_id`),
  KEY `user_server_key` (`server_id`),
  CONSTRAINT `user_key` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_server_key` FOREIGN KEY (`server_id`) REFERENCES `serverinfo` (`server_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `severuser` */

insert  into `severuser`(`id`,`server_id`,`user_id`,`user`,`password`,`ipaddr`,`create_time`,`update_time`) values (1,'ANHU35LM9RFG',1,'wxk','123456','192.168.23.0','2020-05-11 18:39:51','2020-05-11 18:39:51'),(4,'396L36GX28DI',1,'wxk','123456','192.168.23.0','2020-05-11 19:33:45','2020-05-11 19:33:45'),(6,'20TZONW6DFXF',1,'wxk','123456','192.168.23.0','2020-05-12 15:41:14','2020-05-12 15:41:14'),(7,'3M2M01MX04P8',1,'wxk','123456','192.168.23.0','2020-05-12 15:43:30','2020-05-12 15:43:30'),(8,'OVV49580KABQ',1,'wxk','123456','192.168.23.0','2020-05-12 15:46:29','2020-05-12 15:46:29'),(9,'ZN888HMV1M21',1,'wxk','123456','192.168.23.0','2020-05-16 09:49:42','2020-05-16 09:49:42'),(10,'XKTH6Q20TYJY',1,'wxk','123456','192.168.23.0','2020-05-16 09:59:12','2020-05-16 09:59:12'),(11,'B760P49U9903',1,'wxk','123456','192.168.23.0','2020-05-16 11:06:48','2020-05-16 11:06:48'),(12,'8TO45B8SUB18',1,'wxk','123456','192.168.23.0','2020-06-06 11:31:16','2020-06-06 11:31:16');

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `data` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `test` */

insert  into `test`(`id`,`name`,`password`,`data`) values (1,'asd','125354','2020-03-17 20:14:04'),(2,'qwe','123456','2020-03-12 20:14:08'),(3,'wxk66','wdadads',NULL),(4,'wxk66','wdadads',NULL),(5,'wxk66','wdadads',NULL),(6,'wxk66','wdadads',NULL),(7,'admin','abc123456',NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键，自动增长',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(128) NOT NULL COMMENT '用户密码',
  `realname` varchar(32) NOT NULL COMMENT '真实姓名',
  `depart_id` int(32) NOT NULL COMMENT '所属部门(外键)',
  `phone` varchar(32) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(128) DEFAULT NULL COMMENT '电子邮箱',
  PRIMARY KEY (`id`),
  KEY `user_depart_key` (`depart_id`),
  CONSTRAINT `user_depart_key` FOREIGN KEY (`depart_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`realname`,`depart_id`,`phone`,`email`) values (1,'admin','123456','张三',1,'11112222333','25514548@test.com'),(2,'admin02','123456','李四',2,'11112222333','25514548@test.com'),(3,'sadas','123456','张世伟',3,'11112222333','25514548@test.com'),(4,'asda','123456','张三',1,'11112222333','25514548@test.com'),(5,'liubei','123456','傅明',2,'11112222333','c.umpt@pcmdqwujq.at');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

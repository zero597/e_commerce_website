/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 8.0.13 : Database - b2bgoods
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`b2bgoods` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `b2bgoods`;

/*Table structure for table `cart` */

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
  `id` int(11) NOT NULL COMMENT '主键',
  `goodsname` varbinary(255) NOT NULL COMMENT '商品名称',
  `number` int(11) NOT NULL COMMENT '数量',
  `price` int(11) NOT NULL COMMENT '商品单价',
  `goodid` int(11) NOT NULL COMMENT '商品id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`),
  KEY `goodid` (`goodid`),
  KEY `uid` (`uid`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`goodid`) REFERENCES `goods` (`gid`),
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `b2bdata`.`user` (`uaccount`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cart` */

insert  into `cart`(`id`,`goodsname`,`number`,`price`,`goodid`,`uid`) values (1,'牛奶',2,50,1,1);

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `gid` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品主键',
  `gname` varbinary(255) NOT NULL COMMENT '商品名称',
  `gremain` varbinary(255) NOT NULL COMMENT '商品图片',
  `gdetails` varbinary(255) NOT NULL COMMENT '商品介绍',
  `gprice` int(11) NOT NULL COMMENT '商品价格',
  `types` int(11) NOT NULL COMMENT '商品类别',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`gid`,`gname`,`gremain`,`gdetails`,`gprice`,`types`) values (1,'牛奶','http:jijijij','这是一款牛奶',25,1);

/*Table structure for table `userorder` */

DROP TABLE IF EXISTS `userorder`;

CREATE TABLE `userorder` (
  `gid` int(11) NOT NULL COMMENT '商品id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  `goodsname` varbinary(255) NOT NULL COMMENT '商品数量',
  `number` int(11) NOT NULL COMMENT '购买数量',
  `price` int(11) NOT NULL COMMENT '总价',
  `time` datetime DEFAULT NULL COMMENT '购买时间',
  PRIMARY KEY (`gid`),
  KEY `uid` (`uid`),
  CONSTRAINT `userorder_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `b2bdata`.`user` (`uaccount`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `userorder` */

insert  into `userorder`(`gid`,`uid`,`goodsname`,`number`,`price`,`time`) values (1,1,'牛奶',2,50,'2023-06-14 08:55:03');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

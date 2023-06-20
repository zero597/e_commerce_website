/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.33 : Database - b2bgoods
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`b2bgoods` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `b2bgoods`;

/*Table structure for table `cart` */

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goodsname` varbinary(255) NOT NULL COMMENT '商品名称',
  `number` int NOT NULL COMMENT '数量',
  `price` int NOT NULL COMMENT '商品单价',
  `goodid` int NOT NULL COMMENT '商品id',
  `uid` int NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`),
  KEY `goodid` (`goodid`),
  KEY `uid` (`uid`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`goodid`) REFERENCES `goods` (`gid`),
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `b2bdata`.`user` (`uaccount`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;

/*Data for the table `cart` */

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `gid` int NOT NULL AUTO_INCREMENT COMMENT '商品主键',
  `gname` varbinary(255) NOT NULL COMMENT '商品名称',
  `gremain` varbinary(255) NOT NULL COMMENT '商品图片',
  `gdetails` varbinary(255) NOT NULL COMMENT '商品介绍',
  `gprice` int NOT NULL COMMENT '商品价格',
  `types` int NOT NULL COMMENT '商品类别',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;

/*Data for the table `goods` */

insert  into `goods`(`gid`,`gname`,`gremain`,`gdetails`,`gprice`,`types`) values (1,'草莓','http://localhost:8896/img/goods/goods003.jpg','可口草莓',4,0),(2,'苹果','http://localhost:8896/img/2.jpg','红富士苹果',2,0),(3,'橙子','http://localhost:8896/img/goods/goods001.jpg','金黄的大橙子',4,0),(4,'葡萄','http://localhost:8896/img/goods/goods002.jpg','吐鲁番葡萄',12,0),(5,'大虾','http://localhost:8896/img/goods/goods018.jpg','山东大虾',5,2),(6,'带鱼','http://localhost:8896/img/goods/goods020.jpg','好吃的带鱼',50,2),(7,'扇贝','http://localhost:8896/img/goods/goods019.jpg','大神快来快来',20,2),(8,'皮皮虾','http://localhost:8896/img/goods/goods021.jpg','啥的客户',10,2),(9,'脉动','http://localhost:8896/img/goods/maidong.png','不在状态，脉动一下',4,1),(10,'汽水','http://localhost:8896/img/goods/qishui.png','栓双',8,1),(11,'沙棘汁','http://localhost:8896/img/goods/shajizhi.png','好喝',3,1),(12,'和其正','http://localhost:8896/img/goods/heqizheng.png','dsa asd',5,1),(13,'菠菜','http://localhost:8896/img/goods/bocai.png','大',2,3),(14,'生菜','http://localhost:8896/img/goods/shengcai.png','asdajlskdja',2,3),(15,'番茄','http://localhost:8896/img/goods/fanqie.png','好吃',1,3),(16,'胡萝卜','http://localhost:8896/img/goods/huluobo.png','asdkjlajkld',2,3);

/*Table structure for table `userorder` */

DROP TABLE IF EXISTS `userorder`;

CREATE TABLE `userorder` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `uid` int NOT NULL COMMENT '用户id',
  `goodsname` varbinary(255) NOT NULL COMMENT '商品数量',
  `number` int NOT NULL COMMENT '购买数量',
  `price` int NOT NULL COMMENT '总价',
  `time` datetime DEFAULT NULL COMMENT '购买时间',
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `userorder_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `b2bdata`.`user` (`uaccount`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

/*Data for the table `userorder` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

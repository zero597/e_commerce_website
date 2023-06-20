/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.33 : Database - b2bdata
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`b2bdata` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `b2bdata`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uaccount` int NOT NULL AUTO_INCREMENT COMMENT '用户账号',
  `upassword` varbinary(20) NOT NULL COMMENT '用户密码',
  `uname` varbinary(20) NOT NULL COMMENT '用户姓名',
  `usex` varbinary(10) NOT NULL COMMENT '性别',
  PRIMARY KEY (`uaccount`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

/*Data for the table `user` */

insert  into `user`(`uaccount`,`upassword`,`uname`,`usex`) values (1,'123456','TOM','男'),(2,'123','lin','男'),(3,'111','test','男'),(4,'1111','lina','男'),(5,'1111','aaa','男');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

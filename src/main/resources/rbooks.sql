/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-09-04 12:12:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for rbooks
-- ----------------------------
DROP TABLE IF EXISTS `rbooks`;
CREATE TABLE `rbooks` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(300) NOT NULL,
  `author` varchar(15) DEFAULT NULL,
  `datepicker` varchar(10) DEFAULT NULL,
  `average` varchar(10) DEFAULT NULL,
  `price` varchar(100) DEFAULT NULL,
  `attention` int(11) DEFAULT '1',
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rbooks
-- ----------------------------
INSERT INTO `rbooks` VALUES ('1', 'JAVA编程', '法瑞尔', '2012-1', '0.0', '99.00元', '2');
INSERT INTO `rbooks` VALUES ('2', 'Java编程思想', '美] Bruce Eckel', '2005-9', '9.0', '	95.00元', '4');
INSERT INTO `rbooks` VALUES ('3', '武生院', '代购网', '2018-2', '0.3', '59', '2');
INSERT INTO `rbooks` VALUES ('4', '武生院', '代购网', '2018-2', '0.3', '59', '1');
INSERT INTO `rbooks` VALUES ('5', '精美甜品/新派菜谱系列', '丫 丫,老笋', '08/08/2017', '0.0', '6.00', '2');
INSERT INTO `rbooks` VALUES ('6', '丫头儿', '赵赵', '08/16/2017', '7.5', '36.00元', '6');
INSERT INTO `rbooks` VALUES ('7', '武侠，从牛A到牛C', '大脸撑在小胸上(李汀)', '12/10/2014', '8.3', '29.80', '1');
INSERT INTO `rbooks` VALUES ('8', '女奴之盟城风云', '林政', '08/28/2017', '7.2', '24.0', '5');
INSERT INTO `rbooks` VALUES ('9', 'Python源码剖析', '陈儒', '08/28/2017', '7.9', '69.00', '1');
INSERT INTO `rbooks` VALUES ('11', '丫山传奇', '卡伦·卡茨', '08/02/2017', '', '', '1');
INSERT INTO `rbooks` VALUES ('12', '非常小公主', '意)马西尼', '08/01/2017', '', '', '2');
INSERT INTO `rbooks` VALUES ('13', '鼻子耳朵小脚丫-亲爱的宝宝绘本', '卡伦·卡茨', '08/09/2017', '', '', '2');
INSERT INTO `rbooks` VALUES ('14', 'Effective Modern C++', 'Scott Meyers', '09/06/2017', '9.3', 'USD 49.99', '8');
INSERT INTO `rbooks` VALUES ('15', 'JAVA并发编程实践', '戈茨', '09/03/2017', '8.8', '58元', '7');
INSERT INTO `rbooks` VALUES ('16', 'Peter Van Der Linden', '戈茨', '09/03/2017', '9.1', '54元', '1');

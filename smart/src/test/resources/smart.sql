/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : smart

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2017-09-20 15:39:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');

-- ----------------------------
-- Table structure for sssp_department
-- ----------------------------
DROP TABLE IF EXISTS `sssp_department`;
CREATE TABLE `sssp_department` (
  `id` int(11) NOT NULL,
  `departmentName` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sssp_department
-- ----------------------------
INSERT INTO `sssp_department` VALUES ('1', '部门1');
INSERT INTO `sssp_department` VALUES ('2', '部门2');
INSERT INTO `sssp_department` VALUES ('3', '部门3');

-- ----------------------------
-- Table structure for sssp_empoyee
-- ----------------------------
DROP TABLE IF EXISTS `sssp_empoyee`;
CREATE TABLE `sssp_empoyee` (
  `id` int(11) NOT NULL,
  `birth` date DEFAULT NULL,
  `crateTime` datetime DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `lastName` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Department_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtcwr5ppwc53d69rygy3up16b4` (`Department_ID`),
  CONSTRAINT `FKtcwr5ppwc53d69rygy3up16b4` FOREIGN KEY (`Department_ID`) REFERENCES `sssp_department` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sssp_empoyee
-- ----------------------------
INSERT INTO `sssp_empoyee` VALUES ('1', '2017-09-19', '2017-09-19 08:38:53', '111@qq.com', '李雷', '1');
INSERT INTO `sssp_empoyee` VALUES ('2', '2017-09-01', '2017-09-19 08:41:38', '222@qq.com', '韩梅梅', '1');
INSERT INTO `sssp_empoyee` VALUES ('3', '2017-06-01', '2017-09-19 08:42:11', '333@qq.com', '李秋水', '2');
INSERT INTO `sssp_empoyee` VALUES ('4', '2017-06-01', '2017-09-19 08:43:32', '444@qq.com', '吴莫愁', '1');
INSERT INTO `sssp_empoyee` VALUES ('5', '2017-09-20', '2017-09-20 10:06:32', '555@qq.com', '李明', '1');

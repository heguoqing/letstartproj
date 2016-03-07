/*
Navicat MySQL Data Transfer

Source Server         : finestay204
Source Server Version : 50173
Source Host           : 10.0.0.204:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2016-03-07 17:49:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for c3p0testtable
-- ----------------------------
DROP TABLE IF EXISTS `c3p0testtable`;
CREATE TABLE `c3p0testtable` (
  `num` varchar(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_wx_template_msg_to
-- ----------------------------
DROP TABLE IF EXISTS `tbl_wx_template_msg_to`;
CREATE TABLE `tbl_wx_template_msg_to` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `open_id` varchar(50) NOT NULL COMMENT '微信关注ID',
  `Name` varchar(50) DEFAULT NULL COMMENT '微信名字',
  `status` varchar(4000) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='微信模板消息的接受人';

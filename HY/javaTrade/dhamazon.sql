/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : dhamazon

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2024-05-13 13:30:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `adminuser_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `login_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `createby` varchar(100) DEFAULT NULL,
  `update_time` timestamp(6) NULL DEFAULT NULL,
  `updateby` varchar(100) DEFAULT NULL,
  `lastlogin_time` timestamp(6) NULL DEFAULT NULL,
  `create_time` timestamp(6) NULL DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `status_desc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`adminuser_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `goods_id` char(32) NOT NULL,
  `goods_name` varchar(100) NOT NULL,
  `goods_category` varchar(50) NOT NULL,
  `purchase_price` decimal(10,2) NOT NULL,
  `selling_price` decimal(10,2) NOT NULL,
  `stock_quantity` decimal(10,2) NOT NULL DEFAULT '0.00',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods
-- ----------------------------

-- ----------------------------
-- Table structure for t_goods_in
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_in`;
CREATE TABLE `t_goods_in` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `goods_id` char(32) NOT NULL,
  `goods_name` varchar(100) NOT NULL,
  `in_quantity` decimal(10,2) NOT NULL,
  `in_price` decimal(10,2) NOT NULL,
  `in_time` datetime NOT NULL,
  `supplier_id` char(32) NOT NULL,
  `supplier_name` varchar(100) NOT NULL,
  `warehouse_id` char(32) NOT NULL,
  `warehouse_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `goods_id` (`goods_id`),
  KEY `supplier_id` (`supplier_id`),
  KEY `warehouse_id` (`warehouse_id`),
  CONSTRAINT `t_goods_in_ibfk_1` FOREIGN KEY (`goods_id`) REFERENCES `t_goods` (`goods_id`),
  CONSTRAINT `t_goods_in_ibfk_2` FOREIGN KEY (`supplier_id`) REFERENCES `t_supplier` (`supplier_id`),
  CONSTRAINT `t_goods_in_ibfk_3` FOREIGN KEY (`warehouse_id`) REFERENCES `t_warehouse` (`warehouse_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods_in
-- ----------------------------

-- ----------------------------
-- Table structure for t_purchaser
-- ----------------------------
DROP TABLE IF EXISTS `t_purchaser`;
CREATE TABLE `t_purchaser` (
  `purchaser_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `purchaser_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `purchaser_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `purchaser_desc` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `loginname` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `telephone` varchar(100) DEFAULT NULL,
  `zip` varchar(20) DEFAULT NULL,
  `addr` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  PRIMARY KEY (`purchaser_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_purchaser
-- ----------------------------

-- ----------------------------
-- Table structure for t_sales
-- ----------------------------
DROP TABLE IF EXISTS `t_sales`;
CREATE TABLE `t_sales` (
  `sales_id` bigint NOT NULL AUTO_INCREMENT,
  `goods_id` char(32) NOT NULL,
  `goods_name` varchar(100) NOT NULL,
  `purchase_quantity` decimal(10,2) NOT NULL,
  `purchase_price` decimal(10,2) NOT NULL,
  `purchase_time` date NOT NULL,
  `purchaser_id` char(32) NOT NULL,
  `purchaser_name` varchar(100) NOT NULL,
  `refund_status` tinyint NOT NULL DEFAULT '0' COMMENT '0-未退货, 1-已退货',
  PRIMARY KEY (`sales_id`),
  KEY `goods_id` (`goods_id`),
  KEY `purchaser_id` (`purchaser_id`),
  CONSTRAINT `t_sales_ibfk_1` FOREIGN KEY (`goods_id`) REFERENCES `t_goods` (`goods_id`),
  CONSTRAINT `t_sales_ibfk_2` FOREIGN KEY (`purchaser_id`) REFERENCES `t_purchaser` (`purchaser_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sales
-- ----------------------------

-- ----------------------------
-- Table structure for t_supplier
-- ----------------------------
DROP TABLE IF EXISTS `t_supplier`;
CREATE TABLE `t_supplier` (
  `supplier_id` char(32) NOT NULL,
  `supplier_no` varchar(20) DEFAULT NULL,
  `supplier_name` varchar(100) DEFAULT NULL,
  `supplier_desc` varchar(500) DEFAULT NULL,
  `login_name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `telephone` varchar(100) DEFAULT NULL,
  `zip` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_supplier
-- ----------------------------

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `admin_id` char(32) NOT NULL,
  `admin_name` varchar(20) DEFAULT NULL,
  `login_name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `create_by` varchar(100) DEFAULT NULL,
  `update_time` timestamp(6) NULL DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `last_login_time` timestamp(6) NULL DEFAULT NULL,
  `create_time` timestamp(6) NULL DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `status_desc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_users
-- ----------------------------

-- ----------------------------
-- Table structure for t_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `t_warehouse`;
CREATE TABLE `t_warehouse` (
  `warehouse_id` char(32) NOT NULL,
  `warehouse_name` varchar(100) NOT NULL,
  `warehouse_location` varchar(200) NOT NULL,
  `total_capacity` decimal(10,2) NOT NULL,
  `available_capacity` decimal(10,2) NOT NULL,
  `goods_id` varchar(1000) DEFAULT NULL,
  `goods_quantity` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`warehouse_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_warehouse
-- ----------------------------

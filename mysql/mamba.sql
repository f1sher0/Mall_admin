/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : mamba

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2024-05-19 15:52:24
*/

create database mamba;
use mamba;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsId` int NOT NULL AUTO_INCREMENT COMMENT '商品的唯一标识',
  `goodsName` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '商品的名称',
  `goodsCategory` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '商品所属的分类',
  `purchasePrice` decimal(10,2) NOT NULL COMMENT '商品的进货价格',
  `sellingPrice` decimal(10,2) NOT NULL COMMENT '商品的销售价格',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '商品创建的时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '商品最后一次更新的时间',
  PRIMARY KEY (`goodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品信息';

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', 'Apple iPhone 13', 'Electronics', '699.00', '999.00', '2024-05-19 15:46:44', '2024-05-19 15:46:44');
INSERT INTO `goods` VALUES ('2', 'Samsung Galaxy S21', 'Electronics', '649.00', '899.00', '2024-05-19 15:46:44', '2024-05-19 15:46:44');
INSERT INTO `goods` VALUES ('3', 'Sony WH-1000XM4', 'Accessories', '279.00', '349.00', '2024-05-19 15:46:44', '2024-05-19 15:46:44');

-- ----------------------------
-- Table structure for goodsin
-- ----------------------------
DROP TABLE IF EXISTS `goodsin`;
CREATE TABLE `goodsin` (
  `goodsInId` int NOT NULL AUTO_INCREMENT COMMENT '入库单的唯一标识',
  `goodsInNo` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '入库单的编号',
  `supplierId` int NOT NULL COMMENT '供应商的ID',
  `supplierName` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '供应商的名称',
  `goodsPrice` decimal(10,2) NOT NULL COMMENT '入库商品的单价',
  `goodsAmount` decimal(10,2) NOT NULL COMMENT '入库商品的总金额',
  `goodsInTime` datetime NOT NULL COMMENT '商品入库的时间',
  `warehouseId` int NOT NULL COMMENT '入库商品所在的仓库ID',
  `warehouseName` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '入库商品所在的仓库名称',
  `operatorId` int NOT NULL COMMENT '执行入库操作的用户ID',
  `operatorName` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '执行入库操作的用户名称',
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '入库单的备注信息',
  PRIMARY KEY (`goodsInId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品入库';

-- ----------------------------
-- Records of goodsin
-- ----------------------------
INSERT INTO `goodsin` VALUES ('1', 'IN001', '1', 'Tech Distributors Inc.', '699.00', '34950.00', '2024-05-18 10:00:00', '1', 'Central Warehouse', '1', 'admin', 'Initial stock');
INSERT INTO `goodsin` VALUES ('2', 'IN002', '2', 'Gadget World', '279.00', '5580.00', '2024-05-18 11:00:00', '2', 'East Warehouse', '2', 'manager', 'Restock');

-- ----------------------------
-- Table structure for goodsout
-- ----------------------------
DROP TABLE IF EXISTS `goodsout`;
CREATE TABLE `goodsout` (
  `salesId` int NOT NULL AUTO_INCREMENT COMMENT '销售单的唯一标识',
  `salesNo` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '销售单的编号',
  `purchaserId` int NOT NULL COMMENT '采购商的ID',
  `purchaserName` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '采购商的名称',
  `goodsPrice` decimal(10,2) NOT NULL COMMENT '销售商品的单价',
  `goodsAmount` decimal(10,2) NOT NULL COMMENT '销售商品的总金额',
  `salesTime` datetime NOT NULL COMMENT '商品销售的时间',
  `warehouseId` int NOT NULL COMMENT '销售商品出库的仓库ID',
  `warehouseName` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '销售商品出库的仓库名称',
  `operatorId` int NOT NULL COMMENT '执行销售操作的用户ID',
  `operatorName` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '执行销售操作的用户名称',
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '销售单的备注信息',
  PRIMARY KEY (`salesId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='销售';

-- ----------------------------
-- Records of goodsout
-- ----------------------------
INSERT INTO `goodsout` VALUES ('1', 'OUT001', '1', 'Best Buy', '999.00', '29970.00', '2024-05-19 09:00:00', '1', 'Central Warehouse', '1', 'admin', 'First sale');
INSERT INTO `goodsout` VALUES ('2', 'OUT002', '2', 'Electro Mart', '349.00', '6980.00', '2024-05-19 10:00:00', '2', 'East Warehouse', '2', 'manager', 'Special order');

-- ----------------------------
-- Table structure for inlistgoods
-- ----------------------------
DROP TABLE IF EXISTS `inlistgoods`;
CREATE TABLE `inlistgoods` (
  `inListGoodsId` int NOT NULL AUTO_INCREMENT COMMENT '入库单商品的唯一标识',
  `goodsInId` int NOT NULL COMMENT '入库单的唯一标识',
  `goodsId` int NOT NULL COMMENT '入库商品的ID',
  PRIMARY KEY (`inListGoodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='入库单_商品';

-- ----------------------------
-- Records of inlistgoods
-- ----------------------------
INSERT INTO `inlistgoods` VALUES ('1', '1', '1');
INSERT INTO `inlistgoods` VALUES ('2', '1', '2');
INSERT INTO `inlistgoods` VALUES ('3', '2', '3');

-- ----------------------------
-- Table structure for purchaser
-- ----------------------------
DROP TABLE IF EXISTS `purchaser`;
CREATE TABLE `purchaser` (
  `purchaserId` int NOT NULL AUTO_INCREMENT COMMENT '采购商的唯一标识',
  `purchaserNo` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '采购商的编号',
  `purchaserName` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '采购商的名称',
  `purchaserDesc` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '采购商的描述信息',
  `loginName` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '采购商的登录名',
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '采购商的登录密码',
  `telephone` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '采购商的联系电话',
  `zip` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '采购商的邮编',
  `address` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '采购商的地址',
  `email` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '采购商的邮箱',
  `status` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '采购商的状态',
  `avatar` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '采购商的头像',
  PRIMARY KEY (`purchaserId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='采购商信息';

-- ----------------------------
-- Records of purchaser
-- ----------------------------
INSERT INTO `purchaser` VALUES ('1', 'PUR001', 'Best Buy', 'Retail chain for electronics', 'bestbuy', 'password123', '321-654-9870', '10003', '789 Retail Road', 'contact@bestbuy.com', 'A', 'purchaser1.jpg');
INSERT INTO `purchaser` VALUES ('2', 'PUR002', 'Electro Mart', 'Electronics and accessories retailer', 'electromart', 'password123', '654-321-0987', '10004', '321 Electro Street', 'info@electromart.com', 'A', 'purchaser2.jpg');

-- ----------------------------
-- Table structure for saleslistgoods
-- ----------------------------
DROP TABLE IF EXISTS `saleslistgoods`;
CREATE TABLE `saleslistgoods` (
  `salesListGoodsId` int NOT NULL AUTO_INCREMENT COMMENT '销售单商品的唯一标识',
  `salesId` int NOT NULL COMMENT '销售单的唯一标识',
  `goodsId` int NOT NULL COMMENT '销售商品的ID',
  PRIMARY KEY (`salesListGoodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='销售单_商品';

-- ----------------------------
-- Records of saleslistgoods
-- ----------------------------
INSERT INTO `saleslistgoods` VALUES ('1', '1', '1');
INSERT INTO `saleslistgoods` VALUES ('2', '1', '2');
INSERT INTO `saleslistgoods` VALUES ('3', '2', '3');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `supplierId` int NOT NULL AUTO_INCREMENT COMMENT '供应商的唯一标识',
  `supplierNo` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '供应商的编号',
  `supplierName` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '供应商的名称',
  `supplierDesc` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '供应商的描述信息',
  `loginName` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '供应商的登录名',
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '供应商的登录密码',
  `telephone` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '供应商的联系电话',
  `zip` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '供应商的邮编',
  `address` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '供应商的地址',
  `email` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '供应商的邮箱',
  `status` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '供应商的状态',
  `avatar` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '供应商的头像',
  PRIMARY KEY (`supplierId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='供应商信息';

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('1', 'SUP001', 'Tech Distributors Inc.', 'Leading supplier of electronic gadgets', 'techdistributor', 'password123', '123-456-7890', '10001', '123 Tech Street', 'contact@techdistributors.com', 'A', 'supplier1.jpg');
INSERT INTO `supplier` VALUES ('2', 'SUP002', 'Gadget World', 'Wholesale supplier of electronic accessories', 'gadgetworld', 'password123', '987-654-3210', '10002', '456 Gadget Avenue', 'info@gadgetworld.com', 'A', 'supplier2.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int NOT NULL AUTO_INCREMENT COMMENT '用户的唯一标识',
  `username` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '用户的登录名',
  `password` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '用户的登录密码',
  `gender` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '用户的性别',
  `age` int DEFAULT NULL COMMENT '用户的年龄',
  `phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '用户的联系电话',
  `email` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '用户的邮箱',
  `role` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '用户的角色',
  `status` char(1) COLLATE utf8_bin NOT NULL COMMENT '用户的状态',
  `avatar` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户的头像',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户创建的时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '用户最后一次更新的时间',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin123', 'M', '35', '123-456-7890', 'admin@example.com', 'Administrator', 'A', 'admin.jpg', '2024-05-19 15:47:20', '2024-05-19 15:47:20');
INSERT INTO `user` VALUES ('2', 'manager', 'manager123', 'F', '30', '098-765-4321', 'manager@example.com', 'Manager', 'A', 'manager.jpg', '2024-05-19 15:47:20', '2024-05-19 15:47:20');

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse` (
  `warehouseId` int NOT NULL AUTO_INCREMENT COMMENT '仓库的唯一标识',
  `warehouseName` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '仓库的名称',
  `warehouseLocation` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '仓库的具体位置',
  `totalCapacity` decimal(10,2) NOT NULL COMMENT '仓库的总容量',
  `availableCapacity` decimal(10,2) NOT NULL COMMENT '仓库当前的可用容量',
  PRIMARY KEY (`warehouseId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='第三方仓库信息';

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES ('1', 'Central Warehouse', '123 Warehouse Lane', '1000.00', '800.00');
INSERT INTO `warehouse` VALUES ('2', 'East Warehouse', '456 Storage Avenue', '500.00', '300.00');

-- ----------------------------
-- Table structure for warehousegoods
-- ----------------------------
DROP TABLE IF EXISTS `warehousegoods`;
CREATE TABLE `warehousegoods` (
  `warehouseGoodsId` int NOT NULL AUTO_INCREMENT COMMENT '仓库商品信息的唯一标识',
  `warehouseId` int NOT NULL COMMENT '仓库的唯一标识',
  `goodsId` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '仓库中存储的商品ID，以逗号分隔',
  `goodsQuantity` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '仓库中存储的商品数量，以逗号分隔，与goodsId一一对应',
  PRIMARY KEY (`warehouseGoodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='仓库商品信息';

-- ----------------------------
-- Records of warehousegoods
-- ----------------------------
INSERT INTO `warehousegoods` VALUES ('1', '1', '1,2', '50,30');
INSERT INTO `warehousegoods` VALUES ('2', '2', '3', '20');

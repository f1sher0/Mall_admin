/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : mamba

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2024-05-25 17:45:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `announcementId` int NOT NULL AUTO_INCREMENT COMMENT '公告的唯一标识',
  `title` varchar(100) NOT NULL COMMENT '公告标题',
  `content` text NOT NULL COMMENT '公告内容',
  `publisherEmail` varchar(100) NOT NULL COMMENT '发布者的邮箱',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '公告创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '公告更新时间',
  PRIMARY KEY (`announcementId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='公告信息表';

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES ('2', '新商品上架', '我们上架了新的电子产品和家居用品，欢迎选购！', 'admin@example.com', '2024-05-23 15:58:11', '2024-05-23 15:58:11');
INSERT INTO `announcement` VALUES ('3', '促销活动', '本周末全场8折优惠，快来抢购吧！', 'admin@example.com', '2024-05-23 15:58:11', '2024-05-23 15:58:11');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsId` int NOT NULL AUTO_INCREMENT COMMENT '商品的唯一标识',
  `goodsName` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '商品的名称',
  `goodsCategory` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '商品所属的分类',
  `purchasePrice` decimal(10,2) NOT NULL COMMENT '商品的进货价格',
  `sellingPrice` decimal(10,2) NOT NULL COMMENT '商品的销售价格',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '商品创建的时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '商品最后一次更新的时间',
  `onShelf` int DEFAULT NULL,
  PRIMARY KEY (`goodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品信息';

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '华为笔记本电脑', '电子产品', '5000.00', '6000.00', '2024-05-23 15:57:42', '2024-05-25 17:35:07', '0');
INSERT INTO `goods` VALUES ('2', '宜家沙发', '家居用品', '1500.00', '2000.00', '2024-05-23 15:57:42', '2024-05-25 17:32:55', '1');
INSERT INTO `goods` VALUES ('3', 'temp', 'temp', '22.00', '333.00', '2024-05-17 17:34:51', '2024-05-25 17:34:56', '1');

-- ----------------------------
-- Table structure for goodsin
-- ----------------------------
DROP TABLE IF EXISTS `goodsin`;
CREATE TABLE `goodsin` (
  `goodsInId` int NOT NULL AUTO_INCREMENT COMMENT '入库单的唯一标识',
<<<<<<< HEAD
  `goodsInNo` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '入库单的编号,可以含有多个商品的id,以逗号分隔',
  `supplierId` int NOT NULL COMMENT '供应商的ID',
  `supplierName` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '供应商的名称',
  `goodsPrice` decimal(10,2) NOT NULL COMMENT '入库商品的单价',
=======
  `goodsInNo` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '入库单的编号,可以含有多个商品的id,以逗号分隔,获取后三位字符为数字id',
  `goodsName` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '商品名称,与商品编号对应,以逗号分隔',
  `goodsCategory` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '商品分类,与商品编号对应,以逗号分隔',
  `supplierId` int NOT NULL COMMENT '供应商的ID',
  `supplierName` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '供应商的名称',
  `goodsPrice` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '入库商品的单价,以逗号分隔,与商品编号对应',
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
  `goodsAmount` decimal(10,2) NOT NULL COMMENT '入库商品的总金额',
  `goodsInTime` datetime NOT NULL COMMENT '商品入库的时间',
  `warehouseId` int NOT NULL COMMENT '入库商品所在的仓库ID',
  `warehouseName` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '入库商品所在的仓库名称',
  `operatorId` int NOT NULL COMMENT '执行入库操作的用户ID',
  `operatorName` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '执行入库操作的用户名称',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '入库单的备注信息',
<<<<<<< HEAD
=======
 
 

>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
  PRIMARY KEY (`goodsInId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品入库';

-- ----------------------------
-- Records of goodsin
-- ----------------------------
<<<<<<< HEAD
INSERT INTO `goodsin` VALUES ('1', 'GIN001,GIN003', '1', '华纳电子信息公司', '5000.00', '50000.00', '2024-05-23 10:00:00', '1', '北京仓库', '1', '操作员张三', '首次入库');
INSERT INTO `goodsin` VALUES ('2', 'GIN002', '2', '京东惊喜公司', '1500.00', '15000.00', '2024-05-23 11:00:00', '2', '上海仓库', '2', '操作员李四', '首次入库');

=======
 
INSERT INTO `goodsin` VALUES ('1', 'GIN001,GIN003', '商品A,商品C', '分类1,分类3', '1', '华纳电子信息公司', '5000.00,8000.00', '50000.00', '2024-05-23 10:00:00', '1', '北京仓库', '1', '操作员张三', '首次入库');
INSERT INTO `goodsin` VALUES ('2', 'GIN002', '商品B', '分类2', '2', '京东惊喜公司', '1500.00', '15000.00', '2024-05-23 11:00:00', '2', '上海仓库', '2', '操作员李四', '首次入库');


 
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
-- ----------------------------
-- Table structure for goodsout
-- ----------------------------
DROP TABLE IF EXISTS `goodsout`;
CREATE TABLE `goodsout` (
  `salesId` int NOT NULL AUTO_INCREMENT COMMENT '销售单的唯一标识',
<<<<<<< HEAD
  `salesNo` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '销售单的编号,可以含有多个商品的id,以逗号分隔',
=======
  `salesNo` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '销售单的编号,可以含有多个商品的id,以逗号分隔,获取后三位字符为数字id',
>>>>>>> dbc29ad74aa4d65a220d8274d782e4bcbe358f3a
  `purchaserId` int NOT NULL COMMENT '采购商的ID',
  `purchaserName` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '采购商的名称',
  `goodsPrice` decimal(10,2) NOT NULL COMMENT '销售商品的单价',
  `goodsAmount` decimal(10,2) NOT NULL COMMENT '销售商品的总金额',
  `salesTime` datetime NOT NULL COMMENT '商品销售的时间',
  `warehouseId` int NOT NULL COMMENT '销售商品出库的仓库ID',
  `warehouseName` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '销售商品出库的仓库名称',
  `operatorId` int NOT NULL COMMENT '执行销售操作的用户ID',
  `operatorName` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '执行销售操作的用户名称',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '销售单的备注信息',
  PRIMARY KEY (`salesId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='销售';

-- ----------------------------
-- Records of goodsout
-- ----------------------------
INSERT INTO `goodsout` VALUES ('3', 'SOUT001', '1', '家乐福采购部', '6000.00', '60000.00', '2024-05-23 12:00:00', '1', '北京仓库', '1', '操作员张三', '首次销售');
INSERT INTO `goodsout` VALUES ('4', 'SOUT002', '2', '沃尔玛采购部', '2000.00', '20000.00', '2024-05-23 13:00:00', '2', '上海仓库', '2', '操作员李四', '首次销售');

-- ----------------------------
-- Table structure for inlistgoods
-- ----------------------------
DROP TABLE IF EXISTS `inlistgoods`;
CREATE TABLE `inlistgoods` (
  `inListGoodsId` int NOT NULL AUTO_INCREMENT COMMENT '入库单商品的唯一标识',
  `goodsInId` int NOT NULL COMMENT '入库单的唯一标识',
  `goodsId` int NOT NULL COMMENT '入库商品的ID',
  `isReturned` enum('Yes','No') CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'No' COMMENT '是否退货',
  PRIMARY KEY (`inListGoodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='入库单_商品';

-- ----------------------------
-- Records of inlistgoods
-- ----------------------------
INSERT INTO `inlistgoods` VALUES ('4', '1', '1', 'No');
INSERT INTO `inlistgoods` VALUES ('5', '2', '2', 'Yes');

-- ----------------------------
-- Table structure for purchaser
-- ----------------------------
DROP TABLE IF EXISTS `purchaser`;
CREATE TABLE `purchaser` (
  `purchaserId` int NOT NULL AUTO_INCREMENT COMMENT '采购商的唯一标识',
  `purchaserNo` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '采购商的编号',
  `purchaserName` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '采购商的名称',
  `purchaserDesc` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '采购商的描述信息',
  `loginName` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '采购商的登录名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '采购商的登录密码',
  `telephone` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '采购商的联系电话',
  `zip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '采购商的邮编',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '采购商的地址',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '采购商的邮箱',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '采购商的状态',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '采购商的头像',
  PRIMARY KEY (`purchaserId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='采购商信息';

-- ----------------------------
-- Records of purchaser
-- ----------------------------
INSERT INTO `purchaser` VALUES ('3', 'P001', '家乐福采购部', '家乐福是全球知名零售商，采购部负责全球商品的采购和供应链管理。', 'carrefour', 'password123', '020-88888888', '510000', '广州市天河区天河路', 'carrefour@carrefour.com', '1', null);
INSERT INTO `purchaser` VALUES ('4', 'P002', '沃尔玛采购部', '沃尔玛是一家全球性的零售巨头，其采购部负责全球范围内的商品采购。', 'walmart', 'password456', '0755-99999999', '518000', '深圳市福田区福华路', 'walmart@walmart.com', '1', null);

-- ----------------------------
-- Table structure for returnrequest
-- ----------------------------
DROP TABLE IF EXISTS `returnrequest`;
CREATE TABLE `returnrequest` (
  `requestId` int NOT NULL AUTO_INCREMENT COMMENT '退货申请的唯一标识',
  `submitterName` varchar(100) NOT NULL COMMENT '提交人的名字',
  `submitTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间',
  `reason` varchar(500) NOT NULL COMMENT '申请理由',
  `goodsId` int NOT NULL COMMENT '退货商品的ID',
  `status` enum('待审核','已批准','已拒绝') NOT NULL DEFAULT '待审核' COMMENT '审核状态',
  `reviewerName` varchar(100) DEFAULT NULL COMMENT '审核人名字',
  `reviewTime` datetime DEFAULT NULL COMMENT '审核时间',
  PRIMARY KEY (`requestId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='退货申请表';

-- ----------------------------
-- Records of returnrequest
-- ----------------------------
INSERT INTO `returnrequest` VALUES ('3', 'string', '2024-05-23 23:55:04', 'string', '0', '已批准', 'string', '2024-05-23 23:55:04');
INSERT INTO `returnrequest` VALUES ('4', '李四', '2024-05-23 15:58:03', '收到商品与描述不符', '2', '待审核', null, null);
INSERT INTO `returnrequest` VALUES ('5', 'string', '2024-05-23 23:51:30', 'string', '3', '待审核', 'string', '2024-05-23 23:51:30');
INSERT INTO `returnrequest` VALUES ('7', 'string', '2024-05-23 23:51:30', 'string', '3', '已拒绝', 'string', '2024-05-23 23:51:30');

-- ----------------------------
-- Table structure for saleslistgoods
-- ----------------------------
DROP TABLE IF EXISTS `saleslistgoods`;
CREATE TABLE `saleslistgoods` (
  `salesListGoodsId` int NOT NULL AUTO_INCREMENT COMMENT '销售单商品的唯一标识',
  `salesId` int NOT NULL COMMENT '销售单的唯一标识',
  `goodsId` int NOT NULL COMMENT '销售商品的ID',
  `isReturned` enum('Yes','No') CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'No' COMMENT '是否退货',
  PRIMARY KEY (`salesListGoodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='销售单_商品';

-- ----------------------------
-- Records of saleslistgoods
-- ----------------------------
INSERT INTO `saleslistgoods` VALUES ('4', '1', '1', 'No');
INSERT INTO `saleslistgoods` VALUES ('5', '2', '2', 'No');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `supplierId` int NOT NULL AUTO_INCREMENT COMMENT '供应商的唯一标识',
  `supplierNo` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '供应商的编号',
  `supplierName` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '供应商的名称',
  `supplierDesc` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '供应商的描述信息',
  `loginName` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '供应商的登录名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '供应商的登录密码',
  `telephone` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '供应商的联系电话',
  `zip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '供应商的邮编',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '供应商的地址',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '供应商的邮箱',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '供应商的状态',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '供应商的头像',
  PRIMARY KEY (`supplierId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='供应商信息';

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('3', 'S001', '华纳电子信息公司', '华纳电子信息公司成立于1995年，主要供应电子产品，业务覆盖全球。', 'huana', 'password123', '010-88888888', '100000', '北京市朝阳区望京街道', 'huana@huana.com', '1', null);
INSERT INTO `supplier` VALUES ('4', 'S002', '京东惊喜公司', '京东惊喜公司是一家大型家居用品供应商，拥有丰富的产品线和广泛的客户基础。', 'jingdong', 'password456', '010-99999999', '200000', '上海市浦东新区世纪大道', 'jingdong@jd.com', '1', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int NOT NULL AUTO_INCREMENT COMMENT '用户的唯一标识',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '用户' COMMENT '用户的登录名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户的登录密码',
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户的性别',
  `age` int DEFAULT NULL COMMENT '用户的年龄',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户的联系电话',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户的邮箱',
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户的角色',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '0' COMMENT '用户的审核状态',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户的头像',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户创建的时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '用户最后一次更新的时间',
  PRIMARY KEY (`userId`,`email`),
  UNIQUE KEY `unique_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('5', 'admin', 'admin123', 'M', '30', '010-88888888', 'admin@example.com', '管理员', '1', null, '2024-05-23 15:58:16', '2024-05-23 15:58:16');
INSERT INTO `user` VALUES ('6', 'user1', 'user123', 'F', '25', '010-99999999', 'user1@example.com', '普通用户', '0', null, '2024-05-23 15:58:16', '2024-05-25 14:18:09');
INSERT INTO `user` VALUES ('7', 'string', 'string', null, '0', null, 'string', 'string', '0', 'string', '2024-05-25 14:30:24', '2024-05-25 14:37:38');
INSERT INTO `user` VALUES ('8', 'string', 'string', null, '0', null, 'string22', 'string', '0', 'string', '2024-05-25 14:34:24', '2024-05-25 14:37:42');
INSERT INTO `user` VALUES ('9', 'string', 'string', null, '0', null, 'string212', 'string', '1', 'string', '2024-05-25 14:34:49', '2024-05-25 14:34:49');
INSERT INTO `user` VALUES ('10', 'string', 'string', 'F', '0', 'string', 'str22ing', 'string', '0', 'string', '2024-05-25 14:47:23', '2024-05-25 14:47:23');
INSERT INTO `user` VALUES ('11', '用户', 'string', 'F', '0', 'string', 'str222ing', 'string', '0', 'string', '2024-05-25 14:50:45', '2024-05-25 14:50:45');

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse` (
  `warehouseId` int NOT NULL AUTO_INCREMENT COMMENT '仓库的唯一标识',
  `warehouseName` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '仓库的名称',
  `warehouseLocation` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '仓库的具体位置',
  `totalCapacity` decimal(10,2) NOT NULL COMMENT '仓库的总容量',
  `availableCapacity` decimal(10,2) NOT NULL COMMENT '仓库当前的可用容量',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '0' COMMENT '仓库的审核状态',
  PRIMARY KEY (`warehouseId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='第三方仓库信息';

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES ('3', '北京仓库', '北京市海淀区学院路', '10000.00', '8000.00', '0');
INSERT INTO `warehouse` VALUES ('4', '上海仓库', '上海市静安区南京西路', '15000.00', '12000.00', '1');

-- ----------------------------
-- Table structure for warehousegoods
-- ----------------------------
DROP TABLE IF EXISTS `warehousegoods`;
CREATE TABLE `warehousegoods` (
  `warehouseGoodsId` int NOT NULL AUTO_INCREMENT COMMENT '仓库商品信息的唯一标识',
  `warehouseId` int NOT NULL COMMENT '仓库的唯一标识',
  `goodsId` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '仓库中存储的商品ID，以逗号分隔',
  `goodsQuantity` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '仓库中存储的商品数量，以逗号分隔，与goodsId一一对应',
  PRIMARY KEY (`warehouseGoodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='仓库商品信息';

-- ----------------------------
-- Records of warehousegoods
-- ----------------------------
INSERT INTO `warehousegoods` VALUES ('3', '1', '1', '10');
INSERT INTO `warehousegoods` VALUES ('4', '2', '2', '10');

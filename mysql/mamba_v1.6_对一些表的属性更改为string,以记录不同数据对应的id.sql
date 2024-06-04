/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : mamba

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2024-05-29 15:28:39
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
  `warehouseId` int DEFAULT '1' COMMENT '仓库ID',
  PRIMARY KEY (`goodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品信息';

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '华为笔记本电脑', '电子产品', '5000.00', '6000.00', '2024-05-23 15:57:42', '2024-05-29 15:00:22', '0', '1');
INSERT INTO `goods` VALUES ('2', '宜家沙发', '家居用品', '1500.00', '2000.00', '2024-05-23 15:57:42', '2024-05-29 15:00:22', '0', '1');
INSERT INTO `goods` VALUES ('3', 'temp', 'temp', '22.00', '333.00', '2024-05-17 17:34:51', '2024-05-29 15:00:24', '1', '2');
INSERT INTO `goods` VALUES ('6', '商品A', '分类1', '5000.00', '7500.00', '2024-05-28 15:03:49', '2024-05-29 15:00:28', '1', '1');
INSERT INTO `goods` VALUES ('7', '商品C', '分类3', '8000.00', '12000.00', '2024-05-28 15:03:49', '2024-05-28 15:03:49', '1', '0');
INSERT INTO `goods` VALUES ('8', '商品A', '分类1', '5000.00', '7500.00', '2024-05-28 15:05:14', '2024-05-28 15:05:14', '1', '0');
INSERT INTO `goods` VALUES ('9', '商品C', '分类3', '8000.00', '12000.00', '2024-05-28 15:05:14', '2024-05-28 15:05:14', '1', '0');
INSERT INTO `goods` VALUES ('10', '商品A', '分类1', '5000.00', '7500.00', '2024-05-28 15:05:45', '2024-05-28 15:05:45', '1', '0');
INSERT INTO `goods` VALUES ('11', '商品C', '分类3', '8000.00', '12000.00', '2024-05-28 15:05:45', '2024-05-28 15:05:45', '1', '0');
INSERT INTO `goods` VALUES ('12', '商品A', '分类1', '6000.00', '9000.00', '2024-05-28 15:06:56', '2024-05-28 15:06:56', '1', '0');
INSERT INTO `goods` VALUES ('16', '商品Aa', '分类1', '5000.00', '7500.00', '2024-05-28 15:17:29', '2024-05-28 15:17:29', '1', '0');
INSERT INTO `goods` VALUES ('17', '商品Cc', '分类3', '8000.00', '12000.00', '2024-05-28 15:17:29', '2024-05-28 15:17:29', '1', '0');
INSERT INTO `goods` VALUES ('18', '商品K ', '电子材料', '1000.00', '1500.00', '2024-05-28 15:17:29', '2024-05-28 15:17:29', '1', '0');
INSERT INTO `goods` VALUES ('19', '商品Aa', '分类1', '5000.00', '7500.00', '2024-05-28 15:51:26', '2024-05-28 15:51:26', '1', '0');
INSERT INTO `goods` VALUES ('20', '商品Ccy ', '分类3 ', '1000.00', '1500.00', '2024-05-28 15:51:26', '2024-05-28 15:51:26', '1', '0');
INSERT INTO `goods` VALUES ('23', '商品haa', '分类6', '5000.00', '7500.00', '2024-05-28 16:10:45', '2024-05-28 16:10:45', '1', '0');
INSERT INTO `goods` VALUES ('24', '商品Ccy ', '分类3 ', '1020.50', '1530.75', '2024-05-28 16:10:45', '2024-05-28 16:10:45', '1', '0');
INSERT INTO `goods` VALUES ('25', '商品haa', '分类6', '500.00', '750.00', '2024-05-28 16:21:19', '2024-05-28 16:21:19', '1', '0');
INSERT INTO `goods` VALUES ('26', '商品Ccy ', '分类3 ', '1020.50', '1530.75', '2024-05-28 16:21:19', '2024-05-28 16:21:19', '1', '0');
INSERT INTO `goods` VALUES ('27', '商品haa', '分类6', '500.00', '750.00', '2024-05-28 16:22:37', '2024-05-28 16:22:37', '1', '0');
INSERT INTO `goods` VALUES ('28', '商品Ccy ', '分类3 ', '1020.50', '1530.75', '2024-05-28 16:22:37', '2024-05-28 16:22:37', '1', '0');
INSERT INTO `goods` VALUES ('29', '商品haa', '分类6', '500.00', '750.00', '2024-05-28 16:24:35', '2024-05-28 16:24:35', '1', '0');
INSERT INTO `goods` VALUES ('30', '商品Ccy ', '分类3 ', '1020.50', '1530.75', '2024-05-28 16:24:35', '2024-05-28 16:33:43', '0', '0');

-- ----------------------------
-- Table structure for goodsin
-- ----------------------------
DROP TABLE IF EXISTS `goodsin`;
CREATE TABLE `goodsin` (
  `goodsInId` int NOT NULL AUTO_INCREMENT COMMENT '入库单的唯一标识',
  `goodsInNo` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '入库单的编号,可以含有多个商品的id,以逗号分隔,获取后三位字符为数字id',
  `goodsName` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '商品名称,与商品编号对应,以逗号分隔',
  `goodsCategory` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '商品分类,与商品编号对应,以逗号分隔',
  `supplierId` int NOT NULL COMMENT '供应商的ID',
  `supplierName` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '供应商的名称',
  `goodsPrice` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '入库商品的单价,以逗号分隔,与商品编号对应',
  `goodsAmount` decimal(10,2) NOT NULL COMMENT '入库商品的总金额',
  `goodsInTime` datetime NOT NULL COMMENT '商品入库的时间',
  `warehouseId` int NOT NULL COMMENT '入库商品所在的仓库ID',
  `warehouseName` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '入库商品所在的仓库名称',
  `operatorId` int NOT NULL COMMENT '执行入库操作的用户ID',
  `operatorName` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '执行入库操作的用户名称',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '入库单的备注信息',
  PRIMARY KEY (`goodsInId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品入库';

-- ----------------------------
-- Records of goodsin
-- ----------------------------
INSERT INTO `goodsin` VALUES ('1', 'GIN001,GIN003', '商品A,商品C', '分类1,分类3', '1', '华纳电子信息公司', '5000.00,8000.00', '50000.00', '2024-05-23 10:00:00', '1', '北京仓库', '1', '操作员张三', '首次入库');
INSERT INTO `goodsin` VALUES ('2', 'GIN002', '商品B', '分类2', '2', '京东惊喜公司', '1500.00', '15000.00', '2024-05-23 11:00:00', '2', '上海仓库', '2', '操作员李四', '首次入库');
INSERT INTO `goodsin` VALUES ('5', 'GIN004,GIN008', '商品A,商品C', '分类1,分类3', '1', '华纳电子信息公司', '5000.00,8000.00', '13000.00', '2024-05-28 15:03:49', '1', '北京仓库', '1', '操作员张五', '首次入库');
INSERT INTO `goodsin` VALUES ('6', 'GIN009,GIN008', '商品A,商品C', '分类1,分类3', '1', '华纳电子信息公司', '5000.00,8000.00', '13000.00', '2024-05-28 15:05:14', '1', '北京仓库', '1', '操作员张五', '首次入库');
INSERT INTO `goodsin` VALUES ('7', 'GIN009,GIN0011', '商品A,商品C', '分类1,分类3', '1', '华纳电子信息公司', '5000.00,8000.00', '13000.00', '2024-05-28 15:05:46', '1', '北京仓库', '1', '操作员张五', '首次入库');
INSERT INTO `goodsin` VALUES ('8', 'GIN004', '商品A', '分类1', '1', '华纳电子信息公司', '6000.00', '6000.00', '2024-05-28 15:06:57', '1', '北京仓库', '1', '操作员张五', '首次入库');
INSERT INTO `goodsin` VALUES ('9', 'GIN001,GIN003,dkd0012', '商品Aa,商品Cc,商品K ', '分类1,分类3,电子材料', '1', '华纳电子信息公司', '5000.00,8000.00,1000', '14000.00', '2024-05-28 15:17:29', '1', '北京仓库', '1', '操作员张三', '首次入库');
INSERT INTO `goodsin` VALUES ('14', 'GIN027,GIN028', '商品haa,商品Ccy ', '分类6,分类3 ', '1', '华纳电子信息公司', '500.00,1020.5', '1520.50', '2024-05-28 16:22:37', '1', '北京仓库', '1', '操作员张三', '首次入库');
INSERT INTO `goodsin` VALUES ('15', 'GIN029,GIN030', '商品haa,商品Ccy ', '分类6,分类3 ', '1', '华纳电子信息公司', '500.00,1020.5', '1520.50', '2024-05-28 16:24:36', '1', '北京仓库', '1', '操作员张三', '首次入库');

-- ----------------------------
-- Table structure for goodsout
-- ----------------------------
DROP TABLE IF EXISTS `goodsout`;
CREATE TABLE `goodsout` (
  `salesId` int NOT NULL AUTO_INCREMENT COMMENT '销售单的唯一标识',
  `salesNo` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '销售单的编号,可以含有多个商品的id,以逗号分隔,获取后三位字符为数字id',
  `purchaserId` int NOT NULL COMMENT '采购商的ID',
  `purchaserName` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '采购商的名称',
  `goodsPrice` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '销售商品的单价，以逗号分隔，对应相应id商品的售价',
  `goodsAmount` decimal(10,2) NOT NULL COMMENT '销售商品的总金额',
  `salesTime` datetime NOT NULL COMMENT '商品销售的时间',
  `warehouseId` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '销售商品出库的仓库ID，以逗号分隔',
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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='入库单_商品';

-- ----------------------------
-- Records of inlistgoods
-- ----------------------------
INSERT INTO `inlistgoods` VALUES ('4', '1', '1', 'No');
INSERT INTO `inlistgoods` VALUES ('5', '2', '2', 'Yes');
INSERT INTO `inlistgoods` VALUES ('8', '1', '1', 'No');
INSERT INTO `inlistgoods` VALUES ('9', '1', '3', 'No');
INSERT INTO `inlistgoods` VALUES ('10', '1', '12', 'No');
INSERT INTO `inlistgoods` VALUES ('15', '12', '23', 'Yes');
INSERT INTO `inlistgoods` VALUES ('16', '12', '24', 'Yes');
INSERT INTO `inlistgoods` VALUES ('17', '13', '25', 'No');
INSERT INTO `inlistgoods` VALUES ('18', '13', '26', 'No');
INSERT INTO `inlistgoods` VALUES ('19', '14', '27', 'No');
INSERT INTO `inlistgoods` VALUES ('20', '14', '28', 'No');
INSERT INTO `inlistgoods` VALUES ('21', '15', '29', 'No');
INSERT INTO `inlistgoods` VALUES ('22', '15', '30', 'No');

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
INSERT INTO `returnrequest` VALUES ('4', 'string', '2024-05-23 15:58:03', '收到商品与描述不符', '2', '已批准', 'string', '2024-05-29 13:33:09');
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
INSERT INTO `warehouse` VALUES ('1', '北京仓库', '北京市海淀区学院路', '10000.00', '8000.00', '1');
INSERT INTO `warehouse` VALUES ('2', '上海仓库', '上海市静安区南京西路', '15000.00', '12000.00', '1');

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

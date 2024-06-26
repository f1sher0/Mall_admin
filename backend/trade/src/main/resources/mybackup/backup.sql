-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: mamba
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `announcement`
--

DROP TABLE IF EXISTS `announcement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `announcement` (
  `announcementId` int NOT NULL AUTO_INCREMENT COMMENT '公告的唯一标识',
  `title` varchar(100) NOT NULL COMMENT '公告标题',
  `content` text NOT NULL COMMENT '公告内容',
  `publisherEmail` varchar(100) NOT NULL COMMENT '发布者的邮箱',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '公告创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '公告更新时间',
  PRIMARY KEY (`announcementId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='公告信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcement`
--

LOCK TABLES `announcement` WRITE;
/*!40000 ALTER TABLE `announcement` DISABLE KEYS */;
INSERT INTO `announcement` VALUES (2,'新商品上架','我们上架了新的电子产品和家居用品，欢迎选购！','admin@example.com','2024-05-23 15:58:11','2024-05-23 15:58:11'),(3,'促销活动','本周末全场8折优惠，快来抢购吧！','admin@example.com','2024-05-23 15:58:11','2024-05-23 15:58:11');
/*!40000 ALTER TABLE `announcement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (4,'华为笔记本电脑','电子产品',5000.00,6000.00,'2024-05-23 15:57:42','2024-05-23 15:57:42',1),(5,'宜家沙发','家居用品',1500.00,2000.00,'2024-05-23 15:57:42','2024-05-23 15:57:42',1);
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goodsin`
--

DROP TABLE IF EXISTS `goodsin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goodsin` (
  `goodsInId` int NOT NULL AUTO_INCREMENT COMMENT '入库单的唯一标识',
  `goodsInNo` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '入库单的编号,可以含有多个商品的id,以逗号分隔',
  `supplierId` int NOT NULL COMMENT '供应商的ID',
  `supplierName` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '供应商的名称',
  `goodsPrice` decimal(10,2) NOT NULL COMMENT '入库商品的单价',
  `goodsAmount` decimal(10,2) NOT NULL COMMENT '入库商品的总金额',
  `goodsInTime` datetime NOT NULL COMMENT '商品入库的时间',
  `warehouseId` int NOT NULL COMMENT '入库商品所在的仓库ID',
  `warehouseName` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '入库商品所在的仓库名称',
  `operatorId` int NOT NULL COMMENT '执行入库操作的用户ID',
  `operatorName` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '执行入库操作的用户名称',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '入库单的备注信息',
  PRIMARY KEY (`goodsInId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品入库';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goodsin`
--

LOCK TABLES `goodsin` WRITE;
/*!40000 ALTER TABLE `goodsin` DISABLE KEYS */;
INSERT INTO `goodsin` VALUES (3,'GIN001',1,'华纳电子信息公司',5000.00,50000.00,'2024-05-23 10:00:00',1,'北京仓库',1,'操作员张三','首次入库'),(4,'GIN002',2,'京东惊喜公司',1500.00,15000.00,'2024-05-23 11:00:00',2,'上海仓库',2,'操作员李四','首次入库');
/*!40000 ALTER TABLE `goodsin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goodsout`
--

DROP TABLE IF EXISTS `goodsout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goodsout` (
  `salesId` int NOT NULL AUTO_INCREMENT COMMENT '销售单的唯一标识',
  `salesNo` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '销售单的编号,可以含有多个商品的id,以逗号分隔',
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goodsout`
--

LOCK TABLES `goodsout` WRITE;
/*!40000 ALTER TABLE `goodsout` DISABLE KEYS */;
INSERT INTO `goodsout` VALUES (3,'SOUT001',1,'家乐福采购部',6000.00,60000.00,'2024-05-23 12:00:00',1,'北京仓库',1,'操作员张三','首次销售'),(4,'SOUT002',2,'沃尔玛采购部',2000.00,20000.00,'2024-05-23 13:00:00',2,'上海仓库',2,'操作员李四','首次销售');
/*!40000 ALTER TABLE `goodsout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inlistgoods`
--

DROP TABLE IF EXISTS `inlistgoods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inlistgoods` (
  `inListGoodsId` int NOT NULL AUTO_INCREMENT COMMENT '入库单商品的唯一标识',
  `goodsInId` int NOT NULL COMMENT '入库单的唯一标识',
  `goodsId` int NOT NULL COMMENT '入库商品的ID',
  `isReturned` enum('Yes','No') CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'No' COMMENT '是否退货',
  PRIMARY KEY (`inListGoodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='入库单_商品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inlistgoods`
--

LOCK TABLES `inlistgoods` WRITE;
/*!40000 ALTER TABLE `inlistgoods` DISABLE KEYS */;
INSERT INTO `inlistgoods` VALUES (4,1,1,'No'),(5,2,2,'No');
/*!40000 ALTER TABLE `inlistgoods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchaser`
--

DROP TABLE IF EXISTS `purchaser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchaser`
--

LOCK TABLES `purchaser` WRITE;
/*!40000 ALTER TABLE `purchaser` DISABLE KEYS */;
INSERT INTO `purchaser` VALUES (3,'P001','家乐福采购部','家乐福是全球知名零售商，采购部负责全球商品的采购和供应链管理。','carrefour','password123','020-88888888','510000','广州市天河区天河路','carrefour@carrefour.com','1',NULL),(4,'P002','沃尔玛采购部','沃尔玛是一家全球性的零售巨头，其采购部负责全球范围内的商品采购。','walmart','password456','0755-99999999','518000','深圳市福田区福华路','walmart@walmart.com','1',NULL);
/*!40000 ALTER TABLE `purchaser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `returnrequest`
--

DROP TABLE IF EXISTS `returnrequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `returnrequest`
--

LOCK TABLES `returnrequest` WRITE;
/*!40000 ALTER TABLE `returnrequest` DISABLE KEYS */;
INSERT INTO `returnrequest` VALUES (3,'string','2024-05-23 23:55:04','string',0,'已批准','string','2024-05-23 23:55:04'),(4,'李四','2024-05-23 15:58:03','收到商品与描述不符',2,'待审核',NULL,NULL),(5,'string','2024-05-23 23:51:30','string',3,'待审核','string','2024-05-23 23:51:30'),(7,'string','2024-05-23 23:51:30','string',3,'已拒绝','string','2024-05-23 23:51:30');
/*!40000 ALTER TABLE `returnrequest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saleslistgoods`
--

DROP TABLE IF EXISTS `saleslistgoods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saleslistgoods` (
  `salesListGoodsId` int NOT NULL AUTO_INCREMENT COMMENT '销售单商品的唯一标识',
  `salesId` int NOT NULL COMMENT '销售单的唯一标识',
  `goodsId` int NOT NULL COMMENT '销售商品的ID',
  `isReturned` enum('Yes','No') CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'No' COMMENT '是否退货',
  PRIMARY KEY (`salesListGoodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='销售单_商品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saleslistgoods`
--

LOCK TABLES `saleslistgoods` WRITE;
/*!40000 ALTER TABLE `saleslistgoods` DISABLE KEYS */;
INSERT INTO `saleslistgoods` VALUES (4,1,1,'No'),(5,2,2,'No');
/*!40000 ALTER TABLE `saleslistgoods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (3,'S001','华纳电子信息公司','华纳电子信息公司成立于1995年，主要供应电子产品，业务覆盖全球。','huana','password123','010-88888888','100000','北京市朝阳区望京街道','huana@huana.com','1',NULL),(4,'S002','京东惊喜公司','京东惊喜公司是一家大型家居用品供应商，拥有丰富的产品线和广泛的客户基础。','jingdong','password456','010-99999999','200000','上海市浦东新区世纪大道','jingdong@jd.com','1',NULL);
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (5,'admin','admin123','M',30,'010-88888888','admin@example.com','管理员','1',NULL,'2024-05-23 15:58:16','2024-05-23 15:58:16'),(6,'user1','user123','F',25,'010-99999999','user1@example.com','普通用户','0',NULL,'2024-05-23 15:58:16','2024-05-25 14:18:09'),(7,'string','string',NULL,0,NULL,'string','string','0','string','2024-05-25 14:30:24','2024-05-25 14:37:38'),(8,'string','string',NULL,0,NULL,'string22','string','0','string','2024-05-25 14:34:24','2024-05-25 14:37:42'),(9,'string','string',NULL,0,NULL,'string212','string','1','string','2024-05-25 14:34:49','2024-05-25 14:34:49'),(10,'string','string','F',0,'string','str22ing','string','0','string','2024-05-25 14:47:23','2024-05-25 14:47:23'),(11,'用户','string','F',0,'string','str222ing','string','0','string','2024-05-25 14:50:45','2024-05-25 14:50:45');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouse`
--

DROP TABLE IF EXISTS `warehouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `warehouse` (
  `warehouseId` int NOT NULL AUTO_INCREMENT COMMENT '仓库的唯一标识',
  `warehouseName` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '仓库的名称',
  `warehouseLocation` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '仓库的具体位置',
  `totalCapacity` decimal(10,2) NOT NULL COMMENT '仓库的总容量',
  `availableCapacity` decimal(10,2) NOT NULL COMMENT '仓库当前的可用容量',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '0' COMMENT '仓库的审核状态',
  PRIMARY KEY (`warehouseId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='第三方仓库信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouse`
--

LOCK TABLES `warehouse` WRITE;
/*!40000 ALTER TABLE `warehouse` DISABLE KEYS */;
INSERT INTO `warehouse` VALUES (3,'北京仓库','北京市海淀区学院路',10000.00,8000.00,'0'),(4,'上海仓库','上海市静安区南京西路',15000.00,12000.00,'1');
/*!40000 ALTER TABLE `warehouse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehousegoods`
--

DROP TABLE IF EXISTS `warehousegoods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `warehousegoods` (
  `warehouseGoodsId` int NOT NULL AUTO_INCREMENT COMMENT '仓库商品信息的唯一标识',
  `warehouseId` int NOT NULL COMMENT '仓库的唯一标识',
  `goodsId` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '仓库中存储的商品ID，以逗号分隔',
  `goodsQuantity` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '仓库中存储的商品数量，以逗号分隔，与goodsId一一对应',
  PRIMARY KEY (`warehouseGoodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='仓库商品信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehousegoods`
--

LOCK TABLES `warehousegoods` WRITE;
/*!40000 ALTER TABLE `warehousegoods` DISABLE KEYS */;
INSERT INTO `warehousegoods` VALUES (3,1,'1','10'),(4,2,'2','10');
/*!40000 ALTER TABLE `warehousegoods` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-25 16:39:39

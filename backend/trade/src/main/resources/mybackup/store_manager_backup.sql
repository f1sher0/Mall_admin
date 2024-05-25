-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: store_manager
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
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `sale_no` int NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`,`sale_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'罗弘文',1,'18935674510'),(1,'罗弘文',2,'18935674510'),(1,'罗弘文',3,'18935674510'),(1,'罗弘文',5,'18935674510'),(2,'王黎昕',2,'13135234651'),(2,'王黎昕',4,'13135234651'),(2,'王黎昕',6,'13135234651'),(3,'潘绍齐',3,'14355234651'),(6,'邵鸿煊',6,'13345234651'),(7,'顾烨华',7,'13733234651'),(8,'冯楷瑞',88,'18935674510'),(9,'黄文轩',2,'18978566230'),(12,'范越彬',12,'18215674510'),(32,'张彭',32,'13135234651'),(46,'小李子',46,'19387262235'),(47,'迈克',47,'13847383374'),(48,'艾宁宁',48,'17846376689'),(49,'张感',49,'19938293380'),(50,'张林林',50,'19938298846'),(66,'丸子头',66,'17854896658'),(100,'周屏',100,'18823487725'),(321,'周曾',321,'16345234651'),(1234,'客户1',1234,'1111111'),(1312,'任博文',1312,'13435246651'),(1314,'何泽洋',1314,'19324554651'),(131233,'薛越彬',131233,'13135234651');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emps`
--

DROP TABLE IF EXISTS `emps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emps` (
  `id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `dept` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `manage_id` int DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emps`
--

LOCK TABLES `emps` WRITE;
/*!40000 ALTER TABLE `emps` DISABLE KEYS */;
INSERT INTO `emps` VALUES (1,'小明','测试部',1,'123'),(2,'张健柏','技术部',1,'123'),(3,'戴风华','市场部',1,'666'),(4,'丁智渊','财务部',1,'123'),(5,'李四','技术部',1,'666'),(6,'Musk','市场部',1,'666'),(7,'测试人','销售部',1,'123'),(8,'阿莫','销售部',1,'123'),(11,'ces','测试部',1,'123'),(12,'小杰','销售部',1,'123'),(21,'陆睿渊','技术部',1,'123'),(22,'萧擎','技术部',1,'123'),(32,'雷聪健','技术部',1,'666'),(122,'赵曾','捣蛋部',1,'123'),(212,'徐金','市场部',1,'123'),(555,'555','3',2,'123'),(555555555,'JWT','对的',1,'55');
/*!40000 ALTER TABLE `emps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manages`
--

DROP TABLE IF EXISTS `manages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manages` (
  `id` int NOT NULL,
  `store_id` int DEFAULT NULL,
  `emp_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `store_id` (`store_id`),
  KEY `emp_id` (`emp_id`),
  CONSTRAINT `manages_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `stores` (`id`),
  CONSTRAINT `manages_ibfk_2` FOREIGN KEY (`emp_id`) REFERENCES `emps` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manages`
--

LOCK TABLES `manages` WRITE;
/*!40000 ALTER TABLE `manages` DISABLE KEYS */;
INSERT INTO `manages` VALUES (1,1,1);
/*!40000 ALTER TABLE `manages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicines`
--

DROP TABLE IF EXISTS `medicines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicines` (
  `id` int NOT NULL,
  `type_no` int DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `supplier_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `price` int DEFAULT NULL,
  `selling` int DEFAULT NULL,
  `storage_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicines`
--

LOCK TABLES `medicines` WRITE;
/*!40000 ALTER TABLE `medicines` DISABLE KEYS */;
INSERT INTO `medicines` VALUES (1,15520284,'盐酸去氧肾上腺素','神州制药有限公司',34,56,1),(2,61869257,'白血生','新平制药有限公司',26,38,1),(3,61869257,'白血生','新平制药有限公司',26,38,1),(4,46361016,'阿莫罗芬','华东制药有限公司',24,44,2),(5,55725240,'盐酸苯海拉明','艾西莫药业(中国)有限公司',12,32,1),(6,15520284,'盐酸去氧肾上腺素','神州制药有限公司',34,45,1),(7,45684635,'阿魏酸钠葡萄糖注射液','神州制药有限公司',17,30,1),(8,45684635,'阿魏酸钠葡萄糖注射液','神州制药有限公司',17,30,1),(9,55725240,'盐酸苯海拉明','艾西莫药业(中国)有限公司',12,32,1),(10,41291118,'秋水仙胺','同心制药',16,26,1),(11,15520284,'盐酸去氧肾上腺素','神州制药有限公司',34,45,1),(12,78676109,'脑活素','正大药业',12,30,1),(13,41291118,'秋水仙胺','同心制药',16,26,1),(21,78676109,'脑活素','正大药业',12,30,1),(24,48579842,'葡萄糖酸钙','大鹏制药',11,20,1),(27,48579842,'葡萄糖酸钙','大鹏制药',11,20,1),(32,86727543,'胶原酶','天庆制药有限公司',12,22,1),(43,64271396,'赖氨酸茶碱','药模制药有限公司',23,33,2),(44,45693623,'胃药胶囊','辽东可成药业有限公司',35,45,1),(45,45693623,'胃药胶囊','辽东可成药业有限公司',35,45,1),(46,99837281,'和胃丸','仁和药业',32,42,1),(47,73829983,'铝碳酸镁咀嚼片','华森药业有限公司',35,45,1),(48,84738475,'胃舒宁颗粒','乐天药业',20,30,1),(49,38276678,'伤风感冒素','巨雷药业有限公司',14,36,1),(50,34354443,'感冒灵颗粒','三九药业',15,47,1),(54,33323232,'大力丸','供应商a',12,44,1),(66,86727543,'胶原酶','天庆制药有限公司',12,22,1),(99,47346898,'水解蛋白','天庆制药有限公司',6,9,1),(100,23256191,'安达美','上虞磬制药有限公司',29,44,1),(111,47346898,'水解蛋白','天庆制药有限公司',6,9,1),(131,43023301,'猪苓多糖','康和药业',18,28,2),(277,55486152,'松节油','江津制药有限公司',22,32,1),(321,23256191,'安达美','上虞磬制药有限公司',29,44,1),(520,55486152,'松节油','江津制药有限公司',22,32,1),(777,55486152,'松节油','江津制药有限公司',22,32,1),(1234,55486152,'松节油','江津制药有限公司',22,32,1),(1314,66501801,'视明露眼水','安杰股份有限公司',18,23,1),(9999,66501801,'视明露眼水','安杰股份有限公司',18,23,1),(11111,62579616,'白内停滴眼液','智科制药有限公司',33,43,1),(222222,62579616,'白内停滴眼液','智科制药有限公司',22,32,1);
/*!40000 ALTER TABLE `medicines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `out_ins`
--

DROP TABLE IF EXISTS `out_ins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `out_ins` (
  `no` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `time` date DEFAULT NULL,
  `state` int DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  `supplier_id` int DEFAULT NULL,
  PRIMARY KEY (`no`),
  KEY `store_id` (`store_id`),
  KEY `supplier_id` (`supplier_id`),
  CONSTRAINT `out_ins_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `stores` (`id`),
  CONSTRAINT `out_ins_ibfk_2` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `out_ins`
--

LOCK TABLES `out_ins` WRITE;
/*!40000 ALTER TABLE `out_ins` DISABLE KEYS */;
INSERT INTO `out_ins` VALUES ('1','2023-08-03',1,1,1),('111','2023-08-12',1,1,1),('11111','2023-08-12',1,1,1),('1234','2023-08-14',1,1,1),('2','2023-07-01',1,1,1),('211','2023-08-12',0,1,1),('222222','2023-08-12',1,1,1),('27','2023-08-11',1,1,1),('277','2023-08-11',1,1,1),('32','2023-08-17',1,1,1),('4','2022-07-01',0,1,1),('43','2023-08-18',1,1,1),('44','2023-08-19',1,1,1),('45','2023-08-19',1,1,1),('46','2023-07-21',1,1,1),('47','2023-07-24',1,1,1),('48','2023-07-14',1,1,1),('49','2023-07-20',1,1,1),('5','2022-09-01',0,1,1),('50','2023-07-13',1,1,1),('52','2023-08-19',0,1,1),('520','2023-08-18',1,1,1),('54','2023-08-19',1,1,1),('6','2023-07-22',0,1,1),('66','2023-08-18',1,1,1),('7','2023-08-11',1,1,2),('777','2023-08-14',1,1,1),('8','2023-08-10',1,1,2),('998888','2023-08-14',0,1,1),('9999','2023-07-18',1,1,1);
/*!40000 ALTER TABLE `out_ins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales` (
  `state` int DEFAULT NULL,
  `no` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `time` date DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  PRIMARY KEY (`no`),
  KEY `customer_id` (`customer_id`),
  KEY `store_id` (`store_id`),
  CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`),
  CONSTRAINT `sales_ibfk_2` FOREIGN KEY (`store_id`) REFERENCES `stores` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (0,'100','2023-12-22',100,1),(0,'1234','2023-08-19',1234,1),(1,'1314','2023-12-23',1314,1),(1,'2','2023-08-07',1,1),(0,'3','2023-12-27',1,1),(1,'32','2023-12-29',32,1),(1,'321','2023-08-16',321,1),(1,'4','2023-12-29',2,1),(1,'46','2023-08-19',46,1),(1,'47','2023-08-19',47,1),(1,'48','2023-08-19',48,1),(1,'49','2023-08-19',49,1),(1,'5','2023-07-09',1,1),(1,'50','2023-08-19',50,1),(1,'6','2023-07-15',2,1),(1,'66','2023-08-19',66,1),(0,'7','2023-08-13',7,1);
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storages`
--

DROP TABLE IF EXISTS `storages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `storages` (
  `id` int NOT NULL,
  `medicine_id` int NOT NULL,
  `store_id` int DEFAULT NULL,
  PRIMARY KEY (`medicine_id`),
  KEY `store_id` (`store_id`),
  CONSTRAINT `storages_ibfk_1` FOREIGN KEY (`medicine_id`) REFERENCES `medicines` (`id`),
  CONSTRAINT `storages_ibfk_2` FOREIGN KEY (`store_id`) REFERENCES `stores` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storages`
--

LOCK TABLES `storages` WRITE;
/*!40000 ALTER TABLE `storages` DISABLE KEYS */;
INSERT INTO `storages` VALUES (1,1,1),(2,2,1);
/*!40000 ALTER TABLE `storages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stores`
--

DROP TABLE IF EXISTS `stores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stores` (
  `id` int NOT NULL,
  `sale_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `manage_id` int NOT NULL,
  `out_in_id` int NOT NULL,
  `storage_id` int NOT NULL,
  PRIMARY KEY (`id`,`sale_no`,`manage_id`,`out_in_id`,`storage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stores`
--

LOCK TABLES `stores` WRITE;
/*!40000 ALTER TABLE `stores` DISABLE KEYS */;
INSERT INTO `stores` VALUES (1,'1',1,1,1),(1,'2',2,2,1);
/*!40000 ALTER TABLE `stores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suppliers` (
  `id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `out_in_no` int DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` VALUES (1,'神州制药有限公司',1,'14725836901'),(2,'新平制药有限公司',2,'13579246810'),(3,'艾西莫药业(中国)有限公司',3,'18612345678'),(5,'正大药业',5,'13912345678'),(6,'大鹏制药',6,'15898765432'),(7,'华东制药有限公司',7,'17823133212'),(9,'江津制药有限公司',3,'13109876543'),(43,'天庆制药有限公司',43,'13019283746'),(44,'辽东可成药业有限公司',44,'19946798875'),(46,'仁和药业',46,'13846837746'),(47,'华森药业有限公司',47,'17856699854'),(48,'乐天药业',48,'18827376643'),(49,'巨雷药业有限公司',49,'19983783327'),(50,'三九药业',50,'15238293380'),(54,'供应商a',54,'17854896658'),(99,'上虞磬制药有限公司',3,'18765432109'),(111,'智科制药有限公司',111,'18927364510'),(777,'安杰股份有限公司',777,'13467928501'),(1234,'药模制药有限公司',1234,'18530927461'),(9999,'康和药业',9999,'13309274651'),(11111,'药研股份有限公司',11111,'18203947561'),(222222,'同心制药',222222,'18203911161');
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-25 16:36:40

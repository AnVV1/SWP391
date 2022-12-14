-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: building_management2
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `app_users`
--

DROP TABLE IF EXISTS `app_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `app_users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` bit(1) DEFAULT NULL,
  `is_enabled` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `verification_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_users`
--

LOCK TABLES `app_users` WRITE;
/*!40000 ALTER TABLE `app_users` DISABLE KEYS */;
INSERT INTO `app_users` VALUES (1,_binary '\0',_binary '','$2a$10$zpsUtU0PSZwmeSGKMW3PN.ud9V464dGj/ZyQqA3.5Rs4n0E9BoHH2','admin',NULL),(2,_binary '\0',_binary '','$2a$10$zpsUtU0PSZwmeSGKMW3PN.ud9V464dGj/ZyQqA3.5Rs4n0E9BoHH2','trung@gmail.com',NULL),(3,_binary '\0',_binary '','$2a$10$zpsUtU0PSZwmeSGKMW3PN.ud9V464dGj/ZyQqA3.5Rs4n0E9BoHH2','huu@gmail.com',NULL),(4,_binary '\0',_binary '','$2a$10$zpsUtU0PSZwmeSGKMW3PN.ud9V464dGj/ZyQqA3.5Rs4n0E9BoHH2','tay@gmail.com',NULL),(5,_binary '\0',_binary '','$2a$10$zpsUtU0PSZwmeSGKMW3PN.ud9V464dGj/ZyQqA3.5Rs4n0E9BoHH2','duong@gmail.com',NULL),(6,_binary '\0',_binary '','$2a$10$zpsUtU0PSZwmeSGKMW3PN.ud9V464dGj/ZyQqA3.5Rs4n0E9BoHH2','dong@gmail.com',NULL),(7,_binary '\0',_binary '','$2a$10$zpsUtU0PSZwmeSGKMW3PN.ud9V464dGj/ZyQqA3.5Rs4n0E9BoHH2','chien@gmail.com',NULL),(8,_binary '\0',_binary '','$2a$10$zpsUtU0PSZwmeSGKMW3PN.ud9V464dGj/ZyQqA3.5Rs4n0E9BoHH2','cao@gmail.com',NULL),(9,_binary '\0',_binary '','$2a$10$zpsUtU0PSZwmeSGKMW3PN.ud9V464dGj/ZyQqA3.5Rs4n0E9BoHH2','duy@gmail.com',NULL),(10,_binary '\0',_binary '','$2a$10$zpsUtU0PSZwmeSGKMW3PN.ud9V464dGj/ZyQqA3.5Rs4n0E9BoHH2','cong@gmail.com',NULL),(17,_binary '\0',_binary '','$2a$10$zpsUtU0PSZwmeSGKMW3PN.ud9V464dGj/ZyQqA3.5Rs4n0E9BoHH2','abc@gmail.com',NULL),(18,_binary '\0',_binary '','$2a$10$zpsUtU0PSZwmeSGKMW3PN.ud9V464dGj/ZyQqA3.5Rs4n0E9BoHH2','now@gmail.com',NULL),(19,_binary '\0',_binary '','$2a$10$zpsUtU0PSZwmeSGKMW3PN.ud9V464dGj/ZyQqA3.5Rs4n0E9BoHH2','test@gmail.com',NULL);
/*!40000 ALTER TABLE `app_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_users_roles`
--

DROP TABLE IF EXISTS `app_users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `app_users_roles` (
  `app_users_id` int NOT NULL,
  `roles_id` int NOT NULL,
  PRIMARY KEY (`app_users_id`,`roles_id`),
  KEY `FK50rx9039q80b79jxbj6hja21k` (`roles_id`),
  CONSTRAINT `FK50rx9039q80b79jxbj6hja21k` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKq6q5rwvnm2uhejy6i07et8iv7` FOREIGN KEY (`app_users_id`) REFERENCES `app_users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_users_roles`
--

LOCK TABLES `app_users_roles` WRITE;
/*!40000 ALTER TABLE `app_users_roles` DISABLE KEYS */;
INSERT INTO `app_users_roles` VALUES (1,1),(17,1),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(18,2),(19,2);
/*!40000 ALTER TABLE `app_users_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract` (
  `contract_id` int NOT NULL AUTO_INCREMENT,
  `check_flag` int NOT NULL,
  `contract_code` varchar(255) DEFAULT NULL,
  `contract_content` varchar(255) DEFAULT NULL,
  `contract_date_end` varchar(255) DEFAULT NULL,
  `contract_date_start` varchar(255) DEFAULT NULL,
  `contract_delete_flag` bit(1) DEFAULT NULL,
  `contract_deposit` int DEFAULT NULL,
  `contract_expired` varchar(255) DEFAULT NULL,
  `contract_image_url` varchar(255) DEFAULT NULL,
  `contract_tax_code` varchar(255) DEFAULT NULL,
  `contract_total` varchar(255) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  `space_id` int DEFAULT NULL,
  PRIMARY KEY (`contract_id`),
  KEY `FKq28qogy68douoc4gkgcy3ow9p` (`customer_id`),
  KEY `FKr2iw6grixlkbx43q2svdrhbb9` (`employee_id`),
  KEY `FK3jetxh2rae58x3ef99jq4vnqp` (`space_id`),
  CONSTRAINT `FK3jetxh2rae58x3ef99jq4vnqp` FOREIGN KEY (`space_id`) REFERENCES `spaces` (`space_id`),
  CONSTRAINT `FKq28qogy68douoc4gkgcy3ow9p` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `FKr2iw6grixlkbx43q2svdrhbb9` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (1,0,'1','n???i dung h???p ?????ng','2022-10-30','2020-03-09',_binary '\0',1211,'5','https://firebasestorage.googleapis.com/v0/b/sprint1-employee.appspot.com/o/01.jpg?alt=media&token=d513b944-2160-43d1-8f72-899ba0ee0e23','1111','12000',100000,1,1,1),(2,0,'HD-0002','n???i dung h???p ?????ng','2022-05-09','2022-03-09',_binary '\0',1211,'2','https://firebasestorage.googleapis.com/v0/b/sprint1-employee.appspot.com/o/01.jpg?alt=media&token=d513b944-2160-43d1-8f72-899ba0ee0e23','1111','12000',1000,2,2,2),(3,0,'HD-0003','n???i dung h???p ?????ng','2022-05-09','2022-03-09',_binary '\0',1211,'2','https://firebasestorage.googleapis.com/v0/b/sprint1-employee.appspot.com/o/01.jpg?alt=media&token=d513b944-2160-43d1-8f72-899ba0ee0e23','1111','12000',1000,2,2,2),(4,0,'HD-0004','n???i dung h???p ?????ng','2022-05-09','2022-03-09',_binary '\0',1211,'2','https://firebasestorage.googleapis.com/v0/b/sprint1-employee.appspot.com/o/01.jpg?alt=media&token=d513b944-2160-43d1-8f72-899ba0ee0e23','1111','12000',1000,3,3,3),(5,0,'HD-0005','n???i dung h???p ?????ng','2022-05-09','2022-03-09',_binary '\0',1211,'2','https://firebasestorage.googleapis.com/v0/b/sprint1-employee.appspot.com/o/01.jpg?alt=media&token=d513b944-2160-43d1-8f72-899ba0ee0e23','1111','12000',1000,3,3,3),(6,0,'HD-0006','n???i dung h???p ?????ng','2022-05-09','2022-03-09',_binary '\0',1211,'2','https://firebasestorage.googleapis.com/v0/b/sprint1-employee.appspot.com/o/01.jpg?alt=media&token=d513b944-2160-43d1-8f72-899ba0ee0e23','1111','12000',1000,3,3,3),(7,0,'HD-0007','n???i dung h???p ?????ng','2022-05-09','2022-03-09',_binary '\0',1211,'2','https://firebasestorage.googleapis.com/v0/b/sprint1-employee.appspot.com/o/01.jpg?alt=media&token=d513b944-2160-43d1-8f72-899ba0ee0e23','1111','12000',1000,3,3,3),(8,0,'HD-0008','n???i dung h???p ?????ng','2022-05-09','2022-03-09',_binary '\0',1211,'2','https://firebasestorage.googleapis.com/v0/b/sprint1-employee.appspot.com/o/01.jpg?alt=media&token=d513b944-2160-43d1-8f72-899ba0ee0e23','1111','12000',1000,3,3,3),(9,0,'HD-0009','n???i dung h???p ?????ng','2022-05-09','2022-03-09',_binary '\0',1211,'2','https://firebasestorage.googleapis.com/v0/b/sprint1-employee.appspot.com/o/01.jpg?alt=media&token=d513b944-2160-43d1-8f72-899ba0ee0e23','1111','12000',1000,3,3,3),(10,0,'HD-0010','n???i dung h???p ?????ng','2022-05-09','2022-03-09',_binary '\0',1211,'2','https://firebasestorage.googleapis.com/v0/b/sprint1-employee.appspot.com/o/01.jpg?alt=media&token=d513b944-2160-43d1-8f72-899ba0ee0e23','1111','12000',1000,3,3,3),(11,0,'KH-0002','aaaaaaaaaaaaaaaaa','2022-10-30','2022-09-29',_binary '\0',300000,'1','https://firebasestorage.googleapis.com/v0/b/sprint1-employee.appspot.com/o/2.jpg?alt=media&token=df191f1e-541c-46a7-a743-5cdba16b4606','23245','600000',600000,2,2,2),(12,0,'HD-3222','cho thue nha','2022-10-30','2022-10-26',_binary '\0',300000,'0','https://firebasestorage.googleapis.com/v0/b/sprint1-employee.appspot.com/o/hinh-dep-12.jpg?alt=media&token=b2cd3624-bf5f-4660-8033-4e721068a274','45535','0',600000,1,1,1);
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `customer_address` varchar(255) DEFAULT NULL,
  `customer_code` varchar(255) DEFAULT NULL,
  `customer_date_of_birth` varchar(255) DEFAULT NULL,
  `customer_delete_flag` bit(1) DEFAULT NULL,
  `customer_email` varchar(255) DEFAULT NULL,
  `customer_identify_number` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `customer_phone` varchar(255) DEFAULT NULL,
  `customer_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'12 L?? Qu?? K???, ???? N???ng','KH-0001','01-01-1994',_binary '\0','hoadeptrai@gmail.com','3434343434','Nguy???n ????nh H??a','0905123456','??ang Thu??'),(2,'12 Nguy???n Ph?????c Nguy??n','KH-0002','01-01-1998',_binary '\0','nhanvanlam@gmail.com','2345543332','L?? ????nh Qu???c','0901231231','???? Thu??'),(3,'141 L?? T??? Tr???ng','KH-0003','01-01-1963',_binary '\0','cuongle@gmail.com','2017123678','L?? Thi???n C?????ng','0905181346','??ang Thu??'),(4,'12 L?? V??n Qu??','KH-0021','01-01-1988',_binary '\0','tiennguyen@gmail.com','4356173849','Nguy???n V??n Ti???n','0901231231','??ang Thu??'),(5,'100 Tr?????ng Chinh','KH-0023','01-01-1990',_binary '\0','dinhcuu@gmail.com','9876543219','Nguy???n ????nh C???u','0901456231','??ang Thu??'),(6,'20 B???c ?????u','KH-0041','01-03-1993',_binary '\0','hoanguyen123@gmail.com','4359683849','L?? Th??? Hoaaaaaaaaaaaaaaaaaaaa','0905931231','???? Thu??'),(7,'12 Nguy???n V??n Tho???i','KH-0005','01-01-1992',_binary '\0','mienthao92@gmail.com','1992617384','Nguy???n Mi??n Th???o','0903231231','???? Thu??'),(8,'12 H???i S??n','KH--0056','01-01-1984',_binary '\0','vinhwaky@gmail.com','1236173849','?????ng Ng???c Vinh','0906231231','??ang Thu??'),(9,'50 Tr???n H??ng ?????o','KH-0013','01-01-1998',_binary '\0','daitrang@gmail.com','1998173849','Tr???n ????i Trang','0902231256','??ang Thu??'),(10,'10 L????ng Th??? Vinh','KH--0010','10-01-1992',_binary '\0','thuytam@gmail.copm','1992173849','Nguy???n Th??y T??m','0905231256','???? Thu??'),(11,'141B L?? T??? Tr???ng','KH-0131','13-01-1994',_binary '\0','letranthaovy1326@gmail.com','2016121211','L?? Tr???n Th???o Vy','0706123123','??ang Thu??'),(12,'K10 H???i S??n','KH-0041','10-11-1994',_binary '\0','bamlee@gmil.com','2344765515','L?? Th??? Ng???c Chi???n','0901324334','??ang Thu??'),(13,'100 Ho??ng Di???u','KH-0025','01-01-1991',_binary '\0','myle@gmail.com','1991234456','L?? Tr???n Minh Hi???p','0905678456','???? Thu??'),(14,'100 Ho??ng Di???u','KH-0028','01-09-1991',_binary '\0','datnguyen@gmail.com','1991566777','Nguy???n ?????t','0706234891','???? Thu??'),(15,'15 ?????ng ??a','KH-0029','01-08-1995',_binary '\0','tieuphuonguyen@gmail.com','1995213131','Ti??u Ph????ng Uy??n','0905121899','???? Thu??'),(16,'5 Tr???n Cao V??n','KH-0005','01-03-1997',_binary '\0','trangnguyen@gmail.com','1997986655','Nguy???n Trang','0901987766','??ang Thu??');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `employee_address` varchar(255) DEFAULT NULL,
  `employee_code` varchar(255) DEFAULT NULL,
  `employee_date_of_birth` varchar(255) DEFAULT NULL,
  `employee_delete_flag` bit(1) DEFAULT NULL,
  `employee_email` varchar(255) DEFAULT NULL,
  `employee_gender` varchar(255) DEFAULT NULL,
  `employee_image` varchar(255) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `employee_phone` varchar(255) DEFAULT NULL,
  `employee_start_date` varchar(255) DEFAULT NULL,
  `app_user_id` int DEFAULT NULL,
  `employee_position_id` int NOT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `FKmokg97p9ob14q0kj3p1m3bxw0` (`app_user_id`),
  KEY `FKkft5wjvwfuqgkuuh6tces2pdr` (`employee_position_id`),
  CONSTRAINT `FKkft5wjvwfuqgkuuh6tces2pdr` FOREIGN KEY (`employee_position_id`) REFERENCES `employee_position` (`employee_position_id`),
  CONSTRAINT `FKmokg97p9ob14q0kj3p1m3bxw0` FOREIGN KEY (`app_user_id`) REFERENCES `app_users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Ngh??? An','ADMIN','1999-02-13',_binary '\0','admin@gmail.com','Nam',NULL,'ADMIN','0339234567','2022-06-19',1,1),(2,'Ngh??? An','NV-0002','1999-05-19',_binary '\0','trung@gmail.com','Nam',NULL,'L?? Th??? Trung','033923432','2022-06-19',2,1),(3,'Hu???','NV-0003','1998-02-14',_binary '\0','huu@gmail.com','Nam',NULL,'Nguy???n Ng?? H???u','033929992','2022-06-19',3,1),(4,'???? N??ng','NV-0004','1997-07-19',_binary '\0','tay@gmail.com','Nam',NULL,'Nguy???n Ng?? Anh T??y','037777992','2022-06-19',4,1),(5,'???? N??ng','NV-0005','1996-02-11',_binary '\0','duong@gmail.com','Nam',NULL,'Ph??ng H???i D????ng ','037778888','2022-06-19',5,1),(6,'Hu???','NV-0006','1994-05-19',_binary '\0','dong@gmail.com','Nam',NULL,'Nguy???n H???i ????ng ','0309999988','2022-06-19',6,1),(7,'H?? N???i','NV-0007','1999-02-29',_binary '\0','chien@gmail.com','Nam',NULL,'Nguy???n V??n Chi???n ','0377777988','2022-06-19',7,1),(8,'???? N??ng','NV-0008','1995-04-29',_binary '\0','cao@gmail.com','Nam',NULL,'Nguy???n V??n Cao ','035555988','2022-06-19',8,1),(9,'Hu???','NV-0009','1996-02-16',_binary '\0','duy@gmail.com','Nam',NULL,'Nguy???n V??n Duy ','035343488','2022-06-19',9,1),(10,'H?? N???i','NV-0010','1999-04-19',_binary '\0','cong@gmail.com','Nam',NULL,'Nguy???n V??n C??ng ','03323488','2022-06-19',10,1),(15,'Ngh??? An','NV-1023','1999-02-13',_binary '\0','abc@gmail.com','Nam','https://firebasestorage.googleapis.com/v0/b/sprint1-employee.appspot.com/o/hinh-dep-12.jpg?alt=media&token=6ea05481-2adf-4508-be1a-6ee53653cd21','trung','0900008888','2022-10-13',17,2),(16,'Ngh??? An','NV-1024','1999-02-13',_binary '','now@gmail.com','Nam','https://firebasestorage.googleapis.com/v0/b/sprint1-employee.appspot.com/o/hinh-dep-12.jpg?alt=media&token=330eb23b-aecd-458a-87bd-e7af0178f462','trung','0900008888','2022-10-19',18,2),(17,'Ngh??? An','NV-1212','1999-02-13',_binary '\0','test@gmail.com','Nam','https://firebasestorage.googleapis.com/v0/b/sprint1-employee.appspot.com/o/hinh-dep-12.jpg?alt=media&token=18b7aa3f-bf34-44b4-b82c-5b6bee9b7c6e','L?? Th??? Trung','0900008888','2022-10-25',19,2);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_position`
--

DROP TABLE IF EXISTS `employee_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_position` (
  `employee_position_id` int NOT NULL AUTO_INCREMENT,
  `employee_position_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_position`
--

LOCK TABLES `employee_position` WRITE;
/*!40000 ALTER TABLE `employee_position` DISABLE KEYS */;
INSERT INTO `employee_position` VALUES (1,'Qu???n L??'),(2,'Nh??n Vi??n');
/*!40000 ALTER TABLE `employee_position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `floors`
--

DROP TABLE IF EXISTS `floors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `floors` (
  `floor_id` int NOT NULL AUTO_INCREMENT,
  `floor_area` varchar(255) DEFAULT NULL,
  `floor_capacity` varchar(255) DEFAULT NULL,
  `floor_code` varchar(255) DEFAULT NULL,
  `floor_delete_flag` bit(1) DEFAULT NULL,
  `floor_name` varchar(255) DEFAULT NULL,
  `floor_status_id` int NOT NULL,
  `floor_type_id` int NOT NULL,
  PRIMARY KEY (`floor_id`),
  KEY `FK8qqh4r58pfsw7ilfvl9uexy1t` (`floor_status_id`),
  KEY `FKt6ggncxpasna7ml7f6ii9ucpq` (`floor_type_id`),
  CONSTRAINT `FK8qqh4r58pfsw7ilfvl9uexy1t` FOREIGN KEY (`floor_status_id`) REFERENCES `floors_status` (`floor_status_id`),
  CONSTRAINT `FKt6ggncxpasna7ml7f6ii9ucpq` FOREIGN KEY (`floor_type_id`) REFERENCES `floors_type` (`floor_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `floors`
--

LOCK TABLES `floors` WRITE;
/*!40000 ALTER TABLE `floors` DISABLE KEYS */;
INSERT INTO `floors` VALUES (1,'100','10','MTL001',_binary '\0','T????ng 1',1,1),(2,'200','20','MTL002',_binary '\0','T????ng 2',2,2),(3,'300','30','MTL003',_binary '\0','T????ng 3',3,3),(4,'400','40','MTL004',_binary '\0','T????ng 4',1,4),(5,'500','50','MTL005',_binary '\0','T????ng 5',2,5);
/*!40000 ALTER TABLE `floors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `floors_status`
--

DROP TABLE IF EXISTS `floors_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `floors_status` (
  `floor_status_id` int NOT NULL AUTO_INCREMENT,
  `floor_status_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`floor_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `floors_status`
--

LOCK TABLES `floors_status` WRITE;
/*!40000 ALTER TABLE `floors_status` DISABLE KEYS */;
INSERT INTO `floors_status` VALUES (1,'Ch??a ba??n giao'),(2,'??ang va??o ????'),(3,'??ang s????a ch????a');
/*!40000 ALTER TABLE `floors_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `floors_type`
--

DROP TABLE IF EXISTS `floors_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `floors_type` (
  `floor_type_id` int NOT NULL AUTO_INCREMENT,
  `floor_type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`floor_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `floors_type`
--

LOCK TABLES `floors_type` WRITE;
/*!40000 ALTER TABLE `floors_type` DISABLE KEYS */;
INSERT INTO `floors_type` VALUES (1,'T????ng tr????t'),(2,'T????ng tr??n'),(3,'T????ng h????m'),(4,'T????ng l????ng'),(5,'T????ng th??????ng');
/*!40000 ALTER TABLE `floors_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_EMPLOYEE');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spaces`
--

DROP TABLE IF EXISTS `spaces`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spaces` (
  `space_id` int NOT NULL AUTO_INCREMENT,
  `space_area` varchar(255) DEFAULT NULL,
  `space_code` varchar(255) DEFAULT NULL,
  `space_delete_flag` bit(1) DEFAULT NULL,
  `space_image` varchar(255) DEFAULT NULL,
  `space_manager_fee` varchar(255) DEFAULT NULL,
  `space_note` varchar(255) DEFAULT NULL,
  `space_price` varchar(255) DEFAULT NULL,
  `floor_id` int NOT NULL,
  `space_status_id` int NOT NULL,
  `space_type_id` int NOT NULL,
  PRIMARY KEY (`space_id`),
  KEY `FK7b5xxpjod1855phf4h9v3s3x3` (`floor_id`),
  KEY `FKq969ojnjc0ujahj7sffuysych` (`space_status_id`),
  KEY `FKd49rr414iyb4dsqt0fvv0fh19` (`space_type_id`),
  CONSTRAINT `FK7b5xxpjod1855phf4h9v3s3x3` FOREIGN KEY (`floor_id`) REFERENCES `floors` (`floor_id`),
  CONSTRAINT `FKd49rr414iyb4dsqt0fvv0fh19` FOREIGN KEY (`space_type_id`) REFERENCES `spaces_type` (`space_type_id`),
  CONSTRAINT `FKq969ojnjc0ujahj7sffuysych` FOREIGN KEY (`space_status_id`) REFERENCES `spaces_status` (`space_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spaces`
--

LOCK TABLES `spaces` WRITE;
/*!40000 ALTER TABLE `spaces` DISABLE KEYS */;
INSERT INTO `spaces` VALUES (1,'50','MB-001',_binary '\0','https://firebasestorage.googleapis.com/v0/b/sprint1-employee.appspot.com/o/5.jpg?alt=media&token=c5f58428-f2df-4e35-918d-fb3b45556f4a','1000000','???? cho thu??','3000000',1,1,1),(2,'60','MB-002',_binary '\0','https://firebasestorage.googleapis.com/v0/b/building-manager-6262e.appspot.com/o/5b0b905d673[???]?alt=media&token=024a8daa-b510-428a-b10b-0e9758b2b290','2000000','ch??a thu??','4000000',1,2,2),(3,'70','MB-003',_binary '\0','https://firebasestorage.googleapis.com/v0/b/building-manager-6262e.appspot.com/o/5b0b905d673[???]?alt=media&token=024a8daa-b510-428a-b10b-0e9758b2b290','3000000','??ang s???a','5000000',2,3,3),(4,'80','MB-004',_binary '\0','https://firebasestorage.googleapis.com/v0/b/building-manager-6262e.appspot.com/o/5b0b905d673[???]?alt=media&token=024a8daa-b510-428a-b10b-0e9758b2b290','4000000','kh??ng c??','6000000',2,3,2),(5,'90','MB-004',_binary '\0','https://firebasestorage.googleapis.com/v0/b/building-manager-6262e.appspot.com/o/5b0b905d673[???]?alt=media&token=024a8daa-b510-428a-b10b-0e9758b2b290','5000000','kh??ng c??','7000000',3,3,3),(6,'100','MB-005',_binary '\0','https://firebasestorage.googleapis.com/v0/b/building-manager-6262e.appspot.com/o/5b0b905d673[???]?alt=media&token=024a8daa-b510-428a-b10b-0e9758b2b290','5000000','kh??ng c??','9000000',3,2,1),(7,'50','MB-006',_binary '\0','https://firebasestorage.googleapis.com/v0/b/building-manager-6262e.appspot.com/o/5b0b905d673[???]?alt=media&token=024a8daa-b510-428a-b10b-0e9758b2b290','1000000','kh??ng c??','5000000',4,2,2),(8,'80','MB-007',_binary '\0','https://firebasestorage.googleapis.com/v0/b/building-manager-6262e.appspot.com/o/5b0b905d673[???]?alt=media&token=024a8daa-b510-428a-b10b-0e9758b2b290','1000000','kh??ng c??','6000000',4,2,1),(9,'100','MB-999',_binary '\0',NULL,'20000000','Kh??ng c??','30000000',1,1,1);
/*!40000 ALTER TABLE `spaces` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spaces_status`
--

DROP TABLE IF EXISTS `spaces_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spaces_status` (
  `space_status_id` int NOT NULL AUTO_INCREMENT,
  `spacer_status_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`space_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spaces_status`
--

LOCK TABLES `spaces_status` WRITE;
/*!40000 ALTER TABLE `spaces_status` DISABLE KEYS */;
INSERT INTO `spaces_status` VALUES (1,'Ch??a v??o ???'),(2,'???? v??o ???'),(3,'Ch??a b??n giao'),(4,'??ang s???a ch???a');
/*!40000 ALTER TABLE `spaces_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spaces_type`
--

DROP TABLE IF EXISTS `spaces_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spaces_type` (
  `space_type_id` int NOT NULL AUTO_INCREMENT,
  `space_type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`space_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spaces_type`
--

LOCK TABLES `spaces_type` WRITE;
/*!40000 ALTER TABLE `spaces_type` DISABLE KEYS */;
INSERT INTO `spaces_type` VALUES (1,'M???t ?????ng'),(2,'M???t ti???n'),(3,'M???t c???t');
/*!40000 ALTER TABLE `spaces_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-25 21:11:06

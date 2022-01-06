CREATE DATABASE  IF NOT EXISTS `transplux` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `transplux`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: transplux
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `default_name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Jet-Ski'),(2,'Light-Aircraft'),(3,'Private-Jet'),(4,'Sport-Car'),(5,'Yacht');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `language` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `language`
--

LOCK TABLES `language` WRITE;
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT INTO `language` VALUES (1,'fr'),(2,'en');
/*!40000 ALTER TABLE `language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineitem`
--

DROP TABLE IF EXISTS `lineitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lineitem` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `real_Price` double NOT NULL,
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  PRIMARY KEY (`id`,`order_id`),
  KEY `FKLineItem201054` (`product_id`),
  KEY `FKLineItem230087` (`order_id`),
  CONSTRAINT `FKLineItem201054` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKLineItem230087` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`),
  CONSTRAINT `lineitem_chk_1` CHECK ((`quantity` > 0)),
  CONSTRAINT `lineitem_chk_2` CHECK ((`real_price` > 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineitem`
--

LOCK TABLES `lineitem` WRITE;
/*!40000 ALTER TABLE `lineitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `lineitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `is_paid` bit(1) DEFAULT NULL,
  `user_email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKOrder389838` (`user_email`),
  CONSTRAINT `FKOrder389838` FOREIGN KEY (`user_email`) REFERENCES `user` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `label` varchar(20) NOT NULL,
  `description` varchar(100) NOT NULL,
  `price` double NOT NULL,
  `promotion_id` int DEFAULT NULL,
  `category_id` int NOT NULL,
  `product_image` varchar(100) DEFAULT NULL,
  `product_logo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKProduct850050` (`category_id`),
  KEY `FKProduct712391` (`promotion_id`),
  CONSTRAINT `FKProduct712391` FOREIGN KEY (`promotion_id`) REFERENCES `promotion` (`id`),
  CONSTRAINT `FKProduct850050` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `product_chk_1` CHECK ((`price` > 0))
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Kawasaki STX 160','The fastest jet-ski in the world',14849,1,1,'images/products/Jet_Ski/Kawasaki_STX_160.png','images/products/Jet_Ski/Kawasaki_STX_160_Logo.png'),(2,'Daher Socata TBM 940','To go where you want to go',4000000,NULL,2,'images/products/Light_Aircraft/Daher_Socata_TBM_940.jpg','images/products/Light_Aircraft/Daher_Socata_TBM_940_Logo.jpg'),(3,'Piper M600','Fly like a pro',1000000,NULL,2,'images/products/Light_Aircraft/Piper_M600.jpg','images/products/Light_Aircraft/Piper_M600_Logo.png'),(4,'Cessna Citation M2','Perfect for the best CTO',3000000,NULL,3,'images/products/Private_Jet/Cessna_Citation_M2.jpg','images/products/Private_Jet/Cessna_Citation_M2_Logo.png'),(5,'BMW I8','Fell the power',142200,NULL,4,'images/products/Sport_Car/bmw_i8.jpg','images/products/Sport_Car/bmw_i8_Logo.png'),(6,'Porsche 911','The true car',125792,NULL,4,'images/products/Sport_Car/Porsche_911.png','images/products/Sport_Car/Porsche_911_Logo.png'),(7,'DOJO','For your best cruises',10000000,NULL,5,'images/products/Yacht/DOJO.jpg','images/products/Yacht/DOJO_Logo.png');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `promotion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `starting_date` datetime NOT NULL,
  `ending_date` datetime NOT NULL,
  `percentage` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `promotion_chk_1` CHECK ((`percentage` > 0)),
  CONSTRAINT `promotion_chk_2` CHECK ((`percentage` < 100))
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion`
--

LOCK TABLES `promotion` WRITE;
/*!40000 ALTER TABLE `promotion` DISABLE KEYS */;
INSERT INTO `promotion` VALUES (1,'2021-12-30 00:00:00','2022-10-10 00:00:00',20);
/*!40000 ALTER TABLE `promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `translation`
--

DROP TABLE IF EXISTS `translation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `translation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `category_id` int NOT NULL,
  `language_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `product_translation_uk` (`category_id`,`language_id`),
  KEY `FKTranslatio400571` (`language_id`),
  CONSTRAINT `FKTranslatio161934` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKTranslatio400571` FOREIGN KEY (`language_id`) REFERENCES `language` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `translation`
--

LOCK TABLES `translation` WRITE;
/*!40000 ALTER TABLE `translation` DISABLE KEYS */;
INSERT INTO `translation` VALUES (1,'Jet-Ski',1,1),(2,'Jet-ski',1,2),(3,'Avions légers',2,1),(4,'Light Aircraft',2,2),(5,'Jet privé',3,1),(6,'Private jet',3,2),(7,'Voiture de sport',4,1),(8,'Sport car',4,2),(9,'Yacht',5,1),(10,'Yacht',5,2);
/*!40000 ALTER TABLE `translation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `email` varchar(50) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `male` tinyint(1) NOT NULL,
  `city` varchar(20) NOT NULL,
  `country` varchar(20) NOT NULL,
  `password` varchar(200) NOT NULL,
  `zip_code` int NOT NULL,
  `address` varchar(100) NOT NULL,
  `favorite_animal` varchar(45) DEFAULT NULL,
  `phone` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `authorities` varchar(45) NOT NULL DEFAULT 'ROLE_USER',
  `non_expired` tinyint(1) NOT NULL DEFAULT '1',
  `non_locked` tinyint(1) NOT NULL DEFAULT '1',
  `credentials_non_expired` tinyint(1) NOT NULL DEFAULT '1',
  `enable` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('manager@outlook.com','Isaline','Didier',0,'Sensenruth','Uzbekistan','$2a$10$63k3PJULkVlHYW7WrNLXXOENchLrFJQpJQm1dRbo4omm49GFrraRa',6832,'Rue des Minières 6','','473507157','isaline','ROLE_USER',1,1,1,1),('manr@outlook.com','Isaline','Didier',0,'Sensenruth','Uzbekistan','$2a$10$bUBwdPKxchToD1KLN7wwHONAkj.b3PEovXQbo3wgVUY7ExTTLgCoO',6832,'Rue des Minières 6','','473507157','isaline2','ROLE_USER',1,1,1,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-06  2:27:56

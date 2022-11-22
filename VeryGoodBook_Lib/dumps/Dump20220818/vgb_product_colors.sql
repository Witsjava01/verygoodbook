-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: vgb
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `product_colors`
--

DROP TABLE IF EXISTS `product_colors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_colors` (
  `product_id` int NOT NULL,
  `color_name` varchar(10) NOT NULL,
  `photo_url` varchar(250) DEFAULT NULL,
  `icon_url` varchar(250) DEFAULT NULL,
  `stock` int NOT NULL,
  PRIMARY KEY (`product_id`,`color_name`),
  CONSTRAINT `fkey_product_colors_TO_products` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_colors`
--

LOCK TABLES `product_colors` WRITE;
/*!40000 ALTER TABLE `product_colors` DISABLE KEYS */;
INSERT INTO `product_colors` VALUES (12,'紅','https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/127/90/N001279019.jpg&v=6045db9ck&w=348&h=348',NULL,5),(12,'芥黃','https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/127/75/N001277566.jpg&w=348&h=348&v=603f2e52k','https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/127/75/N001277566.jpg&w=85&h=85&v=603f2e52k',12),(12,'藍','https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/127/75/N001277562.jpg&v=6045db9ck&w=348&h=348','https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/127/75/N001277562.jpg&v=603f2e52k&w=85&h=85',11),(14,'螢光黃','https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/142/82/N001428261.jpg&v=628b3961k&w=348&h=348','https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/142/82/N001428261.jpg&v=628b3961k&w=85&h=85',10),(15,'櫻花粉','https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/084/29/N000842993.jpg&v=62c28d21k&w=348&h=348','https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/084/29/N000842993.jpg&v=62c28d21k&w=85&h=85',10),(15,'湖水綠','https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/084/29/N000842992.jpg&v=62c28c6ck&w=348&h=348','https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/084/29/N000842992.jpg&v=62c28c6ck&w=85&h=85',3),(15,'藍','https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/019/62/N000196271.jpg&v=62c28d20k&w=348&h=348','https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/019/62/N000196271.jpg&v=62c28d20k&w=85&h=85',8),(16,'薄荷綠','https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/141/44/N001414445.jpg&v=62454415k&w=348&h=348','https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/141/44/N001414445.jpg&v=62454415k&w=85&h=85',11),(16,'黑','https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/141/44/N001414444.jpg&w=348&h=348&v=62454415','https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/141/44/N001414444.jpg&w=85&h=85&v=62454415',5),(19,'白','https://www.9x9.tw/public/files/product/N91827-54377S.jpg',NULL,30),(19,'黑','https://www.9x9.tw/public/files/product/thumb/N51202-53104S.jpg',NULL,15);
/*!40000 ALTER TABLE `product_colors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-18 11:12:59

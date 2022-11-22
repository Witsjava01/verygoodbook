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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `unit_price` double NOT NULL,
  `stock` int NOT NULL,
  `photo_url` varchar(250) DEFAULT NULL,
  `description` varchar(300) NOT NULL DEFAULT '',
  `launch_date` date NOT NULL DEFAULT (curdate()),
  `category` varchar(20) NOT NULL DEFAULT '',
  `discount` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Java SE 17 技術手冊',680,12,'https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/092/37/0010923732.jpg&w=374&h=374&v=626bbe47','‧基於Java 17 LTS版本！涵蓋Java 15至17新特性 \r ‧增加HTTP Client API介紹 \r ‧作者十幾年實務教育訓練中，匯整學員遇到的觀念、實作、應用等問題的經驗集合。\r ‧必要時從Java SE API的原始碼分析，了解各語法在Java SE API中如何應用。\r ‧涵蓋Java 15至17的文字區塊、模式比對、record/sealed等新特性。\r ‧建議練習的範例提供Lab檔案，更能掌握練習重點。\r ‧IDE操作為本書教學內容之一，更能與實務結合','2022-07-01','書籍',21),(2,'最新 Java 程式語言 修訂第七版',680,8,'https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/091/85/0010918576.jpg&w=374&h=374&v=62204450','本書從第一版出版至今已超過 15 個年頭，累積銷量超過 5 萬冊，是最受好評的 Java 入門教材。期間配合 Java 版本的演進歷經多次改版，每次改版都匯集了眾多讀者、教師的意見，適當增加了新的題材與語法， 同時也因應不同世代的需求，刪除過時的內容，\n務求讓書中內容更簡明易懂、更符合初學者的需求。\nJava 語言一直是企業界最愛用的語言，因此我們期許讀者不僅撰寫出可編譯、可執行的 Java 程式，更重要的是要瞭解良好的程式設計方法。','2022-07-01','書籍',5),(3,'Java SE 17基礎必修課(適用Java 17~10，涵蓋ITS Java國際認證)',560,9,'https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/092/68/0010926843.jpg&v=629dd745k&w=348&h=348','扎實Java程式設計訓練，培養程式設計與運算思維能力，為您打下輕鬆考取ITS Java國際認證能力! \n\n※專家與教師共同執筆\n由OCJP與ITS Java認證講師、科技大學教授Java程式設計資深教師共同編著，針對目前初學者學習Java程式設計必備技能所撰寫的教材。','2022-07-21','書籍',21),(4,'Java最強入門邁向頂尖高手之路：王者歸來(第二版)全彩版',1000,11,'https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/087/31/0010873110.jpg&w=374&h=374&v=5f7c475b','很早就想改版第一版的書籍，歷經多時的醞釀與投入，終於完成這本書著作的改版，心情是愉快的，因為我相信只要讀者購買本書遵循本書實例，一定可以輕輕鬆鬆快快樂樂學會Java語法與應用，逐步讓自己往Java頂尖高手之路邁進，這也是撰寫本書的目的。','2022-07-21','書籍',21),(5,'圖說演算法：使用Java',490,9,'https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/084/55/0010845577.jpg&w=187&h=187&v=5e0b2337','','2022-07-21','書籍',10),(11,'[MUJI無印良品]繪圖色鉛筆/12色(R)',145,8,'https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/100/24/N001002483.jpg&w=348&h=348&v=5d22e5b9','','2022-07-27','文具',0),(12,'[MUJI無印良品]水性繪筆',39,28,'https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/127/75/N001277566.jpg&w=348&h=348&v=603f2e52k','品名：水性繪筆.淡藍\n商品說明：沈穩柔和的色調，顏色互相搭配性高。滑順書寫感為其特色。\n規格：淡藍\n材質：筆蓋、筆管:聚丙烯\n產地：日本。','2022-07-27','文具',0),(13,'【德國LYRA】Groove三角洞洞色鉛筆(10色)',720,8,'https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/007/38/N000073899.jpg&v=56137711k&w=348&h=348','','2022-08-01','文具',20),(14,'【德國LYRA】Groove三角洞洞色鉛筆-螢光色系(同色6入)',360,28,'https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/142/82/N001428261.jpg&v=628b3961k&w=348&h=348','','2022-08-01','文具',20),(15,'【德國LYRA】Groove三角洞洞鉛筆(同色6入)',360,50,'https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/084/29/N000842993.jpg&v=62c28d21k&w=348&h=348','','2022-08-01','文具',25),(16,'KUTSUWA Dr.compass 自動筆圓規',225,14,'https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/141/44/N001414444.jpg&w=187&h=187&v=62454415','','2022-08-01','文具',0),(18,'Java學習手冊 第五版',780,2,'https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/091/08/0010910870.jpg&v=61af37eak&w=348&h=348','針對Java及程式設計初學者，這本暢銷書介紹涵蓋至Java 11的程式語言功能與API。本書三位作者以建立實務應用程式為目標，透過有趣、完整與實際的案例，完整介紹Java基礎知識。包含類別函式庫、程式設計技巧及常見作法。\n讀者將會學到管理應用程式資源的新方法，以及最新Java核心語言功能。','2022-08-03','書籍',10);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-04 19:26:44

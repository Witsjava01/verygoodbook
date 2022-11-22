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
-- Temporary view structure for view `products_list_view`
--

DROP TABLE IF EXISTS `products_list_view`;
/*!50001 DROP VIEW IF EXISTS `products_list_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `products_list_view` AS SELECT 
 1 AS `id`,
 1 AS `name`,
 1 AS `color_name`,
 1 AS `unit_price`,
 1 AS `min_size_price`,
 1 AS `max_size_price`,
 1 AS `stock`,
 1 AS `photo_url`,
 1 AS `category`,
 1 AS `launch_date`,
 1 AS `discount`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `product_detail_view`
--

DROP TABLE IF EXISTS `product_detail_view`;
/*!50001 DROP VIEW IF EXISTS `product_detail_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `product_detail_view` AS SELECT 
 1 AS `id`,
 1 AS `product_id`,
 1 AS `name`,
 1 AS `color_name`,
 1 AS `size_color`,
 1 AS `size_count`,
 1 AS `unit_price`,
 1 AS `stock`,
 1 AS `color_stock`,
 1 AS `photo_url`,
 1 AS `description`,
 1 AS `launch_date`,
 1 AS `category`,
 1 AS `discount`,
 1 AS `color_photo`,
 1 AS `icon_url`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `products_list_view`
--

/*!50001 DROP VIEW IF EXISTS `products_list_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `products_list_view` AS select `products`.`id` AS `id`,`products`.`name` AS `name`,`product_colors`.`color_name` AS `color_name`,ifnull(min(`product_color_sizes`.`unit_price`),`products`.`unit_price`) AS `unit_price`,min(`product_color_sizes`.`unit_price`) AS `min_size_price`,max(`product_color_sizes`.`unit_price`) AS `max_size_price`,ifnull(ifnull(sum(`product_color_sizes`.`stock`),sum(`product_colors`.`stock`)),`products`.`stock`) AS `stock`,ifnull(`product_colors`.`photo_url`,`products`.`photo_url`) AS `photo_url`,`products`.`category` AS `category`,`products`.`launch_date` AS `launch_date`,`products`.`discount` AS `discount` from ((`products` left join `product_colors` on((`products`.`id` = `product_colors`.`product_id`))) left join `product_color_sizes` on(((`products`.`id` = `product_color_sizes`.`product_id`) and ((`product_colors`.`color_name` = `product_color_sizes`.`color_name`) or (`product_colors`.`color_name` is null))))) group by `products`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `product_detail_view`
--

/*!50001 DROP VIEW IF EXISTS `product_detail_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `product_detail_view` AS select `products`.`id` AS `id`,`product_colors`.`product_id` AS `product_id`,`products`.`name` AS `name`,`product_colors`.`color_name` AS `color_name`,`product_color_sizes`.`color_name` AS `size_color`,count(`product_color_sizes`.`size_name`) AS `size_count`,ifnull(min(`product_color_sizes`.`unit_price`),`products`.`unit_price`) AS `unit_price`,ifnull(sum(`product_color_sizes`.`stock`),`products`.`stock`) AS `stock`,ifnull(sum(`product_color_sizes`.`stock`),`product_colors`.`stock`) AS `color_stock`,`products`.`photo_url` AS `photo_url`,`products`.`description` AS `description`,`products`.`launch_date` AS `launch_date`,`products`.`category` AS `category`,`products`.`discount` AS `discount`,`product_colors`.`photo_url` AS `color_photo`,ifnull(`product_colors`.`icon_url`,`product_colors`.`photo_url`) AS `icon_url` from ((`products` left join `product_colors` on((`products`.`id` = `product_colors`.`product_id`))) left join `product_color_sizes` on(((`products`.`id` = `product_color_sizes`.`product_id`) and ((`product_colors`.`color_name` = `product_color_sizes`.`color_name`) or (`product_colors`.`color_name` is null))))) group by `products`.`id`,`product_colors`.`color_name` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-18 11:12:59

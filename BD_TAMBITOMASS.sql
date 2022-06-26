CREATE DATABASE  IF NOT EXISTS `tambito_sistema_expericias_formativas_proyecto` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tambito_sistema_expericias_formativas_proyecto`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: tambito_sistema_expericias_formativas_proyecto
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
-- Table structure for table `cat_producto`
--

DROP TABLE IF EXISTS `cat_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cat_producto` (
  `cod_cat` int NOT NULL AUTO_INCREMENT,
  `des_cat` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`cod_cat`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat_producto`
--

LOCK TABLES `cat_producto` WRITE;
/*!40000 ALTER TABLE `cat_producto` DISABLE KEYS */;
INSERT INTO `cat_producto` VALUES (1,'Bebidas'),(2,'Snack'),(3,'Postres');
/*!40000 ALTER TABLE `cat_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `DNI` char(8) NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `numtelefono` varchar(20) DEFAULT NULL,
  `dirección` varchar(100) DEFAULT NULL,
  `pais` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'71693471','Brando','Carquin','986825701','av.Morales duares','Peru'),(2,'70477605','Sebastian','Navarro','932401869','av.Marino Condorcanqui 1604','Peru'),(3,'46286106','Carlos','Arnao','966852147','av.Pardo 852','Peru'),(4,'09757650','Walter','Ramos','997779908','av.Canada 475','Peru'),(5,'10756963','Jorge','Bardales','945125863','av. Lima 874','Peru');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `idEmpleado` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(15) DEFAULT NULL,
  `apellido` varchar(15) DEFAULT NULL,
  `DNI` char(8) DEFAULT NULL,
  `telefono` char(9) DEFAULT NULL,
  `correo` varchar(25) DEFAULT NULL,
  `categoria` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`idEmpleado`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'Julián','Martine','12345678','987456213','julian123@gmail.com','Cajero'),(2,'Mario ','Fernandez','21365487','965245613','mario123@gmail.com','Vendedor'),(3,'Roberto','Sanchez','51426387','985214763','roberto123@gmail.com','Limpieza'),(4,'Renzo Agustín','Villanueva','42635187','985471236','renzo123@gmail.com','Reponedor'),(5,'Jorge Luis','Robles','78542163','965214783','jorge123@gmail.com','Administrador');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden_compra`
--

DROP TABLE IF EXISTS `orden_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orden_compra` (
  `idOrden` int NOT NULL AUTO_INCREMENT,
  `idCliente` int NOT NULL,
  `idEmpleado` int NOT NULL,
  `ordenFecha` datetime DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`idOrden`,`idCliente`,`idEmpleado`),
  KEY `FK_idCliente_Orden_idx` (`idCliente`),
  KEY `FK_idEmpleado_Orden_idx` (`idEmpleado`),
  CONSTRAINT `FK_idCliente_Orden` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `FK_idEmpleado_Orden` FOREIGN KEY (`idEmpleado`) REFERENCES `empleado` (`idEmpleado`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden_compra`
--

LOCK TABLES `orden_compra` WRITE;
/*!40000 ALTER TABLE `orden_compra` DISABLE KEYS */;
INSERT INTO `orden_compra` VALUES (2,1,1,'2022-06-06 23:46:01',29),(3,1,1,'2022-06-06 23:52:05',37.5),(4,1,1,'2022-06-06 23:57:20',35.6),(5,1,1,'2022-06-06 23:58:41',35.6),(6,1,1,'2022-06-06 23:59:06',35.6),(7,1,1,'2022-06-07 19:59:24',46),(8,1,1,'2022-06-07 20:11:19',94.4),(9,1,1,'2022-06-07 20:56:17',94.4),(10,1,1,'2022-06-07 20:56:20',94.4),(11,1,1,'2022-06-07 20:59:52',46),(12,1,1,'2022-06-07 21:00:08',46),(13,1,1,'2022-06-08 08:26:57',81.8),(14,1,1,'2022-06-08 08:27:47',81.8),(15,1,1,'2022-06-08 09:24:07',46),(16,1,1,'2022-06-08 09:26:35',46),(17,1,1,'2022-06-26 09:32:36',46),(18,1,1,'2022-06-26 10:23:00',158.5);
/*!40000 ALTER TABLE `orden_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden_detalle`
--

DROP TABLE IF EXISTS `orden_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orden_detalle` (
  `idOrden` int NOT NULL,
  `idProducto` int NOT NULL,
  `cantidad` smallint DEFAULT NULL,
  `subtotal` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idOrden`,`idProducto`),
  KEY `Fk_idProdcuto_producto_idx` (`idProducto`),
  CONSTRAINT `Fk_idOrden_orden` FOREIGN KEY (`idOrden`) REFERENCES `orden_compra` (`idOrden`),
  CONSTRAINT `Fk_idProdcuto_producto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden_detalle`
--

LOCK TABLES `orden_detalle` WRITE;
/*!40000 ALTER TABLE `orden_detalle` DISABLE KEYS */;
INSERT INTO `orden_detalle` VALUES (6,1,2,29.00),(6,3,3,6.60),(7,1,2,29.00),(7,2,2,17.00),(8,1,2,29.00),(8,2,2,17.00),(8,4,2,48.40),(9,1,2,29.00),(9,2,2,17.00),(9,4,2,48.40),(11,1,2,29.00),(11,2,2,17.00),(13,1,2,29.00),(13,3,2,4.40),(13,4,2,48.40),(15,1,2,29.00),(15,2,2,17.00),(16,1,2,29.00),(16,2,2,17.00),(17,1,2,29.00),(17,2,2,17.00),(18,1,8,116.00),(18,2,5,42.50);
/*!40000 ALTER TABLE `orden_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idProducto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `categoria` int DEFAULT NULL,
  `fechaRegistro` datetime DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `stock` smallint DEFAULT NULL,
  `peso` varchar(15) DEFAULT NULL,
  `cantidadPeso` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `categoria_idx` (`categoria`),
  CONSTRAINT `FK_Cat_Pro` FOREIGN KEY (`categoria`) REFERENCES `cat_producto` (`cod_cat`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'papas',1,NULL,14.50,0,'Gramos',5.00),(2,'gaseosa',1,'2022-06-02 14:34:44',8.50,15,'Litros',2.50),(3,'Chicha',1,'2022-06-02 14:42:08',2.20,15,'Militros',500.00),(4,'adgadg',2,'2022-06-02 14:44:15',24.20,0,'Litros',24.60);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `idProveedor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `ruc` char(11) DEFAULT NULL,
  `producto` varchar(100) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `pais` varchar(100) DEFAULT NULL,
  `telefono` char(20) DEFAULT NULL,
  `fechaRegistro` datetime DEFAULT NULL,
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'Coca Cola Company','78951123844','Coca Cola','Av tomas Valle 471','cocaCola@gmail.com','Perú','987456321','2022-06-26 11:02:48'),(2,'Lays','98745632145','Doritos','Av Arriola 582','lays@gmail.com','Bolivia','974562148','2022-06-26 11:02:48'),(3,'Aje Group','14785696245','Volt','Av San miguel 785','aje@gmail.com','Perú','984563214','2022-06-26 11:02:48'),(4,'Pingles','10257585966','Papas Pingles','Av Universitaria 147','pingles@gmail.com','Perú','921456357','2022-06-26 11:02:48'),(5,'Field','78951123844','Choco Soda','Av tomas Valle 471','field@gmail.com','Perú','954126873','2022-06-26 11:02:48');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'tambito_sistema_expericias_formativas_proyecto'
--

--
-- Dumping routines for database 'tambito_sistema_expericias_formativas_proyecto'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_buscar_pro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_pro`(
in nombre varchar(40)
)
BEGIN
	select * from producto where nombre like concat('%' ,nombre, '%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-26 11:16:54

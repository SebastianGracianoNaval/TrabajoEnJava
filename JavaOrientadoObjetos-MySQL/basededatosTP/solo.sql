-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fretesgracianoespejo
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `idCategorias` int NOT NULL AUTO_INCREMENT,
  `nombreCategoria` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCategorias`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jornada`
--

DROP TABLE IF EXISTS `jornada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jornada` (
  `idJornada` int NOT NULL AUTO_INCREMENT,
  `tituloJornada` varchar(45) DEFAULT NULL,
  `objetivoJornada` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idJornada`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jornada`
--

LOCK TABLES `jornada` WRITE;
/*!40000 ALTER TABLE `jornada` DISABLE KEYS */;
/*!40000 ALTER TABLE `jornada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `idMaterial` int NOT NULL AUTO_INCREMENT,
  `tituloMaterial` varchar(45) DEFAULT NULL,
  `categoriaMaterial` varchar(45) DEFAULT NULL,
  `fuenteMaterial` varchar(45) DEFAULT NULL,
  `enlaceMaterial` varchar(45) DEFAULT NULL,
  `procedenciaMaterial` varchar(45) DEFAULT NULL,
  `Jornada_idJornada` int NOT NULL,
  `prioridad` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`idMaterial`,`Jornada_idJornada`),
  KEY `fk_Material_Jornada1_idx` (`Jornada_idJornada`),
  CONSTRAINT `fk_Material_Jornada1` FOREIGN KEY (`Jornada_idJornada`) REFERENCES `jornada` (`idJornada`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material/propuesta`
--

DROP TABLE IF EXISTS `material/propuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material/propuesta` (
  `Propuestas_idPropuestas` int NOT NULL,
  `Material_idMaterial` int NOT NULL,
  PRIMARY KEY (`Propuestas_idPropuestas`,`Material_idMaterial`),
  KEY `fk_material/propuesta_Material1_idx` (`Material_idMaterial`),
  CONSTRAINT `fk_material/propuesta_Material1` FOREIGN KEY (`Material_idMaterial`) REFERENCES `material` (`idMaterial`),
  CONSTRAINT `fk_material/propuesta_Propuestas` FOREIGN KEY (`Propuestas_idPropuestas`) REFERENCES `propuestas` (`idPropuestas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material/propuesta`
--

LOCK TABLES `material/propuesta` WRITE;
/*!40000 ALTER TABLE `material/propuesta` DISABLE KEYS */;
/*!40000 ALTER TABLE `material/propuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propuestas`
--

DROP TABLE IF EXISTS `propuestas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `propuestas` (
  `idPropuestas` int NOT NULL AUTO_INCREMENT,
  `tituloPropuesta` varchar(45) DEFAULT NULL,
  `autorPropuesta` varchar(45) DEFAULT NULL,
  `estadoPropuesta` varchar(45) DEFAULT NULL,
  `descripcionPropuesta` varchar(45) DEFAULT NULL,
  `motivoRechazoPropuesta` varchar(45) DEFAULT NULL,
  `origenPropuesta` varchar(45) DEFAULT NULL,
  `motivacionPropuesta` varchar(45) DEFAULT NULL,
  `fechaPropuesta` date DEFAULT NULL,
  `Categorias_idCategorias` int NOT NULL,
  PRIMARY KEY (`idPropuestas`,`Categorias_idCategorias`),
  KEY `fk_Propuestas_Categorias1_idx` (`Categorias_idCategorias`),
  CONSTRAINT `fk_Propuestas_Categorias1` FOREIGN KEY (`Categorias_idCategorias`) REFERENCES `categorias` (`idCategorias`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propuestas`
--

LOCK TABLES `propuestas` WRITE;
/*!40000 ALTER TABLE `propuestas` DISABLE KEYS */;
/*!40000 ALTER TABLE `propuestas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-09 14:19:12

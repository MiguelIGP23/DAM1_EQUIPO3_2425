CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.4.0

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
-- Table structure for table `actividad`
--

DROP TABLE IF EXISTS `actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actividad` (
  `idActividad` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `rutas_idRuta` int NOT NULL,
  PRIMARY KEY (`idActividad`),
  KEY `fk_actividad_rutas1_idx` (`rutas_idRuta`),
  CONSTRAINT `fk_actividad_rutas1` FOREIGN KEY (`rutas_idRuta`) REFERENCES `rutas` (`idRuta`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--

LOCK TABLES `actividad` WRITE;
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
INSERT INTO `actividad` VALUES (1,'Tiro con arco',1);
/*!40000 ALTER TABLE `actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calendario`
--

DROP TABLE IF EXISTS `calendario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calendario` (
  `idCalendario` int NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `detalles` text,
  `recomendaciones` text,
  `rutas_idRuta` int NOT NULL,
  `usuario_idUsuario` int NOT NULL,
  PRIMARY KEY (`idCalendario`),
  KEY `fk_calendario_rutas1_idx` (`rutas_idRuta`),
  KEY `fk_calendario_usuario1_idx` (`usuario_idUsuario`),
  CONSTRAINT `fk_calendario_rutas1` FOREIGN KEY (`rutas_idRuta`) REFERENCES `rutas` (`idRuta`),
  CONSTRAINT `fk_calendario_usuario1` FOREIGN KEY (`usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendario`
--

LOCK TABLES `calendario` WRITE;
/*!40000 ALTER TABLE `calendario` DISABLE KEYS */;
INSERT INTO `calendario` VALUES (1,'2026-05-23 17:30:00','nos vamos de paseo por el campo','traete calzado comodo',1,2),(2,'2025-08-14 20:00:00','partidillo entre colegas','no se me ocurren mas cosas',1,1);
/*!40000 ALTER TABLE `calendario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagenesinteres`
--

DROP TABLE IF EXISTS `imagenesinteres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imagenesinteres` (
  `idimagenesinteres` int NOT NULL AUTO_INCREMENT,
  `url` text NOT NULL,
  `descripcion` text,
  `puntosinteres_idPuntosinteres` int NOT NULL,
  PRIMARY KEY (`idimagenesinteres`),
  KEY `fk_imagenesinteres_puntosinteres1_idx` (`puntosinteres_idPuntosinteres`),
  CONSTRAINT `fk_imagenesinteres_puntosinteres1` FOREIGN KEY (`puntosinteres_idPuntosinteres`) REFERENCES `puntosinteres` (`idPuntosinteres`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagenesinteres`
--

LOCK TABLES `imagenesinteres` WRITE;
/*!40000 ALTER TABLE `imagenesinteres` DISABLE KEYS */;
INSERT INTO `imagenesinteres` VALUES (1,'https://sl.bing.net/kRnqU8lLdf2','foto muy bonita',1);
/*!40000 ALTER TABLE `imagenesinteres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagenespeligro`
--

DROP TABLE IF EXISTS `imagenespeligro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imagenespeligro` (
  `idimagenespeligro` int NOT NULL AUTO_INCREMENT,
  `url` text NOT NULL,
  `descripcion` text,
  `puntospeligro_idPuntosinteres` int NOT NULL,
  PRIMARY KEY (`idimagenespeligro`),
  KEY `fk_imagenespeligro_puntospeligro1_idx` (`puntospeligro_idPuntosinteres`),
  CONSTRAINT `fk_imagenespeligro_puntospeligro1` FOREIGN KEY (`puntospeligro_idPuntosinteres`) REFERENCES `puntospeligro` (`idPuntospeligro`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagenespeligro`
--

LOCK TABLES `imagenespeligro` WRITE;
/*!40000 ALTER TABLE `imagenespeligro` DISABLE KEYS */;
INSERT INTO `imagenespeligro` VALUES (1,'https://sl.bing.net/dhpFQ3mPJS0','cuidado con el agujero',1);
/*!40000 ALTER TABLE `imagenespeligro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntosinteres`
--

DROP TABLE IF EXISTS `puntosinteres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `puntosinteres` (
  `idPuntosinteres` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) NOT NULL,
  `latitud` double NOT NULL,
  `longitud` double NOT NULL,
  `elevacion` double NOT NULL,
  `caracteristicas` text,
  `tipo` enum('histórico-arqueológico',' naturaleza','mirador',' área de descanso','punto de agua','refugio/alojamiento',' cultural',' geológico','fauna específica','botánico') DEFAULT NULL,
  `descripcion` text,
  `timestamp` int DEFAULT NULL,
  `rutas_idRuta` int NOT NULL,
  PRIMARY KEY (`idPuntosinteres`),
  KEY `fk_puntosinteres_rutas1_idx` (`rutas_idRuta`),
  CONSTRAINT `fk_puntosinteres_rutas1` FOREIGN KEY (`rutas_idRuta`) REFERENCES `rutas` (`idRuta`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puntosinteres`
--

LOCK TABLES `puntosinteres` WRITE;
/*!40000 ALTER TABLE `puntosinteres` DISABLE KEYS */;
INSERT INTO `puntosinteres` VALUES (1,'mirador de patos',3.1456,1.254,85,'tranquilo y bonito','mirador','como nadan los patos!',2,1),(2,'fuente de las gaviotas',3.1236,1.365,110,'zona tranquila con sombra','punto de agua','no se que poner',12,1);
/*!40000 ALTER TABLE `puntosinteres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntospeligro`
--

DROP TABLE IF EXISTS `puntospeligro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `puntospeligro` (
  `idPuntospeligro` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) NOT NULL,
  `latitud` double NOT NULL,
  `longitud` double NOT NULL,
  `elevacion` double NOT NULL,
  `kilometros` double DEFAULT NULL,
  `gravedad` tinyint DEFAULT NULL,
  `posicion` int DEFAULT NULL,
  `descripcion` text,
  `timestamp` int DEFAULT NULL,
  `rutas_idRuta` int NOT NULL,
  PRIMARY KEY (`idPuntospeligro`),
  KEY `fk_puntospeligro_rutas1_idx` (`rutas_idRuta`),
  CONSTRAINT `fk_puntospeligro_rutas1` FOREIGN KEY (`rutas_idRuta`) REFERENCES `rutas` (`idRuta`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puntospeligro`
--

LOCK TABLES `puntospeligro` WRITE;
/*!40000 ALTER TABLE `puntospeligro` DISABLE KEYS */;
INSERT INTO `puntospeligro` VALUES (1,'barranco',0.2345,2.2514,150,1,2,1,'cuidado con el agujero',4,1),(2,'ladrones',0.4345,1.2618,90,3,4,2,'cuiado que te sacan la navaja',11,1);
/*!40000 ALTER TABLE `puntospeligro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rutas`
--

DROP TABLE IF EXISTS `rutas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rutas` (
  `idRuta` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `nombre_inicioruta` varchar(45) NOT NULL,
  `nombre_finalruta` varchar(45) NOT NULL,
  `latitudInicial` double NOT NULL,
  `latitudFinal` double NOT NULL,
  `longitudInicial` double NOT NULL,
  `longitudFinal` double NOT NULL,
  `distancia` double NOT NULL,
  `duracion` time NOT NULL,
  `desnivelPositivo` int DEFAULT NULL,
  `desnivelNegativo` int DEFAULT NULL,
  `altitudMax` double DEFAULT NULL,
  `altitudMin` double DEFAULT NULL,
  `clasificacion` enum('circular','lineal') DEFAULT NULL,
  `nivelEsfuerzo` tinyint DEFAULT NULL,
  `nivelRiesgo` tinyint DEFAULT NULL,
  `estadoRuta` tinyint DEFAULT '0',
  `tipoTerreno` tinyint DEFAULT NULL,
  `indicaciones` tinyint DEFAULT NULL,
  `temporadas` set('invierno','verano','otoño','primavera') DEFAULT NULL,
  `accesibilidad` tinyint DEFAULT NULL,
  `rutaFamiliar` tinyint DEFAULT NULL,
  `archivoGPX` text,
  `recomendaciones` text,
  `zonaGeografica` varchar(45) DEFAULT NULL,
  `mediaEstrellas` double DEFAULT NULL,
  `usuario_idUsuario` int NOT NULL,
  PRIMARY KEY (`idRuta`),
  KEY `fk_rutas_usuario1_idx` (`usuario_idUsuario`),
  CONSTRAINT `fk_rutas_usuario1` FOREIGN KEY (`usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rutas`
--

LOCK TABLES `rutas` WRITE;
/*!40000 ALTER TABLE `rutas` DISABLE KEYS */;
INSERT INTO `rutas` VALUES (1,'Paseo por el bosque','Bar manolo','Fuente del rio',0.2345,2.3625,0.2536,2.2345,8.9,'03:26:00',450,270,1300,1150,NULL,NULL,NULL,0,NULL,NULL,'verano,primavera',1,1,NULL,'Lleva cervecitas',NULL,NULL,1),(2,'Subida al everest','salida del bosque','pico mas alto',4.2356,8.3625,4.2476,9.6345,120,'30:15:00',7890,600,8400,1340,NULL,NULL,NULL,0,NULL,NULL,'invierno',1,1,NULL,'Suerte o muerte',NULL,NULL,1);
/*!40000 ALTER TABLE `rutas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(25) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(32) NOT NULL,
  `rol` enum('administrador','diseñador','profesor','alumno') DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'saul','garcia','saul@gmail.com','e19d5cd5af0378da05f63f891c7467af','administrador'),(2,'miguel','ingles','miguel@gmail.com','e19d5cd5af0378da05f63f891c7467af','diseñador'),(3,'manuel','mediavilla','manuel@gmail.com','e19d5cd5af0378da05f63f891c7467af','profesor'),(4,'diego','berdial','diego@gmail.com','e19d5cd5af0378da05f63f891c7467af','alumno');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valora`
--

DROP TABLE IF EXISTS `valora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `valora` (
  `idValora` int NOT NULL AUTO_INCREMENT,
  `dificultad` tinyint NOT NULL,
  `fecha` date NOT NULL,
  `estrellas` tinyint DEFAULT NULL,
  `interesCultural` tinyint DEFAULT NULL,
  `belleza` tinyint DEFAULT NULL,
  `valoracionTecnica` text,
  `reseña` text,
  `usuario_idUsuario` int NOT NULL,
  `rutas_idRuta` int NOT NULL,
  PRIMARY KEY (`idValora`),
  UNIQUE KEY `conexionunique_paraquelosdosnoseaniguales` (`usuario_idUsuario`,`rutas_idRuta`),
  KEY `fk_valora_usuario1_idx` (`usuario_idUsuario`),
  KEY `fk_valora_rutas1_idx` (`rutas_idRuta`),
  CONSTRAINT `fk_valora_rutas1` FOREIGN KEY (`rutas_idRuta`) REFERENCES `rutas` (`idRuta`),
  CONSTRAINT `fk_valora_usuario1` FOREIGN KEY (`usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valora`
--

LOCK TABLES `valora` WRITE;
/*!40000 ALTER TABLE `valora` DISABLE KEYS */;
INSERT INTO `valora` VALUES (1,4,'2024-05-24',4,4,3,'Teto valoracaion tecnica','Muy bonito todo',1,1),(2,3,'2023-10-08',3,5,4,'','Me ha gustado mucho',4,1);
/*!40000 ALTER TABLE `valora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'mydb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-07 19:32:17

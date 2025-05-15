### *Base de datos*

###### Diagrama entidad-relacion

![diagrama-e/r](https://github.com/MiguelIGP23/DAM1_EQUIPO3_2425/blob/2ff84c4b6d9851bdd404d5ab7e7a641d1925552e/equipo3/Bases%20de%20Datos/Imagen%20entidad-relacion.PNG)


###### Diagrama Relacional

![diagramarelacional](https://github.com/MiguelIGP23/DAM1_EQUIPO3_2425/blob/422c07123ecd38740a117b397bdb0c7edcba716a/equipo3/Bases%20de%20Datos/entidad-relacion-imagen-final.png)


###### Script de la base de datos

````

CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.39

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
  CONSTRAINT `fk_actividad_rutas1` FOREIGN KEY (`rutas_idRuta`) REFERENCES `rutas` (`idRuta`) on delete cascade
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
  CONSTRAINT `fk_calendario_usuario1` FOREIGN KEY (`usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) on delete cascade
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
  CONSTRAINT `fk_imagenesinteres_puntosinteres1` FOREIGN KEY (`puntosinteres_idPuntosinteres`) REFERENCES `puntosinteres` (`idPuntosinteres`) on delete cascade
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
  CONSTRAINT `fk_imagenespeligro_puntospeligro1` FOREIGN KEY (`puntospeligro_idPuntosinteres`) REFERENCES `puntospeligro` (`idPuntospeligro`) on delete cascade
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
  `tipo` enum('historico','mirador','area_de_descanso','punto_de_agua','alojamiento','cultural',' geologico','fauna','botanico') DEFAULT 'mirador',
  `descripcion` text,
  `timestamp` int DEFAULT NULL,
  `rutas_idRuta` int NOT NULL,
  PRIMARY KEY (`idPuntosinteres`),
  KEY `fk_puntosinteres_rutas1_idx` (`rutas_idRuta`),
  CONSTRAINT `fk_puntosinteres_rutas1` FOREIGN KEY (`rutas_idRuta`) REFERENCES `rutas` (`idRuta`) on delete cascade
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
  CONSTRAINT `fk_puntospeligro_rutas1` FOREIGN KEY (`rutas_idRuta`) REFERENCES `rutas` (`idRuta`) on delete cascade
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puntospeligro`
--

LOCK TABLES `puntospeligro` WRITE;
/*!40000 ALTER TABLE `puntospeligro` DISABLE KEYS */;
INSERT INTO `puntospeligro` VALUES (1,'barranco',0.2345,2.2514,150,1,2,1,'cuidado con las rocas',4,1),(2,'ladrones',0.4345,1.2618,90,3,4,2,'corre corre',11,1),(3,'lobos',0.3451,1.0234,98,4,4,3,'hay lobos',15,1),(4,'aaaaaa',0.4455,1.1223,110,2,5,1,'no se',3,2);
/*!40000 ALTER TABLE `puntospeligro` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `actualizarNivelRiesgo_Insert` AFTER INSERT ON `puntospeligro` FOR EACH ROW BEGIN
  DECLARE media_gravedad DOUBLE;

	-- Calculamos la media de gravedad de los puntos de peligro de toda la ruta
  SELECT AVG(gravedad)
  INTO media_gravedad
  FROM puntospeligro
  WHERE rutas_idRuta = NEW.rutas_idRuta;

	-- Actualizamos en la tabla rutas el nivelRiesgo de la ruta que contiene el punto de peligro
  UPDATE rutas
  SET nivelRiesgo = ROUND(media_gravedad)
  WHERE idRuta = NEW.rutas_idRuta;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `actualizarNivelRiesgo_Update` AFTER UPDATE ON `puntospeligro` FOR EACH ROW BEGIN
  DECLARE media_gravedad DOUBLE;

	-- Calcula la media de gravedad de los puntos de peligro que pertenecen a la misma ruta
  SELECT AVG(gravedad)
  INTO media_gravedad
  FROM puntospeligro
  WHERE rutas_idRuta = NEW.rutas_idRuta;

	-- Actualiza el valor de nivelRiesgo de la ruta que contiene el punto de peligro modificado
  UPDATE rutas
  SET nivelRiesgo = ROUND(media_gravedad)
  WHERE idRuta = NEW.rutas_idRuta;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `actualizarNivelRiesgo_Delete` AFTER DELETE ON `puntospeligro` FOR EACH ROW BEGIN
  DECLARE media_gravedad DOUBLE;

	-- Calculamos la media de gravedad de los puntos que pertenecen a la misma ruta que el eliminado
  SELECT AVG(gravedad)
  INTO media_gravedad
  FROM puntospeligro
  WHERE rutas_idRuta = OLD.rutas_idRuta;

	-- Actualizamos el nivelRiesgo de la ruta que contenia al punto de peligro eliminado
  UPDATE rutas
  SET nivelRiesgo = ROUND(media_gravedad)
  WHERE idRuta = OLD.rutas_idRuta;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
  `clasificacion` enum('circular','lineal') DEFAULT 'lineal',
  `nivelEsfuerzo` tinyint DEFAULT NULL,
  `nivelRiesgo` tinyint DEFAULT NULL,
  `estadoRuta` tinyint DEFAULT '0',
  `tipoTerreno` tinyint DEFAULT NULL,
  `indicaciones` tinyint DEFAULT NULL,
  `temporadas` set('invierno','verano','otoño','primavera') DEFAULT NULL,
  `accesibilidad` tinyint DEFAULT NULL,
  `rutaFamiliar` tinyint DEFAULT NULL,
  `archivoGPX` text,
  `recomendacionesEquipo` text,
  `zonaGeografica` varchar(45) DEFAULT NULL,
  `mediaEstrellas` double DEFAULT NULL,
  `usuario_idUsuario` int NOT NULL,
  PRIMARY KEY (`idRuta`),
  KEY `fk_rutas_usuario1_idx` (`usuario_idUsuario`),
  UNIQUE (`nombre`),
  CONSTRAINT `fk_rutas_usuario1` FOREIGN KEY (`usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) on delete cascade
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rutas`
--

LOCK TABLES `rutas` WRITE;
/*!40000 ALTER TABLE `rutas` DISABLE KEYS */;
INSERT INTO `rutas` VALUES (1,'Paseo por el bosque','Bar manolo','Fuente del rio',0.2345,2.3625,0.2536,2.2345,23,'00:15:00',90,20,1300,1150,NULL,4,3,0,NULL,NULL,'verano,primavera',1,1,NULL,'Lleva cervecitas',NULL,4,1),(2,'Subida al everest','salida del bosque','pico mas alto',4.2356,8.3625,4.2476,9.6345,120,'23:15:00',4532,600,8400,1340,NULL,5,5,0,NULL,NULL,'invierno',1,1,NULL,'Suerte o muerte',NULL,3,1);
/*!40000 ALTER TABLE `rutas` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `calcularNivelEsfuerzo_Insert` BEFORE INSERT ON `rutas` FOR EACH ROW BEGIN
  DECLARE duracion_min INT;
  DECLARE duracion_valor INT;
  DECLARE distancia_valor INT;
  DECLARE desnivel_acumulado INT;
  DECLARE desnivel_valor INT;
  DECLARE media DOUBLE;

	-- Calculamos duracion en minutos
  SET duracion_min = HOUR(NEW.duracion) * 60 + MINUTE(NEW.duracion);
	-- Le asignamos puntos en funcion de su valor
  IF duracion_min <= 30 THEN SET duracion_valor = 2;
  ELSEIF duracion_min <= 60 THEN SET duracion_valor = 4;
  ELSEIF duracion_min <= 120 THEN SET duracion_valor = 6;
  ELSE SET duracion_valor = 8;
  END IF;

	-- Calculamos puntos en funcion de la distancia
  IF NEW.distancia <= 5 THEN SET distancia_valor = 2;
  ELSEIF NEW.distancia <= 10 THEN SET distancia_valor = 3;
  ELSEIF NEW.distancia <= 15 THEN SET distancia_valor = 4;
  ELSEIF NEW.distancia <= 20 THEN SET distancia_valor = 5;
  ELSEIF NEW.distancia <= 25 THEN SET distancia_valor = 6;
  ELSEIF NEW.distancia <= 30 THEN SET distancia_valor = 7;
  ELSE SET distancia_valor = 8;
  END IF;

	-- Calculamos desnivel total, si desnivel positivo o negativo es null se cuenta como 0
  SET desnivel_acumulado = IFNULL(NEW.desnivelPositivo, 0) + IFNULL(NEW.desnivelNegativo, 0);
	-- Calculamos su puntos en funcion del desnivel total
  IF desnivel_acumulado <= 100 THEN SET desnivel_valor = 2;
  ELSEIF desnivel_acumulado <= 300 THEN SET desnivel_valor = 3;
  ELSEIF desnivel_acumulado <= 500 THEN SET desnivel_valor = 4;
  ELSEIF desnivel_acumulado <= 600 THEN SET desnivel_valor = 5;
  ELSEIF desnivel_acumulado <= 800 THEN SET desnivel_valor = 6;
  ELSEIF desnivel_acumulado <= 1000 THEN SET desnivel_valor = 7;
  ELSE SET desnivel_valor = 8;
  END IF;

	-- Calculamos media y lo asignamos a nivelEsfuerzo
  SET media = (duracion_valor + distancia_valor + desnivel_valor) / 3;
  SET NEW.nivelEsfuerzo = LEAST(ROUND(media), 5);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `calcularNivelEsfuerzo_Update` BEFORE UPDATE ON `rutas` FOR EACH ROW BEGIN
  DECLARE duracion_min INT;
  DECLARE duracion_valor INT;
  DECLARE distancia_valor INT;
  DECLARE desnivel_acumulado INT;
  DECLARE desnivel_valor INT;
  DECLARE media DOUBLE;

	-- Calculamos duracion en minutos
  SET duracion_min = HOUR(NEW.duracion) * 60 + MINUTE(NEW.duracion);

	-- Le asignamos puntos en funcion de su valor
  IF duracion_min <= 30 THEN SET duracion_valor = 2;
  ELSEIF duracion_min <= 60 THEN SET duracion_valor = 4;
  ELSEIF duracion_min <= 120 THEN SET duracion_valor = 6;
  ELSE SET duracion_valor = 8;
  END IF;

	-- Calculamos puntos en funcion de la distancia
  IF NEW.distancia <= 5 THEN SET distancia_valor = 2;
  ELSEIF NEW.distancia <= 10 THEN SET distancia_valor = 3;
  ELSEIF NEW.distancia <= 15 THEN SET distancia_valor = 4;
  ELSEIF NEW.distancia <= 20 THEN SET distancia_valor = 5;
  ELSEIF NEW.distancia <= 25 THEN SET distancia_valor = 6;
  ELSEIF NEW.distancia <= 30 THEN SET distancia_valor = 7;
  ELSE SET distancia_valor = 8;
  END IF;

	-- Calculamos desnivel total, si desnivel positivo o negativo es null se cuenta como 0
  SET desnivel_acumulado = IFNULL(NEW.desnivelPositivo, 0) + IFNULL(NEW.desnivelNegativo, 0);
	-- Calculamos su puntos en funcion del desnivel total
  IF desnivel_acumulado <= 100 THEN SET desnivel_valor = 2;
  ELSEIF desnivel_acumulado <= 300 THEN SET desnivel_valor = 3;
  ELSEIF desnivel_acumulado <= 500 THEN SET desnivel_valor = 4;
  ELSEIF desnivel_acumulado <= 600 THEN SET desnivel_valor = 5;
  ELSEIF desnivel_acumulado <= 800 THEN SET desnivel_valor = 6;
  ELSEIF desnivel_acumulado <= 1000 THEN SET desnivel_valor = 7;
  ELSE SET desnivel_valor = 8;
  END IF;

	-- Calculamos media y lo asignamos a nivelEsfuerzo
  SET media = (duracion_valor + distancia_valor + desnivel_valor) / 3;
  SET NEW.nivelEsfuerzo = LEAST(ROUND(media), 5);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
  PRIMARY KEY (`idUsuario`),
  UNIQUE (`email`)
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
  `estrellas` tinyint NOT NULL,
  `interesCultural` tinyint NOT NULL,
  `belleza` tinyint NOT NULL,
  `valoracionTecnica` text,
  `reseña` text,
  `usuario_idUsuario` int NOT NULL,
  `rutas_idRuta` int NOT NULL,
  PRIMARY KEY (`idValora`),
  UNIQUE KEY `conexionunique_paraquelosdosnoseaniguales` (`usuario_idUsuario`,`rutas_idRuta`),
  KEY `fk_valora_usuario1_idx` (`usuario_idUsuario`),
  KEY `fk_valora_rutas1_idx` (`rutas_idRuta`),
  CONSTRAINT `fk_valora_rutas1` FOREIGN KEY (`rutas_idRuta`) REFERENCES `rutas` (`idRuta`) on delete cascade,
  CONSTRAINT `fk_valora_usuario1` FOREIGN KEY (`usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) on delete cascade
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valora`
--

LOCK TABLES `valora` WRITE;
/*!40000 ALTER TABLE `valora` DISABLE KEYS */;
INSERT INTO `valora` VALUES (1,4,'2024-05-24',5,4,3,'Teto valoracaion tecnica','Muy bonito todo',1,1),(2,3,'2023-10-08',3,5,4,'','Me ha gustado mucho',4,1),(3,2,'2023-12-15',3,4,4,'valoracion tec','resenaaaa',2,2);
/*!40000 ALTER TABLE `valora` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `actualizarMediaEstrellas_Insert` AFTER INSERT ON `valora` FOR EACH ROW BEGIN
  DECLARE media DOUBLE;

	-- Calcula la media de estrellas de las valoraciones asociadas a la ruta
  SELECT AVG(estrellas)
  INTO media
  FROM valora
  WHERE rutas_idRuta = NEW.rutas_idRuta;

	-- Actualiza la columna mediaEstrellas de la ruta
  UPDATE rutas
  SET mediaEstrellas = ROUND(media, 2)
  WHERE idRuta = NEW.rutas_idRuta;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `actualizarMediaEstrellas_Update` AFTER UPDATE ON `valora` FOR EACH ROW BEGIN
  DECLARE media DOUBLE;

	-- Calcula media de estrellas de valoraciones asociadas a la rura
  SELECT AVG(estrellas)
  INTO media
  FROM valora
  WHERE rutas_idRuta = NEW.rutas_idRuta;

	-- Actualiza mediaEstrellass de la ruta
  UPDATE rutas
  SET mediaEstrellas = ROUND(media, 2)
  WHERE idRuta = NEW.rutas_idRuta;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `actualizarMediaEstrellas_Delete` AFTER DELETE ON `valora` FOR EACH ROW BEGIN
  DECLARE media DOUBLE;

	-- Calcula media de estrellas de valoraciones asociadasa a la ruta
  SELECT AVG(estrellas)
  INTO media
  FROM valora
  WHERE rutas_idRuta = OLD.rutas_idRuta;

	-- Actualiza mediaEstrellas de ruta 
  UPDATE rutas
  SET mediaEstrellas = ROUND(media, 2)
  WHERE idRuta = OLD.rutas_idRuta;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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

-- Dump completed on 2025-05-07 23:31:54


````

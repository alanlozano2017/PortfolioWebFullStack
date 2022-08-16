-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: backendlozano
-- ------------------------------------------------------
-- Server version	5.5.24-log

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
-- Table structure for table `educacion`
--

DROP TABLE IF EXISTS `educacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `educacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcione` varchar(1000) DEFAULT '',
  `fine` int(11) DEFAULT '2008',
  `imge` varchar(255) DEFAULT NULL,
  `inicioe` int(11) DEFAULT '2008',
  `nombree` varchar(255) DEFAULT '',
  `tituloe` varchar(255) DEFAULT '',
  `persona_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8co4tldnpfbl6l8oc06veg4jr` (`persona_id`),
  CONSTRAINT `FK8co4tldnpfbl6l8oc06veg4jr` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educacion`
--

LOCK TABLES `educacion` WRITE;
/*!40000 ALTER TABLE `educacion` DISABLE KEYS */;
INSERT INTO `educacion` VALUES (1,'',2008,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSQIMwdmi3qotpbFtpU5nCEgdCPpYbexFnwcBUbY7Td&s',2003,'Colegio Nº15: Ing. Agustín Mercau','Técnico en mantenimiento de Equipos Electromecánicos',NULL),(2,'',2012,'http://www.fcejs.unsl.edu.ar/wp-content/uploads/2019/07/unsl-top.png',2009,'Fices','Ingeniería industral y Administración de empresas (incompleto)',1),(3,'',2022,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2QeDjyweP6729uWze9G4qV1MaMFOpZun39OmxRrw&s',2014,'UNViMe','Analísta de Sistemas y programador (próximo a terminar)',1),(4,'',2022,'https://argentinaprograma.inti.gob.ar/pluginfile.php/1/theme_moove/logo/1659143423/APLogo-20-20.png',2021,'Argentina Programa Inti','Desarrollador Web Full Stack',1);
/*!40000 ALTER TABLE `educacion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-16  8:02:52

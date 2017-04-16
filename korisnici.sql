-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mkorisnici
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrator` (
  `id` int(11) NOT NULL,
  `idOsoba` int(11) NOT NULL,
  `id_osoba` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idosoba_fk_idx` (`idOsoba`),
  KEY `FKl48dvb7decu0rbg3ksih0n498` (`id_osoba`),
  CONSTRAINT `FKl48dvb7decu0rbg3ksih0n498` FOREIGN KEY (`id_osoba`) REFERENCES `osoba` (`id`),
  CONSTRAINT `idosoba_fk` FOREIGN KEY (`idOsoba`) REFERENCES `osoba` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES (1,1,NULL),(2,2,NULL),(3,3,NULL),(4,4,NULL);
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ishrana`
--

DROP TABLE IF EXISTS `ishrana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ishrana` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dorucak` varchar(255) DEFAULT NULL,
  `rucak` varchar(255) DEFAULT NULL,
  `uzina1` varchar(255) DEFAULT NULL,
  `uzina2` varchar(255) DEFAULT NULL,
  `vecera` varchar(255) DEFAULT NULL,
  `id_korisnik` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnruqrwgislkp71wpoas48h8yn` (`id_korisnik`),
  CONSTRAINT `FKnruqrwgislkp71wpoas48h8yn` FOREIGN KEY (`id_korisnik`) REFERENCES `korisnik` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ishrana`
--

LOCK TABLES `ishrana` WRITE;
/*!40000 ALTER TABLE `ishrana` DISABLE KEYS */;
/*!40000 ALTER TABLE `ishrana` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `komentari`
--

DROP TABLE IF EXISTS `komentari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `komentari` (
  `datum` date NOT NULL,
  `id` int(11) NOT NULL,
  `id_korisnik` int(11) NOT NULL,
  `id_trener` int(11) NOT NULL,
  `tekst` varchar(255) NOT NULL,
  PRIMARY KEY (`datum`,`id`,`id_korisnik`,`id_trener`,`tekst`),
  KEY `FKrsl0virliqtkx1jf9ck2p5yh1` (`id_korisnik`),
  KEY `FKjvlhaj0ywhltol2g1coe26d0j` (`id_trener`),
  CONSTRAINT `FKjvlhaj0ywhltol2g1coe26d0j` FOREIGN KEY (`id_trener`) REFERENCES `trener` (`id`),
  CONSTRAINT `FKrsl0virliqtkx1jf9ck2p5yh1` FOREIGN KEY (`id_korisnik`) REFERENCES `korisnik` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `komentari`
--

LOCK TABLES `komentari` WRITE;
/*!40000 ALTER TABLE `komentari` DISABLE KEYS */;
/*!40000 ALTER TABLE `komentari` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `korisnik`
--

DROP TABLE IF EXISTS `korisnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `korisnik` (
  `id` int(11) NOT NULL,
  `spol` varchar(45) NOT NULL,
  `godine` int(11) NOT NULL,
  `visina` int(11) NOT NULL,
  `tezina` decimal(10,0) NOT NULL,
  `zeljena_tezina` decimal(10,0) NOT NULL,
  `bolesti` varchar(500) DEFAULT NULL,
  `datum_pristupa` date NOT NULL,
  `idTrener` int(11) NOT NULL,
  `idOsoba` int(11) NOT NULL,
  `id_osoba` int(11) DEFAULT NULL,
  `id_trener` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idOsobaFK_idx` (`idOsoba`),
  KEY `idTrenerFk_idx` (`idTrener`),
  KEY `FK16tumlexce1107tnbcj8pmeie` (`id_osoba`),
  KEY `FK8dgc90helwfq6t89gi3pvixck` (`id_trener`),
  CONSTRAINT `FK16tumlexce1107tnbcj8pmeie` FOREIGN KEY (`id_osoba`) REFERENCES `osoba` (`id`),
  CONSTRAINT `FK8dgc90helwfq6t89gi3pvixck` FOREIGN KEY (`id_trener`) REFERENCES `trener` (`id`),
  CONSTRAINT `idOsobaFK` FOREIGN KEY (`idOsoba`) REFERENCES `osoba` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idTrenerFk` FOREIGN KEY (`idTrener`) REFERENCES `trener` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `korisnik`
--

LOCK TABLES `korisnik` WRITE;
/*!40000 ALTER TABLE `korisnik` DISABLE KEYS */;
INSERT INTO `korisnik` VALUES (1,'musko',20,180,80,76,'nema','2001-04-20',1,10,NULL,NULL),(2,'musko',17,195,100,95,'nema','2020-03-20',1,11,NULL,NULL),(3,'musko',55,185,90,82,'dijabetes','2002-03-20',2,12,NULL,NULL),(4,'zensko',22,165,70,62,'nema','2017-03-20',3,13,NULL,NULL),(5,'zensko',23,171,70,66,'nema','2012-01-20',4,14,NULL,NULL),(6,'zensko',34,175,73,69,'aritmija','2020-05-20',5,15,NULL,NULL),(7,'zensko',55,169,75,65,'nema','2012-02-20',5,16,NULL,NULL);
/*!40000 ALTER TABLE `korisnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `osoba`
--

DROP TABLE IF EXISTS `osoba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osoba` (
  `id` int(11) NOT NULL,
  `ime` varchar(255) NOT NULL,
  `prezime` varchar(255) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osoba`
--

LOCK TABLES `osoba` WRITE;
/*!40000 ALTER TABLE `osoba` DISABLE KEYS */;
INSERT INTO `osoba` VALUES (1,'adna','tahic','user','pass','mail'),(2,'avad','tahic','user2','pass','mail2'),(3,'rabija','tahic','user3','pass','mail3'),(4,'eldar','kurtic','user4','pass','email4'),(5,'aida','kanlic','user5','pass','email5'),(6,'merima','cisija','user6','pass','email6'),(7,'adin','velic','user7','pass','email7'),(8,'amila','kanlic','user8','pass','email8'),(9,'asim','kanlic','user9','pass','email9'),(10,'amel','kanlic','user10','pass','email10'),(11,'emir','muhic','user11','pass','email11'),(12,'amir','velic','user12','pass','email12'),(13,'edina','fehratovic','user13','pass','email13'),(14,'irma','dizdarevic','user14','pass','email14'),(15,'amina','kovacevic','user15','pass','email15'),(16,'admira','zivojevic','user16','pass','email16');
/*!40000 ALTER TABLE `osoba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trener`
--

DROP TABLE IF EXISTS `trener`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trener` (
  `id` int(11) NOT NULL,
  `spol` varchar(45) DEFAULT NULL,
  `godine` int(11) DEFAULT NULL,
  `edukacija` varchar(45) DEFAULT NULL,
  `iskustvo` int(11) DEFAULT NULL,
  `brojKlijenata` int(11) DEFAULT NULL,
  `id_osoba` int(11) DEFAULT NULL,
  `broj_klijenata` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdfu9jjenxo5s140sia1ofcm8r` (`id_osoba`),
  CONSTRAINT `FKdfu9jjenxo5s140sia1ofcm8r` FOREIGN KEY (`id_osoba`) REFERENCES `osoba` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trener`
--

LOCK TABLES `trener` WRITE;
/*!40000 ALTER TABLE `trener` DISABLE KEYS */;
INSERT INTO `trener` VALUES (1,'musko',25,'fax',2,12,5,12),(2,'zensko',16,'fax',3,10,6,10),(3,'zensko',28,'fax',5,25,7,25),(4,'musko',30,'edukacija',9,30,8,30),(5,'musko',35,'ekukacija',13,55,9,55);
/*!40000 ALTER TABLE `trener` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trening`
--

DROP TABLE IF EXISTS `trening`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trening` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `opis` varchar(255) DEFAULT NULL,
  `trajanje` int(11) NOT NULL,
  `vrsta` varchar(255) DEFAULT NULL,
  `id_korisnik` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrdckoj932br4l7n2jup1a8s1h` (`id_korisnik`),
  CONSTRAINT `FKrdckoj932br4l7n2jup1a8s1h` FOREIGN KEY (`id_korisnik`) REFERENCES `korisnik` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trening`
--

LOCK TABLES `trening` WRITE;
/*!40000 ALTER TABLE `trening` DISABLE KEYS */;
/*!40000 ALTER TABLE `trening` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-09  9:58:44

-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mstatistika
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `korisnik`
--

DROP TABLE IF EXISTS `korisnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `korisnik` (
  `id` int(11) NOT NULL,
  `spol` varchar(10) NOT NULL,
  `godine` int(11) NOT NULL,
  `visina` decimal(10,0) NOT NULL,
  `tezina` decimal(10,0) NOT NULL,
  `zeljena_kilaza` decimal(10,0) NOT NULL,
  `bolesti` varchar(255) DEFAULT NULL,
  `datum_pristupa` date NOT NULL,
  `id_trener` int(11) NOT NULL,
  `id_osoba` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_osoba_idx` (`id_osoba`),
  KEY `fk_trener_idx` (`id_trener`),
  CONSTRAINT `FK16tumlexce1107tnbcj8pmeie` FOREIGN KEY (`id_osoba`) REFERENCES `osoba` (`id`),
  CONSTRAINT `FK8dgc90helwfq6t89gi3pvixck` FOREIGN KEY (`id_trener`) REFERENCES `trener` (`id`),
  CONSTRAINT `fk_osoba1` FOREIGN KEY (`id_osoba`) REFERENCES `osoba` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_trener` FOREIGN KEY (`id_trener`) REFERENCES `trener` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `korisnik`
--

LOCK TABLES `korisnik` WRITE;
/*!40000 ALTER TABLE `korisnik` DISABLE KEYS */;
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
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osoba`
--

LOCK TABLES `osoba` WRITE;
/*!40000 ALTER TABLE `osoba` DISABLE KEYS */;
/*!40000 ALTER TABLE `osoba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametritreninga`
--

DROP TABLE IF EXISTS `parametritreninga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parametritreninga` (
  `id` int(11) NOT NULL,
  `id_korisnika` int(11) NOT NULL,
  `tezina` decimal(10,0) NOT NULL,
  `datum` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_korisnik1_idx` (`id_korisnika`),
  CONSTRAINT `FKnw979nyhllrqhlmvpwdkmwq6f` FOREIGN KEY (`id_korisnika`) REFERENCES `korisnik` (`id`),
  CONSTRAINT `fk_korisnik1` FOREIGN KEY (`id_korisnika`) REFERENCES `korisnik` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametritreninga`
--

LOCK TABLES `parametritreninga` WRITE;
/*!40000 ALTER TABLE `parametritreninga` DISABLE KEYS */;
/*!40000 ALTER TABLE `parametritreninga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rejting`
--

DROP TABLE IF EXISTS `rejting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rejting` (
  `id` int(11) NOT NULL,
  `id_korisnik` int(11) NOT NULL,
  `id_trener` int(11) NOT NULL,
  `ocjena` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_trener2_idx` (`id_trener`),
  KEY `fk_korisnik2_idx` (`id_korisnik`),
  CONSTRAINT `FK1ri1y7j261ekdxmr5f7do5pmn` FOREIGN KEY (`id_trener`) REFERENCES `trener` (`id`),
  CONSTRAINT `FK7vapapos2mtc1kho3ar3w0053` FOREIGN KEY (`id_korisnik`) REFERENCES `korisnik` (`id`),
  CONSTRAINT `fk_korisnik2` FOREIGN KEY (`id_korisnik`) REFERENCES `korisnik` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_trener2` FOREIGN KEY (`id_trener`) REFERENCES `trener` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rejting`
--

LOCK TABLES `rejting` WRITE;
/*!40000 ALTER TABLE `rejting` DISABLE KEYS */;
/*!40000 ALTER TABLE `rejting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trener`
--

DROP TABLE IF EXISTS `trener`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trener` (
  `id` int(11) NOT NULL,
  `spol` varchar(10) NOT NULL,
  `godine` int(11) NOT NULL,
  `edukacija` varchar(255) NOT NULL,
  `iskustvo` int(11) NOT NULL,
  `broj_klijenata` int(11) NOT NULL,
  `id_osoba` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_osoba_idx` (`id_osoba`),
  CONSTRAINT `FKdfu9jjenxo5s140sia1ofcm8r` FOREIGN KEY (`id_osoba`) REFERENCES `osoba` (`id`),
  CONSTRAINT `fk_osoba` FOREIGN KEY (`id_osoba`) REFERENCES `osoba` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trener`
--

LOCK TABLES `trener` WRITE;
/*!40000 ALTER TABLE `trener` DISABLE KEYS */;
/*!40000 ALTER TABLE `trener` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-29  8:58:59

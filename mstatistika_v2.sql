-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema mplaniprogram
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mplaniprogram
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mplaniprogram` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema mstatistika
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mstatistika
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mstatistika` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema mkorisnici
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mkorisnici
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mkorisnici` DEFAULT CHARACTER SET utf8 ;
USE `mplaniprogram` ;

-- -----------------------------------------------------
-- Table `mplaniprogram`.`osoba`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mplaniprogram`.`osoba` (
  `id` INT(11) NOT NULL,
  `ime` VARCHAR(45) NOT NULL,
  `prezime` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mplaniprogram`.`korisnik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mplaniprogram`.`korisnik` (
  `id` INT(11) NOT NULL,
  `spol` VARCHAR(45) NOT NULL,
  `godine` INT(11) NOT NULL,
  `visina` DECIMAL(10,0) NOT NULL,
  `tezina` DECIMAL(10,0) NOT NULL,
  `zeljena_tezina` DECIMAL(10,0) NOT NULL,
  `bolesti` VARCHAR(255) NULL DEFAULT NULL,
  `datum_pristupa` DATE NOT NULL,
  `id_trener` INT(11) NOT NULL,
  `id_osoba` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_osoba_idx` (`id_osoba` ASC),
  CONSTRAINT `FK16tumlexce1107tnbcj8pmeie`
    FOREIGN KEY (`id_osoba`)
    REFERENCES `mplaniprogram`.`osoba` (`id`),
  CONSTRAINT `fk_osoba`
    FOREIGN KEY (`id_osoba`)
    REFERENCES `mplaniprogram`.`osoba` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mplaniprogram`.`ishrana`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mplaniprogram`.`ishrana` (
  `id` INT(11) NOT NULL,
  `dorucak` VARCHAR(255) NOT NULL,
  `rucak` VARCHAR(255) NOT NULL,
  `vecera` VARCHAR(255) NOT NULL,
  `uzina1` VARCHAR(255) NOT NULL,
  `uzina2` VARCHAR(255) NOT NULL,
  `id_korisnik` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_korisnik3_idx` (`id_korisnik` ASC),
  CONSTRAINT `FKnruqrwgislkp71wpoas48h8yn`
    FOREIGN KEY (`id_korisnik`)
    REFERENCES `mplaniprogram`.`korisnik` (`id`),
  CONSTRAINT `fk_korisnik3`
    FOREIGN KEY (`id_korisnik`)
    REFERENCES `mplaniprogram`.`korisnik` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mplaniprogram`.`trener`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mplaniprogram`.`trener` (
  `id` INT(11) NOT NULL,
  `spol` VARCHAR(10) NOT NULL,
  `godine` INT(11) NOT NULL,
  `edukacija` VARCHAR(255) NOT NULL,
  `iskustvo` INT(11) NOT NULL,
  `broj_klijenata` INT(11) NOT NULL,
  `id_osoba` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fkosoba_idx` (`id_osoba` ASC),
  CONSTRAINT `FKdfu9jjenxo5s140sia1ofcm8r`
    FOREIGN KEY (`id_osoba`)
    REFERENCES `mplaniprogram`.`osoba` (`id`),
  CONSTRAINT `fkosoba`
    FOREIGN KEY (`id_osoba`)
    REFERENCES `mplaniprogram`.`osoba` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mplaniprogram`.`komentari`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mplaniprogram`.`komentari` (
  `id` INT(11) NOT NULL,
  `id_trener` INT(11) NOT NULL,
  `id_korisnik` INT(11) NOT NULL,
  `tekst` VARCHAR(255) NOT NULL,
  `datum` DATE NOT NULL,
  PRIMARY KEY (`id`, `id_trener`, `tekst`, `datum`, `id_korisnik`),
  INDEX `fk_trener_idx` (`id_trener` ASC),
  INDEX `fk_korisnik_idx` (`id_korisnik` ASC),
  CONSTRAINT `FKjvlhaj0ywhltol2g1coe26d0j`
    FOREIGN KEY (`id_trener`)
    REFERENCES `mplaniprogram`.`trener` (`id`),
  CONSTRAINT `FKrsl0virliqtkx1jf9ck2p5yh1`
    FOREIGN KEY (`id_korisnik`)
    REFERENCES `mplaniprogram`.`korisnik` (`id`),
  CONSTRAINT `fk_korisnik`
    FOREIGN KEY (`id_korisnik`)
    REFERENCES `mplaniprogram`.`korisnik` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_trener`
    FOREIGN KEY (`id_trener`)
    REFERENCES `mplaniprogram`.`trener` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mplaniprogram`.`trening`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mplaniprogram`.`trening` (
  `id` INT(11) NOT NULL,
  `id_korisnik` INT(11) NULL DEFAULT NULL,
  `trajanje` INT(11) NOT NULL,
  `vrsta` VARCHAR(255) NOT NULL,
  `opis` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fkkorisnik1_idx` (`id_korisnik` ASC),
  CONSTRAINT `FKrdckoj932br4l7n2jup1a8s1h`
    FOREIGN KEY (`id_korisnik`)
    REFERENCES `mplaniprogram`.`korisnik` (`id`),
  CONSTRAINT `fkkorisnik1`
    FOREIGN KEY (`id_korisnik`)
    REFERENCES `mplaniprogram`.`korisnik` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `mstatistika` ;

-- -----------------------------------------------------
-- Table `mstatistika`.`osoba`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mstatistika`.`osoba` (
  `id` INT(11) NOT NULL,
  `ime` VARCHAR(45) NOT NULL,
  `prezime` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mstatistika`.`trener`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mstatistika`.`trener` (
  `id` INT(11) NOT NULL,
  `spol` VARCHAR(10) NOT NULL,
  `godine` INT(11) NOT NULL,
  `edukacija` VARCHAR(255) NOT NULL,
  `iskustvo` INT(11) NOT NULL,
  `broj_klijenata` INT(11) NOT NULL,
  `id_osoba` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_osoba_idx` (`id_osoba` ASC),
  CONSTRAINT `FKdfu9jjenxo5s140sia1ofcm8r`
    FOREIGN KEY (`id_osoba`)
    REFERENCES `mstatistika`.`osoba` (`id`),
  CONSTRAINT `fk_osoba`
    FOREIGN KEY (`id_osoba`)
    REFERENCES `mstatistika`.`osoba` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mstatistika`.`korisnik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mstatistika`.`korisnik` (
  `id` INT(11) NOT NULL,
  `spol` VARCHAR(10) NOT NULL,
  `godine` INT(11) NOT NULL,
  `visina` DECIMAL(10,0) NOT NULL,
  `tezina` DECIMAL(10,0) NOT NULL,
  `zeljena_kilaza` DECIMAL(10,0) NOT NULL,
  `bolesti` VARCHAR(255) NULL DEFAULT NULL,
  `datum_pristupa` DATE NOT NULL,
  `id_trener` INT(11) NOT NULL,
  `id_osoba` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_osoba_idx` (`id_osoba` ASC),
  INDEX `fk_trener_idx` (`id_trener` ASC),
  CONSTRAINT `FK16tumlexce1107tnbcj8pmeie`
    FOREIGN KEY (`id_osoba`)
    REFERENCES `mstatistika`.`osoba` (`id`),
  CONSTRAINT `FK8dgc90helwfq6t89gi3pvixck`
    FOREIGN KEY (`id_trener`)
    REFERENCES `mstatistika`.`trener` (`id`),
  CONSTRAINT `fk_osoba1`
    FOREIGN KEY (`id_osoba`)
    REFERENCES `mstatistika`.`osoba` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_trener`
    FOREIGN KEY (`id_trener`)
    REFERENCES `mstatistika`.`trener` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mstatistika`.`parametritreninga`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mstatistika`.`parametritreninga` (
  `id` INT(11) NOT NULL,
  `id_korisnika` INT(11) NOT NULL,
  `tezina` DECIMAL(10,0) NOT NULL,
  `datum` DATE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_korisnik1_idx` (`id_korisnika` ASC),
  CONSTRAINT `FKnw979nyhllrqhlmvpwdkmwq6f`
    FOREIGN KEY (`id_korisnika`)
    REFERENCES `mstatistika`.`korisnik` (`id`),
  CONSTRAINT `fk_korisnik1`
    FOREIGN KEY (`id_korisnika`)
    REFERENCES `mstatistika`.`korisnik` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mstatistika`.`rejting`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mstatistika`.`rejting` (
  `id` INT(11) NOT NULL,
  `id_korisnik` INT(11) NOT NULL,
  `id_trener` INT(11) NOT NULL,
  `ocjena` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_trener2_idx` (`id_trener` ASC),
  INDEX `fk_korisnik2_idx` (`id_korisnik` ASC),
  CONSTRAINT `FK1ri1y7j261ekdxmr5f7do5pmn`
    FOREIGN KEY (`id_trener`)
    REFERENCES `mstatistika`.`trener` (`id`),
  CONSTRAINT `FK7vapapos2mtc1kho3ar3w0053`
    FOREIGN KEY (`id_korisnik`)
    REFERENCES `mstatistika`.`korisnik` (`id`),
  CONSTRAINT `fk_korisnik2`
    FOREIGN KEY (`id_korisnik`)
    REFERENCES `mstatistika`.`korisnik` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_trener2`
    FOREIGN KEY (`id_trener`)
    REFERENCES `mstatistika`.`trener` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `mkorisnici` ;

-- -----------------------------------------------------
-- Table `mkorisnici`.`osoba`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mkorisnici`.`osoba` (
  `id` INT(11) NOT NULL,
  `ime` VARCHAR(255) NOT NULL,
  `prezime` VARCHAR(255) NOT NULL,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mkorisnici`.`administrator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mkorisnici`.`administrator` (
  `id` INT(11) NOT NULL,
  `idOsoba` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idosoba_fk_idx` (`idOsoba` ASC),
  UNIQUE INDEX `idOsoba_UNIQUE` (`idOsoba` ASC),
  CONSTRAINT `idosoba_fk`
    FOREIGN KEY (`idOsoba`)
    REFERENCES `mkorisnici`.`osoba` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mkorisnici`.`trener`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mkorisnici`.`trener` (
  `id` INT(11) NOT NULL,
  `spol` VARCHAR(45) NULL DEFAULT NULL,
  `godine` INT(11) NULL DEFAULT NULL,
  `edukacija` VARCHAR(45) NULL DEFAULT NULL,
  `iskustvo` INT(11) NULL DEFAULT NULL,
  `brojKlijenata` INT(11) NULL DEFAULT NULL,
  `id_osoba` INT(11) NULL DEFAULT NULL,
  `broj_klijenata` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKdfu9jjenxo5s140sia1ofcm8r` (`id_osoba` ASC),
  UNIQUE INDEX `id_osoba_UNIQUE` (`id_osoba` ASC),
  CONSTRAINT `FKdfu9jjenxo5s140sia1ofcm8r`
    FOREIGN KEY (`id_osoba`)
    REFERENCES `mkorisnici`.`osoba` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mkorisnici`.`korisnik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mkorisnici`.`korisnik` (
  `id` INT(11) NOT NULL,
  `spol` VARCHAR(45) NOT NULL,
  `godine` INT(11) NOT NULL,
  `visina` INT(11) NOT NULL,
  `tezina` DECIMAL(10,0) NOT NULL,
  `zeljena_tezina` DECIMAL(10,0) NOT NULL,
  `bolesti` VARCHAR(500) NULL DEFAULT NULL,
  `datum_pristupa` DATE NOT NULL,
  `idTrener` INT(11) NOT NULL,
  `idOsoba` INT(11) NOT NULL,
  `id_osoba` INT(11) NULL DEFAULT NULL,
  `id_trener` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idOsobaFK_idx` (`idOsoba` ASC),
  INDEX `idTrenerFk_idx` (`idTrener` ASC),
  INDEX `FK16tumlexce1107tnbcj8pmeie` (`id_osoba` ASC),
  INDEX `FK8dgc90helwfq6t89gi3pvixck` (`id_trener` ASC),
  CONSTRAINT `FK16tumlexce1107tnbcj8pmeie`
    FOREIGN KEY (`id_osoba`)
    REFERENCES `mkorisnici`.`osoba` (`id`),
  CONSTRAINT `FK8dgc90helwfq6t89gi3pvixck`
    FOREIGN KEY (`id_trener`)
    REFERENCES `mkorisnici`.`trener` (`id`),
  CONSTRAINT `idOsobaFK`
    FOREIGN KEY (`idOsoba`)
    REFERENCES `mkorisnici`.`osoba` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idTrenerFk`
    FOREIGN KEY (`idTrener`)
    REFERENCES `mkorisnici`.`trener` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mkorisnici`.`ishrana`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mkorisnici`.`ishrana` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `dorucak` VARCHAR(255) NULL DEFAULT NULL,
  `rucak` VARCHAR(255) NULL DEFAULT NULL,
  `uzina1` VARCHAR(255) NULL DEFAULT NULL,
  `uzina2` VARCHAR(255) NULL DEFAULT NULL,
  `vecera` VARCHAR(255) NULL DEFAULT NULL,
  `id_korisnik` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKnruqrwgislkp71wpoas48h8yn` (`id_korisnik` ASC),
  CONSTRAINT `FKnruqrwgislkp71wpoas48h8yn`
    FOREIGN KEY (`id_korisnik`)
    REFERENCES `mkorisnici`.`korisnik` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mkorisnici`.`komentari`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mkorisnici`.`komentari` (
  `datum` DATE NOT NULL,
  `id` INT(11) NOT NULL,
  `id_korisnik` INT(11) NOT NULL,
  `id_trener` INT(11) NOT NULL,
  `tekst` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`datum`, `id`, `id_korisnik`, `id_trener`, `tekst`),
  INDEX `FKrsl0virliqtkx1jf9ck2p5yh1` (`id_korisnik` ASC),
  INDEX `FKjvlhaj0ywhltol2g1coe26d0j` (`id_trener` ASC),
  CONSTRAINT `FKjvlhaj0ywhltol2g1coe26d0j`
    FOREIGN KEY (`id_trener`)
    REFERENCES `mkorisnici`.`trener` (`id`),
  CONSTRAINT `FKrsl0virliqtkx1jf9ck2p5yh1`
    FOREIGN KEY (`id_korisnik`)
    REFERENCES `mkorisnici`.`korisnik` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mkorisnici`.`trening`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mkorisnici`.`trening` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `opis` VARCHAR(255) NULL DEFAULT NULL,
  `trajanje` INT(11) NOT NULL,
  `vrsta` VARCHAR(255) NULL DEFAULT NULL,
  `id_korisnik` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKrdckoj932br4l7n2jup1a8s1h` (`id_korisnik` ASC),
  CONSTRAINT `FKrdckoj932br4l7n2jup1a8s1h`
    FOREIGN KEY (`id_korisnik`)
    REFERENCES `mkorisnici`.`korisnik` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

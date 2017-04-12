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
  UNIQUE INDEX `id_osoba_UNIQUE` (`id_osoba` ASC),
  CONSTRAINT `FK16tumlexce1107tnbcj8pmeie`
    FOREIGN KEY (`id_osoba`)
    REFERENCES `mplaniprogram`.`osoba` (`id`))
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
  UNIQUE INDEX `id_osoba_UNIQUE` (`id_osoba` ASC),
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
  CONSTRAINT `FKjvlhaj0ywhltol2g1coe26d0j`
    FOREIGN KEY (`id_trener`)
    REFERENCES `mplaniprogram`.`trener` (`id`),
  CONSTRAINT `fk_korisnik`
    FOREIGN KEY (`id_korisnik`)
    REFERENCES `mplaniprogram`.`korisnik` (`id`)
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
  CONSTRAINT `FKrdckoj932br4l7n2jup1a8s1h`
    FOREIGN KEY (`id_korisnik`)
    REFERENCES `mplaniprogram`.`korisnik` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

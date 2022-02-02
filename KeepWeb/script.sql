-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema keep
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema keep
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `keep` ;
USE `keep` ;

-- -----------------------------------------------------
-- Table `keep`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `keep`.`Usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `senha` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `keep`.`Nota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `keep`.`Nota` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NOT NULL,
  `dataCriacao` DATETIME NOT NULL,
  `dataAlteracao` DATETIME NOT NULL,
  `descricao` TEXT NOT NULL,
  `cor` VARCHAR(45) NOT NULL,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Nota_Usuario1_idx` (`idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Nota_Usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `keep`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `keep`.`Rotulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `keep`.`Rotulo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(100) NOT NULL,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Rotulo_Usuario1_idx` (`idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Rotulo_Usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `keep`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `keep`.`Endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `keep`.`Endereco` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pais` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `numero` INT NOT NULL,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Endereco_Usuario1_idx` (`idUsuario` ASC) VISIBLE,
  UNIQUE INDEX `idUsuario_UNIQUE` (`idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Endereco_Usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `keep`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `keep`.`Nota_has_Rotulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `keep`.`Nota_has_Rotulo` (
  `idNota` INT NOT NULL,
  `idRotulo` INT NOT NULL,
  PRIMARY KEY (`idNota`, `idRotulo`),
  INDEX `fk_Nota_has_Rotulo_Rotulo1_idx` (`idRotulo` ASC) VISIBLE,
  INDEX `fk_Nota_has_Rotulo_Nota1_idx` (`idNota` ASC) VISIBLE,
  CONSTRAINT `fk_Nota_has_Rotulo_Nota1`
    FOREIGN KEY (`idNota`)
    REFERENCES `keep`.`Nota` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Nota_has_Rotulo_Rotulo1`
    FOREIGN KEY (`idRotulo`)
    REFERENCES `keep`.`Rotulo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `keep`.`Imagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `keep`.`Imagem` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `caminho` TEXT NOT NULL,
  `idNota` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Imagem_Nota1_idx` (`idNota` ASC) VISIBLE,
  CONSTRAINT `fk_Imagem_Nota1`
    FOREIGN KEY (`idNota`)
    REFERENCES `keep`.`Nota` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

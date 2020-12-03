- -----------------------------------------------------
-- Schema whattacook
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `whattacook`;
USE `whattacook` ;

-- -----------------------------------------------------
-- Table `whattacook`.`ingredient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattacook`.`ingredient` (
  `idingredient` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idingredient`)
  );

-- -----------------------------------------------------
-- Table `whattacook`.`recipe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattacook`.`recipe` (
  `idrecipe` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL DEFAULT NULL,
  `text` VARCHAR(45) NULL DEFAULT NULL,
   PRIMARY KEY (`idrecipe`)
    );

-- -----------------------------------------------------
-- Table `whattacook`.`recipe_ingredient`
-- -----------------------------------------------------
CREATE TABLE `recipe_ingredient` (
  `idrecipe` int(11) NOT NULL,
  `idingredient` int(11) NOT NULL,
  PRIMARY KEY (`idrecipe`,`idingredient`),
  FOREIGN KEY (`idrecipe`) REFERENCES recipe(`idrecipe`),
  FOREIGN KEY (`idingredient`) REFERENCES ingredient(`idingredient`)
)  


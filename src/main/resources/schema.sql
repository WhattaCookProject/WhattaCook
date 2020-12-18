- -----------------------------------------------------
-- Schema whattacook
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `whattacook`;
USE `whattacook`;

-- -----------------------------------------------------
-- Table `whattacook`.`ingredient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattacook`.`ingredient` (
  `id_ingredient` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_ingredient`)
  );

-- -----------------------------------------------------
-- Table `whattacook`.`recipe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattacook`.`recipe` (
  `id_recipe` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL DEFAULT NULL,
  `text` VARCHAR(45) NULL DEFAULT NULL,
   PRIMARY KEY (`id_recipe`)
    );

-- -----------------------------------------------------
-- Table `whattacook`.`recipe_ingredient`
-- -----------------------------------------------------
CREATE TABLE `recipe_ingredient` (
  `id_recipe` int(11) NOT NULL,
  `id_ingredient` int(11) NOT NULL,
  PRIMARY KEY (`id_recipe`,`id_ingredient`),
  FOREIGN KEY (`id_recipe`) REFERENCES recipe(`id_recipe`),
  FOREIGN KEY (`id_ingredient`) REFERENCES ingredient(`id_ingredient`)
)  


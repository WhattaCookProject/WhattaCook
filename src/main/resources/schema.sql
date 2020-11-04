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
-- Table `whattacook`.`ingredient_has_recipe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattacook`.`ingredient_has_recipe` (
  `ingredient_idingredient` INT NOT NULL,
  `recipe_idrecipe` INT NOT NULL,
  PRIMARY KEY (`ingredient_idingredient`, `recipe_idrecipe`),
  INDEX `fk_ingredient_has_recipe_recipe1_idx` (`recipe_idrecipe` ASC) VISIBLE,
  INDEX `fk_ingredient_has_recipe_ingredient_idx` (`ingredient_idingredient` ASC) VISIBLE,
  CONSTRAINT `fk_ingredient_has_recipe_ingredient`
    FOREIGN KEY (`ingredient_idingredient`)
    REFERENCES `whattacook`.`ingredient` (`idingredient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ingredient_has_recipe_recipe1`
    FOREIGN KEY (`recipe_idrecipe`)
    REFERENCES `whattacook`.`recipe` (`idrecipe`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    )


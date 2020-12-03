INSERT INTO `whattacook`.`ingredient` (`idingredient`, `name`) VALUES ('1', 'Apple');
INSERT INTO `whattacook`.`ingredient` (`idingredient`, `name`) VALUES ('2', 'Egg');

INSERT INTO `whattacook`.`recipe` (`idrecipe`, `title`, `text`) VALUES ('1', 'Apple pie', 'Apple pie recipe');
INSERT INTO `whattacook`.`recipe` (`idrecipe`, `title`, `text`) VALUES ('2', 'Spanish omelet', 'Spanish omelet recipe');

INSERT INTO `whattacook`.`recipe_ingredient` (`idrecipe`, `idingredient`) VALUES ('1', '1');
INSERT INTO `whattacook`.`recipe_ingredient` (`idrecipe`, `idingredient`) VALUES ('2', '2');


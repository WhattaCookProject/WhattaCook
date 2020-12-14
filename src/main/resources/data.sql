INSERT INTO `whattacook`.`ingredient` (`id_ingredient`, `name`) VALUES ('1', 'Apple');
INSERT INTO `whattacook`.`ingredient` (`id_ingredient`, `name`) VALUES ('2', 'Egg');

INSERT INTO `whattacook`.`recipe` (`id_recipe`, `title`, `text`) VALUES ('1', 'Apple pie', 'Apple pie recipe');
INSERT INTO `whattacook`.`recipe` (`id_recipe`, `title`, `text`) VALUES ('2', 'Spanish omelet', 'Spanish omelet recipe');

INSERT INTO `whattacook`.`recipe_ingredient` (`id_recipe`, `id_ingredient`) VALUES ('1', '1');
INSERT INTO `whattacook`.`recipe_ingredient` (`id_recipe`, `id_ingredient`) VALUES ('2', '2');


INSERT INTO `whattacook`.`ingredient` (`id_ingredient`, `name`) VALUES ('1', 'Papa');
INSERT INTO `whattacook`.`ingredient` (`id_ingredient`, `name`) VALUES ('2', 'Cebolla');
INSERT INTO `whattacook`.`ingredient` (`id_ingredient`, `name`) VALUES ('3', 'Aceite');
INSERT INTO `whattacook`.`ingredient` (`id_ingredient`, `name`) VALUES ('4', 'Sal');
INSERT INTO `whattacook`.`ingredient` (`id_ingredient`, `name`) VALUES ('5', 'Huevo');
INSERT INTO `whattacook`.`ingredient` (`id_ingredient`, `name`) VALUES ('6', 'Fideos');
INSERT INTO `whattacook`.`ingredient` (`id_ingredient`, `name`) VALUES ('7', 'Salsa de Tomate');
INSERT INTO `whattacook`.`ingredient` (`id_ingredient`, `name`) VALUES ('8', 'Tomate');
INSERT INTO `whattacook`.`ingredient` (`id_ingredient`, `name`) VALUES ('9', 'Zanahoria');
INSERT INTO `whattacook`.`ingredient` (`id_ingredient`, `name`) VALUES ('10', 'Lechuga');

INSERT INTO `whattacook`.`recipe` (`id_recipe`, `title`, `text`) VALUES ('1', 'Tortilla de Papas', 'Tortilla de Papas recipe');
INSERT INTO `whattacook`.`recipe` (`id_recipe`, `title`, `text`) VALUES ('2', 'Fideos con Tuco', 'Fideos con Tuco recipe');
INSERT INTO `whattacook`.`recipe` (`id_recipe`, `title`, `text`) VALUES ('3', 'Ensalada', 'Ensalada recipe');

INSERT INTO `whattacook`.`recipe_ingredient` (`id_recipe`, `id_ingredient`) VALUES ('1', '1');
INSERT INTO `whattacook`.`recipe_ingredient` (`id_recipe`, `id_ingredient`) VALUES ('1', '2');
INSERT INTO `whattacook`.`recipe_ingredient` (`id_recipe`, `id_ingredient`) VALUES ('1', '3');
INSERT INTO `whattacook`.`recipe_ingredient` (`id_recipe`, `id_ingredient`) VALUES ('1', '4');
INSERT INTO `whattacook`.`recipe_ingredient` (`id_recipe`, `id_ingredient`) VALUES ('1', '5');
INSERT INTO `whattacook`.`recipe_ingredient` (`id_recipe`, `id_ingredient`) VALUES ('2', '2');
INSERT INTO `whattacook`.`recipe_ingredient` (`id_recipe`, `id_ingredient`) VALUES ('2', '3');
INSERT INTO `whattacook`.`recipe_ingredient` (`id_recipe`, `id_ingredient`) VALUES ('2', '4');
INSERT INTO `whattacook`.`recipe_ingredient` (`id_recipe`, `id_ingredient`) VALUES ('2', '6');
INSERT INTO `whattacook`.`recipe_ingredient` (`id_recipe`, `id_ingredient`) VALUES ('2', '7');
INSERT INTO `whattacook`.`recipe_ingredient` (`id_recipe`, `id_ingredient`) VALUES ('3', '2');
INSERT INTO `whattacook`.`recipe_ingredient` (`id_recipe`, `id_ingredient`) VALUES ('3', '3');
INSERT INTO `whattacook`.`recipe_ingredient` (`id_recipe`, `id_ingredient`) VALUES ('3', '4');
INSERT INTO `whattacook`.`recipe_ingredient` (`id_recipe`, `id_ingredient`) VALUES ('3', '8');
INSERT INTO `whattacook`.`recipe_ingredient` (`id_recipe`, `id_ingredient`) VALUES ('3', '9');
INSERT INTO `whattacook`.`recipe_ingredient` (`id_recipe`, `id_ingredient`) VALUES ('3', '10');

package whattacook.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import whattacook.dto.Ingredient;

public interface IIngredientDAO extends JpaRepository<Ingredient, Long>{
	Ingredient findIngredientByName(String name);
}

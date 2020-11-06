package whattacook.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import whattacook.dto.Recipe;

public interface IRecipeDAO extends JpaRepository<Recipe, Long> {
	Recipe findRecipeByTitle(String title);
	

}

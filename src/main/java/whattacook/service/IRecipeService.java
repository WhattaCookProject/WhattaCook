package whattacook.service;

import java.util.List;

import whattacook.dto.Recipe;

public interface IRecipeService {

	//GET all
	List<Recipe> showAllRecipes();

	//GET by id
	Recipe showRecipeById(Long id);

	//POST
	Recipe saveNewRecipe(Recipe recipe);

	//DELETE
	void deleteRecipe(Long id);

	//PUT
	Recipe modifyRecipe(Recipe recipe);

}

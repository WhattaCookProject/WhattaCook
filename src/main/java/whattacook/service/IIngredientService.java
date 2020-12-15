package whattacook.service;

import java.util.HashMap;
import java.util.List;

import whattacook.dto.Ingredient;

public interface IIngredientService {

	//GET all
	public List<Ingredient> showAllIngredients();
	
	//GET by id
	public Ingredient showIngredientById(Long id);
	
	//POST
	public Ingredient saveNewIngredient(Ingredient ingredient);
	
	//PUT
	public Ingredient modifyNameIngredient(Ingredient ingredient);
	
	//DELETE
	public void deleteIngredient(Long id);

	//Returns alacenaList
	List<Long> alacenaList();

	//Returns HashMap with recipe id & times that is repeated
	HashMap<String, Double> recipeCounter(List<Long> alacenaList);
}

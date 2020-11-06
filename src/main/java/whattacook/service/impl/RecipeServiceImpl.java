package whattacook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whattacook.dao.IRecipeDAO;
import whattacook.dto.Recipe;
import whattacook.service.IRecipeService;

@Service
public class RecipeServiceImpl implements IRecipeService {
	
	@Autowired
	private IRecipeDAO iRecipeDao;
	
	@Autowired
	IRecipeService iRecipeService;

	//GET all 
	@Override
	public List<Recipe> showAllRecipes() {
		return iRecipeDao.findAll();
	}

	//GET by id
	@Override
	public Recipe showRecipeById(Long id) {
		return iRecipeDao.findById(id).get();
	}

	//POST
	@Override
	public Recipe saveNewRecipe(Recipe recipe) {
		return iRecipeDao.save(recipe);
	}

	//PUT the recipe name
	@Override
	public Recipe modifyRecipe(Recipe recipe) {
		List<Recipe> recipeList = iRecipeService.showAllRecipes();
		for(Recipe recipeFor : recipeList) {
			if(recipeFor.getId() == recipe.getId()) {
				recipeFor.setTitle(recipe.getTitle());
				recipeFor.setText(recipe.getText());
				return iRecipeDao.save(recipeFor);
			}
		}
		return null;
	}

	//DELETE by Id
	@Override
	public void deleteRecipe(Long id) {
		iRecipeDao.deleteById(id);
	}

}

package whattacook.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whattacook.dao.IIngredientDAO;
import whattacook.dto.Ingredient;
import whattacook.dto.Recipe;
import whattacook.service.IIngredientService;
import whattacook.service.IRecipeService;

@Service
public class IngredientServiceImpl implements IIngredientService{

	@Autowired
	private IIngredientDAO iIngredientDao;
	@Autowired
	IRecipeService iRecipeService;
	
	@Autowired
	IIngredientService iIngredientService;

	//GET all 
	@Override
	public List<Ingredient> showAllIngredients() {
		return iIngredientDao.findAll();
	}

	//GET by id
	@Override
	public Ingredient showIngredientById(Long id) {
		return iIngredientDao.findById(id).get();
	}

	//POST
	@Override
	public Ingredient saveNewIngredient(Ingredient ingredient) {
		return iIngredientDao.save(ingredient);
	}

	//PUT the ingredient name
	@Override
	public Ingredient modifyNameIngredient(Ingredient ingredient) {
		List<Ingredient> ingredientList = iIngredientService.showAllIngredients();
		for(Ingredient ingredientFor : ingredientList) {
			if(ingredientFor.getId() == ingredient.getId()) {
				ingredientFor.setName(ingredient.getName());
				return iIngredientDao.save(ingredientFor);
			}
		}
		return null;
	}

	//DELETE by Id
	@Override
	public void deleteIngredient(Long id) {
		iIngredientDao.deleteById(id);
	}
	
	
	//GET RECIPES WITH CHOOSEN INGREDIENTS + SUCCESS RATE
	@Override
	public HashMap<Integer, Object> recipeCounter(List<Long> alacenaList){
		HashMap<Integer, Object> recipeSR = new HashMap<>();
        List<Recipe> recipes = iRecipeService.showAllRecipes();
        double successRate;
        
        //Recorro las recetas:
        for(int i=0; i<recipes.size();i++) {
        	Set<Ingredient> isMadeWith = recipes.get(i).getIsMadeWith();
        	int cont=0;
        	//Por cada ingrediente:
            for (Ingredient ing:isMadeWith) {
            	//Por cada ingrediente en alacena:
            	for(Long alacenaIng:alacenaList) {
            		if(alacenaIng.equals(ing.getId())) {
            			cont++;
            		}
            	}
            } 
            if(cont>0) { // Add recipe to list if has at least 1 ingredient
        		successRate=((double)cont/(double)isMadeWith.size())*100;
            	recipeSR.put((int)successRate,recipes.get(i)); // key = success rate x100 as Integer  --> value = recipe object
        	}
        }
        HashMap<Integer, Object> recipeCountSortedByCount = recipeSR.entrySet()
                .stream()
                .sorted((Map.Entry.<Integer, Object>comparingByKey().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
        return recipeCountSortedByCount;
	
	}
	

	
}

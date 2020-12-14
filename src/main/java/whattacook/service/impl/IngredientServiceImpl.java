package whattacook.service.impl;

import java.util.ArrayList;
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

	@Override
	public List<Long> alacenaList(){
		List<Long> alacenaList = new ArrayList<Long>();

		alacenaList.add((long) 2);
		alacenaList.add((long) 3);
		alacenaList.add((long) 4);
		alacenaList.add((long) 8);
		alacenaList.add((long) 9);

		return alacenaList;
	}
	
	/*	Traigo lista con ids(Long) y comparo si coincide con algun id de ingredientes de las recipes 
	 *	guardo el id del recipe que coincide y el SuccessRate
	 */	
	@Override
	public HashMap<Long, Double> recipeCounter(List<Long> alacenaList){
		HashMap<Long, Double> recipeSR = new HashMap<>();
        List<Recipe> recipes = iRecipeService.showAllRecipes();
        double successRate;
        
        //recorro las recetas
        for(int i=0; i<recipes.size();i++) {
        	Set<Ingredient> isMadeWith = recipes.get(i).getIsMadeWith();
        	int cont=0;
        	//por cada ingrediente
            for (Ingredient ing:isMadeWith) {
            	//por cada ingrediente mio
            	for(Long alacenaIng:alacenaList) {
            		//si son iguales
            		if(alacenaIng.equals(ing.getId())) {
            			//sumo a un contador
            			cont++;
            		}
            	}
            	//almaceno la receta y la cantidad de veces que coincidio su ing con un ing mio
            	successRate=((double)cont/(double)isMadeWith.size());
            	recipeSR.put(recipes.get(i).getId(), successRate);
              }    	
        }
        HashMap<Long, Double> recipeCountSortedByCount = recipeSR.entrySet()
                .stream()
                .sorted((Map.Entry.<Long, Double>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
		return recipeCountSortedByCount;
	}
	

	
}

package whattacook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whattacook.dao.IIngredientDAO;
import whattacook.dto.Ingredient;
import whattacook.service.IIngredientService;

@Service
public class IngredientServiceImpl implements IIngredientService{

	@Autowired
	private IIngredientDAO iIngredientDao;
	
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

		alacenaList.add(1);//Papa
		alacenaList.add(2);//Cebolla
		alacenaList.add(3);//Aceite
		alacenaList.add(4);//Sal
		alacenaList.add(5);//Huevo

		return alacenaList;
	}
	

	
}

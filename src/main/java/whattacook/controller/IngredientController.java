package whattacook.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import whattacook.dto.Ingredient;
import whattacook.service.IIngredientService;
import whattacook.service.impl.IngredientServiceImpl;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
	
	@Autowired
	IIngredientService iIngredientService;
	
	//CREATE-POST
	@PostMapping
	public HashMap<String, Object> saveNewIngredient(@RequestBody Ingredient newIngredient){
		
		HashMap<String, Object> map = new HashMap<>();
		
		try {
			Ingredient ingredientToSave = iIngredientService.saveNewIngredient(newIngredient);
			map.put("success", true);
			map.put("message", "Ingredient created");
			map.put("ingredient", ingredientToSave);
		}catch(Exception e) {
			map.put("success", false);
			map.put("message", "Ingredient not created: " + e.getMessage());
		}
		
		return map;
		
	}
	

	//READ-GET
		
	//Show all ingredients
	@GetMapping("/all")
	public HashMap<String, Object> showAllIngredients(){
		
		HashMap<String, Object> map = new HashMap<>();
		
		try {
			List<Ingredient> ingredientsToShow = iIngredientService.showAllIngredients();
			map.put("success", true);
			map.put("message", "Got all Ingredients");
			map.put("ingredient", ingredientsToShow);
		}catch(Exception e) {
			map.put("success", false);
			map.put("message","No ingredients to be show: " + e.getMessage());
		}
		
		return map;
	}
	
	//Show ingredient by id
	@GetMapping("/{id}")
	public HashMap<String, Object> showIngredientById(@PathVariable Long id){
		
		HashMap<String, Object> map = new HashMap<>(); 
		
		try {
			Ingredient toShowIngredient = iIngredientService.showIngredientById(id);
			map.put("success", true);
			map.put("message", "Got one Ingredient");
			map.put("ingredient", toShowIngredient);
		}catch(Exception e){
			map.put("success", false);
			map.put("message","No ingredients to be show: " + e.getMessage());
		}
		
		return map;
	}
	
	//UPDATE-PUT
	@PutMapping
	public HashMap<String, Object> modifyIngredient(@RequestBody Ingredient ingredientUpdated){
		
		HashMap<String, Object> map = new HashMap<>();
		
		try {
			Ingredient ingredientMod = iIngredientService.modifyNameIngredient(ingredientUpdated);
			map.put("success", true);
			map.put("message", "Ingredient updated");
			map.put("ingredient", ingredientMod);
		}catch(Exception e) {
			map.put("success", false);
			map.put("message", "The ingredient has not been updated: " + e.getMessage());
		}
		
		return map;
	}
	
	//DELETE
	@DeleteMapping("/{id}")
	public HashMap<String, Object> deleteIngredient(@PathVariable Long id){
		
		HashMap<String, Object> map = new HashMap<>();
		
		try {
			iIngredientService.deleteIngredient(id);
			map.put("success", true);
			map.put("message", "The ingredient with the id " + id + " has deleted.");
		}catch(Exception e) {
			map.put("success", false);
			map.put("message", "This id ingredient does not exist");
		}
		
		return map;
	}
		
}
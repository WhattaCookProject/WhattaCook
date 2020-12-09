package whattacook.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import whattacook.dto.Recipe;
import whattacook.service.IRecipeService;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

	@Autowired
	IRecipeService iRecipeService;

    //CREATE-POST
    @PostMapping
    public HashMap<String, Object> saveNewRecipe(@RequestBody Recipe newRecipe){

        HashMap<String, Object> map = new HashMap<>();

        try {
            Recipe recipeToSave = iRecipeService.saveNewRecipe(newRecipe);
            map.put("success", true);
            map.put("message", "Recipe created");
            map.put("recipe", recipeToSave);
        }catch(Exception e) {
            map.put("success", false);
            map.put("message", "Recipe not created: " + e.getMessage());
        }

        return map;

    }

    
    //READ-GET

    //Show all Recipes
    @CrossOrigin
    @GetMapping("/all")
    public HashMap<String, Object> showAllRecipes(){

        HashMap<String, Object> map = new HashMap<>();

        try {
            List<Recipe> recipesToShow = iRecipeService.showAllRecipes();
            map.put("success", true);
            map.put("message", "Got all Recipes");
            map.put("recipe", recipesToShow);
        }catch(Exception e) {
            map.put("success", false);
            map.put("message","No recipes to be show: " + e.getMessage());
        }

        return map;
    }

    //Show recipe by id
    @GetMapping("/{id}")
    public HashMap<String, Object> showRecipeById(@PathVariable Long id){

        HashMap<String, Object> map = new HashMap<>();

        try {
            Recipe toShowRecipe = iRecipeService.showRecipeById(id);
            map.put("success", true);
            map.put("message", "Got one Recipe");
            map.put("recipe", toShowRecipe);
        }catch(Exception e){
            map.put("success", false);
            map.put("message","No Recipes to be show: " + e.getMessage());
        }

        return map;
    }

    //UPDATE-PUT
    @PutMapping
    public HashMap<String, Object> modifyRecipe(@RequestBody Recipe recipeUpdated){

        HashMap<String, Object> map = new HashMap<>();

        try {
            Recipe recipeMod = iRecipeService.modifyRecipe(recipeUpdated);
            map.put("success", true);
            map.put("message", "Recipe updated");
            map.put("recipe", recipeMod);
        }catch(Exception e) {
            map.put("success", false);
            map.put("message", "The recipe has not been updated: " + e.getMessage());
        }

        return map;
    }

    //DELETE
    @DeleteMapping("/{id}")
    public HashMap<String, Object> deleteRecipe(@PathVariable Long id){

        HashMap<String, Object> map = new HashMap<>();

        try {
            iRecipeService.deleteRecipe(id);
            map.put("success", true);
            map.put("message", "The recipe with the id " + id + " has deleted.");
        }catch(Exception e) {
            map.put("success", false);
3        }

        return map;
    }



}

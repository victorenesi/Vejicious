package uk.ac.tees.b1196119.vejicious.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RandomRecipeApiResponse {

	@SerializedName("recipes")
	private List<Recipe> recipes;

	public void setRecipes(List<Recipe> recipes){
		this.recipes = recipes;
	}

	public List<Recipe> getRecipes(){
		return recipes;
	}



}
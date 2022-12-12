package uk.ac.tees.b1196119.vejicious.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AnalyzedInstructionsItem{

	@SerializedName("name")
	private String name;

	@SerializedName("steps")
	private List<Step> steps;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSteps(List<Step> steps){
		this.steps = steps;
	}

	public List<Step> getSteps(){
		return steps;
	}
}
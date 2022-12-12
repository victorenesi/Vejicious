package uk.ac.tees.b1196119.vejicious.Models;

import com.google.gson.annotations.SerializedName;

public class EquipmentItem{

	@SerializedName("image")
	private String image;

	@SerializedName("localizedName")
	private String localizedName;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setLocalizedName(String localizedName){
		this.localizedName = localizedName;
	}

	public String getLocalizedName(){
		return localizedName;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
}
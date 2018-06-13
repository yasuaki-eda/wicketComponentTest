package com.edans.model;

import org.apache.wicket.util.io.IClusterable;

public class FoodType implements IClusterable{

	private int id;
	private String name;
	private String type;

	public FoodType (int id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public FoodType() {
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}



}

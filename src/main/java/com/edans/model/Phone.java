package com.edans.model;

import org.apache.wicket.util.io.IClusterable;

public class Phone implements IClusterable {

	private String name;
	private int id;
	private String description;

	public Phone(String name, int id, String description) {
		this.name = name;
		this.id = id;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

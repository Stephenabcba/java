package com.stephenlee.abstractart;

public class Sculpture extends Art {
	private String material;
	
	public Sculpture(String title) {
		this.title = title;
		this.author = "Unknown";
		this.description = "";
		this.material = "Unknown";
	}
	@Override
	public void viewArt() {
		System.out.println("Currently Viewing a Sculpture.");
		System.out.println("Title: " + this.title + " | Author: " + this.author + " | Description: " + this.description + " | Material: " + this.material);
	}

}

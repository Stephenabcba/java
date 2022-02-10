package com.stephenlee.abstractart;

public class Painting extends Art {
	private String paintType;
	
	public Painting(String title) {
		this.title = title;
		this.author = "Unknown";
		this.description = "";
		this.paintType = "Unknown";
	}

	@Override
	public void viewArt() {
		System.out.println("Currently Viewing a Painting.");
		System.out.println("Title: " + this.title + " | Author: " + this.author + " | Description: " + this.description + " | Paint type: " + this.paintType);
	}

}

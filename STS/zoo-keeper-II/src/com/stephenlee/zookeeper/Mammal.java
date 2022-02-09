package com.stephenlee.zookeeper;

public class Mammal {
	// ATTRIBUTES 
	protected int energy;

	// CONSTRUCTOR
	public Mammal() {
		this.energy = 100;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	public int displayEnergy() {
		System.out.println(this.energy);
		return this.energy;
	}
	
}

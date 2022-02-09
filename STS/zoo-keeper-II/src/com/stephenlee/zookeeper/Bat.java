package com.stephenlee.zookeeper;

public class Bat extends Mammal{
	public Bat() {
		this.energy = 300;
	}
	
	public void fly() {
		System.out.println("*Bat taking off sounds*");
		this.energy -= 50;
	}
	
	public void eatHumans() {
		this.energy += 25;
	}
	
	public void attackTown() {
		System.out.println("*Town on fire noises*");
		this.energy -= 100;
	}
}

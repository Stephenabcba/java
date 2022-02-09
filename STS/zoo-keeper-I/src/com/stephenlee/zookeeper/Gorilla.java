package com.stephenlee.zookeeper;

public class Gorilla extends Mammal {
	public Gorilla() {
		super();
	}
	
	public void throwSomething() {
		System.out.println("The gorilla threw something. -5 energy.");
		this.energy -= 5;
	}
	
	public void eatBananas() {
		System.out.println("The gorilla ate bananas. +10 energy.");
		this.energy += 10;
	}
	
	public void climb() {
		System.out.println("The gorilla climbed. -10 energy.");
		this.energy -= 10;
	}
}

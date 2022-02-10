package com.stephenlee.calculator;

public class TestCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c = new Calculator();
		c.performOperation(10.5);
		c.performOperation("+");
		c.performOperation(5.2);
		c.performOperation("*");
		c.performOperation(10);
		c.performOperation("=");
		System.out.println(c.getResults());
		c.clear();
		c.performOperation(5);
		c.performOperation("+");
		c.performOperation(10);
		c.performOperation("*");
		c.performOperation(10);
		c.performOperation("=");
		System.out.println(c.getResults());
	}

}

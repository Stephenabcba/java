package com.stephenlee.calculator;

public class TestCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c = new Calculator();
		c.setOperandOne(10.5);
		c.setOperandTwo(5.2);
		c.setOperation("+");
		c.performOperation();
		System.out.println(c.getResults());
	}

}

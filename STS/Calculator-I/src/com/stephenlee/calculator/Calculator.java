package com.stephenlee.calculator;

public class Calculator implements java.io.Serializable {
	private double operandOne;
	private double operandTwo;
	private String operation;
	private double results;
	
	public Calculator() {}

	public double getOperandOne() {
		return operandOne;
	}

	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}

	public double getOperandTwo() {
		return operandTwo;
	}

	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public double getResults() {
		return results;
	}

	public void setResults(double results) {
		this.results = results;
	}
	
	public void performOperation() {
		if (this.operation == "+" ) {
			this.results = this.operandOne + this.operandTwo;
		} else {
			this.results = this.operandOne - this.operandTwo;
		}
	}
}

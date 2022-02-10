package com.stephenlee.calculator;

import java.util.ArrayList;

public class Calculator implements java.io.Serializable {
	private double results;
	private ArrayList<String> operations;
	private ArrayList<Double> operands;

	public Calculator() {
		this.operands = new ArrayList<Double>();
		this.operations = new ArrayList<String>();
	}

	public double getResults() {
		return results;
	}

	public void setResults(double results) {
		this.results = results;
	}

	public ArrayList<String> getOperations() {
		return operations;
	}

	public void setOperations(ArrayList<String> operations) {
		this.operations = operations;
	}

	public ArrayList<Double> getOperands() {
		return operands;
	}

	public void setOperands(ArrayList<Double> operands) {
		this.operands = operands;
	}

	public void performOperation(String operation) {
		if (operation == "=") {
			this.calculate();
		} else {
			this.operations.add(operation);
		}
	}

	public void performOperation(double operand) {
		this.operands.add(operand);
	}
	
	public void clear() {
		this.operands.clear();
		this.operations.clear();
		this.results = 0;
	}

	private void calculate() {
		int index = 0;
		while(this.operations.contains("*") || this.operations.contains("/")) {
			if (this.operations.get(index)=="*" || this.operations.get(index)=="/") {
				double tempResult;
				if (this.operations.get(index)=="*") {
					tempResult = this.operands.get(index) * this.operands.get(index+1);
				} else {
					tempResult = this.operands.get(index) / this.operands.get(index+1);
				}
				this.operands.set(index, tempResult);
				this.operations.remove(index);
				this.operands.remove(index+1);
			} else {
				index++;
			}
			if (index >= this.operations.size()) {
				index = 0;
			}
		}
		index = 0;
		while(this.operations.contains("+") || this.operations.contains("-")) {
			if (this.operations.get(index)=="+" || this.operations.get(index)=="-") {
				double tempResult;
				if (this.operations.get(index)=="+") {
					tempResult = this.operands.get(index) + this.operands.get(index+1);
				} else {
					tempResult = this.operands.get(index) - this.operands.get(index+1);
				}
				this.operands.set(index, tempResult);
				this.operations.remove(index);
				this.operands.remove(index+1);
			} else {
				index++;
			}
			if (index >= this.operations.size()) {
				index = 0;
			}
		}
		this.results = this.operands.get(0);
	}
}

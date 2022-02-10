package com.stephenlee.calculator;

public class Operand implements java.io.Serializable {
	private double operand;
	private boolean used;
	
	public Operand(double operand) {
		this.operand = operand;
	}

	public double getOperand() {
		return operand;
	}

	public void setOperand(double operand) {
		this.operand = operand;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
	
}

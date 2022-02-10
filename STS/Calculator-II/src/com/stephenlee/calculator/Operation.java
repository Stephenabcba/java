package com.stephenlee.calculator;

public class Operation implements java.io.Serializable {
	private String operation;
	private boolean used;
	
	public Operation(String operation) {
		this.operation = operation;
		this.used = false;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
	
}

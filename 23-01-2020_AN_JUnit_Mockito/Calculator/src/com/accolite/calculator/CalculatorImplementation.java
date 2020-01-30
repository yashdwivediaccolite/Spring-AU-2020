package com.accolite.calculator;

public class CalculatorImplementation{

	private CalculatorInterface impl;
	
	public void setImpl(CalculatorInterface impl) {
		this.impl=impl;
	}
	
	public double add(double a, double b) {
		return impl.add(a,b);
	}

	public double subtract(double a, double b) {
		return impl.subtract(a, b);
	}

	public double multiply(double a, double b) {
		return impl.multiply(a, b);
	}

	public double divide(double a, double b) {
		return impl.divide(a, b);
	}
	
}

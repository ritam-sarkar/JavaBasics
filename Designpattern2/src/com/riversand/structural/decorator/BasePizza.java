package com.riversand.structural.decorator;

public class BasePizza implements Pizza {

	@Override
	public String bake() {
		return "Base";
	}
	@Override
	public double getPrice() {
		return 100;
	}
}

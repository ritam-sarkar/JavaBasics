package com.riversand.structural.decorator;

abstract public class PizzaDecorator implements Pizza{

	protected Pizza pizza;
	public PizzaDecorator(Pizza pizza) {
		this.pizza = pizza;
	}
	
	@Override
	public String bake() {
		return pizza.bake();
	}
	public double getPrice() {
		return pizza.getPrice();
	}
}

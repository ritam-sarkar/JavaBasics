package com.design.creational.builder;

public class PizzaBuilder {	

	private Pizza pizza;
	public PizzaBuilder() {
		pizza = new Pizza();		
	}
	public void bread(String bread, double price) {
		pizza.setBread(bread);
		pizza.setPrice(pizza.getPrice()+price);
	}
	public void nonvegTopping(String topping, double price) {
		pizza.setNonvegTopping(topping);
		pizza.setPrice(pizza.getPrice()+price);
	}
	public void vegTopping(String topping, double price) {
		pizza.setVegTopping(topping);
		pizza.setPrice(pizza.getPrice()+price);
	}
	public Pizza build() {
		return pizza;
	}
}

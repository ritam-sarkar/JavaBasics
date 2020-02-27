package com.design.creational.builder;

public class PizzaBuilder {	

	private String bread;
	private String nonvegTopping;
	private String vegTopping;	
	private double price;
	
	public PizzaBuilder() {
	}
	public PizzaBuilder bread(String bread, double price) {
		this.bread = bread;
		price += price;
		return this;
	}
	public PizzaBuilder nonvegTopping(String topping, double price) {
		this.nonvegTopping = topping;
		this.price += price;
		return this;
	}
	public PizzaBuilder vegTopping(String topping, double price) {
		this.vegTopping = topping;
		this.price += price;
		return this;
	}
	public Pizza build() {
		return new Pizza(bread, nonvegTopping, vegTopping, price);
	}
}

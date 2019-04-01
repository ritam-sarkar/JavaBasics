package com.design.structural.decorator;

public class PaneerPizzaDecorator extends PizzaDecorator{

	private String topping;
	private double price;	
	public PaneerPizzaDecorator(Pizza pizza, String topping, double price) {
		super(pizza);
		this.topping = topping;	
		this.price = price;
	}
	public String getTopping() {
		return topping;
	}
	public String bake() {
		return this.topping + " "+super.bake();
	}
	public double getPrice() {
		return this.price + super.getPrice();
	}
}

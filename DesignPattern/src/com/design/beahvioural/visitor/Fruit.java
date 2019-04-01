package com.design.beahvioural.visitor;

public class Fruit implements Item{
	private String name;
	private int price;
	private int weight;
	public Fruit(String name, int price, int weight) {
		super();
		this.name = name;
		this.price = price;
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getWeight() {
		return weight;
	}
	@Override
	public int accept(ShoppingVisitor visitor) {
		return visitor.visit(this);
	}
	

}

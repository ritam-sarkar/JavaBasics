package com.design.beahvioural.visitor;

public class Book implements Item {
	
	private String name;
	private int price;

	@Override
	public int accept(ShoppingVisitor visitor) {
	   return  visitor.visit(this);
	}

	public Book(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	

}

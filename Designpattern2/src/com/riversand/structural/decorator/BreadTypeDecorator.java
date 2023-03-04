package com.riversand.structural.decorator;

public class BreadTypeDecorator extends SandwichDecorator {
	
	private String breadType;

	public BreadTypeDecorator(Sandwich customsandwich, String breadType) {
		super(customsandwich);
		this.breadType = breadType;
	}
	public String make() {
		return super.make()+" + "+addBreadType();
	}
	private String addBreadType() {
		return this.breadType;
	}

}

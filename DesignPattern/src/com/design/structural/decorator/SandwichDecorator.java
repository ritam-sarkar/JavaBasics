package com.design.structural.decorator;

public abstract class SandwichDecorator implements Sandwich{

	protected Sandwich customsandwich;

	public SandwichDecorator(Sandwich customsandwich) {
		super();
		this.customsandwich = customsandwich;
	}

	public SandwichDecorator() {
		super();
	}
	public String make() {
		return this.customsandwich.make();
	}
	
}

package com.design.structural.decorator;

public class FillingDecorator extends SandwichDecorator {
	private String fillingType;

	public FillingDecorator(Sandwich customsandwich, String fillingType) {
		super(customsandwich);
		this.fillingType = fillingType;
	};
	private String addFilling() {
		return this.fillingType;
	}
	public String make() {
		return super.make()+" + "+addFilling();
	}

}

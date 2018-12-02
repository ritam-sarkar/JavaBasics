/**
 * 
 */
package com.design.structural.decorator;

/**
 * @author ritsarka
 *
 */
public class MeatDecorator extends SandwichDecorator{

	private String meat;

	public MeatDecorator() {
		super();
	}

	public MeatDecorator(Sandwich customsandwich, String meat) {
		super(customsandwich);
		this.meat = meat;
	}
	private String addMeat() {
		return this.meat;
	}
	public String make() {
		return super.make()+" + "+addMeat();
	}
	
}

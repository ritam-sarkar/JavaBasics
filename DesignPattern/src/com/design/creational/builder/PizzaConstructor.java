/**
 * 
 */
package com.design.creational.builder;

/**
 * @author ritsarka
 *
 */
public class PizzaConstructor {

	private String bread;
	private String topping;
	private String type;
	public PizzaConstructor() {
		super();
	}
	
	public PizzaConstructor(String bread) {
		super();
		this.bread = bread;
	}
	

	public PizzaConstructor(String topping, String type) {
		super();
		this.topping = topping;
		this.type = type;
	}
	

	public PizzaConstructor(String bread, String topping, String type) {
		super();
		this.bread = bread;
		this.topping = topping;
		this.type = type;
	}

	public String getBread() {
		return bread;
	}
	public String getTopping() {
		return topping;
	}
	public String getType() {
		return type;
	}
	
	
	
}

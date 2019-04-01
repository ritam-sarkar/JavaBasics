/**
 * 
 */
package com.design.creational.factory;

/**
 * @author ritsarka
 *
 */
public abstract class Car {

	protected CarType model;
	protected String name;
	protected long price;
	protected abstract void construct();
	public Car(CarType model) {
		this.model = model;
		construct();
	}
	public CarType getModel() {
		return model;
	}
	public void setModel(CarType model) {
		this.model = model;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
}

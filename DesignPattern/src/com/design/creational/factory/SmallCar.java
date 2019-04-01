package com.design.creational.factory;

public class SmallCar extends Car{
	public SmallCar(CarType model) {
		super(model);
	}
	@Override
	protected void construct() {
		this.name = "Alto 800";
		this.price = 200000;		
	}
}

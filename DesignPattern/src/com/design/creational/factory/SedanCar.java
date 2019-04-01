package com.design.creational.factory;

public class SedanCar extends Car{	
	public SedanCar() {
		super(CarType.SEDAN);
	}
	@Override
	protected void construct() {
		this.name = "Honda city";
		this.price = 1000000;
	}
}

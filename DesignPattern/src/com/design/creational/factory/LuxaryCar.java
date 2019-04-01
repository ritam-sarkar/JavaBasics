package com.design.creational.factory;

public class LuxaryCar extends Car{
	public LuxaryCar() {
		super(CarType.LUXURY);		
	}
	@Override
	protected void construct() {
		this.name = "Audi";
		this.price = 30000000;
	}
}

package com.design.creational.factory;

public class CarFactory {

	public Car buildCar(CarType carType) {
		Car car = null;
		switch(carType) {
		   case LUXURY :
			   car = new LuxaryCar();
			   break;
		   case SEDAN :
			   car = new SedanCar();
			   break;
		   case SMALL :
			   car = new SmallCar(carType);
			   break;
		}
		return car;
	}
}

package com.design.creational.factory;

public class FactoryPatternDemo2 {

	public static void main(String[] args) {
		CarFactory carFactory = new CarFactory();
		Car luxary = carFactory.buildCar(CarType.LUXURY);
		Car sedan = carFactory.buildCar(CarType.SEDAN);
		Car small = carFactory.buildCar(CarType.SMALL);
		System.out.println(" Small "+small.getName()+" "+small.getPrice());
		System.out.println(" Sedan "+sedan.getName()+" "+sedan.getPrice());
		System.out.println(" Luxary "+luxary.getName()+" "+luxary.getPrice());
		
	}
}

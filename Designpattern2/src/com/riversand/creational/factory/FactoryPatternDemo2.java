package com.riversand.creational.factory;

public class FactoryPatternDemo2 {

	public static void main(String[] args) {
		CarFactory carFactory = new CarFactory();
		Car luxary = carFactory.getCar(CarType.LUXURY);
		Car sedan = carFactory.getCar(CarType.SEDAN);
		Car small = carFactory.getCar(CarType.SMALL);
		System.out.println(" Small "+small.getName()+" "+small.getPrice());
		System.out.println(" Sedan "+sedan.getName()+" "+sedan.getPrice());
		System.out.println(" Luxary "+luxary.getName()+" "+luxary.getPrice());
		
	}
}
enum CarType {
	SMALL, SEDAN, LUXURY
}
class CarFactory {

	public Car getCar(CarType carType) {
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
abstract class Car {

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
class LuxaryCar extends Car{
	public LuxaryCar() {
		super(CarType.LUXURY);
	}
	@Override
	protected void construct() {
		this.name = "Audi";
		this.price = 30000000;
	}
}
class SedanCar extends Car{
	public SedanCar() {
		super(CarType.SEDAN);
	}
	@Override
	protected void construct() {
		this.name = "Honda city";
		this.price = 1000000;
	}
}
class SmallCar extends Car{
	public SmallCar(CarType model) {
		super(model);
	}
	@Override
	protected void construct() {
		this.name = "Alto 800";
		this.price = 200000;
	}
}

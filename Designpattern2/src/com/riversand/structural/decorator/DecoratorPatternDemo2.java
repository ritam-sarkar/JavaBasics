package com.riversand.structural.decorator;

public class DecoratorPatternDemo2 {

	public static void main(String[] args) {

		BasePizza basePizza = new BasePizza();
		ChickenPizzaDecortor chickenPizzaDecortor = new ChickenPizzaDecortor(basePizza, "Chicken", 200);
		PaneerPizzaDecorator paneerPizzaDecorator = new PaneerPizzaDecorator(basePizza,"Paneer",150);
		CheeseDecorator finalChickenPizza = new CheeseDecorator(chickenPizzaDecortor, "Cheese", 50);
		CheeseDecorator finalPaneerPizza = new CheeseDecorator(paneerPizzaDecorator, "Cheese", 50);
		System.out.println("Chicken pizza "+finalChickenPizza.bake()+" "+finalChickenPizza.getPrice());
		System.out.println(" Paneer pizza "+finalPaneerPizza.bake()+"   "+finalPaneerPizza.getPrice());
	}

}

package com.design.creational.builder;

/**
 * 
 * @author ritsarka
 * 
 * Why use builder pattern
 * 
 * Complex constructor resolve
 * Large no of parameters
 * Immutable
 * Example {@link StringBuilder}
 *
 */
public class BuilderPatternDemo {

	public static void main(String[] args) {
		//callMutableClass();
		//callComplexConstructor();
		callBuilder();

	}
	/**
	 *  This call provide immutability, simple constructor set up
	 */
	private static void callBuilder() {
		PizzaBuilder pb1 = new PizzaBuilder();
		pb1.bread("Thin crust", 150).nonvegTopping("Chicken", 200);
		Pizza nonVeg = pb1.build();
		PizzaBuilder pb2 = new PizzaBuilder();
		pb2.bread("Normal ", 100).nonvegTopping("Mutton ", 300).vegTopping("Paneer ", 250);
		Pizza mixPizza = pb2.build();
		System.out.println(" Nonveg pizza "+ nonVeg.getBread()+" "+nonVeg.getNonvegTopping()+" "+nonVeg.getVegTopping()+" "+nonVeg.getPrice());
		System.out.println(" Mix pizza  "+ mixPizza.getBread()+" "+mixPizza.getNonvegTopping()+" "+mixPizza.getVegTopping()+" "+mixPizza.getPrice());
		
		
		
		
	}
	/**
	 * This call can provide immutability but , if there are large number of attributes, then we 
	 * cannot proceed with this approach, or if all attributes are of same type like String then 
	 * ambiguity problems can occur or so many of combination may decrease readability 
	 */
	private static void callComplexConstructor() {
		
		PizzaConstructor pizzaConstructor = new PizzaConstructor("soft bread", " peprika", "Veg");
		System.out.println("calling complex constructor class");
		System.out.println(pizzaConstructor.getBread()+"  "+pizzaConstructor.getTopping()+"  "+pizzaConstructor.getType());
		
	}

	private static void callMutableClass() {
		/*Pizza pizza = new Pizza();
		pizza.setBread("thin crust");
		pizza.setTopping("corn");
		pizza.setType("Veg");
		System.out.println("calling mutable class");
		System.out.println(pizza.getBread() + "  " + pizza.getTopping() + "  " + pizza.getType());*/
		
	}

}

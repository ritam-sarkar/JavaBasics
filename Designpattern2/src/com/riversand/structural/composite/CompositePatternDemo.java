package com.riversand.structural.composite;
/**
 * Componenets representpart of whole structure
 * Compose objects into tree structure
 * Individual object treated as Composite
 * Examples : java.awt.Componenet
 *            jsf widgets
 */
public class CompositePatternDemo {
	public static void main(String[] args) {
		
		Menu mainMenu = new Menu("main", "/main");
		MenuItem mainMenuItem1 = new MenuItem("HR", "/myhr");
		MenuItem mainMenuItem2 = new MenuItem("Meal", "/mealcard");
		mainMenu.add(mainMenuItem1);
		mainMenu.add(mainMenuItem2);
		Menu subMenu = new Menu("claim", "/cliam");
		MenuItem subMenuItem = new MenuItem("medical", "/medical");
		subMenu.add(subMenuItem);
		mainMenu.add(subMenu);
		System.out.println(mainMenu.toString());
		
		
		
	}
}


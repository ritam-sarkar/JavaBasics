package com.design.beahvioural.visitor;

import java.util.ArrayList;
import java.util.List;

public class VisitorPatternDemo {

	public static void main(String[] args) {

		List<Item> items = new ArrayList<Item>();
		items.add(new Book("Physics ", 500));
		items.add(new Book("Datastructure", 400));
		items.add(new Fruit("mango", 50, 2));
		items.add(new Fruit("Watermelon", 40, 4));
		ShoppingVisitor shoppingVisitor = new ShoppingVisitorImpl();
		int totatCost =0;
		for(Item item : items) {
			totatCost += item.accept(shoppingVisitor);
		}
		System.out.println(" Total shopping cost "+totatCost);
	}

}

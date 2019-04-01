package com.design.beahvioural.visitor;

public class ShoppingVisitorImpl implements ShoppingVisitor{

	public int visit(Book book) {
		System.out.println(" Visited the book "+book.getName());
		return book.getPrice();		
	}

	@Override
	public int visit(Fruit fruit) {
		System.out.println(" Visited the fruit "+fruit.getName()+" of weight "+fruit.getWeight());
		return fruit.getWeight()*fruit.getPrice();
	}
}

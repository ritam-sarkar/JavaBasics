package com.riversand.beahvioural.visitor;

import java.util.ArrayList;
import java.util.List;

public class VisitorPatternDemo {

    public static void main(String[] args) {

        List<Item> items = new ArrayList<Item>();
        items.add(new Book("Physics ", 500));
        items.add(new Book("Datastructure", 400));
        items.add(new Fruit("mango", 50, 2));
        items.add(new Fruit("Watermelon", 40, 4));
        ShoppingVisitor shoppingVisitor = new Alice();
        ShoppingVisitor bob = new Bob();
        int totatCost = 0;
        for (Item item : items) {
            totatCost += item.accept(shoppingVisitor);
        }
        System.out.println(" Total shopping cost " + totatCost);
    }

}

interface Item {
    int accept(ShoppingVisitor visitor);
}


class Book implements Item {

    private String name;
    private int price;

    @Override
    public int accept(ShoppingVisitor visitor) {
        return visitor.visit(this);
    }

    public Book(String name, int price) {
        super();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}

class Fruit implements Item {
    private String name;
    private int price;
    private int weight;

    public Fruit(String name, int price, int weight) {
        super();
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int accept(ShoppingVisitor visitor) {
        return visitor.visit(this);
    }


}

class Alice implements ShoppingVisitor {

    public int visit(Book book) {
        System.out.println(" Alice Visited the book " + book.getName());
        return book.getPrice();
    }

    @Override
    public int visit(Fruit fruit) {
        System.out.println(" Alice Visited the fruit " + fruit.getName() + " of weight " + fruit.getWeight());
        return fruit.getWeight() * fruit.getPrice();
    }
}
class Bob implements ShoppingVisitor {
	@Override
	public int visit(Book book) {
		System.out.println(" Blob Visited the book " + book.getName());
		return book.getPrice();
	}

	@Override
	public int visit(Fruit fruit) {
		System.out.println(" Bob Visited the fruit " + fruit.getName() + " of weight " + fruit.getWeight());
		return fruit.getWeight() * fruit.getPrice();
	}
}

interface ShoppingVisitor {
    int visit(Book book);

    int visit(Fruit fruit);
}


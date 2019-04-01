/**
 * 
 */
package com.design.creational.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ritsarka
 *
 * This pattern avoids costly creation
 * avoids subclassing because like builder pattern it follows immutablity
 * Usually implemented with registry
 * Example {@link Object#clone()} 
 * Unlike builder pattern it is difficult implement in legacy code.
 * Prototype design pattern is used when the Object creation is a costly affair and requires a lot of time
 * and resources and you have a similar object already existing
 * We can achieve this by using clone() method but it will create just another instance of the same object.
 */
public class PrototypePatternDemo {

	/**
	 * @param args
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		ItemRegistry itemRegistry = new ItemRegistry();
		Book book = (Book) itemRegistry.createItem(ItemRegistry.Type.BOOK);
		Dvd dvd = (Dvd)itemRegistry.createItem(ItemRegistry.Type.DVD);
		System.out.println("Books data"+book.getName()+" "+book.getPrice()+" "+book.getNumberofPages());
		System.out.println("DVD data"+dvd.getName()+" "+dvd.getPrice()+" "+dvd.getRunTime());
		
	}

}
class ItemRegistry{
	private Map<Type,Item> items = new HashMap<Type,Item>();
	public ItemRegistry() {
		loadItems();
	}
	public Item createItem(Type type) throws CloneNotSupportedException {
		return (Item)items.get(type).clone();
	}
	private void loadItems() {
		
		Book book = new Book();
		book.setName("gangs of four");
		book.setPrice(335L);
		book.setNumberofPages(1000);
		items.put(Type.BOOK, book);
		Dvd dvd = new Dvd();
		dvd.setName("Gangs of wassepur");
		dvd.setPrice(100L);
		dvd.setRunTime(2.54);
		items.put(Type.DVD, dvd);
		
	}
	public static enum Type{
		BOOK,DVD;
	}
}
abstract class Item implements Cloneable{
	
	private String name;
	private Long price;
	public String getName() {
		return name;
	}
	public Long getPrice() {
		return price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
class Book extends Item{
	private int numberofPages;

	public int getNumberofPages() {
		return numberofPages;
	}
	public void setNumberofPages(int numberofPages) {
		this.numberofPages = numberofPages;
	}	
}
class Dvd extends Item{
	private double runTime;

	public double getRunTime() {
		return runTime;
	}

	public void setRunTime(double runTime) {
		this.runTime = runTime;
	}	
}

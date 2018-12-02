/**
 * 
 */
package com.design.structural.fyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * More efficient use of memmory
 * Large number of similar objects
 * Immutable
 * Example {@link Integer}
 * Example {@link String}
 * @author ritsarka
 *
 */
public class InventorySystem {
	private Catalog catalog = new Catalog();
	private List<Order> orders = new ArrayList<Order>();
	public void takeOrder(String name, int orderNumber) {
		Item item = catalog.lookUp(name);
		orders.add(new Order(item, orderNumber));
	}
	public void process() {
		for(Order order : orders) {
			System.out.println(order.processOrder());
		}
		System.out.println("catalog size "+catalog.catalogSize());
	}

}

/**
 * 
 */
package com.riversand.structural.fyweight;

/**
 * @author ritsarka
 *
 */
public class Order {
	private Item item;
	private int orderNumber;
	public Order(Item item, int orderNumber) {
		super();
		this.item = item;
		this.orderNumber = orderNumber;
	}	
	public String processOrder() {
		return "Order place for "+item+" order number "+orderNumber;
	}

}

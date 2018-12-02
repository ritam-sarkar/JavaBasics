/**
 * 
 */
package com.design.structural.fyweight;

/**
 * @author ritsarka
 *
 */
public class Item {
	
	private String name;

	public Item(String name) {
		super();
		this.name = name;
	}
	@Override
	public  String toString() {
		return this.name;
	}

}

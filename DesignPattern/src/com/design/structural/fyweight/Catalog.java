/**
 * 
 */
package com.design.structural.fyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ritsarka
 *
 */
public class Catalog {

	private Map<String,Item> items = new HashMap<String,Item>();
	public Item lookUp(String name) {
		if(!items.containsKey(name)) {
			items.put(name, new Item(name));
		}
		return items.get(name);
	}
	public int catalogSize() {
		return items.size();
	}
	
}

/**
 * 
 */
package com.design.structural.composite;

import java.util.Iterator;

/**
 * @author ritsarka
 *
 */
public class Menu extends MenuComponent {

	public Menu(String name, String url) {
		super(name, url);
	}
	@Override
	public String toString() {
		System.out.println(print(this));
		Iterator<MenuComponent> itr = menucomponents.iterator();
		StringBuilder strBuilder = new StringBuilder();
		while(itr.hasNext()) {
			MenuComponent menuComponent = itr.next();
			strBuilder.append(print(menuComponent));
		}
		
		return strBuilder.toString();
	}

	protected MenuComponent add(MenuComponent menucomponenet) {
		menucomponents.add(menucomponenet);
		return menucomponenet;
	}

	protected MenuComponent remove(MenuComponent menuComponent) {
		menucomponents.remove(menuComponent);
		return menuComponent;
	}

}

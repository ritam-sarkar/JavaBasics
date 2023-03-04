/**
 * 
 */
package com.riversand.structural.composite;

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
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(print());
		
		Iterator<MenuComponent> itr = menucomponents.iterator();		
		while(itr.hasNext()) {
			MenuComponent menuComponent = itr.next();
			strBuilder.append(menuComponent.toString());
		}
		
		return strBuilder.toString();
	}

	protected void add(MenuComponent menucomponenet) {
		menucomponents.add(menucomponenet);
	}

	protected MenuComponent remove(MenuComponent menuComponent) {
		menucomponents.remove(menuComponent);
		return menuComponent;
	}

}

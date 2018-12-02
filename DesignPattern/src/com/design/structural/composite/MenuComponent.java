/**
 * 
 */
package com.design.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ritsarka
 *
 */
public abstract class MenuComponent {
	
	protected List<MenuComponent> menucomponents;
	protected String name;
	protected String url;
	public MenuComponent() {
		this.menucomponents = new ArrayList<MenuComponent>();
	}
	public List<MenuComponent> getMenucomponents() {
		return menucomponents;
	}
	public String getName() {
		return name;
	}
	public String getUrl() {
		return url;
	}
	public String print(MenuComponent menuComponent) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(menuComponent.getName()).append(" : ").append(menuComponent.getUrl());
		strBuilder.append("\n");
		return strBuilder.toString();
	}
	public abstract String toString();
		
    
}

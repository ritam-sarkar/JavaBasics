/**
 * 
 */
package com.riversand.structural.composite;

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
	public MenuComponent(String name, String url) {
		this.name = name;
		this.url = url;
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
	public String print() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(this.getName()).append(" : ").append(this.getUrl());
		strBuilder.append("\n");
		return strBuilder.toString();
	}
	public abstract String toString();
		
    
}

package com.design.structural.facade;

import java.util.ArrayList;
import java.util.List;

public class NonVegRestaurant implements Restaurant {

	@Override
	public List<String> getMenu() {
		List<String> menus = new ArrayList<String>();
		menus.add("Chicken");
		menus.add("Fish");
		return menus;
	}

}

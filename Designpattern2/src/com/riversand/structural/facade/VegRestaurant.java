package com.riversand.structural.facade;

import java.util.ArrayList;
import java.util.List;

public class VegRestaurant implements Restaurant {

	@Override
	public List<String> getMenu() {
		List<String> menus = new ArrayList<String>();
		menus.add("Paneer");
		menus.add("Gobi");
		return menus;
	}

}

package com.riversand.structural.facade;

import java.util.ArrayList;
import java.util.List;

public class LiquorShop implements Restaurant {

	@Override
	public List<String> getMenu() {
		List<String> menus = new ArrayList<String>();
		menus.add("Tuborg");
		menus.add("Jack daniel");
		return menus;
	}

}

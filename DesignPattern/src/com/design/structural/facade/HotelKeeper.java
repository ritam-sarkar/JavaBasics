package com.design.structural.facade;

import java.util.List;

public class HotelKeeper {

	public List<String> getMenus(Menu menu){
		List<String> menus = null;
		switch(menu) {
		case VEG :
			Restaurant vegResTaurant = new VegRestaurant();
			menus = vegResTaurant.getMenu();
			break;
		case NONVEG :
			Restaurant nonVegRestaurant = new NonVegRestaurant();
			menus = nonVegRestaurant.getMenu();
			break;
		case LIQUOR :
			Restaurant liquorShop = new LiquorShop();
			menus = liquorShop.getMenu();
			break;
		}
		return menus;
	}

}

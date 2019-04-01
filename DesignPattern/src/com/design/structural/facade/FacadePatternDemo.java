package com.design.structural.facade;

public class FacadePatternDemo {

	public static void main(String[] args) {

		HotelKeeper hotelKeeper = new HotelKeeper();
		hotelKeeper.getMenus(Menu.VEG).stream().forEach(System.out :: println);
		hotelKeeper.getMenus(Menu.NONVEG).stream().forEach(System.out :: println);
	}

}

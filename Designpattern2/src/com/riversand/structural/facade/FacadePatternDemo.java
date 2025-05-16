package com.riversand.structural.facade;

/**
 * Hotel keeper is working as a facade for us , and as a custome we do not not need to know about what is happenning behind
 * My role is jus to order veg item , hotel keeper will contact the veg restaurant and give me the veg options
 *
 * Rela life example
 * Spring's JdbcTemplate (hides boilerplate JDBC setup)
 *
 * Hibernate’s Session or EntityManager
 *
 */
public class FacadePatternDemo {

	public static void main(String[] args) {

		HotelKeeper hotelKeeper = new HotelKeeper();
		System.out.println("-------VEG-------------");
		hotelKeeper.getMenus(Menu.VEG).stream().forEach(System.out :: println);
		System.out.println("-------NON-VEG-------------");
		hotelKeeper.getMenus(Menu.NONVEG).stream().forEach(System.out :: println);
		System.out.println("-------Liquor-------------");
		hotelKeeper.getMenus(Menu.LIQUOR).stream().forEach(System.out :: println);
	}

}

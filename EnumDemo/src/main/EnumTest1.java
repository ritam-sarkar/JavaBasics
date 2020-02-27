/**
 * 
 */
package main;

import enums.Level;

/**
 * @author Ritam
 *
 */
public class EnumTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(Level.INTERMEDIATE.ordinal());
		System.out.println(Level.BEGINEER);
		System.out.println(Level.BEGINEER.name());
		System.out.println(Level.BEGINEER.compareTo(Level.INTERMEDIATE));
		System.out.println(Level.valueOf("BEGINEER"));
		System.out.println(Level.values()[2]);
		System.out.println(Level.BEGINEER.getDeclaringClass().getSimpleName());
	}
	

}

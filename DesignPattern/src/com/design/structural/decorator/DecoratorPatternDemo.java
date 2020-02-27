/**
 * 
 */
package com.design.structural.decorator;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author ritsarka
 *
 *Also called wrapper
 *Add behavior without affecting others
 *Example {@link OutputStream}  {@link InputStream}
 *Example Collections.synchronizedList is another example of decorator pattern
 *
 */
public class DecoratorPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sandwich simpleSandwich = new Simplesandwich();
		Sandwich breadTypeDecorator = new BreadTypeDecorator(simpleSandwich, "brown");
		Sandwich meatDecorator = new MeatDecorator(breadTypeDecorator, "Chicken");
		Sandwich fillingDecorator = new FillingDecorator(meatDecorator, "Mayonize");
		System.out.println(fillingDecorator.make());
		

	}

}

/**
 * 
 */
package com;

/**
 * @author Ritam
 *
 */
public class A {

	public static void callC(){
		C c = new C();
		c.dispaly();
	}
}
class C{
	public void dispaly(){
		System.out.println("C inside A");
	}
	
}

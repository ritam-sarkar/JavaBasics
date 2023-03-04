/**
 * 
 */
package com.riversand.exception;

import java.io.FileNotFoundException;

/**
 * @author Ritam
 *
 */
public class ErrorDemo {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
        //new ErrorDemo().method1();
		new ErrorDemo().method2();
	}
	public void method1() {
		try {
			System.out.println("this is method 1");
			method1();
		} catch (Error e) {
			System.out.println(" inside catch");
		}
		
	}
	public void method2() {
		System.out.println("this is method 2");
		method1();	
		
	}
	

}

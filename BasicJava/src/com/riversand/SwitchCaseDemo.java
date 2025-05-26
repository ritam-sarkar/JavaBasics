/**
 * 
 */
package com.riversand;

/**
 * @author ritsarka
 *
 */
public class SwitchCaseDemo {
	
	public static void main(String args[]) {
		
		method2(20);
		method2(30);
	}
	public static void m() {
		final int two =2;
		final int three =3;
		int a =3;
		switch(a) {
		case two:
			System.out.println(1);
			break;
		case 3:
			System.out.println(2);
			break;
		default :
			System.out.println("default");
			break;
		}
	}
	private static void  method2(int a){
		switch (a){
			default:
				System.out.println("default");
			case 10:
				System.out.println("10");
			case 20:
				System.out.println("20");
		}
	}

}

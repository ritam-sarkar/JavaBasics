/**
 * 
 */
package com.ibm;

/**
 * @author Ritam
 *
 */
public class NullPointerExceptionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String st [][] = {{"a","b","c"},null,new String[2]};
		System.out.println(st[1]);
		System.out.println(st[0][1]);
		//System.out.println(st[1].toString());
		System.out.println(st[2][0]);
		System.out.println(st[2][1]);
		//System.out.println(st[2][1].toString());
		method1();
	}
	static void method1(){
		int b=0;
		//System.out.println(b);
		
	}

}

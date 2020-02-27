/**
 * 
 */
package com.ibm;

/**
 * @author Ritam
 *
 */
public class OperatorPrecedanceDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(true|| false && true && false && true && true || false);
		System.out.println(false && true &&  false || false || true || true && false);
		System.out.println(true && false || true);
		int a = 10;
		int b=12;
		System.out.println(a++ > b && ++b>a || b-- <++a || b++>a-- && a++>b--);
		System.out.println("a "+a+" b "+b);
		//11  12
		//12  11
	    //11    12
		
		

	}

}

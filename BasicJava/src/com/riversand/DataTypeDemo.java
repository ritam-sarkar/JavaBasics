/**
 * 
 */
package com.riversand;

/**
 * @author Ritam
 *
 */
public class DataTypeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   // different number base
		long a = 0x12l;
		int b = 077666666;
		System.out.println(a);
		System.out.println(b);

		char z = 122;
		System.out.println(z);
		char G = '\u0122';
		System.out.println(G);
		
		//boolean
		
		boolean b1,b2,b3,b4;
		b3 = true;
		b1 = b2 = b3;		
		System.out.println(b1);
		
		//operators
		double x1 = 10.0;
		int x2 = 6;
		System.out.println(x1/x2);
		char ch1 = 'a';
		// can add two char values , but result will be an integer
		char ch = (char) (ch1+ch1); // of you cast int value 192 it will be a charecter
		System.out.println(ch);
		System.out.println(ch1+ch1);
		char ch2 = (char) 65670; // cannot cast more than its range  beyond 65,635
		System.out.println(ch2);
		int intval = 56;
		long longval = intval;
		double doubleval = longval;
		
				

	}
	

}

class Person{};

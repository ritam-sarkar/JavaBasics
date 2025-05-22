/**
 * 
 */
package com.riversand.datatype;

/**
 * @author Ritam
 * byte = 8 bit , short = 16 bit , int= 32 bit , long = 64, float = 32, double = 64 , char = 16
 * range = -2^(n-1) to 2^(n-1)-1  , like for int -2^31 to 2^31-1 = -2,147,483,648 to 2,147,483,647
 *
 * for int ,short byte ,cahr default letrl is int
 * for any fraction default type is double
 *
 *
 */
public class DataTypeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   // different number base
		long a = 0x12l;
		int b = 077;
		System.out.println("printing decimal form of hexadecimal  12 >>  "+a);
		System.out.println("printing decimal value of octal 77 >> "+b);

		char z = 122;
		System.out.println("122 converted to character is >> "+z);
		char G = '\u0122';
		System.out.println("Unsigned character is represented as hexa value like deci  "+G);
		System.out.println("ASCII value of greek u0122 or greek G  is   >> "+(int)G);
		
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
		System.out.println("Value of ch1 >> "+ch1);
		// can add two char values , but result will be an integer
		char ch = (char) (ch1+ch1); // of you cast int value 194 it will be a character
		System.out.println("value of ch >> "+ch);
		System.out.print("Value of ch1+ch1 in this case >> ");
		System.out.println(ch1+ch1);
		System.out.println("Value of ch1+ch1 now >> "+ch1+ch1);
		char ch2 = (char) 65670; // cannot cast more than its range  beyond 65,635
		System.out.println("Cannot cast the range more than 65,635 "+ch2);

		System.out.println("---------------------------");
		System.out.println("Cannot assign long value into an int");
		//long l = 123;
		//int p = l;
		System.out.println("Can assign any int value into an long");
        int p = 123;
		long l = p;
		System.out.println(l);
		double d = 123.09;
		System.out.println("Same for double and float cannot assign a double value into it");
		//float f = 123.9;
		System.out.println("By default fractional number type is double so to define a float has to mention f at the end");
		float f = 123.9f;

	}
	

}


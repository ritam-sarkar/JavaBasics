/**
 * 
 */
package com.ibm;

/**
 * @author Ritam
 *
 */
public class OperatorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*byte b1 = 10;
		byte b2 = 12;
		byte b = (byte) (b1+b2);
		System.out.println(b);
		final byte b3= 11;
		final byte b4 = 12;
		byte b5 = b3+b4;
		System.out.println(b5);		
		System.out.println(b1);
		
		int i = 30;
		int x  = i++ + i-- + ++i + --i + i--;
		System.out.println(x);
		i = 40;
		int int1 = i++,int2 = ++i , int3 = --i;
		System.out.println(int1+" "+int2+" "+int3);
		System.out.println(int1*int2%int3);*/
		//p=11,q=21,r=40
		int p=10,q=21,r=40;
		System.out.println(p++==10 || q++!=20 && r++==40 && p++==11 || q++ == 21 && r++==40); // true  
		System.out.print(p);System.out.print(q);System.out.println(r);
		
		/*System.out.println(p++ == 10 && q++ == 20 || r++ == 40); //
		System.out.print(p);System.out.print(q);System.out.println(r);*/

	}

}

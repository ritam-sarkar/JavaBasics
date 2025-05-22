/**
 * 
 */
package com.riversand.datatype;

/**
 * @author Ritam
 *
 */
public class WrapperClassDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//System.out.println(b);
		Boolean b1 = Boolean.valueOf("true");
		Number n;
		if(b1){
			System.out.println(b1);
		}
		//radix = 10 , it is the number base, like binary it is 2
		Integer i1= Integer.valueOf("123",10);
	    
		System.out.println(i1);
		
		Integer i2 = 900;
		Integer i3 = Integer.valueOf("128");
		Integer i4 = Integer.valueOf("128");
		System.out.println("range is  -127 to 127 ");
		System.out.println("i3 == i4 "+(i3==i4));
		
		
		int i =0;
		System.out.println("All increament operation is left to right ");
	    System.out.printf("%d %d %d", i++,++i,i--);
	    int j =0;
	    int a = j++ + ++j + j--;
	    System.out.println("\na = "+a);
	    
	    Long l1 = new Long(123);
	    Long l2 = 123L;
	    Long l3 = new Long(123L);
	    System.out.println(l3 == l2);
	    Integer intval = new Integer(3);
	    increament(intval);
	    System.out.println("after calling intval "+intval);
	    
	  
	}
	public static void increament(Integer i){
		++i;
		System.out.println("inside increament method intval "+i);
	}

}

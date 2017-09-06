/**
 * 
 */
package com.ibm;

/**
 * @author Ritam
 *
 */
public class StringBasicDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String s1 = " ritam sarkar";
       System.out.println(s1.charAt(0));
       System.out.println(s1.indexOf('r')); // pick first occurrence
       System.out.println(s1.indexOf('r',2)); // to is start index
       System.out.println(s1.indexOf("ar",2));
       
       //substring
       
       System.out.println(s1.substring(2)); // 2 is start index inclusive
       System.out.println(s1.substring(2, 6)); // 6 is end index exclusive
       System.out.println(s1);  // s1 pointed object remains same
       System.out.println(s1.trim()); // can only trims leading and trailing charecter
       String sub1 = s1.substring(0, 3);
       String sub2 = s1.substring(0,3);
       System.out.println("sub1 == sub2 "+sub1 == sub2);
       
       //replace
       
       System.out.println(s1.replace('m', 'n')); 
       System.out.println(s1.replace("ri", "sh")); // ri and sh are not string, they ar charsequence
       String s2 = "ri",s3= "sh";
       System.out.println(s1.replace(s2, s3));
      
       
	}

}

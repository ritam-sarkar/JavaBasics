/**
 * 
 */
package com.ibm;

/**
 * @author ritsarka
 *
 */
public class CharecterLengthTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<4000;i++) {
			sb.append(1);
		}
		String s = sb.toString();
		System.out.println(s.getBytes().length);
		
	}

}

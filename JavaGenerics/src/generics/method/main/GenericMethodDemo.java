/**
 * 
 */
package generics.method.main;

import generics.method.GenericMethod;

/**
 * @author Ritam
 *
 */
public class GenericMethodDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//GenericMethod genMethod = new GenericMethod();
		Integer[] iArr = {1,2,3,4};
		String [] sArr = {"a","b","c","d"};
		
		System.out.println(4+" is part of "+iArr +GenericMethod.isIn(4, iArr));
		System.out.println("a "+" is part of "+sArr +GenericMethod.isIn("a", sArr));

		

	}

}

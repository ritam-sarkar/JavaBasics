/**
 * 
 */
package com.ibm;

/**
 * @author Ritam
 *
 */
public class StringBuilderDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringBuilder sb = new StringBuilder();
		System.out.println("length "+sb.length()+" capacity"+sb.capacity());
		StringBuilder sb1 = new StringBuilder("abcd");
		System.out.println("length "+sb1.length()+" capacity"+sb1.capacity());
		sb1.append("ghjk");
		System.out.println("after appned "+sb1+" capacity "+sb1.capacity());
		sb1.insert(2, 's');
		System.out.println("after insertion "+sb1);
		StringBuilder sb2 = new StringBuilder("123");
		char[] arr = {'j','a','v','a'};
		sb2.insert(1, arr,1,3); // 3 is length of the array starting from 'a' that is 1, output:1ava23
		System.out.println("after insertion "+sb2);
		sb2.insert(1, "java",1,3); // 3 is end position that is exclusive. so output is 1av23
		int intarr[] = new int[51];
		intarr['1']=2;
		System.out.println(intarr['1']);
		
		
	}

}

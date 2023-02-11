/**
 * 
 */
package com.ibm.util;

/**
 * @author Ritam
 *
 */
public class ArrayUtil {
	
	public static void pushInt(int[] a, int val){
		for(int i = 0;i<a.length;i++){
			if(a[i] == 0){
				a[i]= val;
				break;
			}
		}
	}

}

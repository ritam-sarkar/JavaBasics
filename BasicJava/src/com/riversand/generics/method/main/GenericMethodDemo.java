/**
 * 
 */
package com.riversand.generics.method.main;


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
	static class GenericMethod {
		
		public  static <T, V extends T> boolean isIn(V value,T[] nums){
			
			for(int i = 0; i<nums.length;i++){
				if(value.equals(nums[i])){
					return true;
				}
			}
			return false;
		}
	   
	}

}

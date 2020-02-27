package com.ibm;

public class StringAnagramPanagram {

	public static void main(String[] args) {

		System.out.println(isAnagram("Mother in law", "Hitler Woman"));
		System.out.println(isAnagram("Keep", "Peek"));
		System.out.println(isPanagram("The quick brown fox jumps over the lazy dog"));
		
	}
	private static boolean isAnagram(String s1, String s2) {
		
		int NO_OF_CHAR = 256;
		s1 = s1.toLowerCase().trim().replaceAll("\\s+", "");
		s2 = s2.toLowerCase().trim().replaceAll("\\s+", "");
		char[] count1 = new char[NO_OF_CHAR];
		char[] count2 = new char[NO_OF_CHAR];
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		
		if(arr1.length != arr2.length) {
			return false;
		}
		for(int i =0;i<arr1.length && i<arr2.length;i++) {
           count1[arr1[i]]++;
           count2[arr2[i]]++;
		}
		for(int i=0;i<NO_OF_CHAR;i++) {
			if(count1[i] != count2[i]) {
				return false;
			}
		}
		return true;	
		
	}
	private static boolean isPanagram(String s) {
		s.toLowerCase().trim().replaceAll("\\s+", "");
		char[] arr = s.toCharArray();
		boolean[] result = new boolean[26];
		for(int i=0;i<arr.length;i++) {
			if(arr[i] >= 'a' && arr[i] <= 'z') {
				int index = arr[i]-'a';
				result[index] = true;
			}
		}
		for(int i=0;i<result.length;i++) {
			if(!result[i]) {
				return false;
			}
		}
		return true;
	}

}

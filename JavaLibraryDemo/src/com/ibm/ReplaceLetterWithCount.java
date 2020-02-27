package com.ibm;

public class ReplaceLetterWithCount {

	public static void main(String[] args) {

		String s = "taitanic";
		System.out.println(replace1(s, 't'));
		
		
	}
	private static String replace1(String s, char c) {
		int count =0;
		char[] arr = s.toCharArray();
		int n = arr.length;
		for(int i=0;i<n;i++) {
			if(arr[i] == c) {
				count++;
				arr[i] = (char)(count+'0');
			}
		}		
		return String.valueOf(arr);
	}
	

}

package com.ibm;

public class StringReverseDemo {

	public static void main(String[] args) {

		String s = "Ritam";
		System.out.println(reverse(s,s.length()));
	}

	private static String reverse(String s,int n) {
		String reverse = "";
		if(n>0) {
			reverse = s.charAt(n-1)+reverse(s,n-1);
		}
		return reverse;
		
	}
	

}

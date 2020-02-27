package com.ibm;

public class WordcountDemo {

	public static void main(String[] args) {

		String s = "  This   is me  ";
		int count = s.trim().split("\\s+").length;
		System.out.println(count);
		// remove space
		String result = s.trim().replaceAll("\\s+", "");
		System.out.println(result);
		// count number of vowels
		
	}

}

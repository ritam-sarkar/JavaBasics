package com.riversand.datatype;

public class AutoBoxing {

	public static void main(String[] args) {

		Long l1 = 129L;
		Long l2 = 129L;
		
		System.out.println(l1 == l2);
		
		Long l3 = Long.valueOf(129);
		Long l4 = Long.valueOf(129);
		System.out.println(l3 == l4);
		
		
		
	}

}

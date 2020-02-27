package com.ibm.collection.main;

import java.util.ArrayList;
import java.util.List;

public class ListObjectType {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(1);
		invert(list);
		System.out.println(list.get(1));
		
	}
	static void invert(List list) {
		list.add(new String("abc"));
	}

}

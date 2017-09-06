package com.ibm.collection.main;

import java.util.ArrayList;
import java.util.List;

public class SubCollectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		List<String> subList = list.subList(0, list.size());
		System.out.println(subList);
		subList.add("D");
		list.remove(0);
		subList.remove(0);
		
		System.out.println("Afetr remove "+subList);
		System.out.println("Afetr remove "+list);
		
		
	}

}

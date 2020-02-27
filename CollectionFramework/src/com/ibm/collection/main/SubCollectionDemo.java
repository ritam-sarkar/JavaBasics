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
		//list.remove(0);
		//subList.remove(0);
		
		System.out.println("Afetr remove "+subList);
		System.out.println("Afetr remove "+list);
		
		ArrayList l=new ArrayList();
		l.add("a");l.add("b");l.add("c");l.add("d");
		
		List b= l.subList(0, 2);
		
		System.out.println(l);
		System.out.println(b);
		l.add(1, "z");
		System.out.println(l);
		System.out.println(b.toString());
		
		
	}

}

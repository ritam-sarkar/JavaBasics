package com.ibm.collection.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class IteratorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList<String>(); 
		Set<String> set = null;
		list.add("A");
		//list.add("B");
		//list.add("C");
		//list.add("D");
		
		
		ListIterator<String> listItr = list.listIterator();
		//listItr.next();
		while(listItr.hasNext()){
			System.out.println(listItr.next());
			list.add("F");
		}
		/*Iterator<String> itr = list.iterator();
		System.out.println(itr.next());
		itr.remove();
		itr.next();
		itr.remove();*/
		
		
		
		
		
	}

}

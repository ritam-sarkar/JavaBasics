package com.riversand.collectionframework;

import java.util.ArrayList;
import java.util.List;

public class SubListDemo {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		// Creating a sublist
		List<Integer> subList = list.subList(1, 4);
		System.out.println("before set sublist >> "+subList);
        subList.set(0,9);
		System.out.println("after set sublist >> "+subList);
		System.out.println("after set list >> "+list);
		subList.remove(2);
		System.out.println("after remove sublist >> "+subList);
		System.out.println("after remove list >> "+list);
		// lets modify list and it will throw concurrent modification exception while parsing sublist
		/*list.add(6);
		System.out.println("after adding into list sublist "+subList.get(0));*/
		//lets add in sublist
		subList.add(6);
		System.out.println("after adding into sublist list >> "+list);
		subList.add(1,7);
		System.out.println("after adding into sublist sublist >> "+subList);
		System.out.println("after adding into sublist list >> "+list);

		
	}

}

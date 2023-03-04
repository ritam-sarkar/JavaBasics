package com.riversand.collectionframework;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {

		Map<String,Integer> map1 = new HashMap();
		map1.put("A", 1);
		map1.put("A", 2);
		System.out.println(map1.get("A"));
	}

}

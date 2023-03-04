package com.riversand.collectionframework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		System.out.println("Before sorting by value");
		map.values().stream().forEach(System.out::println);
		Map<Integer, String> sortByValueMap = sortByValue(map);
		System.out.println("After sorting by value");
		sortByValueMap.values().stream().forEach(System.out::println);
		
	}

	private static Map<Integer, String> sortByValue(Map<Integer, String> map) {
	
		
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		List<Entry<Integer, String>> listOfEntries = new ArrayList<Entry<Integer, String>>(entrySet);
	    Collections.sort(listOfEntries, (e1,e2)->{
	    	String val1 = e1.getValue();
			String val2 = e2.getValue();
			if(val1.length() != val2.length()) {
				return val2.length() - val1.length();
			}
		    return val2.compareTo(val1);
	    });
		Map<Integer, String> sortedMap = new LinkedHashMap<>();	
		for(Entry<Integer, String> entry : listOfEntries) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;	
		
	}
	

}

/**
 * 
 */
package com.riversand.thread.client;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author Ritam
 *
 */
public class SynchronizedMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,String> map = new HashMap<Integer,String>();
		Map<Integer,String> hTable = new Hashtable<Integer,String>();
		Map<Integer,String> syncMap = Collections.synchronizedMap(map);
		map.put(1, "A");
		syncMap.put(1, "A");
		hTable.put(1, "A");
		System.out.println(hTable.getClass().getName());
		

	}

}

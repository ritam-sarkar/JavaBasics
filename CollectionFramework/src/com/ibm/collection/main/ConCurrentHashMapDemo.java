/**
 * 
 */
package com.ibm.collection.main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Ritam
 *
 */
public class ConCurrentHashMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer,String> conCurrentMap = null;
		conCurrentMap = new ConcurrentHashMap<Integer,String>();
		//conCurrentMap = new HashMap<Integer,String>();
		conCurrentMap.put(1, "A");
		conCurrentMap.put(2, "B");
		conCurrentMap.put(3, "C");
		conCurrentMap.put(4, "D");
		conCurrentMap.put(5, "E");
		// can't edit the key
		conCurrentMap.compute(2, (key,val)->{key = 12;return val;});
		Iterator<Integer> it = conCurrentMap.keySet().iterator();
		while(it.hasNext()){
			Integer key = it.next();
			System.out.println("key "+key+" "+conCurrentMap.get(key));
		}
		
	}

}

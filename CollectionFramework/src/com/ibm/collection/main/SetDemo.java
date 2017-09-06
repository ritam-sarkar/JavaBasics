/**
 * 
 */
package com.ibm.collection.main;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Ritam
 *
 */
public class SetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> linkSet = new LinkedHashSet<String>();
		Set<String> hashSet = new HashSet<String>();
		Set<String> treeSet = new TreeSet<String>();
		linkSet.add("l3");
		linkSet.add("l1");
		linkSet.add("l2");
		
		hashSet.add("h1");
		hashSet.add("h2");
		hashSet.add("h3");
		
		treeSet.add(null);
		treeSet.add("t2");
		treeSet.add("t1");		
		treeSet.add("t3");
		linkSet.add(null);
		hashSet.add(null);
		
		for(String s : linkSet){
			System.out.println(s);
		}
		

	}

}

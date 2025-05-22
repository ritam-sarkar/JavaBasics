/**
 * 
 */
package com.riversand.collectionframework;

import com.sun.source.tree.Tree;

import java.util.*;

/**
 * @author Ritam
 *
 */
public class ListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<String> queue = new LinkedList<String>();
		queue.remove("Java"); // return false
		//queue.add(1,"Java"); // Index outof bound exception
		queue.add("abc");
        //System.out.println(queue.get(1)); // Index out of bound exception

         Set<Employee> employees = new TreeSet<>();
		 employees.add(new Employee()); // classcastexception as Employee did not implements Comparable


	}
	static class Employee {
		private String empId;
		private String name;

	}

}

package com.design.structural.fyweight;

/**
 * for first valueof call 5 it creates a object , for third valueof call it does not create
 * any object just return the same object from the pool
 * 
 * @author ritsarka
 *
 */
public class IntegerDemo {

	public static void main(String[] args) {

		Integer firstInt = Integer.valueOf(5);
		Integer secondInt = Integer.valueOf(10);
		Integer thirdInt = Integer.valueOf(5);
		System.out.println(System.identityHashCode(firstInt));
		System.out.println(System.identityHashCode(secondInt));
		System.out.println(System.identityHashCode(thirdInt));
	}

}

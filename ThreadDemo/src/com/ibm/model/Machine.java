/**
 * 
 */
package com.ibm.model;

/**
 * @author Ritam
 *
 */
public class Machine {
	
	public String doTaskOne(){
		System.out.println("Task 1 doing by "+Thread.currentThread().getName());
		return "Task 1 doing by "+Thread.currentThread().getName();
	}
	public String doTaskTwo(){
		System.out.println("Task 2 doing by "+Thread.currentThread().getName());
		return "Task 2 doing by "+Thread.currentThread().getName();
	}
	public String doTaskThree(){
		System.out.println("Task 3 doing by "+Thread.currentThread().getName());
		return "Task 3 doing by "+Thread.currentThread().getName();
	}	
	

}

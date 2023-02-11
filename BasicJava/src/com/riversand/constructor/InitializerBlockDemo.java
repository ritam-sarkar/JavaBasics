/**
 * 
 */
package com.riversand.constructor;

/**
 * @author Ritam
 *
 */
public class InitializerBlockDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println("Employee class constructor >>> ");
		//new Employee("abc");
		System.out.println("Manager class constructor >>>");
		new Manager("manager");
	}

}

class Employee{

	static {
		System.out.println("static block of employee");
	}

	{
		System.out.println("initializer of Employee");
	}
	public Employee(){
		System.out.println("Employee no argument constructor");
	}
	public Employee(String s){
		System.out.println("Employee argument constructor");
	}

	
}

class Manager extends Employee{

	static {
		System.out.println("static block of Manager");
	}

	{
		System.out.println("initializer of Manager");
	}
	public Manager(){
		System.out.println("Manager no argument constructor");
	}
	public Manager(String s){
		System.out.println("Manager argument constructor");
	}
}

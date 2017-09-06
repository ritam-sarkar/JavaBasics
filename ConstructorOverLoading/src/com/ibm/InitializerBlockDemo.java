/**
 * 
 */
package com.ibm;

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

		//new Employee().getAge();
		new Manager().getAge();
		new Manager().getAge();
	}

}

class Employee{
	private int id;
	private int age=50;
	
	{
		System.out.println("initializer of Employee");
	}
	public Employee(){
		System.out.println("Employee no argument constructor");
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	
}

class Manager extends Employee{
	{
		System.out.println("initializer of Manager");
	}
	public Manager(){
		System.out.println("Manager no argument constructor");
	}
}

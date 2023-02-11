/**
 * 
 */
package com.riversand;

/**
 * @author Ritam
 *
 */
public class ScopeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employees emp = new Employees();
		emp.setAge(2);
		System.out.println("age "+emp.getAge());
		

	}

}
class Employees {
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		
	}
	
}
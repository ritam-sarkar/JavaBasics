/**
 * 
 */
package com.riversand.polymorphism;

/**
 * @author Ritam
 *
 */
public class CovarientReturnTypeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Child().getN());
		new Child().get().message();
	}

}
class Parent{
	Number n;
	public Number getN(){
		System.out.println("This is parent method");
		return n;
	}
	public Parent get(){
		return this;
	}
	public void method1(){
		System.out.println("parent method 1");
	}
}
class Child extends Parent{
	Integer i;
	
	@Override
	public Child get(){
		return this;
	}
	// Covarient means only the child type return
	@Override
	public Integer getN(){
		System.out.println("This is child mthod");
		
		return i;
	}
	public void message(){
		System.out.println("This is child class");
	}
}

/**
 * 
 */
package com.ibm;

/**
 * @author Ritam
 *
 */
public class DefaultMethodDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Interviewer inv = null;/* = new Manager();*/
		inv.defultMethod();
		Interviewer.bookConferenceNumber();
		//inv.normalMethod();
		
	}

}

interface Interviewer {
	static void bookConferenceNumber(){
		System.out.println("This is static method");
	}
	default void defultMethod(){
		System.out.println("This is default method");
	}
	/*default public static void  defualtStaticMethod(){
		System.out.println("This is static default method");
	}*/
	void normalMethod();
}

class Manager implements Interviewer{

	@Override
	public void normalMethod() {
		System.out.println("This is normal method");
		
	}
	@Override
	public void defultMethod(){
		System.out.println("this is child default method");
	}
	
}
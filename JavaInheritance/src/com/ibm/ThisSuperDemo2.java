/**
 * 
 */
package com.ibm;

/**
 * @author Ritam
 *
 */
public class ThisSuperDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Dog().dogMethod();

	}

}
interface Animal1{
	String village= "animal village";
	void method();
	
}
class Dog implements Animal1{
	String village;
	public void dogMethod(){
		
	}
	@Override
	public void method() {
		// TODO Auto-generated method stub
		
	}
	
}

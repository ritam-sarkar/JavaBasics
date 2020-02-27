/**
 * 
 */
package com.ibm;

import java.io.IOException;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.ChildLoader;

/**
 * @author Ritam
 *
 */
public class TypeCastingDemo {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Employee1 emp = new Manager1();
        emp.counducInterview();
        Employee1 hr = new Hr1();
        System.out.println(hr.empid);
        System.out.println(((Hr1)hr).empid);
        Manager1  mng = new Manager1();
        System.out.println(((Employee1)mng).empid);
        
        // parent child downcasting
        Parent parent = new Child1();
        Child1 child1 = (Child1)parent; 
        
        
        
	}
	static class Parent{
		
	}
	static class Child1 extends Parent{
		
	}
	static class Child2 extends Parent{
		
	}
	static abstract class Abstract1{
		public Abstract1() {
			
		}
	}
	static abstract class ChildAbstract1 extends Abstract1{
		
	}
	static class Concreate extends ChildAbstract1{
		
	}
	

}
interface Interviewer1{
	
}

class Employee1 implements Interviewer1{	
	int empid;
	public void counducInterview(){
		System.out.println("Employee conducting interview");
	}
}
class Manager1 extends Employee1 implements Interviewer1{
	int empid = 120;
	public void counducInterview(){
		System.out.println("Manager conducting interview");
	}
}
class Hr1 extends Employee1 implements Interviewer1{
	int empid = 100;
	public void counducInterview(){
		System.out.println("Hr conducting interview");
	}
}


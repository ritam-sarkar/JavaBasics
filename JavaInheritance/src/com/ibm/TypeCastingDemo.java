/**
 * 
 */
package com.ibm;

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


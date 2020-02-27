package com.ibm;

public class MethodOverLoadingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodOverLoadingDemo obj = new MethodOverLoadingDemo();
		obj.f1(null);
		Employee e = new CEO();
		CEO c = new CEO();
		// Rule 2 : As method overloading happens at compile time so it will call the method which accepts Employee type
		obj.f2(e);
		// Rule 3: f3 accepts CEO object as CEO is a n instance of Employee 
		obj.f3(c);
		// Rule 4 : f4 cannot accept employee reference as employee is not instance of CEO, its a parent class of CEO
		//obj.f4(e);
		
	}
	
    void f1(String s) {
      System.out.println(" String");	
    }
    void f1(Object i) {
    	System.out.println("Object");
    }
    // Rule 1: ambiguous for Integer and String as they are sibling classes
    /*void f1(Integer i) {
    	System.out.println(" Integer");
    }*/
    
    void f2(Employee e) {
    	System.out.println("Employee");
    }
    void f2(CEO c) {
    	System.out.println("CEO");
    }
    void f3(Employee e) {
    	System.out.println(" f3 accepts Employee");
    }
    void f4(CEO c) {
    	
    }
    static class Employee{
    	
    }
    static class CEO extends Employee{
    	
    }

}

package com.ibm;

public class StaticWithInheritence {

	public static void main(String[] args) {

		Parent p =  new Child();
		p.f1();
		Child c = new Child();
		c.f1();
		
		
		
	}
	static class Parent{
		
		static void f1() {
			System.out.println(" Parent f1");
		}
		void f2() {
			
		}
		
	}
	static class Child extends Parent{		
		
		// Rule : This is not Override, static method cannot perticipate in overriding, This is method hiding
		static void f1() {
			System.out.println(" Child f1");
		}
		// Rule : Only using static keyword cannot hide a method defination
		/*static void f2() {
			
		}*/
		
		
	}
	
	

}


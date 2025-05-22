package com.riversand.polymorphism;

import java.util.ArrayList;
import java.util.List;

public class Overriding {

	public static void main(String[] args)  {
 
		Parent p = new Child();
		new Child().f1(0.5f, 0.2f);
		Child c = new Child();
		c.f1(5, 2);
		//Rule : any static items method or variables are bind with the class reference, they don't participate in method overroding
		p.f4(); // call parent method
		
		
	}
	static class Parent{
		static int M = 2;
		void f1(long a, long b) {
			System.out.println(a+" "+b);
		}
		List f2(Number l) {
			return null;
			
		}
		void f3(Number n) {
			
		}
		static void f4() {
			System.out.println("parent method");
		}
		static void f5() {
			
		}
		
	}
	static class Child extends Parent{
		
		//Rule : This is not a override, just an another method
		// Rule : M is static variable and its inherited not overroden
        void f1(float a, float b)  {
        	System.out.println(" float a float b in child"+M);
		}
       
        // Rule : At the time of overriding return types can be covariant
        @Override
        ArrayList f2(Number l) {
			return null;
        	
        }
        /** Rule : At the time of overriding parameter type should not be covariant
         It will not e a error but the method is just another method not overriding
         Rule : The type of the generic return type should be equal not covariant like
		 if parent has List<String> child should have ArrayList<String> not ArrayList<Object> **/
        //@Override
        void f3(Integer i) {
        	
        }
        // Method hiding, not method overloading
        static void f4() {
        	System.out.println("Child method");
        }
        // Rule: either both are static or none of them are static in parent and child class
        /*void f5() {
        	
        }*/
        
        
	}

}

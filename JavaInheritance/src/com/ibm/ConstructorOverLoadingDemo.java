package com.ibm;

import java.util.ArrayList;
import java.util.List;

public class ConstructorOverLoadingDemo {

	int a = 2;
	public static void main(String[] args) {

		Child c = new Child();
		System.out.println(c.x);
	}
	static class Parent {
		
	}
	static class Parent2{
		Parent2(int a, int b){
			
		}
		Parent2(int a){
			
		}
		Parent2(List l){
			
		}
	}
	static class Child extends Parent2{

		 int x;
		 int y;
		public Child() {
			this(10, 20);
		}
		public Child(int x, int y) {
			// Rule 1 : Reccursive error, at the compile time, do not wait for the JVM to throw stack overlow error 
			//this();
			super(x,y);
			this.x = x;
			this.y = y;
		}
		Child(ArrayList l){
			super(1,2);
		}
		
	}
	static class Child2 extends Parent2{

		Child2(int a, int b) {
			super(a, b);
		}
		// Rule2 : Has to call the parent argumentative constructor from every child constructor 
		// Because compiler is not able to call super(); from the first line as no argument constructor does not exist in parent class
		Child2(){
			super(1,2);
		}
		
	}
	

}

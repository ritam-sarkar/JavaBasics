package com.ibm;

import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.impl.orb.ParserTable.TestAcceptor1;

public class CoVariantDemo {

	public static void main(String[] args) {

		ArrayList<Integer> l = new ArrayList<>();
		l.add(1);
		Parent1 parent = new Child2();
		parent.printList(l);
		System.out.println(parent.getValue());
		parent.testMethodInt(1);
		System.out.println(parent.i);
	}
	
}
class Parent1{
	int i=10;
	protected void printList(List list) {
		System.out.println("printing from parent");
	}
	protected Number getValue() {
		System.out.println(" get value of parent called");
		return 2;
	}
	protected void testMethodInt(int i) {
		System.out.println(" call from parent int");
	}
	protected void testMethodInt(Integer i) {
		System.out.println(" call from parent Integer");
	}
}
class Child2 extends Parent1{
	
	int i = 11;
	// This is not overridden method
	protected void printList(ArrayList list) {
		System.out.println("printing from child");
	}
	// covariant return type
	@Override
	protected Long getValue() {
		System.out.println(" get value of child called");
		return 2L;
	}
	
}


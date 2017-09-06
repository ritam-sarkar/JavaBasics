package com.ibm;

public class FinalAbstractDemo {

	public static void main(String[] args) {

		
	}

}
abstract class ParentClass{
	public /*static*/ final int a;
	public ParentClass(){
		a=10;
	}
	
}
class DerivedClass extends ParentClass{
	public DerivedClass(){
		super();
	}
}

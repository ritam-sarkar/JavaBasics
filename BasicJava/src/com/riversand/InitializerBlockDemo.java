package com.riversand;

public class InitializerBlockDemo {

	public static void main(String[] args) {

		//case 1 : //System.out.println(Child.b);
		
		Child c = new Child();
		
	}
	
	static class Parent {
		int a = 2;
		static {
			System.out.println("Parent static block");
		}
		{
			System.out.println("Parent initializer block");
		}
		public Parent() {
			System.out.println("Parent constructor");
		}
		
	}
	static class Child extends Parent{
		static int b = 2;
		int c =3;
		static {
			System.out.println("Child static block");
		}
		{
			System.out.println(a);
			System.out.println("Child initializer block");
		}
		public Child() {
			System.out.println("Child constructor");
		}
	}

}

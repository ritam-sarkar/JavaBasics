package com.ibm;

public class VaribaleInheritanceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child c = new Child();
		Parent p = new Parent();
		System.out.println(c.a);
		System.out.println(p.a);
		System.out.println(Child.b);
		System.out.println(Parent.b);

	}
	
	static class Parent{		
		int a = 20;
		static int b = 20;
		
	}
	static class Child extends Parent{	
		int a =30;
		static int b = 30;		
		/*public Child() {
			a =30;
		}*/
	}

}

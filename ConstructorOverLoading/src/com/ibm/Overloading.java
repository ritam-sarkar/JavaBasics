package com.ibm;

public class Overloading {

	public static void main(String[] args) {

		Overloading ob = new Overloading();
		ob.f1(10, 2);
		ob.f3(1.0);
		ob.f2(10.2f, 3.2f);
	}
	/*void f1(int a, int b) {
		System.out.println(" int a int b");
	}
	void f1(int a, long b) {
		System.out.println("int a long b");
	}
	void f1(long a, int b) {
		System.out.println("long a int b");
	} */
	void f1(long a, long b) {
		System.out.println("long a long b");
	}
	void f3(float a) {
		
	}
    void f3(double a) {
		System.out.println("double a");
	}
	
	void f2(float a, float b) {
		System.out.println("float a float b");
	}
	void f2(float a, double b) {
		System.out.println("float a double b");
	}
	void f2(double a, float b) {
		System.out.println("double a float b");
	}
	void f2(double a, double b) {
		System.out.println("double a double b");
	}	

}

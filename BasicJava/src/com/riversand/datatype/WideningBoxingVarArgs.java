package com.riversand.datatype;


/**
 * https://cs-fundamentals.com/java-programming/method-overloading-in-java
 */
public class WideningBoxingVarArgs {

	public static void main(String[] args) {

		int i = 5;
		go(i,i);
		go(i);
		combination(i);
	}
	// If you close this method C.E because the sequence is Boxing, widening, varargs
	// int to Integer(Boxing) then Integer to Number widening , then Number ... n varargs
	public static void go(Number ... n) {
		System.out.println("Number ... go");
	}

	// int to Integer boxing , Integer to Long here widening failed for go(i,i)
	public static void go(Long ... n) {
		System.out.println(" Long ... go");
	}
	// If you open this directly widening will satisfy as Widening > Boxing > varargs for direct access
	public static void go(long l1, long l2) {
		System.out.println(" long long  go");
	}



	// Preference of method  Widening > Boxing > varargs
	public static void go(Integer i) {
		System.out.println(" Integer go");
	}
	public static void go(long l) {
		System.out.println(" long go");
	}
	public static void combination(long l) {
		System.out.println("Inside long combination");
	}
	public static void combination(Number l) {
		System.out.println("Inside Number combination");
	}




}

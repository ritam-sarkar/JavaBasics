package com.riversand.datatype;

public class WideningBoxingVarArgs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 5;
		go(i,i);
		go(i);
		combination(i);
	}
	// If you close this method C.E because the sequence is Boxing, widening, varargs
	public static void go(Number ... n) {
		System.out.println("Number ... ");
	}
	
	public static void go(Long ... n) {
		System.out.println(" Long ... ");
	}
	
	public static void go(Integer i) {
		System.out.println(" Integer");
	}
	// Preference of method  Widening > Boxing > wideningq
	public static void go(long l) {
		System.out.println(" long ");
	}
	public static void combination(long l) {
		System.out.println("Inside long combination");
	}
	public static void combination(Number l) {
		System.out.println("Inside Number combination");
	}

}

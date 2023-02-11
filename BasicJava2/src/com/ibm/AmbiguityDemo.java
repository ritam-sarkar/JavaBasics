package com.ibm;

public class AmbiguityDemo {

	public static void main(String[] args) {
		Object ref = new int[]{1,2,3,4};
		char[] charArray = {'a','b'};
		Character[] charArrayBox = new Character[2];
		int[] intArray =  {1,2};
		OverloadedDemo1 obj1 = new OverloadedDemo1();
		OverloadedDemo2 obj2 = new OverloadedDemo2();
		OverLoadDemo3 obj3 = new OverLoadDemo3();
		
		obj1.test(charArray); // print Char
		obj1.test(intArray); // Print Object
		obj1.test(charArrayBox); // print Oject
		obj1.test(2); // print Int
		
		obj3.test(3);  // Int
		obj3.test(2l); // long
		// If double method is commented, it won't call float method by default, so CE will happen
		obj3.test(12.0); // double
		obj3.test(12.0f); // float
    }

}
class OverloadedDemo1{     
    public void test(Object obj) {
        System.out.println("Object");
    }
    public void test(char[] obj) {
        System.out.println("Char");
    } 
    public void test(Integer obj) {
        System.out.println("Int");
    } 
    
}
class OverloadedDemo2{
	    /*public void test(long lng) {
	        System.out.println("Long");
	    }*/
	    public void test(Long bigLong) {
	        System.out.println("object Long");
	    }
	   /* public void test(int in) {
	        System.out.println("int");
	    }*/
	   /* public void test(char c) {
	        System.out.println("char");
	    }*/
	      
	    public void test(Integer integer) {
	        System.out.println("Integer");
	    }	      
	    
}
class OverLoadDemo3 {
	 public void test(int i) {
	        System.out.println("int");
	    }	
	 
	 public void test(long l) {
	        System.out.println("long");
	    }	
	 public void test(short s) {
	        System.out.println("short");
	   }
	 public void test(float f) {
	        System.out.println("float");
	   }
	 public void test(byte b) {
	        System.out.println("byte");
	   }
	 public void test(char c) {
	        System.out.println("char");
	   }
	 public void test(double d) {
		 System.out.println("double");
	 }
	 
}

class OverLoadDemo4{
	public void test(Character c) {
        System.out.println("int");
    }	
 
 public void test(long l) {
        System.out.println("long");
    }
}
package com.ibm;

public class AmbiguityDemo {

	public static void main(String[] args) {
		Object ref = new int[]{1,2,3,4};
		//Object[] obs = new int[]{1,2,3,4};
		OverloadedMethod1 obj1 = new OverloadedMethod1();
		OverloadedMethod2 obj2 = new OverloadedMethod2();
		OverLoadDemo3 obj3 = new OverLoadDemo3();
		obj3.test('a');
		obj2.test(1);
        //obj.test(null);
		
    }

}
class OverloadedMethod1{     
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
class OverloadedMethod2{
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
	 
}

class OverLoadDemo4{
	public void test(Character c) {
        System.out.println("int");
    }	
 
 public void test(long l) {
        System.out.println("long");
    }
}
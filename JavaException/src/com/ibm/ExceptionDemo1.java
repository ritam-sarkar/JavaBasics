/**
 * 
 */
package com.ibm;

import java.io.FileNotFoundException;

/**
 * @author Ritam
 *
 */
public class ExceptionDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
      String s = new A().method1();
     System.out.println(s);
      System.out.println(new A().method2().a);
	}

}
class CustomException extends Exception{
	
}
class CustomObject{
	int a =10;
}

class A{
	/**
	 * Flow of execution
	 * 1. find a exception in try block, do not execute anything after that and go to the relevant catch block
	 * 2. After catch block execution go to finally block
	 * 3. If we return anything inside catch block and assign it again in finally block then there will be two copies of the same object.
	 *    If it is a primitive value or immutable class then finally cannot modify the value, if it is an object or mutable class it can modify the value.
	 *     
	 * 
	 */
	public String method1(){
		String x = null;
		CustomObject ob = new CustomObject();
		try{	
			System.out.println("try block");
			x = "XX";			
			throw new CustomException();
			
		}catch(CustomException e){
			System.out.println("catch block");			
			return x;
		}finally{
			System.out.println("finally");
			x = "YY";
			//return x;
		}
	}
	public CustomObject method2(){
		CustomObject ob = new CustomObject();
		try{	
			System.out.println("try block");
			ob.a = 11;
			throw new CustomException();
		}catch(CustomException e){
			System.out.println("catch block");	
			return ob;
		}finally{
			System.out.println("finally");
			ob.a = 12;	
		}
	}
	
}

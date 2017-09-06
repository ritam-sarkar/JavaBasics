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
		// TODO Auto-generated method stub
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
	
	public String method1(){
		String x = null;
		CustomObject ob = new CustomObject();
		try{	
			System.out.println("try block");
			x = "XX";			
			throw new CustomException();
			//throw new FileNotFoundException();

			//return "try";

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

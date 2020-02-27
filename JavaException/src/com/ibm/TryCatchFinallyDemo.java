package com.ibm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLDataException;

public class TryCatchFinallyDemo {

	public static void main(String[] args) throws FileNotFoundException {
		TryCatchFinallyDemo obj = new TryCatchFinallyDemo();
        System.out.println(new TryCatchFinallyDemo().test(10));
        //obj.emptyException();
	}
	public  int  test(int a) throws FileNotFoundException{
		a =10;
		try{
			
			/*String s = null;
			s.toString();*/
			a=20;
			throw new FileNotFoundException();			
		}catch(FileNotFoundException e) {
			a = 30;
			return a;
		}finally{
			System.out.println(" Inside finally");
			a=40;
			/**
			 * If we return a then it would have override the return statements of catch and try block, so there will be
			 * a warning saying finally block is not ended properly
			 */
			//return a;
		}
		//System.out.println("a is "+a);
	}
	public void emptyException (){
		try{
			
		}catch(NullPointerException | ArithmeticException e){
			
			// Rule : This two exceptions should not be in a same hierarchy
			e.printStackTrace();
		} 
	}
	

}

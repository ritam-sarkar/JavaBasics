package com.ibm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLDataException;

public class TryCatchFinallyDemo {

	public static void main(String[] args) throws FileNotFoundException {
		TryCatchFinallyDemo obj = new TryCatchFinallyDemo();
		// TODO Auto-generated method stub
        System.out.println(new TryCatchFinallyDemo().test());
        obj.emptyException();
	}
	public  int  test() throws FileNotFoundException{
		int a =10;
		try{
			
			/*String s = null;
			s.toString();*/
			a=20;
			//throw new IOException();
            return a;
		}finally{
			a=40;
		}
		//System.out.println("a is "+a);
	}
	public void emptyException (){
		try{
			
		}catch(NullPointerException | ArithmeticException e){
			e.printStackTrace();
		}
	}
	

}

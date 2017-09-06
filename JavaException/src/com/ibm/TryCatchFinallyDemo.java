package com.ibm;

import java.io.IOException;

public class TryCatchFinallyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        test();
	}
	public static void  test(){
		int a =10;
		try{
			/*String s = null;
			s.toString();*/
			a=20;
			throw new IOException();
//			/return a;
		}catch(Exception e){
			a=20;
		}finally{
			a=40;
		}
		System.out.println("a is "+a);
	}

}

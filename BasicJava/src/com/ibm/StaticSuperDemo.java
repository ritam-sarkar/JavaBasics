package com.ibm;

import java.util.LinkedList;

public class StaticSuperDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(Y.a);
      new Y().print();
      new Y().getB();
	}

}
class X{
	static int a=10;
	int b = 6;
	static{
		//System.out.println(this.a); 
	}
}
class Y extends X{
	static int a =20;
	public  static void print(){
		//System.out.println(super.a);
	}
	public int getB(){
		return b;
	}
}
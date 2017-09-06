/**
 * 
 */
package com.ibm;

/**
 * @author Ritam
 *
 */
public class ThisSuperDemo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
	}

}
class ASuper {
	private int a;

	public ASuper(int a) {
		this.a = a;
	}
	public void display(){
		System.out.println("a is "+this.a);
	}
	
}
class BSub extends ASuper {
    private int b;
	public BSub(int a) {
		super(a);
		// TODO Auto-generated constructor stub
	}
	
}

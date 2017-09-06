/**
 * 
 */
package com.ibm;

/**
 * @author Ritam
 *
 */
public class FinalDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     new A(2).print();
     new A().test();
     
	}

}
class A{
	 final int i;
	 static final int j;
	public void print(){
		
		System.out.println(i);
	}
	public A(){this.i = 1;}
	public A(int i){
		this.i = i;
	}
	static {
		j=9;
	}
	public void test(){ 
		final boolean b = true;
		if(b){
			System.out.println(b);
		}
	}
}

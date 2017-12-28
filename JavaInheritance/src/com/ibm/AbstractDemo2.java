/**
 * 
 */
package com.ibm;

/**
 * @author Ritam
 *
 */
public class AbstractDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Abst1 ab = new Child1();
     ab.display();
     Abst1 ab1 = new Abst1(12){
    	 
		@Override
		void display() {
			System.out.println("value of a is "+this.getA());
		}
    	 
     };
     ab1.display();
     
	}

}
abstract class Abst1{
	 private int a =10;
	
	public void setA(int a) {
		this.a = a;
	}
	public int getA() {
		return a;
	}
	Abst1(int a ){
		this.a = a;
	}
	
	public Abst1() {
	}
	abstract void display();	
}
class Child1 extends Abst1{

	public Child1(){
		
	}
	Child1(int a) {
		super(a);
	}

	@Override
	void display() {
       System.out.println("a is "+this.getA());		
	}
	
}

interface Int1{
	void method1();
}
abstract class AbInt1{
	void method2(){
		
	}
}

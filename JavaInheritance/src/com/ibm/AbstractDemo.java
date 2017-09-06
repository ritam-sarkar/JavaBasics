/**
 * 
 */
package com.ibm;

/**
 * @author Ritam
 *
 */
public class AbstractDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Animal animal = new Tiger();
     animal.eat();
     System.out.println(animal.name);
	}

}

abstract class  Animal {
	protected String name = "Animal";
	 protected abstract void eat();
	  //static void drink(); 
	public Animal(){}
}
class Tiger extends Animal{
     private String name = "tiger";
	@Override
	public  void eat() {
      System.out.println(this.name+"  eats deer");		
	}
	
	/*public void PrintName(){
		System.out.println(" name "+this.name);
	}*/
}
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
     System.out.println(animal.name); // variables bound at compile time
     animal.printName(); // methods bound at runtime
     animal.drink();
	}

}

 abstract class  Animal {
	protected String name = "Animal";
	 protected  abstract void eat();
	  static   void drink(){ System.out.println(" drinks water ");} 
	public Animal(){ System.out.println(" this is animal  class");}
	abstract void printName();
	
}
class Tiger extends Animal{
     private String name = "tiger";
     
	@Override
	public  void eat() {
      System.out.println(this.name+"  eats deer");	
      drink();
	}
	@Override
	public void printName(){
		System.out.println(" name "+name);
	}
	static void drink(){
		System.out.println(" drinks blood ");
	}
}
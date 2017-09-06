/**
 * 
 */
package generics.inheritance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ritam
 *
 */
public class Demo1 {

	/**
	 * @param args
	 */
	int b;
	public static void main(String[] args) {
		
		//Dog dog = new Dog();
		//Dog dog = new Dog("xyz");
		//Animal animal = new Dog("abc");
		Dog dog = new Dog("Dalmecsian");
		System.out.println(dog.getName());
	}
	
}
class Animal{
	public Animal(){
		System.out.println("Animal");
	}
	public Animal(String st){
		System.out.println(st);
	}
	
}
class Dog extends Animal {
	String name = "dog";
	String type = "dalmesian" ;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Dog(String name) {
		//super();
		this.name = type;
		//this.type = name;
	}
	public Dog(){
		System.out.println("Dog");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
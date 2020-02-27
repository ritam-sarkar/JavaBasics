/**
 * 
 */
package com.ibm;

/**
 * @author Ritam
 *
 */
public class ArrayDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[][] = new int[10][];
		System.out.println(arr.length);
		short s = (short)120;
		System.out.println(s);
		Animal[] animals = new Animal[3];
		Dog dog1 = new Dog("dog", "Bark");
		Cat cat1 = new Cat("cat", "Mew");
		animals[0] = dog1;
		animals[1] = cat1;
		System.out.println(animals[0].name + ((Dog)animals[0]).sound);
		
		
		
	}
	static class Animal{
		
		protected String name;
		Animal(String name){
			this.name = name;
		}
	}
	static class Dog extends Animal{
		String sound;
		Dog(String name, String sound){
			super(name);
			this.sound = sound;
		}
	}
	static class Cat extends Animal {
		String sound;
		Cat(String name, String sound){
			super(name);
			this.sound = sound;
		}
	}

	
}

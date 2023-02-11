package com.ibm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableDemo2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Child childObj = new Child(20, 30, 40);		
		FileOutputStream fos = new FileOutputStream("parentchild.ser");
		ObjectOutputStream os = new ObjectOutputStream(fos);
		System.out.println("a "+ childObj.a);
		os.writeObject(childObj);
		
		
		FileInputStream fis = new FileInputStream("parentchild.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Child childObj2 = (Child) ois.readObject();
		System.out.println(" a ==> "+childObj2.a);
	}
	
	static class Parent {
		int a = 10;

		public Parent() {
			this.a =100;
		}
		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}		
	}
	static class Child extends Parent implements Serializable{
		int b;
		int c;
		public Child(int a, int b, int c) {
			this.b = b;
			this.c =c;
			this.a = a;
		}
		public int getB() {
			return b;
		}
		public void setB(int b) {
			this.b = b;
		}
		public int getC() {
			return c;
		}
		public void setC(int c) {
			this.c = c;
		}
		
	}

}

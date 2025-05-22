/**
 * 
 */
package com.riversand.generics.simple;

import java.util.Date;

/**
 * @author Ritam
 *
 */
public class SimpleGeneric {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Generics1<Integer> genInt = new Generics1<>(88);
		Generics1<String> genString = new Generics1<>("eighty eight");
		Generics1 genAll = new Generics1();
		genAll.setObj(new Date());

		genInt.showType();
		System.out.println(genInt.getObj());
		
		genString.showType();
		System.out.println(genString.getObj());
		
		genAll.showType();
		System.out.println(genAll.getObj());
		
		
	}
	static class Generics1 <T>{

		private T obj;

		public T getObj() {
			return obj;
		}

		public void setObj(T obj) {
			this.obj = obj;
		}

		public Generics1(T obj) {
			this.obj = obj;
		}
		public Generics1(){
			super();
		}

		public void showType(){
			System.out.println("type is "+this.obj.getClass().getName());
		}
	}

}

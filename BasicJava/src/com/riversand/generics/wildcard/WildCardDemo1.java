/**
 * 
 */
package com.riversand.generics.wildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ritam
 *
 */
public class WildCardDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> listInt = new ArrayList<>();
		List<Double> listDouble = new ArrayList<>();
		List<Phone> phoneList = new ArrayList<>();
		List<Cycle> cycleList = new ArrayList<>();
		List<Gift> giftList = new ArrayList<>();
		List<Number> numList = new ArrayList<>();
		cycleList.add(new Cycle());
		phoneList.add(new Phone());
		giftList.add(new Gift());
		listInt.add(1);
		listDouble.add(2.0);
		numList.add(21);
		wildMethod(listInt);
		wildMethod(listDouble);
		wildIntegerMethod(listInt);
		// Number is super of Integer , argument <? super Integer>
		wildIntegerMethodSuper(numList);
        // Phone and Cycle both extends Gift
		wildCardWithExtends(phoneList);
		wildCardWithExtends(cycleList);
		//Gift is super of phone argument <? super Phone>, phonelist is also allowed
		wildCardWithSuper(giftList);
		// Cycle is sibling of Phone so not allowed
		//wildCardWithSuper(cycleList);

	}
	private static void wildMethod(List<?> list) {
		Object ob = list.get(0);
		if(ob instanceof Integer) {
			System.out.println((Integer)ob);
		}
		if(ob instanceof Double) {
			System.out.println((Double)ob);
		}
	}
	private static void wildIntegerMethod(List<? extends Integer> list) {
		Integer i = list.get(0);
		System.out.println(i);
		// Rule1 : wildcard with extends cannot add anything
		//list.add(2);
	}
	private static void wildIntegerMethodSuper(List<? super Integer> list) {
		Integer i = (Integer) list.get(0);
		System.out.println(i);
	}
	// Rule6: It will allow Gift and all classes extends Gift
	private static void wildCardWithExtends(List<? extends Gift> list) {

		// Rule2 : For get Use parent type childtype is not allowed		
		//Phone g = phoneList.get(0);
		Gift g = list.get(0);
		System.out.println("g instance of Phone "+ (g instanceof Phone));
		System.out.println("g instance of Cycle "+ (g instanceof Cycle));
	}
	
	private static void wildCardWithSuper(List<? super Phone> phoneList) {
		// Rule3 : get is allowed but it will return only Object
		//Phone p = phoneList.get(0);
		
		// Rule4 : Cannot add Gift can only add Phone
		phoneList.add(new Phone());
		Object o = phoneList.get(0);
		// Rule5 : Can allow List<Phone> and List<Gift>
		System.out.println("object instance of Gift "+(o instanceof Gift));
	}

	
	static class Gift {
		
	}
	static class Phone extends Gift {
		
	}
	static class Cycle extends Gift {
		
	}
	

}

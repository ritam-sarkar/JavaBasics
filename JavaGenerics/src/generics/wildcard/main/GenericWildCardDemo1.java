/**
 * 
 */
package generics.wildcard.main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ritam
 *
 */
public class GenericWildCardDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> listInt = new ArrayList<Integer>();
		List<Double> listDouble = new ArrayList<Double>();
		List<Phone> phoneList = new ArrayList<Phone>();
		List<Cycle> cycleList = new ArrayList<Cycle>();
		List<Gift> giftList = new ArrayList<Gift>();
		cycleList.add(new Cycle());
		phoneList.add(new Phone());
		giftList.add(new Gift());
		listInt.add(1);
		listDouble.add(2.0);
		wildMethod(listInt);
		wildMethod(listDouble);
		wildIntegerMethod(listInt);
		wildIntegerMethodSuper(listInt);
		wildCardWithExtends(phoneList);
		wildCardWithExtends(cycleList);
		wildCardWithSuper(giftList);
		
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
		//list.add(2);
	}
	private static void wildIntegerMethodSuper(List<? super Integer> list) {
		//Integer i = (Integer) list.get(0);
		//System.out.println(i);
		list.add(3);
	}
	// Rule6: It will allow Gift and all classes extends Gift
	private static void wildCardWithExtends(List<? extends Gift> list) {
		// Rule1 : wildcard with extends cannot add anything
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

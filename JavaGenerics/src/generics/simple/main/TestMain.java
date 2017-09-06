/**
 * 
 */
package generics.simple.main;

import java.util.Date;

import generics.simple.Generics1;

/**
 * @author Ritam
 *
 */
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Generics1<Integer> genInt = new Generics1<Integer>(88);
		Generics1<String> genString = new Generics1<String>("eighty eight");
		Generics1 genAll = new Generics1();
		genAll.setObj(new Date());

		genInt.showType();
		System.out.println(genInt.getObj());
		
		genString.showType();
		System.out.println(genString.getObj());
		
		genAll.showType();
		System.out.println(genAll.getObj());
		
		
	}

}

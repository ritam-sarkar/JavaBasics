/**
 * 
 */
package generics.inheritance.main;

import java.util.ArrayList;
import java.util.List;

import generics.inheritance.AbstractCalCulator;
import generics.inheritance.GenericBookParcel;
import generics.inheritance.UpperBound;

/**
 * @author Ritam
 *
 */
public class GenericInheritenceDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericBookParcel<Double,Integer> gkb = new GenericBookParcel<Double,Integer>();
		gkb.setT(1);
		gkb.setX(2.0);		
		gkb.genericMethod1(2,"abc");
		GenericBookParcel<String,Integer> gkb2 = new GenericBookParcel<String,Integer>("str");
		
		UpperBound<String> upc = new UpperBound<String>();
		upc.test("xyz");
		
		
		
	}

}

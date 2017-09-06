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
		listInt.add(1);
		listDouble.add(2.0);
		
		List<? extends Object> list = new ArrayList<Integer>();
		
		

	}

}

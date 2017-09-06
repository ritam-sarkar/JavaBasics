/**
 * 
 */
package generics.typecast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ritam
 *
 */
public class GenericTypeCastTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("abc");
		//list.add(1);
		//String s = (String) list.get(0);
		System.out.println(list.get(0));
		System.out.println(list.get(1));


	}

}

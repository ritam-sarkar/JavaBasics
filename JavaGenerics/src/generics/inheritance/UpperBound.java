/**
 * 
 */
package generics.inheritance;

/**
 * @author Ritam
 *
 */
public class UpperBound<T extends String > {
	T t;
	public void test(T t){
		System.out.println(t.charAt(2));
	}

}

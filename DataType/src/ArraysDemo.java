import java.util.Arrays;

/**
 * 
 */

/**
 * @author Ritam
 *
 */
public class ArraysDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {1,2,3};
		int arr2[] = {3,4,5};
		Object a[] = {arr1,arr2};
		Object b[] = {arr1,arr2};
		System.out.println(Arrays.deepEquals(a, b));

	}

}

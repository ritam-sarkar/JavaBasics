/**
 * 
 */
package generics.inheritance;

/**
 * @author Ritam
 *
 */
public interface Calculator <T extends Comparable<T>,V extends Number>{
  
		
	public T max(T[] arr);
	public T min(T[] arr);
	public void isLessThan(T val1,T val2);
	public void isGreaterThan(T val1,T val2);
    public double avg(V[] arr);
	
	


}

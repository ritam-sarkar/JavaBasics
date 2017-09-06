/**
 * 
 */
package generics.inheritance;

/**
 * @author Ritam
 *
 */
public abstract  class AbstractCalCulator <T extends Comparable<T>,V extends Number> implements Calculator<T,V>{

	@Override
	public T max(T[] arr) {
		T val = arr[0];
		for(int i = 1;i<arr.length;i++){
			if(val.compareTo(arr[i])<0){
				val = arr[i];
			}
		}
		return val;
	}

	@Override
	public T min(T[] arr) {
		T val = arr[0];
		for(int i = 1;i<arr.length;i++){
			if(val.compareTo(arr[i])>0){
				val = arr[i];
			}
		}
		return val;
	}

	

	@Override
	public double avg(V[] arr) {
		double sum = 0.0;
		for(int i = 0;i<arr.length;i++){
			sum += arr[i].doubleValue();
		}
		return sum/arr.length;
	}

	@Override
	public void isLessThan(T val1, T val2) {
		if(val1.compareTo(val2)<0){
			System.out.println(val1+" is less than "+val2);
		}
		
	}

	@Override
	public void isGreaterThan(T val1, T val2) {
		
		if(val1.compareTo(val2)>0){
			System.out.println(val1+" is greater than "+val2);
		}
	}
	
	

}

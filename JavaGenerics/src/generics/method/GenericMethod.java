/**
 * 
 */
package generics.method;

/**
 * @author Ritam
 *
 */
public class GenericMethod {
	
	public  static <T, V extends T> boolean isIn(V value,T[] nums){
		
		for(int i = 0; i<nums.length;i++){
			if(value.equals(nums[i])){
				return true;
			}
		}
		return false;
	}
   
}

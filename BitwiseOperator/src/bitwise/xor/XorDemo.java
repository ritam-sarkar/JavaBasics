/**
 * 
 */
package bitwise.xor;

/**
 * @author Ritam
 *
 */
public class XorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] a = {12,14,14,45,12,67,89,67,89};
        int[] b = {1,2,2,3,7,2,7};
        System.out.println(" odd occurance no is "+findOdd(a, a.length));
       occurance(b);
		
	}
	/**
	 * Given a set of numbers where all elements occur even number
	 *  of times except one number, find the odd occuring number
	 * @param a
	 * @param n
	 * @return
	 */
	public static int findOdd(int[] a, int n){
		int res = 0;
		   for (int i = 0; i < n; i++){
			   res ^= a[i]; 
		   }		     
		return res;
	}
	/**
	 * Given a set of numbers where all elements occur more than 1 time
	 *  one number, find the single occuring number
	 * @param arr
	 */
	public static void occurance(int[] arr){
		int ones = 0, twos = 0 ;		 
	    int common_bit_mask;
	    for(int i=0;i<arr.length;i++){
	    	twos  = twos | (ones & arr[i]);
	    	ones  = ones ^ arr[i];
	    	common_bit_mask = ~(ones & twos);
	    	//remove common bit mast
	    	ones &= common_bit_mask;
	    	twos &= common_bit_mask;  	
	    	
	    }
	    System.out.println(" single occurance "+ones);
	    System.out.println(" double occurance"+twos);
	    	
	}

}

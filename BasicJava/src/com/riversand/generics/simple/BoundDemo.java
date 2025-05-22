/**
 * 
 */
package com.riversand.generics.simple;

/**
 * @author Ritam
 *
 */
public class BoundDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Integer[] arr1 = {1,2,3,4};
		Double[] arr2 = {1.0,2.0,3.0,4.0};
		Float [] arr4 = {1.0F,2.0F,3.0F,4.0F};

		BoundGeneric1<Integer> numInt = new BoundGeneric1<Integer>(arr1);
		BoundGeneric1<Double> numDouble = new BoundGeneric1<Double>(arr2);
		BoundGeneric1<Float> numFloat = new BoundGeneric1<Float>(arr4);

		// cannot use String as String is not child class of Number
		//BoundGeneric1<String> numString = new BoundGeneric1<String>(arr3);
		System.out.println(numInt.getNums().toString()+" average "+numInt.average());
		System.out.println(numDouble.getNums().toString()+" average "+numDouble.average());
		System.out.println("num int and numdouble is same avg "+numInt.sameAvg(numDouble));
		System.out.println("num Int and num float is same avg "+numInt.sameAvg(numFloat));
	}
	static class BoundGeneric1<T extends Number> {

		private T[] nums;

		public BoundGeneric1(T[] nums) {
			super();
			this.nums = nums;
		}
		public double average(){
			double sum = 0.0;
			for (int i = 0; i < nums.length; i++) {
				sum += nums[i].doubleValue();
			}
			return sum/nums.length;
		}
		public T[] getNums() {
			return nums;
		}
		public void setNums(T[] nums) {
			this.nums = nums;
		}
		public boolean sameAvg(BoundGeneric1 ob){
			if(this.average() == ob.average()){
				return true;
			}else{
				return false;
			}
		}

	}

}

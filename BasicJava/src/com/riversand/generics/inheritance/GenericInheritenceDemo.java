/**
 * 
 */
package com.riversand.generics.inheritance;

/**
 * @author Ritam
 *
 */
public class GenericInheritenceDemo {
	public static void main(String [] args){
		Calculator calInt = new CalculatorDoubleImpl();
		Calculator calDouble = new CalculatorIntImpl();
		
		Integer[] intArr = {1,3,4,5};
		double avg = calInt.avg(intArr);
		System.out.println("average of integer array  is "+avg);
		
		Double[] doubArr = {1.0,3.9,4.5,5.7};
		avg = calDouble.avg(doubArr);
		System.out.println("average of integer array  is "+avg);
		
		System.out.println("max of int array is "+calInt.max(intArr));
		System.out.println("min of int array is "+calInt.min(intArr));
		System.out.println("max of int array is "+calDouble.max(doubArr));
		System.out.println("min of int array is "+calDouble.min(doubArr));
	}
	static interface Calculator <T extends Comparable<T>,V extends Number>{


		public T max(T[] arr);
		public T min(T[] arr);
		public void isLessThan(T val1,T val2);
		public void isGreaterThan(T val1,T val2);
		public double avg(V[] arr);
	}

	static abstract  class AbstractCalCulator <T extends Comparable<T>,V extends Number> implements Calculator<T,V> {

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
	static class CalculatorDoubleImpl extends AbstractCalCulator<Double, Double>{

	}
	static class CalculatorIntImpl extends AbstractCalCulator<Integer, Integer>{

	}

}

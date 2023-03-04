/**
 * 
 */
package com.riversand.generics.inheritance.main;

import com.riversand.generics.inheritance.Calculator;
import com.riversand.generics.inheritance.CalculatorDoubleImpl;
import com.riversand.generics.inheritance.CalculatorIntImpl;

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

}

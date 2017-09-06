/**
 * 
 */
package com.ibm;

/**
 * @author Ritam
 *
 */
public class StaticInitilizerBlockDemo {
	static int rate=0;
	static {
		rate =10;
	}
	static{
		rate++;
	}
	
	public StaticInitilizerBlockDemo(int r){
		//rate=r;
		System.out.println("rate "+rate);
	}
	
	public static void main(String[] args){
		new StaticInitilizerBlockDemo(12);
	}
}

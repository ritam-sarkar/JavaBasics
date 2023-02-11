/**
 * 
 */
package com.ibm;

/**
 * @author Ritam
 *
 */
public class FlowControlDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = "1";
		int score = 10;
		if((score = score+10)==100){
			result = "A";
		}else if((score = score+29)==49){
			result = "B";
		}else if((score= score+200)== 10){
			result = "C";
		}else{
			result = "F";
		}
		System.out.println(score);
		System.out.println(result);

	}

}

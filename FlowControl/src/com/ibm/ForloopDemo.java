/**
 * 
 */
package com.ibm;

/**
 * @author Ritam
 *
 */
public class ForloopDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int[] c = new ArrayMultiply().getMultiplyArr();
         System.out.println(c[2]);
	}

}

class ArrayMultiply{
	int[] a = {1,2,3,4};
	int[] b = {1,2,3,4};
	int[] c  = new int[a.length];
	public int[] getMultiplyArr(){
		int alen = a.length;
		int blen = b.length;
		for(int i=0, j=1;i<alen && j<blen;i++,printJ(j),j++){
			c[i]= a[i]*b[j];
		}
		return c;
	}
	public void printJ(int j){
		System.out.println("j is "+j);
	}
	

}

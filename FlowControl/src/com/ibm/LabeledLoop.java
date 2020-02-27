package com.ibm;

public class LabeledLoop {

	public static void main(String[] args) {

		outer :
			for(int i =0;i<5;i++) {
				int j =0;
				System.out.println("Outer loop");
				while(j<4) {
					if(j >2) {
						continue outer;
					}
					System.out.println("Inner loop");					
					j++;
				}
			}
	        System.out.println(" Out from outer loop");
	}

}

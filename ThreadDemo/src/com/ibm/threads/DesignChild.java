/**
 * 
 */
package com.ibm.threads;

/**
 * @author Ritam
 *
 */
public class DesignChild extends ScreenDesign {
	
	@Override
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("This is child thread");
		}
	}

}

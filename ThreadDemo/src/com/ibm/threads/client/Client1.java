/**
 * 
 */
package com.ibm.threads.client;

import com.ibm.threads.ScreenDesign;
import com.ibm.threads.Thread1;
import com.ibm.threads.service.Developer;

/**
 * @author Ritam
 *
 */
public class Client1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScreenDesign design = new ScreenDesign();
		design.setName("design");
		design.start();
		Thread.yield();
		Developer dev = new Developer(design);
		dev.develop();
		

	}

}

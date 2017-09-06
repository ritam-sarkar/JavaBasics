/**
 * 
 */
package com.ibm.threads.client;

import com.ibm.model.Book;
import com.ibm.threads.DesignChild;
import com.ibm.threads.OnlineBuy;
import com.ibm.threads.OnlineReturn;
import com.ibm.threads.ScreenDesign;

/**
 * @author Ritam
 *
 */
public class Client2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ScreenDesign design  = new DesignChild();
		design.setName("child design");
		design.start();
		System.out.println("end thread");*/
		Book book = new Book("Java");
		OnlineBuy buyRunnable = new OnlineBuy(book);
		OnlineReturn returnRunnable = new OnlineReturn(book);
		Thread task1 = new Thread(buyRunnable);
		Thread task2 = new Thread(returnRunnable);
		Thread task3 = new Thread(buyRunnable);
		task1.start();
		task2.start();
		task3.start();
		

		

	}

}

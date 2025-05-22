/**
 * 
 *//*

package com.riversand.thread;

import com.ibm.model.Book;

*/
/**
 * @author Ritam
 *
 *//*

public class OnlineBuy implements Runnable {

	private Book book;
	
	@Override
	public void run() {

		if(this.book.getCopySold()<10)
		  this.book.newSale();
		System.out.println("online buy  --  copies sold"+this.book.getCopySold());
	}
	public OnlineBuy(Book book) {
		super();
		this.book = book;
	}
	public OnlineBuy() {
		super();
	}
	

}
*/

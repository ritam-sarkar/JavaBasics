package com.riversand.thread;

import com.ibm.model.Book;

public class OnlineReturn implements Runnable {

	private Book book;

	@Override
	public void run() {

		if(this.book.getCopySold()>1)
		  this.book.returnBook();
		System.out.println("online return  --  copies sold"+this.book.getCopySold());

		
	}

	public OnlineReturn(Book book) {
		super();
		this.setBook(book);
	}

	public OnlineReturn() {
		super();
	}

	
	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}
	

}

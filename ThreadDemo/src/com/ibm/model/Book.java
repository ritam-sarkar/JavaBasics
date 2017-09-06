/**
 * 
 */
package com.ibm.model;

/**
 * @author Ritam
 *
 */
public class Book {
	private String title;
	private int copySold=0;
	
	synchronized public void newSale(){
		setCopySold(getCopySold() + 1);
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	synchronized public void returnBook(){
		setCopySold(getCopySold() - 1);
		notify();
	}
	public Book(String title) {
		super();
		this.setTitle(title);
	}
	public Book() {
		super();
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the copySold
	 */
	public int getCopySold() {
		return copySold;
	}
	/**
	 * @param copySold the copySold to set
	 */
	public void setCopySold(int copySold) {
		this.copySold = copySold;
	}
	

}

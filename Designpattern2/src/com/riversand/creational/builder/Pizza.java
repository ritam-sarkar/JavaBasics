/**
 * 
 */
package com.riversand.creational.builder;

/**
 * @author ritsarka
 *
 */
public class Pizza {
	
	private String bread;
	private String nonvegTopping;
	private String vegTopping;	
	private double price;
	
	
	public Pizza(String bread, String nonvegTopping, String vegTopping, double price) {
		super();
		this.bread = bread;
		this.nonvegTopping = nonvegTopping;
		this.vegTopping = vegTopping;
		this.price = price;
	}
	public String getBread() {
		return bread;
	}
	public void setBread(String bread) {
		this.bread = bread;
	}		
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getNonvegTopping() {
		return nonvegTopping;
	}
	public void setNonvegTopping(String nonvegTopping) {
		this.nonvegTopping = nonvegTopping;
	}
	public String getVegTopping() {
		return vegTopping;
	}
	public void setVegTopping(String vegTopping) {
		this.vegTopping = vegTopping;
	}
	
	

}

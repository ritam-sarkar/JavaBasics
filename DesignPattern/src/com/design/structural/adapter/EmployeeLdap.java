/**
 * 
 */
package com.design.structural.adapter;

/**
 * @author ritsarka
 *
 */
public class EmployeeLdap {	
	private String name;
	private String mail;
	private int id;
	public EmployeeLdap(String name, String mail, int id) {
		super();
		this.name = name;
		this.mail = mail;
		this.id = id;
	}	
	public String getName() {
		return name;
	}	
	public String getMail() {
		return mail;
	}	
	public int getId() {
		return id;
	}

}

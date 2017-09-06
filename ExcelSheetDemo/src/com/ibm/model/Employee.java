/**
 * 
 */
package com.ibm.model;

/**
 * @author Ritam
 *
 */
public class Employee {
	
	private Integer id;
	private String name;
	private String emailId;
	public Employee(Integer id, String name, String emailId) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

}

/**
 * 
 */
package com.design.structural.adapter;

/**
 * @author ritsarka
 *
 */
public class EmployeeDB implements Employee {
	
	private String lastname;
	private String email;
	private int employeeId;
	
	
	public EmployeeDB() {
		super();
	}
	public EmployeeDB(String lastname, String email, int employeeId) {
		super();
		this.lastname = lastname;
		this.email = email;
		this.employeeId = employeeId;
	}
	@Override
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	

}

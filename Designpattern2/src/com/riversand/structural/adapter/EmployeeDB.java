/**
 * 
 */
package com.riversand.structural.adapter;

/**
 * @author ritsarka
 *
 */
public class EmployeeDB  {
	
	private String name;
	private String emailId;
	private int employee_id;
	
	
	public EmployeeDB() {
		super();
	}

	public EmployeeDB(String name, String emailId, int employee_id) {
		this.name = name;
		this.emailId = emailId;
		this.employee_id = employee_id;
	}

	public String getName() {
		return name;
	}

	public String getEmailId() {
		return emailId;
	}

	public int getEmployee_id() {
		return employee_id;
	}
}

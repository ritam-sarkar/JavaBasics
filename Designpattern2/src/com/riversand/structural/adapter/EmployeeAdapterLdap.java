/**
 * 
 */
package com.riversand.structural.adapter;

/**
 * @author ritsarka
 *
 */
public class EmployeeAdapterLdap implements Employee {
	
	private EmployeeLdap instance;
	
	public EmployeeAdapterLdap(EmployeeLdap instance) {
		this.instance = instance;
	}
	
	@Override
	public int getEmployeeId() {
		return instance.getId();
	}
	@Override
	public String getEmail() {
		return instance.getMail();
	}
	@Override
	public String getLastname() {
		return instance.getName();
	}
}

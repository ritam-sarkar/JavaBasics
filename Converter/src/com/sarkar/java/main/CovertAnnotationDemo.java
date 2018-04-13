/**
 * 
 */
package com.sarkar.java.main;

import java.text.ParseException;
import java.util.Date;

import com.sarkar.annotations.Convert;
import com.sarkar.formatters.Formatter;

/**
 * @author ritsarka
 *
 */
public class CovertAnnotationDemo {

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, ParseException {
		// TODO Auto-generated method stub
		Employee e = new Employee("A", "11-03-1990");
		Formatter.format(e);

	}

}

class Employee{
	private String name;
	@Convert(pattern = "DD-MM-YYYY",target = Date.class)
	private String joinDate;
	public Employee(String name, String joinDate) {
		super();
		this.name = name;
		this.joinDate = joinDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
}

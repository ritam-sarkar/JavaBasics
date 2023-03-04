/**
 * 
 */
package com.riversand.structural.adapter;

/**
 * @author ritsarka
 * This pattern is to turn legacy code to fit into new code.
 * Just like adapter usb adapter supports any other device to convert them to usb port
 * 
 *
 */
public class AdapterPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
      Employee employeeDB = new EmployeeDB("sarkar","rit@gmail.com", 12);
      EmployeeLdap employeeLdap = new EmployeeLdap("ritam", "sarkar@gmail.com", 23);
      Employee employee = new EmployeeAdapterLdap(employeeLdap);
      System.out.println(" object adapter output");
      System.out.println(employee.getEmail()+" "+employee.getEmployeeId()+ " "+employee.getLastname());
	}

}

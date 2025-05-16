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
        EmployeeDB employeeDB = new EmployeeDB("sarkar", "rit@gmail.com", 12);
        EmployeeLdap employeeLdap = new EmployeeLdap("ritam", "sarkar@gmail.com", 23);
        Employee employee = new EmployeeAdapterLdap(employeeLdap);
        System.out.println(" ladap adapter output");
        System.out.println(employee.getEmail() + " " + employee.getEmployeeId() + " " + employee.getLastname());
        Employee employee2 = new EmployeeDBAdapter(employeeDB);
        System.out.println(" DB adapter output");
        System.out.println(employee2.getEmail() + " " + employee2.getEmployeeId() + " " + employee2.getLastname());

    }


}
interface Employee {

    int getEmployeeId();

    String getEmail();

    String getLastname();

}


class EmployeeDBAdapter implements Employee {

    private EmployeeDB employeeDB;

    public EmployeeDBAdapter(EmployeeDB employeeDB) {
        this.employeeDB = employeeDB;
    }

    @Override
    public int getEmployeeId() {
        return employeeDB.getEmployee_id();
    }

    @Override
    public String getEmail() {
        return employeeDB.getEmailId();
    }

    @Override
    public String getLastname() {
        return employeeDB.getName();
    }
}

class EmployeeAdapterLdap implements Employee {

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

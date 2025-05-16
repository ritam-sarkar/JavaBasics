package com.riversand.solid;

public class SingleResponsibilityClass {
    public static void main(String[] args) {
        System.out.println("-----------Without SRP------------");
        withoutSRP();
        System.out.println("-----------With SRP------------");
        withSRP();
    }
    private static void withoutSRP(){
      Employee1 employee1 = new Employee1("Arvind","Engineer",10000.00);
      System.out.println("calculate salary :"+employee1.calculateSalary());
      employee1.printReport();
      employee1.saveToFile();
    }

    /**
     * Here Employee class only contains employee related info
     * Salarycalculator will calculate salary , means only 1 responsibility
     * EmployeeFileSaver and printreport classes are also performing only one responsiblity
     */
    private static void withSRP(){
        Employee employee = new Employee("Modi","Chaiwala",2000);
        double grossSalary = SalaryCalculator.calculate(employee);
        EmployeeReportPrinter.print(employee,grossSalary);
        EmployeeFileSaver.save(employee);
    }
    static class Employee1{
        private String name;
        private String position;
        private double baseSalary;

        public Employee1(String name, String position, double baseSalary) {
            this.name = name;
            this.position = position;
            this.baseSalary = baseSalary;
        }

        public double calculateSalary() {
            return baseSalary * 1.2; // fixed bonus
        }

        public void saveToFile() {
            System.out.println("Employee file saved");
            // file save logic here (I/O)
        }

        public void printReport() {
            System.out.println("Name: " + name);
            System.out.println("Position: " + position);
            System.out.println("Salary: " + calculateSalary());
        }
    }
    static class Employee {
        private String name;
        private String position;
        private double baseSalary;

        public Employee(String name, String position, double baseSalary) {
            this.name = name;
            this.position = position;
            this.baseSalary = baseSalary;
        }
        public String getName() { return name; }
        public String getPosition() { return position; }
        public double getBaseSalary() { return baseSalary; }
    }
    class SalaryCalculator {
        public static double calculate(Employee emp) {
            return emp.getBaseSalary() * 1.2; // bonus logic
        }
    }
    class EmployeeFileSaver {
        public static void save(Employee emp) {
            // write to file/db logic here
            System.out.println("Saving " + emp.getName() + " to file...");
        }
    }
    class EmployeeReportPrinter {
        public static void print(Employee emp, double salary) {
            System.out.println("Name: " + emp.getName());
            System.out.println("Position: " + emp.getPosition());
            System.out.println("Salary: " + salary);
        }
    }

}


package com.riversand.collectionframework.problems;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MaxSalary {
    static class Employee {
        String name;
        String department;
        int salary;

        public Employee(String name, String department, int salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("e1","IT", 2000),
                new Employee("e2","IT", 3000),
                new Employee("e3","HR", 1000),
                new Employee("e4","HR", 500)
        );
        Map<String, Employee> map = employees.stream().collect(Collectors.groupingBy(emp -> emp.department, Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparingInt(emp -> emp.salary)), Optional::get
        )));
        System.out.println(map);
    }
}

package com.riversand.collectionframework.problems;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JoiningMap {
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

    static void main() {
        List<MaxSalary.Employee> employees = List.of(
                new MaxSalary.Employee("e1","IT", 2000),
                new MaxSalary.Employee("e2","IT", 3000),
                new MaxSalary.Employee("e3","HR", 1000),
                new MaxSalary.Employee("e4","HR", 500)
        );
        Map<String, String> result =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                emp -> emp.department,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> list.stream()
                                                .map(emp -> emp.name)
                                                .sorted()
                                                .collect(Collectors.joining(","))
                                )
                        ));
        System.out.println(result);
    }
}

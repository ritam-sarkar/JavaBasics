package com.riversand.collectionframework;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    static class Employee {
        private String department;
        private int salary;

        public Employee(String department, int salary) {
            this.department = department;
            this.salary = salary;
        }

        public String getDepartment() {
            return department;
        }

        public int getSalary() {
            return salary;
        }
    }

    public static void main(String[] args) {

        /**
         * Order depart in reveresed order Sales ,  IT
         * then in each group order the salary in reversed order
         */
        PriorityQueue<Employee> pq = new PriorityQueue<>(
                Comparator.comparing(Employee::getDepartment)
                        .thenComparingInt(Employee::getSalary)
                        .reversed()
        );
        pq.add(new Employee("Sales", 75000));
        pq.add(new Employee("IT", 90000));
        pq.add(new Employee("Sales", 80000));
        pq.add(new Employee("IT", 85000));

        /**
         *
         */
        // peek always return top element
        System.out.println(pq.peek().department);
        System.out.println(pq.peek().department);

        System.out.println("Polling the elements one by one ");
        /**
         * Polling is the correct way, iterator will give some weired result
         */
        while (!pq.isEmpty()){
            Employee e = pq.poll();
            System.out.println(e.department + "|"+e.salary);
        }
        System.out.println(pq.isEmpty());

    }
}

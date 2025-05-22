package com.riversand.association;

import java.util.ArrayList;
import java.util.List;
/*  https://www.geeksforgeeks.org/association-composition-aggregation-java/ */
public class CombinationOfAggComp {
    static class Student {
        String name;
        int id;
        String dept;

       Student(String name, int id, String dept)
        {
            this.name = name;
            this.id = id;
            this.dept = dept;
        }
    }

    static class Department {
        String name;
        private List<Student> students = new ArrayList<>();

        Department(String name){
            this.name = name;
        }
        void addStudent(Student student)
        {
            this.students.add(student);
        }
        public List<Student> getStudents()
        {
            return students;
        }
    }

    static class Institute {

        String instituteName;
        private List<Department> departments = new ArrayList<>();

        Institute(String instituteName) {
            this.instituteName = instituteName;
        }
        void addDepartment(String name){
            this.departments.add(new Department(name));
        }
        void addStudentToDepartment(Student s){
            for (Department d : departments){
                if(d.name.equalsIgnoreCase(s.dept)){
                    d.addStudent(s);
                    break;
                }
            }
        }

        public int getTotalStudentsInInstitute()
        {
            int noOfStudents = 0;
            List<Student> students;

            for (Department dept : departments) {
                students = dept.getStudents();
                noOfStudents += students.size();
            }
            return noOfStudents;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Mia", 1, "CSE");
        Student s2 = new Student("Priya", 2, "CSE");
        Student s3 = new Student("John", 1, "EE");
        Student s4 = new Student("Rahul", 2, "EE");


        Institute institute = new Institute("BITS");
        institute.addDepartment("CSE");
        institute.addDepartment("EE");

        institute.addStudentToDepartment(s1);
        institute.addStudentToDepartment(s2);
        institute.addStudentToDepartment(s3);
        institute.addStudentToDepartment(s4);

        System.out.print("Total students in institute: ");
        System.out.print(institute.getTotalStudentsInInstitute());

    }
}

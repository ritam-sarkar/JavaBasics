package com.riversand.association;

import java.util.ArrayList;
import java.util.List;

public class AggregationDemo {

    public static void main(String[] args) {
        Teacher t1 = new Teacher("A");
        Teacher t2 = new Teacher("B");
        Teacher t3 = new Teacher("C");

        School school = new School("Kalachand");
        /*
        * addTeacher is better option as list can be big so have to create list object separately and we are allowing the teacher list to be updated from outside the school class
        * Our main focus is teacher and School should be loosely coupled not list and school
        */
        //.setTeachers(List.of(t1,t2,t3));
        school.addTeacher(t1);
        school.addTeacher(t2);
        school.addTeacher(t3);
        System.out.println(school.getNumberOfTeachers());


    }

    static class Teacher {
        String name;
        Teacher(String name){
            this.name = name;
        }
    }
    static class School {
        private String name;
        private List<Teacher> teachers = new ArrayList<>();
        public School(String name){
            this.name = name;
        }

        public void addTeacher(Teacher teacher) {
            teachers.add(teacher);
        }
        public void setTeachers(List<Teacher> teachers){
            this.teachers = teachers;
        }
        public int getNumberOfTeachers(){
            return this.teachers.size();
        }

    }


}

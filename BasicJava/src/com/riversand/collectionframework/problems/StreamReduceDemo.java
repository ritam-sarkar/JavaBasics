package com.riversand.collectionframework;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamReduceDemo {
    public static void main(String[] args) {

        accumulatorExample();

        combinerExample();
        
        findHighesGradeInCity();

    }

    private static void findHighesGradeInCity() {
        List<Student> students = List.of(
                new Student("st1","Bangalore",23,6.76),
                new Student("st2","Kolkata",24,7.76),
                new Student("st3","Bangalore",21,8.03),
                new Student("st3","Pune",20,7.06),
                new Student("st3","Kolkata",21,6.96)
        );
        // Output : bang : 8.03

       /* System.out.println(students.collect(Collectors.groupingBy(
                student -> student.city,
                Collectors.toList()))
                .entrySet().stream()
                .collect(Collectors.toMap(es-> es.getKey(), es-> es.getValue().stream().map(s->s.grade).max(Double::compareTo).get())));*/


        //System.out.println(map.get("Bangalore"));
        System.out.println(
                students.stream().collect(Collectors.groupingBy(
                        student -> student.city,
                        Collectors.mapping(
                                s->s.grade,Collectors.collectingAndThen(Collectors.maxBy(Double::compareTo),Optional::get)
                        )))
        );
        System.out.println(
                students.stream().collect(Collectors.groupingBy(
                        s->s.city,Collectors.mapping(s->s.grade,Collectors.reducing(0.0,BinaryOperator.maxBy(Double::compareTo))
                )))
        );

    }

    private static void combinerExample() {
        // Add age of users
        List<User> users = Arrays.asList(new User("John", 30), new User("Julie", 35));
        /**
         *  as partialresult, user both user and return type is also user so we can't accumulate
         *  Here in below example partialresult is integer , user is User and return type is integer (U, T , U)
         *  Combiner performs summation operation on U i.e. integer which we can do it by Integer :: sum as well
         *
         */
        int summationOfAge = users.stream()
                .reduce(
                        0,(partialResult,user)-> partialResult+ user.age, (x,y)-> x+y
                );
        System.out.println(summationOfAge);
    }

    private static void accumulatorExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        // Find max
        System.out.println(numbers
                .stream().reduce(0,Integer::max));
        // Find summation
        System.out.println(numbers
                .stream().reduce(0,Integer::sum));

        Stream<String> strings = Stream.of("a","bc","aa","de");
        //o/p: ABCAADE
        // If I don't use identity it gives Optional as return type
        System.out.println(strings.reduce((s1,s2)-> s1.toUpperCase()+s2.toUpperCase()).get());
    }

    private static class User {
        int age;
        String name;

        public User(String name, int age) {
            this.age = age;
            this.name = name;
        }
    }

    private static class Student {
        String name;
        String city;
        int age;
        double grade;

        public Student(String name, String city, int age, double grade) {
            this.name = name;
            this.city = city;
            this.age = age;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", city='" + city + '\'' +
                    ", age=" + age +
                    ", grade=" + grade +
                    '}';
        }
    }
}

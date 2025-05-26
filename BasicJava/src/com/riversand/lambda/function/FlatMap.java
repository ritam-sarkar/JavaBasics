package com.riversand.lambda.function;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) {
        List<String> sentences = List.of("Hello World", "Java Stream");

        List<Stream<String>> usingMap = sentences.stream()
                .map(s -> Arrays.stream(s.split(" ")))
                .toList();

        System.out.println("After using map list of stream size "+usingMap.size()); // 2 → List<String[]>

        List<String> usingFlatMap = sentences.stream()
                .flatMap(s-> Arrays.stream(s.split(" ")))
                .toList();
        System.out.println("After using flatmap list of string size "+usingFlatMap.size());

        System.out.println("------------flatmap on custom objects --------------");

        class Student {
            String name;
            List<String> courses;
            Student(String name, List<String> courses) {
                this.name = name; this.courses = courses;
            }
        }

        List<Student> students = List.of(
                new Student("Alice", List.of("Math", "Science")),
                new Student("Bob", List.of("History"))
        );
        // Using map:
        List<List<String>> courseLists = students.stream()
                .map(student -> student.courses)
                .toList(); // List<List<String>>

        // Using flatMap:
        List<String> allCourses = students.stream()
                .flatMap(student -> student.courses.stream())
                .toList(); // List<String>

        System.out.println(allCourses); // [Math, Science, History]

    }
}

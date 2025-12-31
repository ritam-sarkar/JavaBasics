package com.riversand.lambda.function;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice1 {
    static void main() {
        String problem = """
                Problem 1: Filter Even Numbers
                Given a list of integers [1, 2, 3, 4, 5, 6, 7, 8], collect only even numbers into a new List using Streams. Expected: [2, 4, 6, 8] """;
        System.out.println(problem);
       p1();

       problem = """ 
               Problem 2: Count Strings by Length
               Given ["cat", "dog", "elephant", "rat"], count strings longer than 3 characters using partitioningBy. Expected: {false=3, true=1}
               """;
       System.out.println(problem);
       p2();
       problem = """
               Problem 3: Group Names by First Letter
               Group ["John", "Jane", "Bob", "Alice", "Mark"] by first character. Expected: {A=[Alice], B=[Bob], J=[John, Jane], M=[Mark]}
               """;
        System.out.println(problem);
       p3();
       problem = """
               Problem 4: Sum Mapped Values
               For ["apple", "banana", "kiwi"], sum character lengths. Expected: 15
               """;
       System.out.println(problem);
       p4();

       problem = """
               Problem 5 (Advanced): Multi-level Grouping
               Given products, group by category then find max price per category.\
               Expected: {Electronics=Product[category=Electronics, price=1500.0], Books=Product[category=Books, price=30.0]}
               """;
       System.out.println(problem);
       p5();
       problem = """
               Problem 6 (Advanced): Partition with Transformation
               From [1,2,3,4,5,6], partition evens/odds and map evens to squares. Expected: {false=[1,9,25], true=[4,16,36]}
               """;
       System.out.println(problem);
       p6();

    }

    private static void p6() {
        Map<Boolean,List<Integer>> map = Stream.of(1,2,3,4,5,6).collect(Collectors.partitioningBy(
                i-> i %2 == 0,Collectors.mapping(x-> x*x, Collectors.toList())
        ));
        System.out.println(map);
    }

    private static void p5() {
        record Product(String category, double price) {}
        List<Product> products = Arrays.asList(
                new Product("Electronics", 1000), new Product("Electronics", 1500),
                new Product("Books", 20), new Product("Books", 30));
        Map<String, Product> map = products.stream().collect(
                Collectors.toMap(Product::category, p -> p,(p1,p2)-> {
                    if(p1.price() > p2.price()){
                        return p1;
                    } else {
                        return p2;
                    }
                }));
        System.out.println(map);

    }

    private static void p4() {
        int sum = Stream.of("apple", "banana", "kiwi")
                .mapToInt(String::length)
                .sum();
        System.out.println("Summation :"+sum);
    }

    private static void p3() {

        Map<Character, List<String>> map = Stream.of("John", "Jane", "Bob", "Alice", "Mark")
                .collect(Collectors.groupingBy(s-> s.charAt(0)));
        System.out.println(map);
    }

    private static void p2() {
        Map<Boolean, Long> map = Stream.of("cat", "dog", "elephant", "rat")
                .collect(Collectors.partitioningBy(s-> s.length() > 3, Collectors.counting()));
        System.out.println(map);
    }

    private static void p1(){
        List<Integer> evens = Stream.of(1,2,3,4,5,6,7,8)
                .filter(i-> i%2 ==0).toList();
        System.out.println(evens);
    }
}

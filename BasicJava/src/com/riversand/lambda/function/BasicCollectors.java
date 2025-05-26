package com.riversand.lambda.function;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicCollectors {
    public static void main(String[] args) {
        System.out.println("------ joining()---------");
        List<Integer> list = List.of(1,2,3,4,5,6,7);
        String csv = list.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println("csv == "+csv);
        System.out.println("----------- sum and average----------");
        int sum = list.stream().filter(i->i%2==0)
                .collect(Collectors.summingInt(Integer :: intValue));
        double avg = list.stream().filter(i->i%2==0)
                .collect(Collectors.averagingInt(Integer :: intValue));
        System.out.println("summation "+sum+" avg "+avg);
        System.out.println("----------grouping by like sql group by ----------");
        /**
         * groupingBy()
         * input type = T
         * accumulator type = <?>
         * return Map<K, List<T>
         * here K = Integer , T = String
         */
        List<String> list2 = List.of("a", "bb", "ccc", "dd");
        Function<String,Integer> classifier = String :: length;
        Map<Integer, List<String>> grouped = list2.stream()
                .collect(Collectors.groupingBy(classifier));
        System.out.println(grouped);

        System.out.println("------- Group by and then aggregate function like sql -----------");
        /**
         * input type = T , Return = D and accumulator = A
         * T = String , D = Long
         */
        Collector<String,?,Long> aggregateFunction = Collectors.counting();
        Map<Integer, Long> countMap = list2.stream().collect(
                Collectors.groupingBy(String :: length, aggregateFunction));
        System.out.println(countMap);

        System.out.println("-------------partitioning by -----------");
        Map<Boolean, List<Integer>> partitioned = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(partitioned);

        System.out.println("------------mapping on grouping by ---------------");
        Map<Integer, Set<Character>> groupAndMapping = list2.stream().collect(Collectors.groupingBy(
                String :: length,
                Collectors.mapping(s->s.charAt(0),Collectors.toSet())
        ));
        System.out.println(groupAndMapping);
        System.out.println("---------list to map -- collectors.tomap ---------------");
        /**
         * Collectors.toMap(
         *     keyMapper,         function to produce keys
         *     valueMapper,       function to produce values
         *     mergeFunction,     what to do on key collision (optional)
         *     mapSupplier        what kind of map to return (optional)
         * )
         */
         Map<Integer,List<String>> groupByLength = list2.stream()
                 .collect(Collectors.toMap(
                      String::length,
                         word -> new ArrayList<>(List.of(word))
                         ,(v1, v2)-> {
                             v1.addAll(v2);
                             return v1;
                         },
                         HashMap :: new
                 ));
        System.out.println(groupByLength);

        /**
         * Use case where toMap is useful than grouping by
         */

        System.out.println("--- ----------Find map<Userid , name> where id is unique --------------");
        record User(Integer id, String name){}
        List<User> users = List.of(
                new User(1,"A"),
                new User(2,"B"),
                new User(3,"C"),
                new User(4,"A")
        );
        Map<Integer,List<String>> map1 = users.stream()
                .collect(Collectors.groupingBy(
                    User::id,
                    Collectors.mapping(User::name, Collectors.toList()
                    )));
        System.out.println("groupby always return collection   "+map1);
        /**
         * Group by always return a list or set or any collection
         * Even aggregate function will aggregate on the chunk of lists , but cannot segregate  them
         * lets see the example of toMap
         */
        Map<Integer,String> map2 = users.stream()
                .collect(Collectors.toMap(User::id, User::name,(v1,v2)->v1));
        System.out.println(" tomap can have a chance to return anything "+map2);


    }
}

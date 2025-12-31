package com.riversand.lambda.function;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collector {
    public static void main(String[] args) {
      buildCSV();
      groupByFirstLetter();
      collectingThen();
    }



    private static void buildCSV(){
        System.out.println("---------build csv----------");
        BiConsumer<StringBuilder,String> accumulator = (sb,s1)-> {
            if(!sb.isEmpty()){
                sb.append(",");
            }
            sb.append(s1);
        };
        // combiner will be ignored for normal stream
        BiConsumer<StringBuilder,StringBuilder> combiner = (sb1,sb2)-> {
            if(!sb1.isEmpty()){
                sb1.append(",");
            }
            sb1.append(sb2);
        };

        StringBuilder finalStringBuilder = Stream.of("Alice","Bob","Charlie")
                .collect(StringBuilder::new,accumulator,combiner);
        System.out.println(finalStringBuilder);
    }

    private static void groupByFirstLetter() {
        System.out.println("--------group by first letter ------------");
        List<String> names = List.of("Alice", "Bob", "Alex", "Brian");
        BiConsumer<Map<Character,List<String>>, String> accumulator = (map,name)->{
            char firstChar = name.charAt(0);
            map.compute(firstChar,(k,v)->{
                if(v== null) v= new ArrayList<>();
                v.add(name);
                return v;
            });
        };
        BiConsumer<Map<Character,List<String>>,Map<Character,List<String>>> combiner = (map1,map2)->{
            map2.forEach((key, list) ->
                    map1.merge(key, list, (l1, l2) -> {
                        l1.addAll(l2);
                        return l1;
                    })
            );
        };
        Map<Character, List<String>> grouped = names.stream().collect(HashMap :: new, accumulator,combiner);
        System.out.println(grouped);
    }
    private static void collectingThen() {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        System.out.println("-------- make every first letter small and the collect them in a list and then convert them into unmodifiable list--------------- ");
        /**
         * T = input type = String
         * A = accumulator Type = List<String> for Collectors.ToList() or toSet()
         * R = return type = List<String>
         */
        java.util.stream.Collector<String,?,List<String>>  downStream = Collectors.toList();
        Function<List<String>,List<String>> finisher = Collections :: unmodifiableList;
        List<String> combined = names.stream()
                .map(word -> word.substring(0, 1).toLowerCase() + word.substring(1))
                        .collect(Collectors.collectingAndThen(downStream,finisher));
        System.out.println(combined);
        System.out.println("----- Collect all elements in a set , count the collected unique elements");
        int count = Stream.of(1,4,5,6,7,4,2,1)
                .collect(Collectors.collectingAndThen(
                        Collectors.toSet(),
                        Set :: size
                ));
        System.out.println("size of unique elemnt set : "+count);
    }

}

package com.riversand.collectionframework.problems;

import java.util.*;
import java.util.stream.Collectors;

public class SortByValue {
    static void main() {

        Map<String, Product> map = Map.of("C1",new Product("C1",100),
                "C2",new Product("C2",30),
                "C3",new Product("C3",80),
                "C4",new Product("C4",60),
                "C5",new Product("C5",30));
        System.out.println(map);
        Map<String, Product> sortedByValue = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(
                        Comparator.comparing(Product::price).reversed()
                ))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, // key mapper
                        Map.Entry::getValue, // value mapper
                        (first,second)-> first, // merger
                        LinkedHashMap::new  // supplier
                ));
        System.out.println(sortedByValue);



    }
    static record Product(String cat, int price){

    }
}

package com.riversand.lambda.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MapMethods {
    public static void main(String[] args) {
        System.out.println("--------simple compute method -----------");
        Map<String, Integer> freq = new HashMap<>();
        List<String> words = List.of("apple", "banana", "apple", "apple");
        for (String word : words) {
            freq.compute(word, (k, v) -> v == null ? 1 : v + 1);
        }
        System.out.println(freq);
        System.out.println("------------compute if absent method ------------");
        Map<String,AtomicInteger> freq2 = new HashMap<>();
        words.forEach(word -> {
            freq2.computeIfAbsent(word,v-> new AtomicInteger(0)).incrementAndGet();
        });
        System.out.println(freq2);
        System.out.println("------------compute if present---------");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");

        map.computeIfPresent(1, (k, v) -> v + " Streams");
        map.computeIfPresent(2, (k, v) -> "Will not run");
        // It will not add 2 , as 2 is not present in the map, its used only to update the map
        System.out.println(map);
        System.out.println("------------- merge ---------------");
        Map<String, Integer> freq3 = new HashMap<>();
        // Here unnecessary null check is not required , so freq calculation is the best option among 3
        words.forEach(w -> {
            freq3.merge(w,1,(v1,v2)->v1+v2);
        });
        System.out.println(freq3);
        System.out.println("----- group using first character merge method----------");
        Map<String,List<String>> mergeMap = new HashMap<>();
        for (String word : words) {
            String key = word.substring(0, 1);
            mergeMap.merge(key, new ArrayList<>(List.of(word)),
                    (oldList, newList) -> { oldList.addAll(newList); return oldList; });
        }
        System.out.println(mergeMap);

    }
}

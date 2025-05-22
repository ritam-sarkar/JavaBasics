package com.riversand.collectionframework.problems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindNonRepetitiveCharacter {
    public static void main(String[] args) {
        String input = "Java Hungry Blog Alive is Awesome";
        // O/p : j is the first non-repetitive character, w can have 1 occurrence but its second after j

        // With 2 iteration
        System.out.println(input.chars()
                .mapToObj(c->Character.toLowerCase(Character.valueOf((char) c)))
                         .filter(c-> !(c.equals(Character.valueOf(' '))))
                         .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap:: new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(es -> es.getValue() == 1)
                .map(es -> es.getKey())
                .findFirst().orElse(null));

    }
}

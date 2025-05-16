package com.riversand.collectionframework.problems;

import java.util.function.Function;
import java.util.stream.Collectors;

public class FindNonRepetitiveCharacter {
    public static void main(String[] args) {
        String input = "Java Hungry Blog Alive is Awesome";
        // O/p : j is the first non-repetitive character, w can have 1 occurrence but its second after j
        input.chars()
                .mapToObj(c->Character.toLowerCase(Character.valueOf((char) c)))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }
}

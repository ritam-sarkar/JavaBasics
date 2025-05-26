package com.riversand.lambda.function;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Reduce {
    public static void main(String[] args) {
      accumulator();
      parallelStream();
      findLongestWord();
    }


    private static void accumulator(){
        System.out.println("---------simple accumulator combiner is silent here--------------");
        int sum = Stream.of(1, 2, 3, 4)
                .reduce(0, (acc, elem) -> acc + elem);
        System.out.println(sum);
        sum = Stream.of(1, 2, 3, 4)
                .parallel()
                .reduce(
                        0,                              // identity
                        Integer::sum,                // accumulator
                        (partial1, partial2) -> partial1 + partial2 // combiner
                );
        System.out.println(sum);

    }
    private static void parallelStream(){
        System.out.println("------------Multi thread process using combiner------------");
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        /**
         * Thread A: [1,2] → partial = 3
         * Thread B: [3,4] → partial = 7
         * Thread C: [5,6] → partial = 11
         * Thread D: [7,8,9,10] → partial = 34
         *
         * Combiner:
         *   3 + 7 = 10
         *   10 + 11 = 21
         *   21 + 34 = 55
         */
        int result = numbers.parallelStream().reduce(
                0,
                (partialSum, element) -> {
                    System.out.println(Thread.currentThread().getName() + " - Accumulator: " + partialSum + " + " + element);
                    return partialSum + element;
                },
                (sum1, sum2) -> {
                    System.out.println(Thread.currentThread().getName() + " - Combiner: " + sum1 + " + " + sum2);
                    return sum1 + sum2;
                }
        );

        System.out.println("Final Result: " + result);
    }
    private static void findLongestWord() {
        List<String> words = List.of("apple", "banana", "mango", "pineapple");

        String longest = words.stream()
                .reduce("", (a, b) -> a.length() > b.length() ? a : b);
        System.out.println("Longest word "+longest);
    }
}

package com.riversand.collectionframework;

import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateCompositionDemo {
    public static void main(String[] args) {
        composeTwoPredicate();
        functionCompose();
    }

    private static void functionCompose() {
        Function<Integer, Integer> multiply = (value) -> value * 2;
        Function<Integer, Integer> add      = (value) -> value + 3;
        // compose
        Function<Integer, Integer> addThenMultiply = multiply.compose(add);
        Integer result1 = addThenMultiply.apply(3);
        System.out.println(result1);

        // and then is opposite of compose
        Function<Integer, Integer> multiplyThenAdd = multiply.andThen(add);

        Integer result2 = multiplyThenAdd.apply(3);
        System.out.println(result2);
    }

    private static void composeTwoPredicate() {
        String input = "A hardworking person must relaz";
        Predicate<String> startsWithA = s->s.startsWith("A");
        Predicate<String> endsWithX = s->s.endsWith("x");
        // and
        System.out.println(startsWithA.and(endsWithX).test(input));
        // or
        System.out.println(startsWithA.or(endsWithX).test(input));
    }
}

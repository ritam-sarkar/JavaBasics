package com.riversand.lambda.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDemo {
    public static void main(String[] args) {
        System.out.println("--------- Test number----------");
        Predicate<Integer> isDivisibleByTwo = x -> x%2 == 0;
        System.out.println("5 is divisible by 2 "+isDivisibleByTwo.test(5));
        System.out.println("5 is not divisible by 2 "+isDivisibleByTwo.negate().test(5));
        System.out.println("--------- where clause like sql ----------- ");
        List<User> users = List.of(
                new User("Alice", 30),
                new User("Amanda", 24),
                new User("Bob", 28),
                new User("Charlie", 32),
                new User("Chris", 40),
                new User("Cathy", 22)
        );
        System.out.println("WHERE (name LIKE 'A%' AND age > 25) OR (name LIKE 'C%' AND age < 35)");
        Predicate<User> nameStartsWithA = u -> u.name.startsWith("A");
        Predicate<User> ageGreaterThan25 = u -> u.age > 25;

        Predicate<User> nameStartsWithC = u -> u.name.startsWith("C");
        Predicate<User> ageLessThan35 = u -> u.age < 35;

// Grouped: (A AND >25) OR (C AND <35)
        Predicate<User> condition =
                nameStartsWithA.and(ageGreaterThan25)
                        .or(nameStartsWithC.and(ageLessThan35));

        List<User> result = users.stream()
                .filter(condition)
                .collect(Collectors.toList());

        result.forEach(user -> System.out.println(user.name+" | "+user.age));

    }
    private static record User(String name, int age){}
}

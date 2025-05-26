package com.riversand.lambda.function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class BasicFunction {
    static class Person {
        String firstName;
        String lastName;

        Person(String f, String l) {
            this.firstName = f;
            this.lastName = l;
        }
    }
    static record User(String name , String email){}

    public static void main(String[] args) {

        convertPersonToFullName();
        functionComposition();
        strategyMap();
        System.out.println("------------ Bi function demo---------");
        createUserRecord();
        mergeTwoMap();
    }
    private static void convertPersonToFullName(){
        System.out.println("------- convert person object to full name -----------");
        Person person = new Person("Ritam", "Sarkar");
        Function<Person,String> fullNameFunction = p->p.firstName + " "+p.lastName;
        System.out.println(fullNameFunction.apply(person));
    }
    private static void functionComposition(){
        System.out.println("------------Function composition---------------");
        Function<Double,Double> divideByTwo = i -> i / 2.0;
        Function<Double,Double> addByTen =  i -> i+10;
        Function<Double,Double> compose = addByTen.compose(divideByTwo);
        System.out.println("Compose f (c) g = f(g(x))"+ compose.apply(4.0)); // (4/2) + 10 = 12
        Function<Double,Double> andThen = addByTen.andThen(divideByTwo);
        System.out.println("Reverse compose f (andthen) g = g(f(x))"+ andThen.apply(4.0)); // (4+10)/2 = 7
    }
    // Used to avoid unnecessary if else
    private static void strategyMap(){
        System.out.println("------------Strategy map --------------");
        Map<String, Function<Integer, String>> converters = new HashMap<>();
        converters.put("hex", Integer::toHexString);
        converters.put("binary", Integer::toBinaryString);

        String format = "binary";
        System.out.println(converters.get(format).apply(10)); // Output: 1010
    }
    private static void createUserRecord(){
        System.out.println("--------- Create user record ----------");
        //BiFunction<String,String,User> createUser = (name, email) -> new User(name,email);
        BiFunction<String,String,User> createUser = User::new;
        User user = createUser.apply("Ritam","ritam.sarkar@");
        System.out.println(user.email);
    }
    private static void mergeTwoMap(){
        Map<String, Integer> map1 = Map.of("a", 1, "b", 2);
        Map<String, Integer> map2 = Map.of("a", 3, "b", 4);

        Map<String, Integer> merged = new HashMap<>(map1);
        /**
         * 1. If key exists value will be added to existing value in key
         * 2. If key does not exist put key ,value
         * 3. Here merged.merge("c",5,(v1,v2)->v1+v2)) ==> {c=5}
         */
        map2.forEach((key, value) ->
                merged.merge(key, value, (v1, v2) -> v1 + v2) // BiFunction here
        );

        System.out.println(merged); // Output: {a=4, b=6}

    }

}

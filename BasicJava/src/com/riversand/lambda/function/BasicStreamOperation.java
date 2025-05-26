package com.riversand.lambda.function;

import java.util.List;
import java.util.Optional;

public class BasicStreamOperation {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User("Alice", 30),
                new User("Amanda", 24),
                new User("Bob", 28),
                new User("Charlie", 32),
                new User("Chris", 40),
                new User("Cathy", 22),
                new User("Amanda", 22),
                new User("Babu", 22),
                new User("Durian", 22),
                new User("Bebo", 22)
        );
        /** Skip and limit
         * first 2 records skipped , start from 3rd record and take upto 5th record as limit =3
        **/
        users.stream().skip(2).limit(3).forEach(u->System.out.println(u.name));
        /**
         * Any match all match , none match
         */
        System.out.println("if any use has age > 32 "+users.stream().anyMatch(user -> user.age > 32));
        System.out.println("if all user has age > 32 "+users.stream().allMatch(user -> user.age > 32));
        System.out.println(" if no user has age > 40 "+users.stream().noneMatch(user -> user.age > 40));
        /**
         * findmatch or findany
         */
        users.stream().filter(user -> user.age > 30).findFirst().ifPresent(user->System.out.println("find first "+user.name));
        users.stream().filter(user -> user.age > 30).findAny().ifPresent(user->System.out.println("findany "+user.name)); // it can return any

        /**
         * more optional methods
         */
        Optional<User> findAny = users.stream().filter(user -> user.age <21).findAny();
        findAny.ifPresentOrElse( user -> System.out.println("User: " + user.name),
                () -> {
            // any fallback logic
                    System.out.println("Fallback logic executed ");
                });
        User fallBackResult = findAny.orElseGet(()-> new User("Fallback",20));
        System.out.println("Fallback user "+fallBackResult.name+" | "+fallBackResult.age);

        try {
            users.stream().filter(u->u.name.startsWith("F")).findAny().orElseThrow(RuntimeException::new);
        } catch (RuntimeException e){
            System.out.println("no names start with F "+e.getMessage());
        }



    }
    private record User(String name, int age){}
}

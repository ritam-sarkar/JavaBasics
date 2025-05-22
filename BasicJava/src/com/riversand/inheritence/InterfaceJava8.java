package com.riversand.inheritence;

public class InterfaceJava8 {

    interface Jumpable {
        static int maxDistance(){
            return 10;
        }
        default void minDistance(){
            System.out.println("min distance from Jumpable");
        }
    }
    interface Movable {
        static String maxDistance(){
            return "ten";
        }
        default void minDistance(){
            System.out.println("min distance from Movable");
        }
    }

    /**
     * Default methods are very crucial
     * 1. If default method is mentioned in both parent interfaces
     *   a. They have to overload properly
     *   b. If they are overloaded properly (signatures are same) the implemented class has to override
     *   c. If they are overloaded properly (parameters are different) then no need to override
     *   d. If not overloaded properly means only return type is different then its a compile time error
     * 2. default method is instance level method , so it is attached with each object of the implementing class
     * 3. Interfacename.super. default method name is going to call parent's default method
     * 4.
     *
     */
    class Animal implements Jumpable, Movable {
        public void display(){
            // cannot call like class inheritance
            //maxDistance();
            // Call with the name of the interface
            Jumpable.maxDistance();
            Movable.maxDistance();
        }

        @Override
        public void minDistance() {
            Jumpable.super.minDistance();
        }
    }
}

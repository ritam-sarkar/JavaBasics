package com.riversand.polymorphism;

import java.util.ArrayList;
import java.util.List;

public class BindingDemo {

    public static void main(String[] args) {
        Parent p = new Child();
        List<String> l1 = new ArrayList<>();
        ArrayList<String> l2 = new ArrayList<>();
        p.methodA(l1); // call child method as overridden applicable here
        p.methodA(l2);// call parent method

        /* variables are bound at compile time */
        System.out.println(p.x); // call parent
        System.out.println(p.y); // call parent

    }

    static class Parent {

        int x = 2;
        Integer y = Integer.valueOf(20);

        void methodA(List<String> list){
            System.out.println("This is methodA parent with List");
        }
        // covariant parameter type is not part of overriding
        void methodA(ArrayList<String> list){
            System.out.println("This is method A parent with arraylist");
        }

    }
    static class Child extends Parent {
        int x = 3;
        Integer y = Integer.valueOf(30);
        void methodA(List<String> list){
            System.out.println("This is methodA child with List");
        }



    }
}

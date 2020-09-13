package com.riversand.lambda;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExceptionInLambda {

    public static void main(String[] args) {
        handleWithWrapper();
        //handleWithOutWrapper();
    }

    private static void handleWithOutWrapper() {
        // lamba expression
        Student student = name -> {
            System.out.println("The Student name is: " + name);
            throw new Exception();
        };
        try {
            student.studentData("Adithya");
        } catch(Exception e) {

        }
    }

    private static void handleWithWrapper() {
        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
        integers.forEach(lambdaWrapper(i -> System.out.println(50 / i)));

    }
    private static Consumer<Integer> lambdaWrapper(Consumer<Integer> consumer) {
        return i -> {
            try {
                consumer.accept(i);
            } catch (ArithmeticException e) {
                System.err.println(
                        "Arithmetic Exception occured : " + e.getMessage());
            }
        };
    }
    // This method is generic or all classes not for only Integer
    static <T, E extends Exception> Consumer<T>  consumerWrapper(Consumer<T> consumer, Class<E> clazz) {

        return i -> {
            try {
                consumer.accept(i);
            } catch (Exception ex) {
                try {
                    E exCast = clazz.cast(ex);
                    System.err.println(
                            "Exception occured : " + exCast.getMessage());
                } catch (ClassCastException ccEx) {
                    throw ex;
                }
            }
        };
    }

}

interface Student {
    // Have to throw an exception from this method
    void studentData(String name) throws Exception;
}

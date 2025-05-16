package com.riversand.solid;

public class SingleResponsibilityMethod {

    public static void main(String[] args) {

    }

    /**
     * instead of doing different functionality in same method
     * if they are separable by some condition always create another method
     * @param isValid
     */
    private static void processOrder(boolean isValid){
       if(isValid){
           System.out.println("Order saved");
           System.out.println("Order placed");
       } else {
           System.out.println("Order goes for verification");
           System.out.println("Order cancelled");
           System.out.println("Order not saved");
       }
    }
    private static void processValidOrder(){
        System.out.println("Order saved");
        System.out.println("Order placed");
    }
    private static void processInvalidOrder(){
        System.out.println("Order goes for verification");
        System.out.println("Order cancelled");
        System.out.println("Order not saved");
    }
}

package com.riversand.beahvioural.strategy;

// Add one more UPI strategy means one more if else
public class WithOutStrategy {

    public static class ShoppingCart {
        public static void main(String[] args) {
            ShoppingCart cart = new ShoppingCart();

            cart.checkout("creditcard", 100);
            cart.checkout("paypal", 200);
        }
        public void checkout(String paymentType, int amount) {
            if (paymentType.equalsIgnoreCase("creditcard")) {
                System.out.println("Paid " + amount + " via Credit Card.");
            } else if (paymentType.equalsIgnoreCase("paypal")) {
                System.out.println("Paid " + amount + " via PayPal.");
            } else if (paymentType.equalsIgnoreCase("upi")) {
                System.out.println("Paid " + amount + " via UPI.");
            } else {
                System.out.println("Invalid payment method");
            }
        }
    }

}



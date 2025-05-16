package com.riversand.beahvioural.strategy;

/**
 * When you have multiple ways to perform a task, and you want to choose one dynamically.
 *
 * To avoid large if-else or switch statements.
 *
 * To follow the Open/Closed Principle: easily add new behavior without changing existing code.
 *
 * Now If I want to add UPI payment strategy , just add one more strategy , no need to touch other entities
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Use Credit Card Strategy
        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(100);

        // Switch to PayPal Strategy
        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(200);
    }
}
// Strategy Interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " via Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " via PayPal.");
    }
}

// Context
class ShoppingCart {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout(int amount) {
        strategy.pay(amount);
    }
}


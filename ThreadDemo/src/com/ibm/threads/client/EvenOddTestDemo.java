package com.ibm.threads.client;
public class EvenOddTestDemo {

    public static void main(String []  args) {
        Calculator cal = new Calculator();
        Thread odd = new Thread(new EvenOdd(cal, 100, false));
        Thread even = new Thread(new EvenOdd(cal, 100, true));
        odd.start();
        even.start();
    }

}

class EvenOdd implements Runnable {

    private int max;
    private Calculator cal;
    private boolean isEven =false;

    EvenOdd(Calculator cal, int max, boolean isEven) {
        this.cal = cal;
        this.max = max;
        this.isEven = isEven;
    }

    @Override
    public void run() {
        int number = isEven ? 2 : 1;
        while (number <= max) {
            if (isEven) {
                cal.printEven(number);
            } else {
                cal.printOdd(number);
            }
            number += 2;
        }
    }

}

class Calculator {

    boolean isEven = false;

    public boolean isEven() {
    	return isEven;
    }
    synchronized void printEven(int number) {

        while (!isEven) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Even:" + number);
        isEven = !isEven;
        notify();
    }

    synchronized void printOdd(int number) {
        while (isEven) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Odd:" + number);
        isEven = !isEven;
        notify();
    }

}
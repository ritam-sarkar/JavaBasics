package com.ibm.threads.client;
public class EvenOddTestDemo {

    public static void main(String []  args) {
        Calculator cal = new Calculator();
        Thread t1 = new Thread(new EvenOdd(cal, 10, false));
        Thread t2 = new Thread(new EvenOdd(cal, 10, true));
        t1.start();
        t2.start();
    }

}

class EvenOdd implements Runnable {

    private int max;
    private Calculator cal;
    private boolean isEvenNumber;

    EvenOdd(Calculator cal, int max, boolean isEvenNumber) {
        this.cal = cal;
        this.max = max;
        this.isEvenNumber = isEvenNumber;
    }

    @Override
    public void run() {
        int number = isEvenNumber == true ? 2 : 1;
        while (number <= max) {

            if (isEvenNumber) {
                cal.printEven(number);
            } else {
                cal.printOdd(number);
            }
            number += 2;
        }

    }

}

class Calculator {

    boolean isOdd = false;

    synchronized void printEven(int number) {

        while (isOdd == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Even:" + number);
        isOdd = false;
        notify();
    }

    synchronized void printOdd(int number) {
        while (isOdd == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Odd:" + number);
        isOdd = true;
        notify();
    }

}
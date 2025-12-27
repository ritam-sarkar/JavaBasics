package com.riversand.thread;

import java.util.concurrent.locks.ReentrantLock;

public class AlternateThreadPrint {

    /**
     *  name == A = true , flag = false , end result = false , so the flow will not enter into while condition and print A
     *  flag = !flag means flag = true, now A will enter waiting state and B will print B
     *
     */

    static class Printer {
        private  boolean flag = false;
        static ReentrantLock lock = new ReentrantLock();


        synchronized void print() {
            int i = 0;
            while (i < 10) {
                // Wait for MY turn
                while ((Thread.currentThread().getName().equalsIgnoreCase("A") == flag)) {
                    try {
                        wait();  // ← CRITICAL: Wait for turn
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                // My turn - print
                System.out.println(Thread.currentThread().getName());
                i++;

                // Switch turn
                flag = !flag;
                notifyAll();  // Wake other thread
            }
        }
    }

    static void main() throws InterruptedException {
        Printer printer = new Printer();
        Thread t1 = new Thread(printer::print, "A");
        Thread t2 = new Thread(printer::print, "B");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("main ends");
    }
}

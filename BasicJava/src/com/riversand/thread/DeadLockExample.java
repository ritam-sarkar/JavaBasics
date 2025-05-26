package com.riversand.thread;

import com.riversand.concurrency.ThreadUtil;

public class DeadLockExample {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void methodA() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " acquired lock1 in methodA");
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " acquired lock2 in methodA");
            }
        }
    }

    public void methodB() {
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + " acquired lock2 in methodB");
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " acquired lock1 in methodB");
            }
        }
    }

    public static void main(String[] args) {
        DeadLockExample deadlock = new DeadLockExample();

        Thread t1 = new Thread(() -> deadlock.methodA(), "Thread-1");
        Thread t2 = new Thread(() -> deadlock.methodB(), "Thread-2");
        ThreadUtil.detectDeadLock();
        t1.start();
        t2.start();
    }
}

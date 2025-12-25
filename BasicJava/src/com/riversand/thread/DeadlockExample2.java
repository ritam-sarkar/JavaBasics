package com.riversand.thread;


import com.riversand.thread.util.ThreadUtil;

public class DeadlockExample2 {

    static class Developer {
        synchronized void fixBugs() {
            System.out.println("fixing.."+Thread.currentThread().getName());
        }
        synchronized void code() {
            System.out.println("coding.."+Thread.currentThread().getName());
        }
    }
    static class Tester {
        synchronized void testAppln() {
            System.out.println("testing.."+Thread.currentThread().getName());
        }
    }
    static class AndroidApp extends Thread {
        Developer dev;
        Tester tester;
        AndroidApp(Developer dev, Tester t) {
            this.dev = dev;
            this.tester = t;
        }
        public void run() {
            synchronized(tester) {
                tester.testAppln();
                dev.fixBugs();
            }
        }
    }
    static class iPhoneApp extends Thread {
        Developer dev;
        Tester tester;

        iPhoneApp(Developer dev, Tester t) {
            this.dev = dev;
            this.tester = t;
        }

        public void run() {
            synchronized (dev) {
                dev.code();
                tester.testAppln();
            }
        }
    }
    static void main(String args[]) {
        Tester paul = new Tester();
        Developer selvan = new Developer();
        AndroidApp androidApp = new AndroidApp(selvan, paul);
        androidApp.setName("android");
        iPhoneApp iPhoneApp = new iPhoneApp(selvan, paul);
        iPhoneApp.setName("iphone");
        androidApp.start();
        iPhoneApp.start();
        ThreadUtil.detectDeadLock();
    }
}

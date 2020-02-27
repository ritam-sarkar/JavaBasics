package com.ibm.concurrent.main;

import java.util.concurrent.CountDownLatch;

/**
 * Reference 
 * http://www.java67.com/2015/06/java-countdownlatch-example.html
 * @author Ritam
 *
 */
public class CountDownLatchExp {

    public static void main(String args[]) throws InterruptedException  {
        
        CountDownLatch latch = new CountDownLatch(4);
        Worker first = new Worker(1000, latch, "WORKER-1");
        Worker second = new Worker(1000, latch, "WORKER-2");
        Worker third = new Worker(1000, latch, "WORKER-3");
        Worker fourth = new Worker(1000, latch, "WORKER-4");
        
        Worker2 fifth = new Worker2(1000, latch, "WORKER-5");
        Worker2 sixth = new Worker2(1000, latch, "WORKER-6");

        first.start();
        fifth.start();
        sixth.start();
        second.start();
        third.start();
        fourth.start();
              
        
       // System.out.println(Thread.currentThread().getName() + " has finished >>"+latch.getCount());

    }

}

class Worker extends Thread {
    private int delay;
    private CountDownLatch latch;

    public Worker(int delay, CountDownLatch latch, String name) {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
        	System.out.println(Thread.currentThread().getName()+" before calling countdown  >> "+latch.getCount());
            latch.countDown();
            System.out.println(Thread.currentThread().getName()+" after calling countdown  >> "+latch.getCount());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Worker2 extends Thread {
	
	private int delay;
    private CountDownLatch latch;

    public Worker2(int delay, CountDownLatch latch, String name) {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
        	System.out.println(Thread.currentThread().getName()+" waiting at latch calling countdown  >> "+latch.getCount());
            latch.await();
            System.out.println(Thread.currentThread().getName()+" After countdown stops ");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


  
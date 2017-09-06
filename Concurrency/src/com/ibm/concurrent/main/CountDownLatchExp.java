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
        
        CountDownLatch latch = new CountDownLatch(2);
        Worker first = new Worker(1000, latch, "WORKER-1");
        Worker second = new Worker(2000, latch, "WORKER-2");
        Worker third = new Worker(3000, latch, "WORKER-3");
        Worker fourth = new Worker(4000, latch, "WORKER-4");
        
        first.start();
        second.start();
        third.start();
        fourth.start();
        System.out.println("main is waiting");
        // Main thread will wait until all thread finished
        latch.await();
        
        System.out.println("main is running");
        
        latch.countDown();
        
        System.out.println(Thread.currentThread().getName() + " has finished >>"+latch.getCount());

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
        	System.out.println(Thread.currentThread().getName()+" starts >> "+latch.getCount());
        	/* deadlock */
        	//latch.await();
            Thread.sleep(delay);
            latch.countDown();
            System.out.println(Thread.currentThread().getName()+" called countdown  >> "+latch.getCount());
            latch.await();
            System.out.println(Thread.currentThread().getName() + " has finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


  
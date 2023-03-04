/**
 * 
 */
package com.riversand.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Ritam
 *
 */
public class AtomicDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AtomicDemo demo = new AtomicDemo();
		
		MyRunnable r = demo.new MyRunnable(0,new AtomicInteger(0), new CustomAtomicInteger(0));
		Thread t1 = new Thread(r, "Thread1");
		Thread t2 = new Thread(r,"Thread2");
		Thread t3 = new Thread(r,"Thread3");
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		System.out.println(" normal count "+r.getCounter());
		System.out.println(" atomic counter "+r.getAtomicCount());
		System.out.println(" custom counter "+r.getCustomCounter());
		
		
	}
	class MyRunnable implements  Runnable {

		private int counter;
		private AtomicInteger atomicCounter;
		private CustomAtomicInteger customCounter;
		
		public MyRunnable(int counter,AtomicInteger atomicCounter,CustomAtomicInteger customCounter) {
			super();
			this.counter = counter;
			this.atomicCounter = atomicCounter;
			this.customCounter = customCounter;
		}

		@Override
		public void run() {
			
			for(int i=1;i<5;i++){
				try {
					Thread.sleep(i*100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				counter++;
				atomicCounter.incrementAndGet();
				customCounter.increamentAndGet();
			}
		}
		public int getCounter(){
			return counter;
		}
		public int getAtomicCount(){
			return atomicCounter.get();
		}
		public int getCustomCounter(){
			return customCounter.get();
		}
		
	}

}


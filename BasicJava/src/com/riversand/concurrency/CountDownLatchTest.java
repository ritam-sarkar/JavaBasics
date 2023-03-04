/**
 * 
 */
package com.riversand.concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * @author Ritam
 *
 */
public class CountDownLatchTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);
		Thread th1 = new Thread(new CountDownRunnable(latch,1000), "th1");
		Thread th2 = new Thread(new CountDownRunnable(latch,3000), "th2");
		Thread th3 = new Thread(new CountDownRunnable(latch,4000), "th3");
		Thread th4 = new Thread(new CountDownRunnable(latch,6000), "th4");
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		latch.await();
		System.out.println(" main running "+latch.getCount());
		
	}

}

class CountDownRunnable implements Runnable{

	private CountDownLatch latch;
	private long delay;
	public CountDownRunnable(CountDownLatch latch, long delay) {
		this.latch = latch;
		this.delay = delay;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" calling countdown ");	
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		latch.countDown();
		System.out.println(Thread.currentThread().getName()+" latch count "+latch.getCount());
		
	}
	
}
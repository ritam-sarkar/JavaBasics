/**
 * 
 */
package com.ibm.concurrent.main;

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
		Thread th1 = new Thread(new AwaitRunnable(latch), "th1");
		Thread th2 = new Thread(new AwaitRunnable(latch), "th2");
		Thread th3 = new Thread(new CountDownRunnable(latch), "th3");
		Thread th4 = new Thread(new CountDownRunnable(latch), "th4");
		Thread th5 = new Thread(new CountDownRunnable(latch), "th5");
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();		
		
	}

}
class AwaitRunnable implements Runnable{
	private CountDownLatch latch;
	public AwaitRunnable(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" calling await ");
		try {
			latch.await();
			System.out.println(Thread.currentThread().getName()+" runs after await");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}
class CountDownRunnable implements Runnable{

	private CountDownLatch latch;
	public CountDownRunnable(CountDownLatch latch) {
		this.latch = latch;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" calling countdown ");		
		latch.countDown();
		System.out.println(Thread.currentThread().getName()+" latch count "+latch.getCount());
		
	}
	
}
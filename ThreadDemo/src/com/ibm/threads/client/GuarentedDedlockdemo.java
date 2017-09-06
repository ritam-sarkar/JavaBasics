/**
 * 
 */
package com.ibm.threads.client;

import java.util.concurrent.CountDownLatch;

/**
 * @author Ritam
 *
 */
public class GuarentedDedlockdemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
       Object ob1 = new Object();
       Object ob2 = new Object();
       CountDownLatch latch = new CountDownLatch(2);
       Thread2 t1 = new Thread2(ob1, ob2, latch);
       Thread2 t2 = new Thread2(ob1, ob2, latch);
       t1.start();
       t2.start();
	}

}
class Thread2 extends Thread{
	private Object ob1,ob2;
	private CountDownLatch latch;
	public Thread2(Object ob1,Object ob2,CountDownLatch latch){
		this.ob1 = ob1;
		this.ob2 = ob2;
		this.latch = latch;
	}
	public void run(){
		synchronized (ob1) {
			System.out.println(Thread.currentThread().getName()+" calling countdown");
			this.latch.countDown();
			synchronized(ob2){
				System.out.println(Thread.currentThread().getName()+" calling await ");
				try {
					this.latch.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
}

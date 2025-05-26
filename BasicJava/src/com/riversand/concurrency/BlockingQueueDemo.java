/**
 * 
 */
package com.riversand.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Ritam
 *
 */
public class BlockingQueueDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>(10);
		
		Thread t3 = new Thread(new Producer(sharedQueue), " producer2");
		Thread t4 = new Thread(new Consumer(sharedQueue), " consumer2");
		
		t3.start();
		t4.start();
	}
	static class Producer implements Runnable{
		private BlockingQueue<Integer> blockingQueue;

		public Producer(BlockingQueue<Integer> blockingQueue) {
			super();
			this.blockingQueue = blockingQueue;
		}
		@Override
		public void run() {
			int i=0;
			while(i<10){
				System.out.println(Thread.currentThread().getName()+" produces "+i);
				try {
					blockingQueue.put(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				i++;
			}
		}
	}

	static class Consumer implements Runnable {
		private BlockingQueue<Integer> blockingQueue;

		public Consumer(BlockingQueue<Integer> blockingQueue) {
			super();
			this.blockingQueue = blockingQueue;
		}
		@Override
		public void run() {
			while(true){
				try {
					System.out.println(Thread.currentThread().getName()+" consumes "+blockingQueue.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}








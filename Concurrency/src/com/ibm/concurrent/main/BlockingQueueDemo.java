/**
 * 
 */
package com.ibm.concurrent.main;

import java.util.ArrayList;
import java.util.List;
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

		BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>(20);		
		
		Thread t3 = new Thread(new Produce2(sharedQueue), " producer2");
		Thread t4 = new Thread(new Consume2(sharedQueue), " consumer2");
		
		t3.start();
		t4.start();
	}

}

class Produce2 implements Runnable{	
	private BlockingQueue<Integer> blockingQueue;

	public Produce2(BlockingQueue<Integer> blockingQueue) {
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

class Consume2 implements Runnable {
	private BlockingQueue<Integer> blockingQueue;	

	public Consume2(BlockingQueue<Integer> blockingQueue) {
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






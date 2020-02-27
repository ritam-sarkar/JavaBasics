/**
 * 
 */
package com.ibm.threads.client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Ritam
 *
 */
public class ProducerConsumerUsingBlockingQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l = new ArrayList<Integer>();
		BlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(10);
		
		Thread t1 = new Thread(new Producer(q)," producer ");
		Thread t2 = new Thread(new Consumer(q)," consumer");
		t1.start();
		t2.start();
		
  
	}

}
class Producer implements Runnable{
	private BlockingQueue<Integer> q;
	public Producer(BlockingQueue<Integer> q){
		this.q =q;
	}
	@Override
	public void run() {
		int i =0;
		while(i<10){			
			try {
				System.out.println(Thread.currentThread().getName()+" produces "+i);
				q.put(i);
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}	
}

class Consumer implements Runnable{
	private BlockingQueue<Integer> q;
	public Consumer(BlockingQueue<Integer> q){
		this.q = q;
	}

	@Override
	public void run() {	
		int i =0;
		while(i<10){
			try {
				System.out.println(Thread.currentThread().getName()+" consumes "+this.q.take());
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}


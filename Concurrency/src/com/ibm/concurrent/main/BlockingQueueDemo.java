/**
 * 
 */
package com.ibm.concurrent.main;

import java.util.ArrayList;
import java.util.List;

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

		MyBlockingQueue<Integer> q = new MyBlockingQueue<Integer>(10);
		Thread t1 = new Thread(new Produce(q), " producer");
		Thread t2 = new Thread(new Consume(q), " consumer");
		t1.start();
		t2.start();
	}

}

class Produce implements Runnable{
	private MyBlockingQueue<Integer> q;
	public Produce(MyBlockingQueue<Integer> q){
		this.q =q;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++){	
			
			try {
				System.out.println(Thread.currentThread().getName()+" produces "+i);
				this.q.enqueue(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}	
}

class Consume implements Runnable{
	private MyBlockingQueue<Integer> q;
	public Consume(MyBlockingQueue<Integer> q){
		this.q = q;
	}

	@Override
	public void run() {	
		
		while(true){
			try {
				System.out.println(Thread.currentThread().getName()+" consumes "+this.q.deQueue());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}


class MyBlockingQueue<T> {
	private List<T> list;
	private int limit;
	public MyBlockingQueue(int limit) {
		super();
		this.limit = limit;
		this.list = new ArrayList<T>();
	}
	public synchronized void enqueue(T item) throws InterruptedException{
		
		while(list.size() == this.limit){
			wait();
		}
		if(this.list.size() ==0){
			notifyAll();
		}
		list.add(item);
		
	}
	public synchronized T deQueue() throws InterruptedException{
		while(this.list.size() == 0){
			wait();
		}
		if(this.list.size() == this.limit){
			notifyAll();
		}
		T result = this.list.remove(0);		
		return result;
	}
	
}

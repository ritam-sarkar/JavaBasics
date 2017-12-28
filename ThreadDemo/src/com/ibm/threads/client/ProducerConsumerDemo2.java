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
public class ProducerConsumerDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l = new ArrayList<Integer>();
		BlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(20);
		
		Thread t1 = new Thread(new Produce(l,q)," producer ");
		Thread t2 = new Thread(new Consume(l,q)," consumer");
		t1.start();
		t2.start();
		
  
	}

}
class Produce implements Runnable{
	private List<Integer> l;
	private BlockingQueue<Integer> q;
	public Produce(List<Integer> l,BlockingQueue<Integer> q){
		this.l = l;
		this.q =q;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			synchronized(this.l){			
				
				System.out.println(Thread.currentThread().getName()+" produces "+i);
				this.l.add(i);
				this.l.notify();
				
			}
			
			/*try {
				this.q.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}		
	}	
}

class Consume implements Runnable{
	private List<Integer> l;
	private BlockingQueue<Integer> q;
	public Consume(List<Integer> l,BlockingQueue<Integer> q){
		this.l = l;
		this.q = q;
	}

	@Override
	public void run() {
		synchronized(this.l){
			while(this.l.size() ==0){
				try {
					this.l.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(int i= 0;i< this.l.size();i++){				
				System.out.println(Thread.currentThread().getName()+" consumes "+this.l.get(i));
			}
		}
		
		/*while(true){
			try {
				System.out.println(Thread.currentThread().getName()+" consumes "+this.q.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
	}
	
}


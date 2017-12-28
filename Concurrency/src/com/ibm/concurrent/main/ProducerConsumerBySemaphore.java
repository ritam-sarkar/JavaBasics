package com.ibm.concurrent.main;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ProducerConsumerBySemaphore {
	
	private Semaphore semProd = new Semaphore(1);
	private Semaphore semCon = new Semaphore(0);
	
	public static void main(String[] args) {
		ProducerConsumerBySemaphore demo = new ProducerConsumerBySemaphore();
		Q q = demo.new Q();
		Thread p1 = demo.new Producer("producer1", q);
		Thread c1 = demo.new Consumer("Consumer1", q);
		Thread p2 = demo.new Producer("producer2", q);
		Thread c2 = demo.new Consumer("Consumer2", q);
		//p1.start();
		//c1.start();
		c2.start();
		p2.start();
		
	}
	
	class Producer extends Thread {
		private Q q;
		public Producer(String name,Q q){
			super.setName(name);
			this.q = q;
		}
		public void run(){
			for(int i=0;i<4;i++){
				q.put(i);
			}
		}
	}
	class Consumer extends Thread {
		private Q q;
		public Consumer(String name,Q q){
			super.setName(name);
			this.q = q;
		}
		public void run(){
			for(int i=0;i<4;i++){
				q.get();
			}
		}
	}
	
	class Q {
		private Queue<Integer> queue = new ArrayDeque<Integer>();;
		public void put(int i){
			try {
				semProd.acquire();
				queue.add(i);
				System.out.println(Thread.currentThread().getName()+" produces "+i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				semCon.release();
			}
			
			
		}
		public void get(){
			try {
				semCon.acquire();
				System.out.println(Thread.currentThread().getName()+" consumes "+queue.poll());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				semProd.release();
			}
		}
	}

}

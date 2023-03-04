package com.riversand.thread.client;

import java.util.LinkedList;

public class ProducerConsumerUsingLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> l = new LinkedList<Integer>();
		
		Thread t1 = new Thread(new Producer(l)," producer ");
		Thread t2 = new Thread(new Consumer(l)," consumer");
		t1.start();
		t2.start();
		
  
	}
	
	static class Producer implements Runnable{
		private LinkedList<Integer> l;
		public Producer(LinkedList<Integer> l){
			this.l =l;
		}
		@Override
		public void run() {
			int i =0;
			synchronized (l) {
				while(i<10) {
					while(l.size() == 10) {
						try {
							System.out.println(Thread.currentThread().getName()+" is waiting");
							l.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}					
					System.out.println(Thread.currentThread().getName()+" produces "+i);
					l.add(i++);
					l.notify();					
				}
			}				
		}	
	}

	static class Consumer implements Runnable{
		private LinkedList<Integer> l;
		public Consumer(LinkedList<Integer> l){
			this.l = l;
		}

		@Override
		public void run() {	
			int i =0;
			synchronized (l) {
				while(i<10) {
					while(l.size() == 0) {
						try {
							System.out.println(Thread.currentThread().getName()+" is waiting");
							l.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					System.out.println(Thread.currentThread().getName()+" consumes "+l.removeFirst());
					i++;
					l.notify();					
				}
			}				
		
		}
		
	}


}

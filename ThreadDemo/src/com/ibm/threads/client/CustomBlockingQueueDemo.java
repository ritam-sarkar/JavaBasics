package com.ibm.threads.client;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueueDemo {

	public static void main(String[] args) {

		CustomBlockingQueue<Integer> customBlockingQueue = new CustomBlockingQueue<Integer>();
		Runnable producer = ()->{
			int i =1;
			while(i<=10) {
				System.out.println(Thread.currentThread().getName()+" produces "+i);
				customBlockingQueue.put(i);
				i++;
			}
		};
		Runnable consumer = ()->{
			while(true) {
				System.out.println(Thread.currentThread().getName()+" consumes "+customBlockingQueue.take());
			}
		};
		Thread p = new Thread(producer, "Producer");
		Thread c = new Thread(consumer, "Consumer");
		p.start();
		c.start();
		
	}
	public static class CustomBlockingQueue<T>{
		
		private Queue<T> q = new LinkedList<T>();
		private static final int SIZE = 5;
		Lock lock = new ReentrantLock();
		Condition notEmpty = lock.newCondition();
		Condition notFull = lock.newCondition();
		
		void put(T item){
			lock.lock();
			try {
				while(q.size() == SIZE) {
					notEmpty.await();
				}
				q.offer(item);
				notFull.signalAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally{
				lock.unlock();
			}			
		}
		
		T take(){
			lock.lock();
			T item = null;
			try {
				while(q.size() == 0) {
					notFull.await();
				}
				item = q.poll();
				notEmpty.signalAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally{
				lock.unlock();
			}
			return item;
		}
		
	}

}

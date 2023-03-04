/**
 * 
 */
package com.riversand.concurrency;

import java.util.ArrayDeque;
import java.util.Queue;


/**
 * @author Ritam
 *
 */
public class CustomeReentrantLockDemo {

	/**
	 * @param args
	 */
	interface CustomLock{
		public void lock();
		public boolean tryLock();
		public void unlock();
		public int getHoldCount();
	}
	public static void main(String[] args) {
		CustomeReentrantLockDemo demo = new CustomeReentrantLockDemo();
		CustomLock customLock = demo.new CustomReentrantLock(true);
		Object1 ob = demo.new Object1(customLock);
		Thread t1 = demo.new MyThread("Thread1", ob);
		Thread t2 = demo.new MyThread("Thread2", ob);
		Thread t3 = demo.new MyThread("Thread3", ob);
		Thread t4 = demo.new MyThread("Thread4", ob);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		

	}
	class MyThread extends Thread{
		String name;
		Object1 ob;
		public MyThread(String name, Object1 ob){
			super.setName(name);
			this.ob = ob;
		}
		public void run(){
			ob.method1();
			ob.method2();
		}
	}
	class CustomReentrantLock implements CustomLock{
		
		private long threadId;
		
		private int holdCount;
		private boolean fair;
		private Queue<Thread> threadQueue;
		public CustomReentrantLock(boolean fair){
			this.fair = fair;
			threadQueue = new ArrayDeque<Thread>();
		}

		@Override
		public synchronized void lock() {
			
			if(holdCount == 0){
				holdCount++;
				threadId = Thread.currentThread().getId();				
			}else if(holdCount > 0 && threadId == Thread.currentThread().getId()){
				holdCount++;								
			}else{
				while(holdCount > 0){
					try {
						if(fair){
							if(!threadQueue.contains(Thread.currentThread()))
							  threadQueue.add(Thread.currentThread());
						}
						wait();						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}				
				holdCount++;				
				if(fair){
					Thread queuedThread = threadQueue.poll();
					if(queuedThread != null){
						threadId = queuedThread.getId();
					}else{
						threadId = Thread.currentThread().getId();
					}
				}else{
					threadId = Thread.currentThread().getId();
				}				
				
			}
		}

		@Override
		public boolean tryLock() {
			if(holdCount == 0){
				lock();
				return true;
			}
			return false;
		}

		@Override
		public synchronized void unlock() {
			if(holdCount == 0){
				throw new IllegalMonitorStateException();
			}else{
				holdCount--;
				if(holdCount == 0){
					notifyAll();					
				}
			}						
		}

		@Override
		public int getHoldCount() {
			return holdCount;
		}
		
		
	}
	
	class Object1{
		private CustomLock lock;
		public Object1(CustomLock lock){
			this.lock = lock;
		}
		public void method1(){
			System.out.println(Thread.currentThread().getName()+" trying to acquire the lock in method1"+lock.getHoldCount());
			lock.lock();
			System.out.println(Thread.currentThread().getName()+" acquired lock in method1  count "+lock.getHoldCount());		
			lock.unlock();
			System.out.println(Thread.currentThread().getName()+" already released lock in mthod1 "+lock.getHoldCount());
		}
		public void method2(){
			System.out.println(Thread.currentThread().getName()+" try to acquire lock in method2 "+lock.getHoldCount());
			lock.lock();
			System.out.println(Thread.currentThread().getName()+" acquired the lock in method2 count "+lock.getHoldCount());
			lock.unlock();
			System.out.println(Thread.currentThread().getName()+" after releasing the lock in method2 count "+lock.getHoldCount());
			
			// throws IllegalMonitorstateexception in this line
			//lock.unlock();
			
		}
	}
	

}

/**
 * 
 */
package com.riversand.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ritam
 *
 */
public class LockInterruptedlyDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LockInterruptedlyDemo demo = new LockInterruptedlyDemo();
		MyOb ob = demo.new MyOb(new ReentrantLock());
		MyThread th1 = demo.new MyThread("Thread1", ob);
		MyThread th2 = demo.new MyThread("Thread2", ob);
		MyThread th3 = demo.new MyThread("Thread3", ob);
		th1.start();
		th2.start();
		th3.start();
		//th1.interrupt();
		
	}
	class MyThread extends Thread{
		
		private MyOb ob;
		public MyThread(String name,MyOb ob){
			super.setName(name);
			this.ob = ob;
		}
		@Override
		public void run(){
			ob.method1();
		}
		
	}
	class MyOb{
		private ReentrantLock lock;
		public MyOb(ReentrantLock lock){
			this.lock = lock;
		}
		public void method1(){
			try {
				System.out.println(Thread.currentThread().getName()+" is  trying to acquire lock ");
				//lock.lockInterruptibly();
				//lock.lock();
				//lock.tryLock(10, TimeUnit.MILLISECONDS);
				System.out.println(Thread.currentThread().getName()+" try to acquire lock "+lock.tryLock());
				System.out.println(Thread.currentThread().getName()+" acquired the lock");
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()+" woke up after sleep still acquired the lock");
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName()+" in exception block ");
			}finally{
				if(lock.isHeldByCurrentThread())
				  lock.unlock();
			}
			
		}
	}

}

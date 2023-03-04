/**
 * 
 */
package com.riversand.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ritam
 *
 */
public class DifferentLockMethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Resource res = new Resource();
		Runnable1 r = new Runnable1(res);
		Thread t1 = new Thread(r, "t1");
		Thread t2 = new Thread(r, "t2");
		t1.start();
		t2.start();
		//t1.interrupt();
		//t2.interrupt();
		//t1.resume();
		//t2.resume();
		

	}

}
class Resource {
	private ReentrantLock l = new ReentrantLock();
	public void test1(){
		//l.lock();
		//System.out.println(Thread.currentThread().getName()+" trying to acquire lock returns "+l.tryLock());
		/*if(l.tryLock(1000, TimeUnit.SECONDS)){
			System.out.println(Thread.currentThread().getName()+" prints test1");
			if(l.isHeldByCurrentThread()){
				System.out.println(Thread.currentThread().getName()+" releasing the lock");
				l.unlock();
			}
		}*/
		try {
			System.out.println(Thread.currentThread()+" trying to acquire lock");
			l.lockInterruptibly();
			
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName()+" interrupted ");
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" prints test1");		
		if(l.isHeldByCurrentThread()){
			l.unlock();
		}
		
	}
	
}
class Runnable1 implements Runnable{
    private Resource r;
    public Runnable1(Resource r){    	
    	this.r =r;
    }	
	@Override
	public void run() {
	   for(int i = 0;i<5;i++){
	       
		this.r.test1();
		
 
	   }
		
	}
	
}

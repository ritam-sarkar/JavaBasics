/**
 * 
 */
package com.riversand.concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ritam
 *
 */
public class ReentrantLockDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object1 ob = new Object1(new ReentrantLock());
        Object2 ob2 = new Object2(new ReentrantLock());
		Thread t1 = new MyThread3("Thread1", ob);
		Thread t2 = new MyThread3("Thread2", ob);
		Thread t3 = new MyThread4("Thread3", ob2);
		Thread t4 = new MyThread4("Thread4", ob2);
		t1.start();
		t2.start();
		//t3.start();
		//t4.start();
		
		
	}

}
class MyThread3 extends Thread{
	String name;
	Object1 ob;
	public MyThread3(String name, Object1 ob){
		super.setName(name);
		this.ob = ob;
	}
	public void run(){
		ob.method1();
		ob.method2();
	}
}
class MyThread4 extends Thread{
	String name;
	Object2 ob;
	public MyThread4(String name, Object2 ob){
		super.setName(name);
		this.ob = ob;
	}
	public void run(){
		ob.method1();
		ob.method2();
	}
}
class Object1{
	private ReentrantLock lock;
	public Object1(ReentrantLock lock){
		this.lock = lock;
	}
	public void method1(){
		//lock.lock();
		System.out.println(Thread.currentThread().getName()+" acquired lock");		
		//lock.unlock();
		System.out.println(Thread.currentThread().getName()+" already released lock");
	}
	public void method2(){
		System.out.println(Thread.currentThread().getName()+" try to acquire lock lock count "+lock.getHoldCount());
		//lock.lock();
		System.out.println(Thread.currentThread().getName()+" acquired the lock count "+lock.getHoldCount());
		lock.unlock();
		System.out.println(Thread.currentThread().getName()+" after releasing the lock "+lock.getHoldCount());
		lock.unlock();
		System.out.println(Thread.currentThread().getName()+" after second unlock called"+lock.getHoldCount());
		// throws IllegalMonitorstateexception in this line
		//lock.unlock();
	}
}
class Object2{
	private ReentrantLock lock;
	public Object2(ReentrantLock lock){
		this.lock = lock;
	}
	public void method1(){
		System.out.println(Thread.currentThread().getName()+" trying to acquire lock");
		if(lock.tryLock()){
			System.out.println(Thread.currentThread().getName()+" acquired lock"+lock.getHoldCount());
		}
		System.out.println(Thread.currentThread().getName()+" releasing lock"+lock.getHoldCount());
		//lock.unlock();
		System.out.println(Thread.currentThread().getName()+" already released lock"+lock.getHoldCount());
		
		
	}
	public void method2(){
		
		
	}
	
}

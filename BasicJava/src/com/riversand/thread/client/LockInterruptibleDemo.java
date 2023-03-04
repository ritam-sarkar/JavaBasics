package com.riversand.thread.client;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptibleDemo {

	public static void main(String[] args) {

		Bus b = new Bus();
		MyRunnable r1 = new MyRunnable(b, "paul");
		MyRunnable r2 = new MyRunnable(b, "Harry");
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		t1.interrupt();
		
	}

}
class MyRunnable implements Runnable{

	private Bus b;
	private String student;
	public  MyRunnable(Bus b, String student) {
		this.b = b;
		this.student = student;
	}
	@Override
	public void run() {		
			try {				
				try {
					b.lock.lockInterruptibly();
					for(int i=0;i<10;i++) {
						b.boardBus(student);
					}
				} catch (InterruptedException e) {
					System.out.println(student +" interrupted");
				}								
			}finally {
				b.lock.unlock();
			}
		
	}
	
}
class Bus{
	Lock lock;
	public Bus() {
		lock = new ReentrantLock();
	}
	public void boardBus(String name) {
		System.out.println(name +" boraded");
	}
}

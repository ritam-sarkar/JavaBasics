package com.ibm.concurrent.main;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Offering offering = new Offering();
      Thread t1 = new Thread1(offering);
      Thread t2 = new Thread1(offering);
      t1.setName("Thread1");
      t2.setName("Thread2");
      t2.start();
      t1.start();
      //t2.interrupt();
		
	}

}

class Offering {
	private int count;
	private ReentrantLock lock;
	public Offering(){
		this.lock = new ReentrantLock();
	}
	
	public void increase(){	
		this.lock.lock();
		System.out.println(Thread.currentThread().getName()+" calling increase");
		this.setCount(this.getCount() + 1);
		System.out.println(Thread.currentThread().getName()+" releasing the lock");
		this.lock.unlock();
	}
	public void decrease(){
		System.out.println(Thread.currentThread().getName()+" calling decrease");
		this.count--;
		System.out.println(Thread.currentThread().getName()+"decrease method ends");
	}
	public ReentrantLock getLock() {
		return lock;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}

class Thread1 extends Thread{
	
	private Offering off;
	public Thread1(Offering off){
		this.off = off;
	}
	@Override
	public void run(){
		try {
		this.off.getLock().lockInterruptibly();
		for(int i=0;i<5;i++){
			    this.off.increase();
			
				if(this.off.getLock().tryLock(10, TimeUnit.MILLISECONDS)){
					this.off.decrease();
					this.off.getLock().unlock();
				}else{
					System.out.println(this.getName()+" Locking false");
				}
				
				this.off.decrease();
		}
		this.off.getLock().unlock();
		}catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();			
				System.out.println(Thread.currentThread().getName()+" interrupted");
				Thread.currentThread().interrupt();
		}
			
		
	}
	
	
}

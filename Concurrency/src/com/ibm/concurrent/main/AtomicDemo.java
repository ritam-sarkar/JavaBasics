/**
 * 
 */
package com.ibm.concurrent.main;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Ritam
 *
 */
public class AtomicDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b = new Book(1);
		//b.publishCopy();
		Thread t1 = new MyThread(b,true);
		t1.setName("publisher");
		Thread t2 = new MyThread(b,false);
		t2.setName("seller");
		t1.start();
		t2.start();
		ReentrantReadWriteLock lock;
	}

}

class Book{	
	private AtomicInteger copy;
	
	public Book(int initial){
		this.copy = new AtomicInteger(initial);
	}
	public void publishCopy(){
		System.out.println(Thread.currentThread().getName()+" published copy after publish copy count "+this.copy.incrementAndGet());
	}
	public void sellCopy(){
		System.out.println(Thread.currentThread().getName()+" selled after selling copy count   "+this.copy.decrementAndGet());		
	}
	
	public boolean reset(){
		return this.copy.compareAndSet(this.copy.get(), 10);
	}
}
class MyThread extends Thread{
	private Book b;
	private boolean isPublisher;
	public MyThread(Book b,boolean isPublisher){
		this.b = b;
		this.isPublisher = isPublisher;
	}
	public void run(){
		for(int i=0;i<5;i++){
			if(isPublisher){
				this.b.publishCopy();
			}else{
				this.b.sellCopy();
			}			
			/*if(!this.b.reset()){
				System.out.println(" reset not successful");
			}*/
		}		
	}
}

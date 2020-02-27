package com.ibm.threads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * Input: n = 5
Output: "0102030405"

Input: n = 2
Output: "0102"
Explanation: There are three threads being fired asynchronously. One of them calls zero(), the other calls even(), and the last one calls odd(). "0102" is the correct output.

 * @author ritsarka
 *
 */
public class ZeroEvenOddDemo {

	public static void main(String[] args) {

		
		ZeroEvenOdd obj = new ZeroEvenOdd(4);
		Thread zero = new Thread(()->{
			try {
				obj.zero((x)->System.out.print(x));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread even = new Thread(()->{
			try {
				obj.even((x)->System.out.print(x));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread odd = new Thread(()->{
			try {
				obj.odd((x)->System.out.print(x));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		zero.start();
		even.start();
		odd.start();
		
		
	}
	
	
	static class ZeroEvenOdd {
	    private int n;
	    private AtomicBoolean zero = new AtomicBoolean(true);
	    private AtomicInteger counter = new AtomicInteger();
	    private Object lock = new Object();
	    public ZeroEvenOdd(int n) {
	        this.n = n;
	        counter.set(1);
	    }

	    // printNumber.accept(x) outputs "x", where x is an integer.
	    public void zero(IntConsumer printNumber) throws InterruptedException {
	        while(counter.get()<=n){
	            synchronized(lock){
	                while(!zero.get()){
	                    lock.wait();
	                }
	                if(counter.get()<=n){
	                    printNumber.accept(0);
	                }
	                zero.set(false);
	                lock.notifyAll();
	            }
	        }
	    }

	    public void even(IntConsumer printNumber) throws InterruptedException {
	        while(counter.get()<=n){
	            synchronized(lock){
	                while(zero.get() || counter.get()%2 == 1){
	                    lock.wait();
	                }
	                if(counter.get()<=n){
	                    printNumber.accept(counter.getAndIncrement());
	                }
	                zero.set(true);
	                lock.notifyAll();
	            }
	        }
	    }

	    public void odd(IntConsumer printNumber) throws InterruptedException {
	        while(counter.get()<=n){
	            synchronized(lock){
	                while(zero.get() || counter.get()%2 == 0){
	                    lock.wait();
	                }
	                if(counter.get()<=n){
	                    printNumber.accept(counter.getAndIncrement());
	                }
	                zero.set(true);
	                lock.notifyAll();
	            }
	        }
	    }
	}
}

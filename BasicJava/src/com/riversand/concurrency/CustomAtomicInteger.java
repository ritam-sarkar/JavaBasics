package com.riversand.concurrency;

public class CustomAtomicInteger {

	private int currVal;
	private int prevVal;
	
	public CustomAtomicInteger(){
		this.currVal = 0;
	}
	
	public CustomAtomicInteger(int initialVal){
		this.currVal = initialVal;
	}
	
	public synchronized int getAndIncreament(){
		return currVal++;
	}
	public synchronized int increamentAndGet(){
		return ++currVal;
	}
	public synchronized int get(){
		return currVal;
	}
	public boolean comareAndSet(int expect,int updatedVal){
		if(currVal == expect){
			currVal = updatedVal;
			return true;
		}
		return false;
	}
	public synchronized int getAndDecreament(){
		return currVal--;
	}
	public synchronized int decreamentAndGet(){
		return --currVal;
	}
	
}

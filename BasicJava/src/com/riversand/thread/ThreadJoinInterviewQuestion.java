package com.riversand.thread;
/**
 * Lets take a scenario, we have Main thread, Thread 1, Thread 2 and Thread 3 and we want our thread to execute in particular scenario like,
Main thread to start first and ends only after all 3 threads is completed.
Thread 1 to start and complete.
Thread 2 to start only after Thread 1 is completed.
Thread 3 to start only after Thread 2 is completed.


 * @author ritsarka
 *
 */
public class ThreadJoinInterviewQuestion {

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new MyThread(null);
		t1.setName("T1");
		t1.start();
		
		Thread t2 = new MyThread(t1);
		t2.setName("T2");
		t2.start();
		
		Thread t3 = new MyThread(t2);		
		t3.setName("T3");
		t3.start();
		
		t3.join();		
		
		System.out.println(Thread.currentThread().getName()+" waits for "+t3.getName()+" to completed ");
		System.out.println(Thread.currentThread().getName()+" running");
		
		System.out.println(Thread.currentThread().getName()+" completed ");
		
	}
	

}
class MyThread extends Thread{
	private Thread t;
	public MyThread(Thread t) {
		this.t = t;
		if(t != null) {
			try {
				System.out.println(Thread.currentThread().getName()+" waits for "+t.getName()+" to completed inside constructor ");
				this.t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" running");				
		
		System.out.println(Thread.currentThread().getName()+" completed");
	}
}

package com.riversand.thread.client;

public class CustomJoinMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRunnable r = new MyRunnable();
		ThreadA t1 = new ThreadA(r);
		t1.setName("A");
		t1.start();
		System.out.println(Thread.currentThread().getName()+" Running...");
		try {
			t1.myJoin();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i=0;i<5;i++) {
			System.out.println(Thread.currentThread().getName()+" running....");
		}
		

	}
	static class MyRunnable implements Runnable{

		@Override
		public void run() {
			for(int i=0;i<5;i++) {
				System.out.println(Thread.currentThread().getName()+" running....");
			}
		}
		
	}

}
class ThreadA extends Thread{
	public ThreadA(Runnable r) {
		super(r);
	}
	public synchronized void myJoin() throws InterruptedException {
		while(isAlive()) {
			wait(0);
		}
	}
}

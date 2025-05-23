package com.riversand.thread.client;


public class DeadlockDemo2 {

	public static void main(String[] args) {


		Object ob1 = new Object();
		Object ob2 = new Object();
		Thread t1 = new Task1(ob1, ob2);
		t1.setName("A");
		Thread t2 = new Task1(ob2, ob1);
		t2.setName("B");
		t1.start();
		t2.start();
		

	}

}

class Task1 extends Thread {

	private Object ob1;
	private Object ob2;

	public Task1(Object ob1, Object ob2) {
		super();
		this.ob1 = ob1;
		this.ob2 = ob2;
	}

	public void run() {

		synchronized (ob1) {
			try {
				Thread.sleep(1000);
				synchronized (ob2) {
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}




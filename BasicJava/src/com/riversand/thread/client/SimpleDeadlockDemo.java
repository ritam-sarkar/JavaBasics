package com.riversand.thread.client;

import com.ibm.util.ThreadUtil;

public class SimpleDeadlockDemo {

	public static void main(String[] args) {

		Object ob1 = new Object();
		Object ob2 = new Object();
		Thread t1 = new Task(ob1, ob2);
		t1.setName("A");
		Thread t2 = new Task(ob2, ob1);
		t2.setName("B");
		t1.start();
		t2.start();
		ThreadUtil.detectDeadLock();
		

	}

}

class Task extends Thread {

	private Object ob1;
	private Object ob2;

	public Task(Object ob1, Object ob2) {
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

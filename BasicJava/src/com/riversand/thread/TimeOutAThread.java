package com.riversand.thread;

import java.util.concurrent.atomic.AtomicBoolean;

public class TimeOutAThread {

	public static void main(String[] args) {

		MyTask task = new MyTask();
		Thread t1 = new Thread(task);
		t1.setName("Thread1");
		
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		task.stop();
	}
	static class MyTask implements Runnable{
		private AtomicBoolean keepRunning = new AtomicBoolean(true);

		@Override
		public void run() {
			while(keepRunning.get()) {
				System.out.println(Thread.currentThread().getName()+" running");
			}
		}
		public void stop() {
			keepRunning.set(false);
		}

	}

	
}


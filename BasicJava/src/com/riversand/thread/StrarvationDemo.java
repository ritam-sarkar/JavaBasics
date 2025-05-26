package com.riversand.thread;

public class StrarvationDemo {

	public static void main(String[] args) {

		Worker worker = new Worker();
		for(int i=0;i<10;i++) {			
			new WorkerThread(worker, "Thread "+i).start();
		}
		
	}
	static class WorkerThread extends Thread{
		private Worker worker;		
		public WorkerThread(Worker worker, String name) {
			super(name);
			this.worker = worker;
		}

		public void run() {
			worker.work();
		}
	}
	
	static class Worker{
		boolean flag = false;
		public synchronized void work() {
			while(!flag) {
				System.out.println(Thread.currentThread().getName()+" is working ");
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		public synchronized void print() {
			
		}
	}

}


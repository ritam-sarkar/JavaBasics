/**
 * 
 */
package com.ibm.threads;

/**
 * @author Ritam
 *
 */
public class ThreadJoinDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ThreadJoinDemo demo = new ThreadJoinDemo();
		ResourceLock lock = demo.new ResourceLock();
		MyRunnable myRun = demo.new MyRunnable(lock);
		Thread threadA = new Thread(myRun, "thread a");
		threadA.setName("thread a");
		threadA.start();
		lock.display(threadA);
		System.out.println(Thread.currentThread().getName()+" finished");
		

	}
	class ResourceLock{
		synchronized String display(Thread th) throws InterruptedException{
			System.out.println(Thread.currentThread().getName()+" acquired lock");
			System.out.println(Thread.currentThread().getName()+" called join on "+th.getName());//main has ResourceLock lock
			th.join();
			for(int i=0;i<5;i++){
				System.out.println(Thread.currentThread().getName()+" running inside display");
			}
			
			return "Resource lock";
		}
		synchronized void display(){
			System.out.println(Thread.currentThread().getName()+" acquired lock");
		}
	}
	class MyRunnable implements Runnable{

		private ResourceLock lock;
		
		public MyRunnable(ResourceLock lock) {
			super();
			this.lock = lock;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
				this.lock.display();
				
		
		}
		
	}

}

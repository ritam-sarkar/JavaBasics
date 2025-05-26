/**
 * 
 */
package com.riversand.thread;

/**
 * @author Ritam
 *
 */
public class ThreadStates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread t1 = new MyThread("Thread1");
		MyThread t2 = new MyThread("Thread2");
		MyThread t3 = new MyThread("Thread3");
		//MyThread t4 = new MyThread("Thread4");
		//t3.setThread(t1, t2);
		MyObj ob = new MyObj();
		t3.setOb(ob);
		t2.setOb(ob);
		//t1.setOb(ob);
		t1.start();
		t2.start();
		t3.start();
		//t4.start();
		
		
		t2.interrupt();
		t3.interrupt();
		
		

	}
	static class MyThread extends Thread{

		Thread t1;
		Thread t2;
		private MyObj myObj;
		public MyThread(String name){
			super.setName(name);
		}
		public void setThread(Thread t1, Thread t2){
			this.t1 = t1;
			this.t2 = t2;
		}
		public void setOb(MyObj myObj){
			this.myObj = myObj;
		}
		@Override
		public void run(){
			System.out.println(Thread.currentThread().getName()+" state "+Thread.currentThread().getState());
			//try {
			//Thread.sleep(10);
		/*if(t1 != null){
			System.out.println(Thread.currentThread().getName() +" called join method on "+t1.getName());
			t1.join();
		}*/
			if(myObj != null)
				myObj.method1();

			//} catch (InterruptedException e) {
			//System.out.println(Thread.currentThread().getName()+" throws interrupted exception");
			//}
			System.out.println(Thread.currentThread().getName()+" ends");

		}
	}
	static class MyObj {
		public void method1(){
			System.out.println(Thread.currentThread().getName()+" trying to acquire lock state "+Thread.currentThread().getState());
			try{
				synchronized(this){
					System.out.println(Thread.currentThread().getName()+" acquired lock");
					System.out.println(Thread.currentThread().getName()+" releasing lock");
					wait();
					System.out.println(Thread.currentThread().getName()+" get back the lock state "+Thread.currentThread().getState());
					notifyAll();
				}
			}catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName()+" throws interrupted exception state "+Thread.currentThread().getState());
			}

			System.out.println(Thread.currentThread().getName()+" ends");


		}
	}
	

}


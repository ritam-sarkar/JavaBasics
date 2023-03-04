package com.riversand.thread;

public class ThreadStateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t1 = new Thread(new Runnable1());
		Thread t2 = new Thread(new Runnable1());
		Thread t3 = new Thread(new Runnable1());
		System.out.println(Thread.State.NEW+" "+Thread.State.NEW.ordinal());
		System.out.println(Thread.State.RUNNABLE+" "+Thread.State.RUNNABLE.ordinal());
		System.out.println(Thread.State.BLOCKED+" "+Thread.State.BLOCKED.ordinal());

		System.out.println(Thread.State.WAITING+" "+Thread.State.WAITING.ordinal());
		System.out.println(Thread.State.TIMED_WAITING+" "+Thread.State.TIMED_WAITING.ordinal());
		System.out.println(Thread.State.TERMINATED+" "+Thread.State.TERMINATED.ordinal());
		
		System.out.println("before start"+t1.getState()+" "+t2.getState()+" "+t3.getState()+" "+Thread.currentThread().getState());
		t1.start();
		t2.start();
		t3.start();
		System.out.println(t1.getState()+" "+t2.getState()+" "+t3.getState()+" "+Thread.currentThread().getState());
	}

}
class Runnable1 implements Runnable{

	@Override
	public void run() {

		for(int i=0;i<5;i++){			
			System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getState());
		}
	}
	
}

package com.ibm.threads.client;

public class BellDemo {

	public static void main(String[] args) {

		Thread t = new Thread(new BellRunnable());
		t.start();
		System.out.println(" end ");		
	}

}
class BellRunnable implements Runnable{

	@Override
	public void run() {
		Bell bell = new Bell(true);
		for(int i=0;i<5;i++) {
			bell.on();
			bell.off();
		}		
	}
	
}
class Bell {
	
	private boolean sound;
	public Bell(boolean sound) {
		this.sound = sound;
	}
	public synchronized void  on() {
	   while(!sound) {
		   try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	   }
	   System.out.println("Switch On");
	   sound = !sound;
	   notify();	   
	}
	public synchronized void off() {		
		while(sound) {
			   try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(" Switch Off ");
		sound = !sound;
	    notify();
	}
}

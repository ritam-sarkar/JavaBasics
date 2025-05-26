package com.riversand.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

	public static void main(String[] args) {

		ExecutorService ex = Executors.newFixedThreadPool(2);

		for(int i=0;i<10;i++) {
          ex.submit(new Worker());
		}
		ex.shutdown();
		
	}

}
class Worker implements Runnable{

	@Override
	public void run() {

		    for(int i=0;i<10;i++) {
		    	
		    }
			System.out.println(Thread.currentThread().getName()+" running");
		
	}
	
}

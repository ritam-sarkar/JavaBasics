/**
 * 
 */
package com.riversand.thread;

import java.util.stream.IntStream;

/**
 * @author Ritam
 *
 */

/**
 * Here Child thread is in waiting state
 */
public class ThreadJoinDemo2 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread mainThread = Thread.currentThread();
        Thread design = new Thread(new ScreenDesign(mainThread),"Design");
		design.start();
		new ThreadJoinDemo2().code(mainThread);
		

	}
	static class ScreenDesign implements Runnable{

		private Thread callingThread;

		public ScreenDesign(Thread callingThread){
			this.callingThread = callingThread;
		}

		@Override
		public void run() {
			IntStream.range(0,5).forEach(i-> System.out.println(Thread.currentThread().getName()+" running "));
			try {
				System.out.println(Thread.currentThread().getName()+" caling join on "+callingThread.getName());
				//Design thread tells main thread that I will join you once you are done
				callingThread.join();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(Thread.currentThread().getName()+" running again");
		}
	}
	public void code(Thread mainThread){
		System.out.println(mainThread.getName()+" Start coding");
		IntStream.range(0,5).forEach(i-> System.out.println(mainThread.getName()+" running "));
	}


}

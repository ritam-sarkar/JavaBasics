/**
 * 
 */
package com.riversand.thread;

/**
 *
 * Here Main thread is in waiting state
 * @author Ritam
 *
 */
public class ThreadJoinDemo1 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {


        Thread design = new Thread(new ScreenDesign(),"Design");
		design.start();
		new ThreadJoinDemo1().code(design);
		

	}
	static class ScreenDesign implements Runnable{

		@Override
		public void run() {
			for (int i=0;i<5;i++){
				System.out.println(Thread.currentThread().getName()+" running ");
			}
		}
	}
	public void code(Thread design){
		System.out.println("Start coding");
		try {
			System.out.println(Thread.currentThread().getName()+" calls join on design ");
			//Main thread tells design thread that I will join you once you are done
			design.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println(Thread.currentThread().getName()+" running ");

	}


}

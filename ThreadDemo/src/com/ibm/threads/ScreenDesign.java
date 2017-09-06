/**
 * 
 */
package com.ibm.threads;

/**
 * @author Ritam
 *
 */
public class ScreenDesign extends Thread{

	private static int threadid;
	@Override
	public void run(){
		for(int i=0;i<7;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	/**
	 * @return the threadid
	 */
	public static int getThreadid() {
		return threadid;
	}
	/**
	 * @param threadid the threadid to set
	 */
	public static void setThreadid(int threadid) {
		ScreenDesign.threadid = threadid;
	}
}

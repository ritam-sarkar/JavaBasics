/**
 * 
 */
package com.riversand.thread.util;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * @author ritsarka
 *
 */
public class ThreadUtil {
	
	public static void  detectDeadLock() {
		Thread t = new DetectDeadlockThread();
		t.setDaemon(true);
		t.setName("Detect deadlock thread");
		t.start();
	}
	private static class DetectDeadlockThread extends Thread{
		public void run() {
			while(true) {
				ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
				long[] threadIds = threadBean.findDeadlockedThreads();
				boolean deadlock = threadIds !=null && threadIds.length >0;
				if(deadlock) {
					System.out.println("Deadlock occurred");
					break;
				}
			}
		}
	}
}


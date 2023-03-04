/**
 * 
 */
package com.riversand.concurrency;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * @author ritsarka
 *
 */
public class ThreadUtil {

	public static void  detectDeadLock() {
		Thread t = new DetectDeadlockThread();
		t.start();
	}
}
class DetectDeadlockThread extends Thread{
	public void run() {
		while(true) {
			ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
			long[] threadIds = threadBean.findDeadlockedThreads();
			boolean deadlock = threadIds !=null && threadIds.length >0;
			System.out.println("Deadlock occurred");
			if(deadlock)
				break;
		}
	}
}

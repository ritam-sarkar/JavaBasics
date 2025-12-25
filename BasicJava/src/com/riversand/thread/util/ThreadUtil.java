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
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreadUtil {
    public static boolean detectDeadLock() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();

        if (deadlockedThreads != null && deadlockedThreads.length > 0) {
            System.out.println("🚨 **DEADLOCK DETECTED** 🚨");
            System.out.println("Deadlocked threads: " + Arrays.toString(deadlockedThreads));

            // Print stack traces of deadlocked threads
            for (long threadId : deadlockedThreads) {
                Thread thread = findThreadById(threadId);
                if (thread != null) {
                    System.out.println("\n🔒 Thread " + thread.getName() + " (" + threadId + "):");
                    for (StackTraceElement ste : thread.getStackTrace()) {
                        System.out.println("  at " + ste);
                    }
                }
            }
            return true;
        }

        System.out.println("✅ No deadlock detected");
        return false;
    }

    private static Thread findThreadById(long threadId) {
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread.getId() == threadId) {
                return thread;
            }
        }
        return null;
    }

    // Bonus: Monitor contention detection (not deadlock)
    public static void printContention() {
        System.out.println("\n📊 Thread contention status:");
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            Thread.State state = thread.getState();
            if (state == Thread.State.BLOCKED || state == Thread.State.WAITING) {
                System.out.println("⏳ " + thread.getName() + " is " + state +
                        " (contention, NOT deadlock)");
            }
        }
    }
}



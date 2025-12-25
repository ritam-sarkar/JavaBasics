package com.riversand.newFeatures.virtualthread;

public class SimpleVirtualThread {
    public static void main() throws InterruptedException {
        /*var builder = Thread.ofVirtual().name("worker-", 0);
        for (int i = 0; i < 100; i++) {
            builder.start(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }*/
        Thread v1 = Thread.ofVirtual().name("V1").start(() -> {
            System.out.println("V1 running by thread "+Thread.currentThread().getName());
        });

        Thread v2 = Thread.ofVirtual().name("V2").start(() -> {
            System.out.println("V2 running "+Thread.currentThread().getName());
        });

        v1.join();
        v2.join();

    }
}

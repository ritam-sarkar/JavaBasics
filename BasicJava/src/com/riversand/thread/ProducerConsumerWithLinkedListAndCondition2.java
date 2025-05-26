package com.riversand.thread;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * In real life producer and consumer runs parallely
 * Here producer produces and Consumer also consumes , may not be alternatively but parallel
 */
public class ProducerConsumerWithLinkedListAndCondition2 {

    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer();
        Producer producer = new Producer(sharedBuffer);
        Consumer consumer = new Consumer(sharedBuffer);
        new Thread(producer, "Producer").start();
        new Thread(consumer, "Consumer").start();


    }

    static class SharedBuffer {
        private LinkedList<Integer> queue;
        private ReentrantLock lock;
        private Condition full;
        private Condition empty;
        static final int capacity = 3;

        public SharedBuffer() {
            this.queue = new LinkedList<>();
            this.lock = new ReentrantLock();
            this.full = lock.newCondition();
            this.empty = lock.newCondition();
        }

        public void add(Integer value) {
            queue.addLast(value);
        }

        public Integer remove() {
            return queue.removeFirst();
        }

        public boolean isFull() {
            return queue.size() == capacity;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public ReentrantLock getLock() {
            return lock;
        }

        public Condition getFull() {
            return full;
        }

        public Condition getEmpty() {
            return empty;
        }
    }

    static class Producer implements Runnable {
        private int value = 1;
        private SharedBuffer buffer;

        public Producer(SharedBuffer sharedBuffer) {
            this.buffer = sharedBuffer;
        }

        @Override
        public void run() {
            /**
             * put the lock to unlock entire block inside infinite loop
             */
            try {
                while (true) {
                    buffer.getLock().lock();
                    try {
                        while (buffer.isFull()) {
                            buffer.getFull().await();
                        }
                        buffer.add(value);
                        System.out.println(Thread.currentThread().getName() + " produced " + value);
                        value++;
                        buffer.getEmpty().signal();
                        Thread.sleep(1000);
                    } finally {
                        buffer.getLock().unlock();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }

    static class Consumer implements Runnable {
        private SharedBuffer buffer;

        public Consumer(SharedBuffer sharedBuffer) {
            this.buffer = sharedBuffer;
        }

        @Override
        public void run() {
            try {
                /**
                 * put the lock to unlock entire block inside infinite loop
                 */
                while (true) {
                    buffer.getLock().lock();
                    try {
                        while (buffer.isEmpty()) {
                            buffer.getEmpty().await();
                        }
                        Integer i = buffer.remove();
                        if (i != null) {
                            System.out.println(Thread.currentThread().getName() + " consumes " + i);
                            buffer.getFull().signal();
                            Thread.sleep(1000);
                        }
                    } finally {
                        buffer.getLock().unlock();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }
}

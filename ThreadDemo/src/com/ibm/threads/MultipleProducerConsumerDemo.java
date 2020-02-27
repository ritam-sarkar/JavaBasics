/**
 * 
 */
package com.ibm.threads;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ritam
 *
 */
public class MultipleProducerConsumerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MultipleProducerConsumerDemo demo = new MultipleProducerConsumerDemo();
		ReentrantLock lock = new ReentrantLock(true);
        SharedObject ob = demo.new SharedObject();
        SharedObjectWithLock ob2 = demo.new SharedObjectWithLock(lock);
        String[] procures = {"P1","P2","P3","P4","P5","P6","P7"};
        String[] consumers = {"C1","C2","C3","C4","C5","C6","C7"};
        for(String p : procures){
        	Producer producer = demo.new Producer(p, ob);
        	producer.start();
        }
        for(String c : consumers){
        	Consumer consumer = demo.new Consumer(c, ob);
        	consumer.start();
        }
        
     
	}
     
	class Producer extends Thread {
		private Object ob;
		public Producer(String name,Object ob){
			super.setName(name);
			this.ob = ob;
		}
		public void run(){
			SharedObject ob1 = null;
			SharedObjectWithLock ob2 = null;
			if(ob instanceof SharedObject){
				ob1 = (SharedObject)ob;
			}else if(ob instanceof SharedObjectWithLock){
				ob2 = (SharedObjectWithLock)ob;
			}
			if(ob1 != null) {
				ob1.put(Thread.currentThread().getName());
			}
			for(int i=0;i<2;i++){
				if(ob2 != null){
					ob2.put(i);
				}
			}
		}
	}
	class Consumer extends Thread {
		private Object ob;
		public Consumer(String name,Object ob){
			super.setName(name);
			this.ob = ob;
		}
		public void run(){
			SharedObject ob1 = null;
			SharedObjectWithLock ob2 = null;
			if(ob instanceof SharedObject){
				ob1 = (SharedObject)ob;
			}else if(ob instanceof SharedObjectWithLock){
				ob2 = (SharedObjectWithLock)ob;
			}
			if(ob1 != null){
				System.out.println(super.getName()+" get the value "+ob1.get());
			}
			for(int i=0;i<2;i++){
				if(ob2 != null){
					System.out.println(super.getName()+" get the value "+ob2.get());
				}				
			}
		}
	}
	class SharedObject {
		private Queue<String> queue = new LinkedList<String>();
		private int capacity =1;
		public synchronized void put(String i){
			System.out.println(Thread.currentThread().getName()+" put "+i);
			queue.add(i);
			notifyAll();
		}
		public synchronized String get(){
			while(queue.isEmpty()){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return queue.poll();
		}
	}
	class SharedObjectWithLock{
		private Queue<Integer> queue =null;
		private ReentrantLock lock = null;
		private Condition empty = null;
		public SharedObjectWithLock(ReentrantLock lock){
			this.lock = lock;
			this.queue = new LinkedList<Integer>();
			empty = lock.newCondition();
		}
		public void put(int i){
			lock.lock();
			try{
				System.out.println(Thread.currentThread().getName()+" put "+i);
				queue.add(i);
				empty.signalAll();
			}finally{
				lock.unlock();
			}
		}
		public int get(){
			lock.lock();
			try{
			while(queue.isEmpty()){
				try {
					empty.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return queue.poll();
			}
			finally{
				lock.unlock();
			}
		}
		
	}
}

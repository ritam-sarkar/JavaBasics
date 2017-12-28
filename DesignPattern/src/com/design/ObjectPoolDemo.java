/**
 * 
 */
package com.design;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author Ritam
 *
 */
public class ObjectPoolDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ObjectPoolDemo demo = new ObjectPoolDemo();
		ObjectPool<MyObject> pool = demo.new MyObjectPool(6);
		Thread t1 = new Thread(demo.new MyRunnable(pool),"Thread1");
		Thread t2 = new Thread(demo.new MyRunnable(pool),"Thread2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();		
		System.out.println(" after pooling pool availablity is "+pool.available());
		pool.shutdown();
	}
	
	class MyRunnable implements Runnable{	
		
		ObjectPool<MyObject> pool;
		public MyRunnable(ObjectPool<MyObject> pool) {
			this.pool = pool;
		}
		@Override
		public void run() {
			for(int i = 0;i<10;i++){
				MyObject ob = pool.checkOut();
				ob.doSomeThing();
				pool.checkIn(ob);
			}			
		}
		
	}
	
	abstract class ObjectPool<T>{
		
		BlockingQueue<T> objectQueue;
		protected abstract void expire(T ob);
		protected abstract boolean validate(T ob);
		protected abstract T create();
		protected Hashtable<T, Long> locked;
		protected Hashtable<T, Long> unlocked;
		protected long expireTime;		
		protected AtomicInteger counter = new AtomicInteger(0);
		protected AtomicBoolean shutdown = new AtomicBoolean(false);
		public ObjectPool(int size){
			objectQueue = new LinkedBlockingQueue<T>(size);
			long now = System.currentTimeMillis();
			locked = new Hashtable<T, Long>();
		    unlocked = new Hashtable<T, Long>();
			expireTime = 3000;
			for(int i=0;i<size;i++){
				T ob = create();
				objectQueue.add(ob);
				unlocked.put(ob,now);
			}   
		    
		}
		protected synchronized T  checkOut(){
			long now = System.currentTimeMillis();
			if(!shutdown.get()){
				T ob;
				if(unlocked.size()>0){
					Enumeration<T> e = unlocked.keys();
					while(e.hasMoreElements()){
						ob = e.nextElement();
						if(now - unlocked.get(ob)>expireTime){
							unlocked.remove(ob);
							expire(ob);							
						}else{
							if(validate(ob)){
								unlocked.remove(ob);
								locked.put(ob, now);
								return ob;
							}else{
								unlocked.remove(ob);
							}
						}
					}
				}
				try {
					ob = objectQueue.take();
					makeAvailable(ob);
					locked.put(ob, now);
					return ob;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				throw new RuntimeException(" Pool is already shut down");				
			}
			return null;			
		}
		protected synchronized void checkIn(T ob){
			if(!shutdown.get()){
				if(locked.containsKey(ob)){
					locked.remove(ob);
				}
				unlocked.put(ob, System.currentTimeMillis());	
			}					
		}		
		protected void release(){
			objectQueue.clear();
			unlocked.clear();
			locked.clear();
		}
		protected void shutdown(){
			if(!shutdown.compareAndSet(false, true)){
				throw new RuntimeException(" pool already shutdown");
			}
		}
		protected synchronized int available(){
			int availableCount =0;
			if(unlocked.size()>0){
				Enumeration<T> e = unlocked.keys();
				while(e.hasMoreElements()){
					T ob = e.nextElement();
					if(validate(ob)){
						availableCount++;
					}
				}
			}
			return availableCount;
		}
		abstract protected void makeAvailable(T ob);
		
		
	}
	class MyObjectPool extends ObjectPool<MyObject>{
		
		public MyObjectPool(int size) {
			super(size);
		}
		
		@Override
		protected void expire(MyObject ob) {
			ob.close();
		}

		@Override
		protected boolean validate(MyObject ob) {
			return ob.isClosed() ? false : true;
		}

		@Override
		protected MyObject create() {
			return new MyObject(counter.incrementAndGet());
		}

		@Override
		protected void makeAvailable(MyObject ob) {
			ob.open();			
		}		
		
	}
	class MyObject {
		AtomicBoolean closed = new AtomicBoolean(false);
		int id;
		MyObject(int id){
			this.id = id;
		}
		void close(){
			closed.compareAndSet(false, true);
		}			
		boolean isClosed(){
			return closed.get();
		}
		void open(){
			closed.compareAndSet(true, false);
		}
		void doSomeThing(){
			System.out.println(this.id+" is called from "+Thread.currentThread().getName());
		}
	}

}

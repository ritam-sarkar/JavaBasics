/**
 * 
 */
package com.ibm.concurrent.main;

import java.util.concurrent.Semaphore;

import com.sun.corba.se.impl.orbutil.concurrent.Mutex;

/**
 * @author Ritam
 *
 */
public class MutexSemaphoreDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MutexSemaphoreDemo demo = new MutexSemaphoreDemo();
        Semaphore semaphore = new Semaphore(3);
        Mutex mutex = new Mutex();
        SharedObject mutexOb = demo.new SharedObject(mutex);
        SharedObject semaOb = demo.new SharedObject(semaphore);
        SemaThread s1 = demo.new SemaThread("s1", semaOb);
        SemaThread s2 = demo.new SemaThread("s2", semaOb);
        SemaThread s3 = demo.new SemaThread("s3", semaOb);
        SemaThread s4 = demo.new SemaThread("s4", semaOb);
        /*MuteThread m1 = demo.new MuteThread("m1", mutexOb);
        MuteThread m2 = demo.new MuteThread("m2", mutexOb);
        MuteThread m3 = demo.new MuteThread("m3", mutexOb);
        MuteThread m4 = demo.new MuteThread("m4", mutexOb);*/
        s1.start();
        s2.start();
        s3.start();
        s4.start();
       // m1.start();
       // m2.start();
       // m3.start();
       // m4.start();
        
        
        
        
	}
	class SemaThread extends Thread{
		private SharedObject ob;
		public SemaThread(String name,SharedObject ob){
			super.setName(name);
			this.ob = ob;
		}
		public void run(){
			ob.semaphoreMethod();
		}
	}
	class MuteThread extends Thread{
		private SharedObject ob;
		public MuteThread(String name,SharedObject ob){
			super.setName(name);
			this.ob = ob;
		}
		public void run(){
			ob.mutexMethod();
		}
	}
	class SharedObject{
		private Mutex mutex;
		private Semaphore semaphore;
		public SharedObject(Mutex mutex){
			this.mutex = mutex;
		}
		public SharedObject(Semaphore semaphore){
			this.semaphore = semaphore;
			
		}
		public void mutexMethod(){
			System.out.println(Thread.currentThread().getName()+" trying to acquire lock  ");
			try {
				mutex.acquire();
				System.out.println(Thread.currentThread().getName()+" got permit");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				mutex.release();				
			}
			
		}
		public void semaphoreMethod(){
			System.out.println(Thread.currentThread().getName()+" trying to acquire lock "+semaphore.availablePermits());
			try {
				semaphore.acquire();
				System.out.println(Thread.currentThread().getName()+" got permit "+semaphore.availablePermits());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				semaphore.release();
				System.out.println(Thread.currentThread().getName()+" after releasing lock "+semaphore.availablePermits());
			}
		}
		
	}

}


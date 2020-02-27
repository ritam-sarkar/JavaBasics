package com.ibm.concurrent.main;

import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;



public class CustomThreadPool {

	public static void main(String[] args) {
		
		CustomThreadPool demo = new CustomThreadPool();
		RunnableTask task1 = demo.new RunnableTask(1);
		RunnableTask task2 = demo.new RunnableTask(2);
		RunnableTask task3 = demo.new RunnableTask(3);
		RunnableTask task4 = demo.new RunnableTask(4);
		ThreadPool pool = demo.new ThreadPool(6);
		pool.execute(task1);
		pool.execute(task2);
		pool.execute(task3);
		pool.execute(task4);
		pool.shutdown();
		pool.execute(task2);
		
	}
	class ThreadPool{
		
		 /**
		  * set shutdownflag to true to stop the client to execute more runnable task
		  */
		 private AtomicBoolean shutDownFlag = new AtomicBoolean(false);
		 
		 /**
		     * Core pool size is the minimum number of workers to keep alive
		     * (and not allow to time out etc) unless allowCoreThreadTimeOut
		     * is set, in which case the minimum is zero.
		     */
		 private volatile int poolSize;

		    /**
		     * Maximum pool size. Note that the actual maximum is internally
		     * bounded by CAPACITY.
		     */
		 
		 private BlockingQueue<Runnable> workQueue;		 
		 
		 private HashSet<Worker> workers = new HashSet<Worker>();
		  
		 
		 public ThreadPool(int poolSize){
			 this.poolSize = poolSize;
			 workQueue = new ArrayBlockingQueue<Runnable>(3);
			 for(int i =1;i<=poolSize;i++){
				 Worker w = new Worker("Thread "+i, workQueue, this);
				 workers.add(w);
				 w.start();				 
			 }
		 }
		 
		 public void execute(Runnable r){
			 if(this.shutDownFlag.get() || !workQueue.offer(r)){
				 reject(r);
				 
			 }	
			 
		 }	
		 public  void shutdown(){
			 shutDownFlag.compareAndSet(false, true);	
			 for(Worker worker : workers) {
				while(!worker.isAlive()) {
					worker.interrupt();
				}
			 }
		 }
		 private void reject(Runnable task) {
			 RunnableTask runnableTask = (RunnableTask)task;
			 throw new RejectedExecutionException(" Rejected task id is "+runnableTask.taskid);
	     }
		 
		 class Worker extends Thread{
		        private BlockingQueue<Runnable> tasks;
		        private ThreadPool threadPool;
				public Worker(String name,BlockingQueue<Runnable> tasks,ThreadPool threadPool){
					super.setName(name);
					this.tasks = tasks;
					this.threadPool = threadPool;
				}
				public void run(){
					while(true){
						Runnable task = tasks.poll();						
						if(threadPool.shutDownFlag.get()) {
							reject(task);
						}else if(task != null){
							task.run();
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}				
					}
				}		
			}
		 
	}
	
	class RunnableTask implements Runnable{

		private int taskid;
		public RunnableTask(int taskid) {
			this.taskid = taskid;
		}
		@Override
		public void run() {
             System.out.println(Thread.currentThread().getName()+" running  task"+this.taskid);			
		}		
	}

}

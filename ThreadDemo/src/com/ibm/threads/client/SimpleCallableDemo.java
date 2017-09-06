package com.ibm.threads.client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import com.ibm.threads.MyCallable;

public class SimpleCallableDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Callable<String> callable1 = new MyCallable(1);
		Callable<String> callable2 = new MyCallable(2);
		Callable<String> callable3 = new MyCallable(3);
		ExecutorService ex = Executors.newFixedThreadPool(5);
		

		//Using Executor framework with no return type;
		/*List<Callable<String>> tasks = new ArrayList<Callable<String>>();
		tasks.add(callable1);
		tasks.add(callable2);
		tasks.add(callable3);
		ex.invokeAll(tasks);*/
		
		
		//Using Executor, Future framework with  return type;
		Future<String> future1 = ex.submit(callable1);
		Future<String> future2 = ex.submit(callable2);
		Future<String> future3 = ex.submit(callable3);
		List<Future<String>> futureList = new ArrayList<Future<String>>();
		futureList.add(future1);
		futureList.add(future2);
		futureList.add(future3);
		for(Future<String> future : futureList){
			System.out.println(future.get());
		}
		
		//Using executor and futuretask
		/*FutureTask<String> futureTask1 = new FutureTask<String>(callable1);
		FutureTask<String> futureTask2 = new FutureTask<String>(callable2);
		FutureTask<String> futureTask3 = new FutureTask<String>(callable3);
		ex.execute(futureTask3);
		ex.execute(futureTask1);
		ex.execute(futureTask2);        
		
		System.out.println(futureTask3.isDone());
		if(futureTask1.isDone() && futureTask2.isDone()){
			System.out.println("task 1 done"+futureTask1.get());
			System.out.println(" task 2 is done");
			ex.shutdown();
		}*/				
			

		
		
	}

}

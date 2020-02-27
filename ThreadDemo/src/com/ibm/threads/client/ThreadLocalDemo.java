package com.ibm.threads.client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThreadLocal<SimpleDateFormat> dateFormatter = new ThreadLocal<SimpleDateFormat>() {
			@Override
			protected SimpleDateFormat initialValue() {
				return new SimpleDateFormat("yyyy-MM-dd");
				
			}
			/*@Override
			public SimpleDateFormat get() {
				return super.get();
			}*/
		};
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		for(int i=0;i<10;i++) {
			executorService.execute(()->{System.out.println(dateFormatter.get().format(new Date()));});
		}		
	}

}

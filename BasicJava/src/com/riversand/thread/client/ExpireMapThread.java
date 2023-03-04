package com.riversand.thread.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ExpireMapThread<T> {

	private static final long keepAliveTime = 10000;
	Map<Integer,Long> timeMap = new ConcurrentHashMap<Integer,Long>();
	private Map<Integer,T> dataMap = new ConcurrentHashMap<Integer,T>();	
	
	public ExpireMapThread() {
		Thread cl = new Thread(new CleanUp<>(timeMap, dataMap));
		cl.start();
		
	}
	public void put(Integer key, T value) {
		dataMap.putIfAbsent(key, value);		
		timeMap.put(key, new Date().getTime());
		
	}
	public T get(Integer key) {
		T value = dataMap.get(key);
		timeMap.put(key, new Date().getTime());
		return value;
		
	}
	public int size() {
		return dataMap.size();
	}
	
	static class CleanUp<U> implements Runnable{
		
		private Map<Integer,Long> timeMap;
		private Map<Integer,U> dataMap;
		
		public CleanUp(Map<Integer,Long> timeMap, Map<Integer,U> dataMap) {
			this.timeMap = timeMap;
			this.dataMap = dataMap;
		}
		
		@Override
		public void run() {			
			while(true) {
				List<Integer> expiredKeys = new ArrayList<Integer>();
				if(!timeMap.isEmpty()) {
					for(Integer key : timeMap.keySet()) {
						long currTime = new Date().getTime();
						if((currTime-timeMap.get(key)) > keepAliveTime) {
							expiredKeys.add(key);
						}
					}
				}				
			  for(Integer key : expiredKeys) {
				  System.out.println("Removing key "+key);
				  timeMap.remove(key); 
				  dataMap.remove(key);
			  }								
			}			
		}		
	}
	
	public static void main(String args[]) throws InterruptedException {
		ExpireMapThread<String> expireMapThread = new ExpireMapThread<String>();
		for(int i=0;i<10;i++) {
			expireMapThread.put(i, "A"+i);
		}		
		System.out.println("size before sleep"+expireMapThread.size());
		Thread.sleep(1000);
		for(int i=1;i<10;i+=2) {
			expireMapThread.get(i);
		}	
		System.out.println("size after sleep "+expireMapThread.size());
		
		
	}
	
}




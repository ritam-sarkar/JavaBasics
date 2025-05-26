package com.riversand.thread;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MergeSortUsingForkJoinPool {

	public static void main(String[] args) {

		int[] arr = {7, 8, 4, 5, 9};
		Merge mergeTask = new Merge(arr, 0, arr.length-1);
		ForkJoinPool pool = new ForkJoinPool(2);
		pool.execute(mergeTask);
		do {
			System.out.printf("******************************************\n");          
	           System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
	           System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
	           System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
	           System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
	           System.out.printf("******************************************\n");
	           
		}while(!mergeTask.isDone());
		pool.shutdown();
		int[] sorted = mergeTask.join();
		Arrays.stream(sorted).forEach(System.out::print);
	}

}
class Merge extends  RecursiveTask<int[]>{

	private int[] arr;
	int start;
	int end;
	
	public Merge(int[] arr, int start, int end) {
		super();
		this.arr = arr;
		this.start = start;
		this.end = end;
	}

	@Override
	protected int[] compute() {
		int[] newArr = null;
		if(arr != null && start < end) {
			//divide
			int mid = (start+end)/2;
			Merge task1 = new Merge(arr, start, mid);
			task1.fork();
			Merge task2 = new Merge(arr, mid+1, end);
			task2.fork();
			// conquer
			int[] arr1 = task1.join();
			int[] arr2 = task2.join();
			int m = arr1.length;
			int n = arr2.length;
			int i=0;
			int j=0;
			int k=0;
			newArr = new int[m+n];						
			while(i<m && j<n) {
				if(arr1[i]<arr2[j]) {
					newArr[k] = arr1[i];
					i++;
				}else {
					newArr[k] = arr2[j];
					j++;
				}
				k++;				
			}
			while(i<m) {
				newArr[k] = arr1[i];
				i++;
				k++;
			}
			while(j<n) {
				newArr[k] = arr2[j];
				j++;
				k++;
			}		
			
		}else {
			newArr = new int[1];
			newArr[0] = arr[start];
		}
		
		return newArr ;
	}

	
	
}

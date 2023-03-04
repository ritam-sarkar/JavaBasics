/**
 * 
 */
package com.riversand.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * @author Ritam
 *
 */
public class ForkJoinPoolDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 System.out.println("No of processor "+Runtime.getRuntime().availableProcessors());
		ForkJoinPoolDemo demo = new ForkJoinPoolDemo();
        Option option1 = demo.createStructure(3);
        Option option2 = demo.createStructure(2);
        ForkJoinPool pool = new ForkJoinPool();
        RetreiveOptionIds forkJoinTask1 = demo.new RetreiveOptionIds(option1);
        RetreiveOptionIds forkJoinTask2 = demo.new RetreiveOptionIds(option2);
        pool.execute(forkJoinTask1);
        pool.execute(forkJoinTask2);        
        do
        {
           System.out.printf("******************************************\n");          
           System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
           System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
           System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
           System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
           System.out.printf("******************************************\n");
          
        } while ((!forkJoinTask1.isDone()) || (!forkJoinTask2.isDone()));
        pool.shutdown();
        
        List<Integer> optionIdList1 = forkJoinTask1.join();
        System.out.println(optionIdList1);
        List<Integer> optionIdList2 = forkJoinTask2.join();
        System.out.println(optionIdList2);
        
		
	}	
	private  Option createStructure(int level){
		
		Option option = new Option(level);
        if(level == 0){
			return option;
		}
		List<Option> options = new ArrayList<Option>();
		option.setOptions(options);
		for(int i =0;i<2;i++){
			option.getOptions().add(createStructure(level-1));
		}
		return option;
	}
	class Option {
		private int optionId;
	    private List<Option> options;
		public Option(int optionId) {
			super();
			this.setOptionId(optionId);
		}
		public List<Option> getOptions() {
			return options;
		}
		public void setOptions(List<Option> options) {
			this.options = options;
		}
		public int getOptionId() {
			return optionId;
		}
		public void setOptionId(int optionId) {
			this.optionId = optionId;
		}	    
	}
	
	class RetreiveOptionIds extends RecursiveTask<List<Integer>>{
		private Option option;
		public RetreiveOptionIds(Option option){
			this.option = option;
		}		

		@Override
		protected List<Integer> compute() {
			List<Integer> optionList = new ArrayList<Integer>();
			if(option != null){
				optionList.add(option.optionId);
				if(option.getOptions() != null){
					List<RetreiveOptionIds> tasks = new ArrayList<RetreiveOptionIds>();
					for(Option innerOption : option.getOptions()){
						RetreiveOptionIds task = new RetreiveOptionIds(innerOption);
						task.fork();
						tasks.add(task);
					}
					for(RetreiveOptionIds task : tasks){
						optionList.addAll(task.join());
					}
				}				
			}			
			return optionList;
		}
		
	}

}

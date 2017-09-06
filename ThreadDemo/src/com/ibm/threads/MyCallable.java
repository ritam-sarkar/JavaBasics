package com.ibm.threads;

import java.util.concurrent.Callable;

import com.ibm.model.Machine;

public class MyCallable implements Callable<String> {

	private int task;
	public MyCallable(int task) {
		this.task = task;
	}
	@Override
	public String call() throws Exception {
		Machine machine = new Machine();
		String result = null;
		switch(this.task){
		case 1:
			result =  machine.doTaskOne();
			break;
		case 2:
			result = machine.doTaskTwo();
			break;
		case 3:
			result = machine.doTaskThree();
			break;
		default :
			break;
		}
		return result;
	}

}

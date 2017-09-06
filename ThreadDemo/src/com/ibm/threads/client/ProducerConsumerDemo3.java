/**
 * 
 */
package com.ibm.threads.client;

/**
 * @author Ritam
 *
 */
public class ProducerConsumerDemo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Factory fact = new Factory();
		Producer3 producer = new Producer3(fact);
		producer.setName(" producer ");
		Consumer3 consumer = new Consumer3(fact);
		consumer.setName(" consumer");
		producer.start();
		consumer.start();

	}

}
class Producer3 extends Thread {
	private Factory factory;
	public Producer3(Factory factory){
		this.factory = factory;
	}
	@Override
	public void run(){
		for(int i = 0; i<5;i++){
			factory.produce();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
class Consumer3 extends Thread {
	private Factory factory;
	public Consumer3(Factory factory){
		this.factory = factory;
	}
	@Override
	public void run(){
		for(int i = 0; i<5;i++){
			factory.consume();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
class Factory {
	boolean available = false;
	String raw;	

	synchronized void produce(){
		while(available == true){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.raw = "raw material";
		System.out.println(Thread.currentThread().getName()+" produces "+this.raw);
		this.available = true;	
		notify();
		
	}
	synchronized void consume(){
		while(available == false){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" consumes "+this.raw);
		this.raw = null;
		this.available = false;
		notify();
	}
	
}
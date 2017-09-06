/**
 * 
 */
package com.ibm.threads.client;

/**
 * @author Ritam
 *
 */
public class ProducerConsumerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Account acc = new Account(5);
		Producer pr = new Producer(acc);
		Consumer c = new Consumer(acc);
		Thread t1 = new Thread(pr, "producer ");
		Thread t2 = new Thread(c, "consumer ");
		t1.start();
		t2.start();
	}

}

class Account{
	private int amount;
	public Account(int amount){
		this.amount = amount;
	}
	public synchronized void  withdraw(int a){
		if(this.getBalance() <=0){
			System.out.println("running out of money");
		}else{
			try {
				while(this.getBalance() != 10){
					wait();
				}				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.amount = this.amount-a;
			notify();
		}		
	}
	public synchronized void deposit(int a){
	   while(this.amount != 5){
		   try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   this.amount = this.amount+a;	
	   notify();
	}
	
	public int getBalance(){
		return this.amount;
	}
}

class Producer implements Runnable{
    private Account acc;
	public Producer(Account acc){
		this.acc = acc;
	}
	@Override
	public void run() {
	  for(int i=0;i<10;i++){		  
		  this.acc.deposit(5);
		  System.out.println(Thread.currentThread().getName()+" deposit and balance "+this.acc.getBalance());
	  }
	  
	}
	
}

class Consumer implements Runnable{

	 private Account acc;
	 public Consumer(Account acc){
		 this.acc = acc;
	 }
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			  this.acc.withdraw(5);
			  System.out.println(Thread.currentThread().getName()+" withdrawl and balance "+this.acc.getBalance());
		  }
		
	}
	
}

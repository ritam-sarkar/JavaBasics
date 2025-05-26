package com.riversand.thread;

public class EvenOddTestDemo2 {

	public static void main(String[] args) {

		Printer printer = new Printer(false);
		EvenOddRunnable even = new EvenOddRunnable(100, printer, true);
		EvenOddRunnable odd = new EvenOddRunnable(100, printer, false);
		Thread t1 = new Thread(odd, "Odd");
		Thread t2 = new Thread(even, "Even");
		t1.start();
		t2.start();

	}

}
class EvenOddRunnable implements Runnable{
	int max;
	private Printer printer;
	private boolean isEven;
	public EvenOddRunnable(int max, Printer printer, boolean isEven) {
		this.max = max;
		this.printer = printer;
		this.isEven = isEven;
	}
	public void run() {
		int i = isEven ? 2 : 1;
		while(i<=max) {
			if(!isEven)
			  printer.printOdd(i);
			else
			  printer.printEven(i);
			i += 2;
		}		
		
	}
}


class Printer{
	boolean isEven = false;
	
	public Printer(boolean isEven) {
		this.isEven = isEven;
	}
	public synchronized void  printEven(int number) {		
		while(!isEven) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" prints "+number);
		isEven = !isEven;
		notify();
	}
	public synchronized void printOdd(int number)   {
		while(isEven) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" prints "+number);
		isEven = !isEven;
		notify();
	}
	
}


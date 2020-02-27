package com.ibm.threads;

public class SynchronizationExample {

	public static void main(String[] args) {

		Test t = new Test();
		Thread1 t1 = new Thread1(t);
		Thread t2 = new Thread2(t);
		t1.start();
		t2.start();
		
	}
	
	static class Thread1 extends Thread{
		private Test t;
		public Thread1(Test t) {
			this.t= t;
		}
		public void run() {
			t.f1();
		}
	}
	static class Thread2 extends Thread{
		private Test t;
		public Thread2(Test t) {
			this.t= t;
		}
		public void run() {
			t.f2();
		}
	}
	
	static class Test{
		private Object ob;
		private Object ob2;
		public Test() {
			ob = new Object();
			ob2 = new Object();
		}
		 synchronized void f1(){			
				
			for(int i =0;i<4;i++) {
				System.out.println("Inside f1 method");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}		
			
		}
		 synchronized void f2(){	
				
			for(int i =0;i<4;i++) {
				System.out.println("Inside f2 method");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
						
		}
	}
	

}


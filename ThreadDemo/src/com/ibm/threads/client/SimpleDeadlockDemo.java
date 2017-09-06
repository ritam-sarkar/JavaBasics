package com.ibm.threads.client;

public class SimpleDeadlockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      MyObject ob = new MyObject("string1",1);
      Thread1 t1 = new Thread1(ob);
      Thread1 t2 = new Thread1(ob);
      t1.start();
      t2.start();
	}

}
class Thread1 extends Thread{
	private MyObject ob;
	public Thread1(MyObject ob){
		this.ob = ob;
	}
	public void run(){
		this.ob.printInt();
		this.ob.printString();
	}
}
class MyObject {
	
	private String s;
	private Integer i;
	
	public MyObject(String s, Integer i){
		this.s = s;
		this.i =i;
	}
	public  void printInt(){
		synchronized (i) {
			System.out.println(s);
			synchronized (s) {
				System.out.println(i);
			}
		}		
	}
	public  void printString(){
		synchronized (s) {
			System.out.println(i);
			synchronized (i) {
				System.out.println(i);
			}
		}		
	}
}

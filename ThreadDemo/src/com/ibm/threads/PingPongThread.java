/**
 * 
 */
package com.ibm.threads;

/**
 * @author Ritam
 *
 */
public class PingPongThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// for Ping Pong
		Ball ball = new Ball(1);
		// for Pong Ping
		//Ball ball = new Ball(0);		
		Thread ping = new PingPong("Ping ", 1, ball);
		Thread pong = new PingPong("Pong ", 0, ball);		
		pong.start();
		ping.start();
	}

}
class PingPong extends Thread{
	private Ball ball;
	private int sound;
	public PingPong(String name,int sound,Ball ball){
       super(name);
       this.ball = ball;
       this.sound = sound;
	}
	@Override
	public void run(){
		for(int i=0;i<10;i++){
			if(this.sound ==1){
				ball.ping();
			}else{
				ball.pong();
			}
		}
	}
	
}
class Ball {
	private int sound=0;
	public Ball(int sound){
		this.sound = sound;
	}
	public synchronized void ping(){
		while(sound ==0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		System.out.println(Thread.currentThread().getName()+" prints  Ping ");
		sound =0;
		notify();
	}
	public synchronized void pong(){
		while(sound ==1){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
		System.out.println(Thread.currentThread().getName()+" prints Pong ");
		sound =1;
		notify();
	}
}

/**
 * 
 */
package com.riversand.thread;

/**
 * @author Ritam
 *
 */
public class PingPongThread {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// for Ping Pong
		Ball ball = new Ball();
		Thread pingThread = new PingPong(ball, true);
		pingThread.setName("Ping");
		Thread pongThread = new PingPong(ball, false);
		pongThread.setName("Pong");
		pongThread.start();
		Thread.sleep(100);
		pingThread.start();

		
	}

}
class PingPong extends Thread{
	
	private Ball ball;
	private boolean ping;
	public PingPong(Ball ball, boolean ping) {
		this.ball = ball;
		this.ping = ping;
	}
	public void run() {
		for(int i=0;i<10;i++) {
			if(ping) {
				ball.ping();
			}else {
				ball.pong();
			}
		}
	}
}
class Ball {

	private boolean ping = true;
	
	public boolean isPing() {
		return ping;
	}
	public synchronized void ping()  {
		while(!ping) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" prints Ping");
		ping = !ping;
		notify();
	}
	public synchronized void pong()  {
		while(ping) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" prints Pong");
		ping = !ping;
		notify();
	}
}

/**
 * 
 */
package main;

import actors.HollywoodActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Actors;
import akka.actor.Props;

/**
 * @author ritsarka
 *
 */
public class UseHollywoodActor {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ActorSystem system = ActorSystem.create("ActorSystem");
		ActorRef johnyDepp = system.actorOf(new Props(HollywoodActor.class), "Johny");
		ActorRef tomHanks = system.actorOf(new Props(HollywoodActor.class), "Tomhanks");
		ActorRef leo = system.actorOf(new Props(HollywoodActor.class), "Leo");		
		johnyDepp.tell("pyrates");
		Thread.sleep(1000);
		tomHanks.tell("cast away");
		Thread.sleep(1000);
		leo.tell("inception");
		system.shutdown();
		
	}

}

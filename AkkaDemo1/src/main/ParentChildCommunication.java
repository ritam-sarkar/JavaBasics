/**
 * 
 */
package main;

import actors.ParentChildActor;
import akka.actor.ActorSystem;
import akka.actor.Props;
import messages.FirstMessage;

/**
 * @author ritsarka
 *
 */
public class ParentChildCommunication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ActorSystem.create().actorOf(new Props(ParentChildActor.class), "parent").tell(new FirstMessage("This is first message"));
		System.out.println("Main Ends here");

	}

}

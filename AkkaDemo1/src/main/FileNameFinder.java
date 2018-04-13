/**
 * 
 */
package main;

import actors.FileActor;
import actors.FileListenerActor;
import actors.FileSerachController;
import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActorFactory;
import messages.SearchMessage;

/**
 * @author ritsarka
 *
 */
public class FileNameFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ActorSystem actorSystem = ActorSystem.create();
		
		ActorRef controller = actorSystem.actorOf(new Props(FileSerachController.class),"controller");
		controller.tell(new SearchMessage("D:\\Repo\\pgbu_platform-2.0", 1));
	}

}

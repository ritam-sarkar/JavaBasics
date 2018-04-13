/**
 * 
 */
package actors;

import java.util.concurrent.atomic.AtomicInteger;

import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.actor.UntypedActorFactory;
import messages.CompleteTaskMessage;
import messages.SearchMessage;

/**
 * @author ritsarka
 *
 */
public class FileSerachController extends UntypedActor{


	@Override
	public void onReceive(Object message) throws Exception {		
		if(message instanceof SearchMessage) {
			SearchMessage searchMsg = (SearchMessage)message;
			UntypedActorFactory untypedActorFactory = new UntypedActorFactory() {
				
				@Override
				public Actor create() {
					return new FileActor(new AtomicInteger(0));
				}
			};
			getContext().actorOf(new Props(untypedActorFactory),"childactor").tell(searchMsg,getSelf());
			
		}else if(message instanceof CompleteTaskMessage) {
			CompleteTaskMessage completeMsg = (CompleteTaskMessage) message;
			if(completeMsg.isComplete()) {
				System.out.println("task ends here");
				this.getContext().system().shutdown();
			}
		}else {
			unhandled(message);
		}
		
	}

	
}

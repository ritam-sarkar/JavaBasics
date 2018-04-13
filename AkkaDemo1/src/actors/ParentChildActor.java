/**
 * 
 */
package actors;

import akka.actor.Props;
import akka.actor.UntypedActor;
import messages.CommunicationMessage;
import messages.FirstMessage;

/**
 * @author ritsarka
 *
 */
public class ParentChildActor extends UntypedActor{

	@Override
	public void onReceive(Object message) throws Exception {
		if(message instanceof FirstMessage) {
			FirstMessage firstMessage = (FirstMessage)message;
			System.out.println(firstMessage.getMessage());
			getContext().actorOf(new Props(ParentChildActor.class)).tell(new CommunicationMessage("hi child"), getSelf());
		}else if(message instanceof CommunicationMessage) {
			CommunicationMessage communicationMessage = (CommunicationMessage)message;
			if(communicationMessage.isFromChild()) {
				System.out.println("message from child "+communicationMessage.getMessage());
				getContext().system().shutdown();
			}else {
				System.out.println(" message from parent "+communicationMessage.getMessage());
				getSender().tell(new CommunicationMessage("Hi parent", true), getSelf());

			}
		}
		
	}

}

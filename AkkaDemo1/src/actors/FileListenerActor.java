/**
 * 
 */
package actors;

import akka.actor.UntypedActor;
import messages.CompleteTaskMessage;
import messages.PrintMessage;

/**
 * @author ritsarka
 *
 */
public class FileListenerActor extends UntypedActor{

	@Override
	public void onReceive(Object message) throws Exception {

		if(message instanceof PrintMessage) {
			PrintMessage print = (PrintMessage) message;
			if(print.getFileNames() != null) {
				for(String fileName : print.getFileNames()) {
					System.out.println(fileName+" printed by "+print.getThreadName());
				}
			}
			getSender().tell(new CompleteTaskMessage(true),getSelf());
			
		}else {
			unhandled(message);
		}
	}

}

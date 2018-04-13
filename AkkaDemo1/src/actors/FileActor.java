/**
 * 
 */
package actors;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import akka.actor.Actor;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.actor.UntypedActorFactory;
import akka.routing.RoundRobinRouter;
import messages.CompleteTaskMessage;
import messages.PrintMessage;
import messages.SearchMessage;

/**
 * @author ritsarka
 *
 */
public class FileActor extends UntypedActor{

	private AtomicInteger actorCount=null;
	
	public FileActor(AtomicInteger actorCount) {
		super();
		this.actorCount = actorCount;
	}
	

	public FileActor() {
		super();
	}


	@Override
	public void onReceive(Object message) throws Exception {
		
		if(message instanceof SearchMessage) {
			List<String> fileNames = new ArrayList<String>();
			SearchMessage search = (SearchMessage) message;
			String folderPath = search.getFilePath();
			if(folderPath != null) {
				File folder = new File(folderPath);
				if(folder.listFiles() != null && folder.listFiles().length>0) {
					for(File file : folder.listFiles()) {
						if(file.isDirectory()) {
							UntypedActorFactory untypedActorFactory = new UntypedActorFactory() {
								
								@Override
								public Actor create() {
									return new FileActor(new AtomicInteger(0));
								}
							};
							actorCount.incrementAndGet();							
							context().actorOf(new Props(untypedActorFactory)).tell(new SearchMessage(file.getPath(), search.getLevel()+1));
							
						}else {
							fileNames.add(file.getName());
						}
					}
					if(!fileNames.isEmpty()) {
						for(String fileName : fileNames) {
							System.out.println(Thread.currentThread().getName()+" printing at level "+search.getLevel());
							System.out.println("message is "+fileName);
						}
						
					}
				}
				getSender().tell(new CompleteTaskMessage(true), getSelf());
			}
			
		}else if(message instanceof CompleteTaskMessage) {
			CompleteTaskMessage completeMsg = (CompleteTaskMessage) message;			
			if(completeMsg.isComplete() && !(actorCount.decrementAndGet() >0)) {
				getSender().tell(completeMsg,getSelf());
			}
		}else {
			unhandled(message);
		}
			
		
	}

}

/**
 * 
 */
package actors;

import akka.actor.UntypedActor;

/**
 * @author ritsarka
 *
 */
public class HollywoodActor extends UntypedActor{

	@Override
	public void onReceive(Object role) throws Exception {
		
		
			System.out.println("Playing " + role +
					" from Thread " + Thread.currentThread().getName());		
				
	}

	

}

/**
 * 
 */
package actors;

import akka.actor.UntypedActor;
import main.Pi.PiApproximation;

/**
 * @author ritsarka
 *
 */
public class Listener extends UntypedActor{

	@Override
	public void onReceive(Object message) throws Exception {

	    if (message instanceof PiApproximation) {
	        PiApproximation approximation = (PiApproximation) message;
	        System.out.println(String.format("\n\tPi approximation: \t\t%s\n\tCalculation time: \t%s",
	            approximation.getPi(), approximation.getDuration()));
	        getContext().system().shutdown();
	      } else {
	        unhandled(message);
	      }
	}

}

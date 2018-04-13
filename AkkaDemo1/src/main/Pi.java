/**
 * 
 */
package main;

import actors.Listener;
import actors.Master;
import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActorFactory;
import akka.util.Duration;

/**
 * @author ritsarka
 *
 */
public class Pi {
	
	  public static void main(String[] args) {
		    Pi pi = new Pi();
		    pi.calculate(4, 10000, 10000);
	  }
	  public void calculate(final int nrOfWorkers, final int nrOfElements, final int nrOfMessages) {
		    // Create an Akka system
		    ActorSystem system = ActorSystem.create("PiSystem");
		 
		    // create the result listener, which will print the result and shutdown the system
		    final ActorRef listener = system.actorOf(new Props(Listener.class), "listener");
		 
		    // create the master
		    
		    UntypedActorFactory factory = new UntypedActorFactory() {				
				@Override
				public Actor create() {
					return new Master(nrOfWorkers, nrOfMessages, nrOfElements, listener);
				}
			};
			ActorRef master = system.actorOf(new Props(factory ), "master");
		 
		    // start the calculation
		    master.tell(new Calculate());
		 
	 }  
	
    public static class Calculate {
    }
     
    public static class Work {
      private final int start;
      private final int nrOfElements;
     
      public Work(int start, int nrOfElements) {
        this.start = start;
        this.nrOfElements = nrOfElements;
      }
     
      public int getStart() {
        return start;
      }
     
      public int getNrOfElements() {
        return nrOfElements;
      }
    }
     
    public static class Result {
      private final double value;
     
      public Result(double value) {
        this.value = value;
      }
     
      public double getValue() {
        return value;
      }
    }
     
    public static class PiApproximation {
      private final double pi;
      private final Duration duration;
     
      public PiApproximation(double pi, Duration duration) {
        this.pi = pi;
        this.duration = duration;
      }
     
      public double getPi() {
        return pi;
      }
     
      public Duration getDuration() {
        return duration;
      }
    }

}

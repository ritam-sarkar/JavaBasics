/**
 * 
 */
package com.riversand.beahvioural.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author ritsarka
 *
 */
public class CustomObserver2 implements Observer {
	
	@Override
	public void update(Observable o, Object arg) {
		
		System.out.println(" observer2 called ");
		if(o instanceof CustomObservable) {
			System.out.println(((CustomObservable) o).getId());	
		}
	}

}

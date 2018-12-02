/**
 * 
 */
package com.design.beahvioural.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author ritsarka
 *
 */
public class CustomObserver1 implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(" observer1 called ");
		if(o instanceof CustomObservable) {
		System.out.println(((CustomObservable) o).getId());	
	}
	}

}

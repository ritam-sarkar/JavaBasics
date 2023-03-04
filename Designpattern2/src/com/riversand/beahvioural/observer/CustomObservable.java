/**
 * 
 */
package com.riversand.beahvioural.observer;

import java.util.Observable;

/**
 * @author ritsarka
 *
 */
public class CustomObservable extends Observable{

	private int id =0;
	public CustomObservable(int id) {
		this.id = id;
	}
	public void method1() {
		this.id = 6;
		System.out.println(" call observer ");
		setChanged();
	}
	public void method2() {
		this.id = 7;
		System.out.println(" Do not call observer");
	}
	public int getId() {
		return this.id;
	}

}

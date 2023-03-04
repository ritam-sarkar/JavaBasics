package com.riversand.beahvioural.observer;

public class UtilObserverDemo {

	public static void main(String[] args) {

		CustomObservable customObservable = new CustomObservable(1);
		CustomObserver1 customObserver1 = new CustomObserver1();
		CustomObserver2 customObserver2 = new CustomObserver2();
		customObservable.addObserver(customObserver1);
		customObservable.addObserver(customObserver2);
		customObservable.method1();
		customObservable.method2();
	}

}

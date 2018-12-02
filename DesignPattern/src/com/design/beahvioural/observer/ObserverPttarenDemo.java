package com.design.beahvioural.observer;

import java.util.HashSet;
import java.util.Observer;
import java.util.Set;

/**
 * One to many
 * Decoupled
 * Event handling
 * publisher / subcriber
 * Example
 * {@link Observer}
 * 
 * @author ritsarka
 *
 */
public class ObserverPttarenDemo {

	public static void main(String[] args) {
		ConcreatObservable concreatObservable = new ConcreatObservable();
		ConcreatObserver1 observer1 = new ConcreatObserver1();
		ConcreatObserver2 observer2 = new ConcreatObserver2();
		concreatObservable.addObserver(observer1);
		concreatObservable.addObserver(observer2);
		concreatObservable.method1();
	}

}
abstract class MyObservable{

	private Set<MyObserver> observers = new HashSet<MyObserver>();
	public void notifyObservers() {
		if(!observers.isEmpty()) {
			for(MyObserver observer : observers) {
				observer.update(this);
			}
		}
	}
	public boolean addObserver(MyObserver observer) {
		return observers.add(observer);
	}
}
interface MyObserver{
	public void update(Object ob);
}
class ConcreatObservable extends MyObservable{
	public void method1() {
		System.out.println(" method1 called");
		notifyObservers();
	}
	public void method2() {
		System.out.println(" method2 called");
	}
	public void method3() {
		System.out.println(" method3 called");
	}
}
class ConcreatObserver1 implements MyObserver{

	@Override
	public void update(Object ob) {
		System.out.println(" first observer called");
		if(ob instanceof ConcreatObservable) {
			((ConcreatObservable) ob).method2();
		}
	}	
}
class ConcreatObserver2 implements MyObserver{

	@Override
	public void update(Object ob) {
		System.out.println(" second observer called");
		if(ob instanceof ConcreatObservable) {
			((ConcreatObservable) ob).method3();
		}
	}	
}

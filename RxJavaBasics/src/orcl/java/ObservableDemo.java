/**
 * 
 */
package orcl.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author ritsarka
 *
 */
public class ObservableDemo {
	
	public static void main(String args[]) {
		
		/**
		 * just() example
		 */
		List<String> list = Arrays.asList("A","B","C","D");
		Observable<String> observable = Observable.just("A","B","C","D");
		Consumer<String> onNext = (s)->System.out.println(s);
		Consumer<Throwable> onError = (e)->System.out.println(e.getMessage());
		Action onComplete = ()->System.out.println("Completed");		
		//observable.subscribe(onNext, onError, onComplete);
		
		/**
		 * Schedulars use
		 */
		Observer<String> observer = new Observer<String>() {

			@Override
			public void onSubscribe(Disposable d) {
				System.out.println(Thread.currentThread().getName());					
				
			}
			@Override
			public void onNext(String t) {
				System.out.println(t+" "+Thread.currentThread().getName());				
			}

			@Override
			public void onError(Throwable e) {

				System.out.println(e.getMessage());
			}

			@Override
			public void onComplete() {
				System.out.println("completed"+Thread.currentThread().getName());
				
			}
		}; 
		observable.subscribeOn(Schedulers.io()).subscribe(observer);
		
		/**
		 *  create and observer example 
		 */
		ObservableOnSubscribe<String> observableOnSubscribe = new ObservableOnSubscribe<String>() {

			@Override
			public void subscribe(ObservableEmitter<String> emitter) throws Exception {
				
				for(String s : list) {						
					emitter.onNext(s);									
			    }
				emitter.onComplete();
		    }
		};		
		Observable<String> observable2 = Observable.create(observableOnSubscribe);		
		//observable2.subscribe((s)->System.out.println(s));
		
	
		
		
	}		

}

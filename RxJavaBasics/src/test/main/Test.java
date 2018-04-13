/**
 * 
 */
package test.main;

import java.util.Arrays;
import java.util.List;

import org.reactivestreams.Subscription;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author ritsarka
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList("One", "Two", "Three", "Four", "Five");		
		Observable<String> observable = Observable.fromArray("One", "Two", "Three", "Four", "Five");
		Consumer<List<String>> onNext = (l)->{l.forEach((s)->{
			if(s.equalsIgnoreCase("Four")) 
				throw new RuntimeException("Four occurred");
			else
				System.out.println(s);
			});};
		Consumer<Throwable> onError = (e)->System.out.println(e.getMessage());	
		ObservableOnSubscribe<String> observableOnSubscribe = new ObservableOnSubscribe<String>() {

			@Override
			public void subscribe(ObservableEmitter<String> emitter) throws Exception {
				while(!emitter.isDisposed())
					list.stream().forEach(emitter::onNext);
			}
		};
		Observer<String> observer = new Observer<String>() {

			@Override
			public void onSubscribe(Disposable d) {
				while(!d.isDisposed()) {
					
				}
			}

			@Override
			public void onNext(String t) {
				if(t.equalsIgnoreCase("Four"))
					onComplete();
				System.out.println(t);
			}

			@Override
			public void onError(Throwable e) {
               System.out.println("error occured");				
			}

			@Override
			public void onComplete() {

				System.out.println("completed");
			}
		};
		//observable.subscribe(observer);
       Observable<List<String>> listObservable = Observable.just(list);   
       //listObservable.subscribe(onNext, onError);
       
	}

}

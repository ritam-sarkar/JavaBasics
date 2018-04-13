package orcl.java;

import java.util.Arrays;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class FlowableDemo {

	public static void main(String[] args) {		

		List<Integer> listInt = Arrays.asList(1,2,3,4);	
		FlowableOnSubscribe<Integer> flowableOnSubscribe = new FlowableOnSubscribe<Integer>() {

			@Override
			public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
				listInt.stream().forEach((i)->{
					if(i == null)
						throw new NullPointerException("Null value found");
					emitter.onNext(i.intValue());
				});
				emitter.onComplete();
			}
		};
		Flowable<List<Integer>> flowable = Flowable.just(listInt);
		Consumer<List<Integer>> onNext = (l)->{
			l.stream().forEach((i)->{
				if(i==null)
					throw new NullPointerException("null value found");
				System.out.println(i.intValue());	
			});			
		};
		Consumer<Throwable> onError = (e)->System.out.println(e.getMessage());
		Action onComplete = ()->System.out.println("completed");
		//flowable.subscribe(onNext, onError,onComplete);
		Flowable<Integer> flowable2 = Flowable.create(flowableOnSubscribe, BackpressureStrategy.BUFFER);
		flowable2.subscribe();
	}

}

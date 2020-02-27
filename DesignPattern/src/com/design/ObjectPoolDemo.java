/**
 * 
 */
package com.design;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 * @author Ritam
 *
 */
public class ObjectPoolDemo {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		ConnectionPool connectionPool = new ConnectionPool();
		Random random = new Random();
		System.out.println(" Initial stage "+connectionPool.getAvailableObject()+" "+connectionPool.getInUseObject());
		MyConnection con1 = connectionPool.checkOut();
		MyConnection con2 = connectionPool.checkOut();
		System.out.println("Con1 is live "+con1.isLive()+" "+connectionPool.getAvailableObject()+" "+connectionPool.getInUseObject());
		MyConnection con3 = connectionPool.checkOut();
		System.out.println("Con1 is live "+con3.isLive()+" "+connectionPool.getAvailableObject()+" "+connectionPool.getInUseObject());
		//MyConnection con4 = connectionPool.checkOut();
		connectionPool.checkIn(con3);
		connectionPool.checkIn(con2);
		System.out.println(" After one connection checked in  "+connectionPool.getAvailableObject()+" "+connectionPool.getInUseObject());
		
		// Cannot checkin a new object from outside, only on-demand can be created from the connection pool
		connectionPool.checkIn(new MyConnection(random.nextInt()));
		System.out.println(" After creating random checked in  "+connectionPool.getAvailableObject()+" "+connectionPool.getInUseObject());
		
		
	}
	
	abstract static class ObjectPool<T> {
		List<T> inUse, available;
		static final int CORE_POOL_SIZE = 2;
		static final int MAX_POOL_SIZE = 3;
		

		ObjectPool() {
			inUse = new CopyOnWriteArrayList<T>();
			available = new CopyOnWriteArrayList<T>();
			for(int i =0; i< CORE_POOL_SIZE ; i++) {
				available.add(create());
			}			
		}

		abstract T create();
		abstract void makeAvailable(T ob);
		abstract void makeInUse(T ob);

		void checkIn(T ob) throws Exception {
			if(available.size() >= MAX_POOL_SIZE) {
				throw new Exception(" No space");
			}
			if(inUse.remove(ob)) {
				makeAvailable(ob);			
				available.add(ob);
			}            			
		}

		T checkOut() throws Exception {
			T ob = null;
			if(available.size() >0) {
				ob = available.get(0);	
				available.remove(ob);
			}else {
				ob = create();				
			}
			makeInUse(ob);
			if(inUse.size() >= MAX_POOL_SIZE) {
				throw new Exception("No space");
			}else {
				inUse.add(ob);
			}
			return ob;
		}
		
		int getInUseObject() {
			return inUse.size();
		}
		int getAvailableObject() {
			return available.size();
		}

	}
	static class ConnectionPool extends ObjectPool<MyConnection>{

		@Override
		MyConnection create() {
			Random random = new Random();			
			return new MyConnection(random.nextInt());
		}

		@Override
		void makeAvailable(MyConnection ob) {
			ob.close();
		}

		@Override
		void makeInUse(MyConnection ob) {
			ob.open();
		}		
	}
	static class MyConnection {
		AtomicBoolean live = null;
		int id;
		MyConnection(int id){
			this.id = id;
			this.live = new AtomicBoolean(false);
		}
		void close(){
			live.compareAndSet(true, false);
		}			
		boolean isLive(){
			return live.get();
		}
		void open(){
			live.compareAndSet(false, true);
		}
		void doSomeThing(){
			System.out.println(this.id+" is called from "+Thread.currentThread().getName());
		}
	}

}

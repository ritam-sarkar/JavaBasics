/**
 * 
 */
package com.riversand.creational.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Ritam
 *
 */
public class Singleton {


	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		/* Bill pugh singleton */
		BillPughSingleton ins = BillPughSingleton.getInstance();
		BillPughSingleton ins2 = BillPughSingleton.getInstance();
		System.out.println("Billpugh "+(ins == ins2));
        multiThreadInitialization();


		/*Serialization demo*/
		
		SerializationSingleTon serializSingleton = SerializationSingleTon.getInstance();
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("filename.ser"));
		os.writeObject(serializSingleton);
		ObjectInputStream oi = new ObjectInputStream(new FileInputStream("filename.ser"));
		SerializationSingleTon deserializeSingleton = (SerializationSingleTon) oi.readObject();
		System.out.println(deserializeSingleton.getInstance().hashCode());
		System.out.println(serializSingleton.hashCode());
		oi.close();
		os.close();
		/* enum */
		EnumSingleton.INSTANCE.display();


		
	}

	private static void multiThreadInitialization() {
		Thread t1 = new Thread(()->{
			BillPughSingleton ins = BillPughSingleton.getInstance();
			System.out.println("Thread1 "+ins.hashCode());
		});
		Thread t2 = new Thread(()->{
			BillPughSingleton ins = BillPughSingleton.getInstance();
			System.out.println("Thread2 "+ins.hashCode());
		});
		t1.start();
		t2.start();
	}


}



/**
 * Its by default singleton
 */
enum EnumSingleton {
	INSTANCE;
	
	public void display(){
		System.out.println("Inside enum singleton");
	}
}

/**
 * Its not thread safe
 */
class SimpleSingleton {
	private static SimpleSingleton instance;

	private SimpleSingleton() {} // Private constructor

	public static SimpleSingleton getInstance() {
		if (instance == null) {
			instance = new SimpleSingleton();
		}
		return instance;
	}
}

/**
 * This is thread safe but performance will reduce because of synchronize block
 */
class ThreadSafeSingleton {
	private ThreadSafeSingleton(){}
	private static ThreadSafeSingleton instance = new ThreadSafeSingleton();
	public ThreadSafeSingleton getInstanceByDoubleLocking(){
		if (instance == null) {
			synchronized (ThreadSafeSingleton.class) {
				if (instance == null) {
					instance = new ThreadSafeSingleton();
				}
			}
		}
		return instance;
	}
}

/**
 * Bill pugh is lazy loaded , and also thread safe
 * final prevents reassignment and  ensures visibility of the object state accross threads
 * new initialization is itself thread safe , now until Holder.Instance is called Holder class is not initialized and the INSTANCE is also final only once initialized
 * inside getInstance we have not written any lines of extra code , so it makes mutable shared state
 * Analogy : Imagine getInstance() as a door. The first thread opens it and triggers the loading of Holder.INSTANCE. Every other thread just walks through the already-opened door.
 */
class BillPughSingleton {
	private BillPughSingleton() {}

	//Lazy initialization using static nested class
	private static class Holder {
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	}

	public static BillPughSingleton getInstance() {
		return Holder.INSTANCE;
	}
}

/**
 * When you serialize and then deserialize a singleton, Java creates a new instance, which breaks the singleton guarantee.
 */
class SerializationSingleTon implements Serializable {
	private static final long serialVersionUID = 1L;

	private SerializationSingleTon() {
	}

	private static class Holder {
		private static final SerializationSingleTon INSTANCE = new SerializationSingleTon();
	}

	public static SerializationSingleTon getInstance() {
		return Holder.INSTANCE;
	}

	// Preserve singleton during deserialization
	protected Object readsResolve() {
		return getInstance();
	}
}


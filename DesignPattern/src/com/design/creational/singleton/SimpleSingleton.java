/**
 * 
 */
package com.design.creational.singleton;

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
public class SimpleSingleton {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		BillPoughSingleton ins = BillPoughSingleton.getInstance();
		ins.display();
		
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
		
		/* Reflection
		 * 
		 *  In place of LazySingleton if we use EnumSingleton there will be a Illegal argument exception, cannot create enum object through reflection
		 *  
		 *  */
		
		Constructor[] constructors = LazySingleton.class.getDeclaredConstructors();
		constructors[0].setAccessible(true);
		LazySingleton reflectSingleton1 = (LazySingleton)constructors[0].newInstance();
		LazySingleton reflectSingleton2 = (LazySingleton) constructors[0].newInstance();
		System.out.println("after reflection firstobject == second object "+(reflectSingleton1 == reflectSingleton2));
		System.out.println("first object hashcode "+reflectSingleton1.hashCode()+" second object hashcode "+reflectSingleton2.hashCode());
			
		
		/* enum */
		EnumSingleton.INSTANCE.display();
		
		/*static */
		StaticInitialization staticSingleton = StaticInitialization.getInstance();
		staticSingleton.display();
		
		
		
	}
	

}

class SerializationSingleTon implements Serializable{
	
	private SerializationSingleTon(){}
	public static class SerilizationHelper{
		private static final SerializationSingleTon instance = new SerializationSingleTon();		
	}
	public static SerializationSingleTon getInstance(){
		return SerilizationHelper.instance;
	}
	protected Object readsResolve(){
		return getInstance();
	}
}
class BillPoughSingleton {
	private static class SingletonHelper{
		private static BillPoughSingleton INSTANCE = new BillPoughSingleton();
	}
	private BillPoughSingleton(){}
	public static BillPoughSingleton getInstance(){
		return SingletonHelper.INSTANCE;
	}
	public void display(){
		System.out.println("this is Bill pough implementation");
	}
}
enum EnumSingleton {
	INSTANCE;
	
	public void display(){
		System.out.println("Inside enum singleton");
	}
}

class EagerInitialization{
 private EagerInitialization(){}
 private static EagerInitialization instance = new EagerInitialization();
 public EagerInitialization getInstance(){
	 return instance;
 }
 
}


class LazySingleton{
	private LazySingleton(){
		throw new IllegalStateException();		
	}
	private static volatile LazySingleton instance = null;
	public LazySingleton getInstance(){
		if(instance == null){
			instance = new LazySingleton();
		}
		return instance;
	}
}

class StaticInitialization{
	private StaticInitialization(){}
	static StaticInitialization instance = null;
	static{		
		instance = new StaticInitialization();
		
	}
	public static StaticInitialization getInstance(){
		return instance;
	}
	public void display(){
		System.out.println("Inside static sngleton");
	}
	
}


class ThreadSafeSingleton {
	private ThreadSafeSingleton(){}
	private static ThreadSafeSingleton instance = new ThreadSafeSingleton();
	public ThreadSafeSingleton getInstanceByDoubleLocking(){
		if(instance == null){
			synchronized(ThreadSafeSingleton.class){
				instance = new ThreadSafeSingleton();				
			}
		}
		return instance;
		
	}
	
}
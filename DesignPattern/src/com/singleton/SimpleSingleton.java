/**
 * 
 */
package com.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

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
	 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
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
	/*protected Object readsResolve(){
		return getInstance();
	}*/
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
	private LazySingleton(){}
	private static LazySingleton instance = null;
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
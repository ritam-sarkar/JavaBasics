/**
 * 
 */
package com.riversand.generics.typecast;

/**
 * @author Ritam
 *
 */
public class GenTypeCastDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Gen<Integer> iOb = new Gen<Integer>(2);
		Gen2<Integer> iOb2 = new Gen2<Integer>(5);
		Gen<String> strOb = new Gen<String>("parent");
		Gen2<String> strOb2 = new Gen2<String>("parent");

		//true;
		if(iOb2 instanceof Gen<?>){
			System.out.println("iob2 is instance of Gen");
		}
		//false
		if(iOb instanceof Gen2<?>){
			System.out.println("iob is instance of Gen2");
		}
		//true
		if(strOb2 instanceof Gen<?>){
			System.out.println("strOb2 is instance of Gen");
		}
		//cannot use generic type in compile time
		/*if(strOb2 instanceof Gen<Integer>){
			System.out.println("strOb2 is instance of Gen");
		}*/
		
		//Type casting
		
		//iOb2 = (Gen2<Integer>)iOb;//Runtime  error ClassCastException
		//System.out.println(iOb.getOb());
		
	}   
}

class Gen<T>{
	private T ob;
	//cannot use static of  anon static type T
	//private static T ob1;
	public Gen(T o){
		//cannot create object of T
		//T ob[] = new T[];
		ob = o;
	}
	public T getOb(){
		return ob;
	}
	public static void  test(){
		
	}
}

class Gen2<T> extends Gen<T>{

public Gen2(T o) {
	super(o);		
}	   
}


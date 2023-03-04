/**
 * 
 */
package com.riversand.enumdemo.enums;

/**
 * @author Ritam
 *
 */
public enum Level{
	BEGINEER("begineer"),INTERMEDIATE("intermediate"),PRO("pro"), PROFICIENT("proficient",2);
	
	static{
		System.out.println("static init block");
	}
	 String value;
	Level(){
		System.out.println("constructor");
	}
	Level(String s){
		this.value = s;
	}
	Level(String s, int ordinal){
		this.value = s;
	}
	String value(){
		return this.value;
	}
	// This method is called implicitly , cannot override this method
	/*@Override
	public static Level valueOf(String value){
		
	}*/
	
	/*@Override
	public String toString(){
		return this.value();
	}*/
	public static void main(String[] args){
		//System.out.println(Level.BEGINEER.value);
		System.out.println("-------------------------------------");
		// enum is by default singleton so constructor and static blocks will be called only one time
		//System.out.println(Level.PROFICIENT.value);
		System.out.println(Level.PROFICIENT);
	}
	

}

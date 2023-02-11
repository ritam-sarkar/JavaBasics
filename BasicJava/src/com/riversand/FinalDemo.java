/**
 * 
 */
package com.riversand;

/**
 * @author Ritam
 *
 */
public class FinalDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyClass myClass = new MyClass();
	}

}
class MyClass {
	final int finalvar;
    public 	MyClass(int a,int b){
    	if(a>b){
    		finalvar = 10;
    	}
    	else{
    		finalvar = 11;
    	}    	
    }
    public MyClass(){
    	if(2>1){
    		finalvar =10;
    	}else if(2>3){
    		finalvar = 11;
    	}
    }
    
}


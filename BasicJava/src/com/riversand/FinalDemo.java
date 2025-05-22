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
		System.out.println(myClass.finalvar);
		System.out.println(myClass.x);
	}

}
//If we remove else part it will throw compiler error , as all conditions are not satisfied to initialize final variable
class MyClass {

	//Rule : final variable has to be initialized whether its used or not used
	final int finalvar;
	// Rule : for static final also the rule is same , but we cannot initialize them inside constructor , has to be inside static block
	//static final int y;
	//Rule : instance variable needs not to be initialized even if used or not used
	int x;
    public 	MyClass(int a,int b){
    	if(a>b){
    		finalvar = 10;
    	}
    	else if(b == a){
    		finalvar = 11;
    	}  else {
			finalvar = 13;
		}
    }
    public MyClass(){
    	if(2>1){
    		finalvar =10;
    	}else if(2>3){
    		finalvar = 11;
    	}
    }

	void f1(){
		final int a;
		int b;
		/**
		 * Rule : Local variable has to be initialized if used
		 */
		/*System.out.println(a);
		System.out.println(b);*/


	}
    
}


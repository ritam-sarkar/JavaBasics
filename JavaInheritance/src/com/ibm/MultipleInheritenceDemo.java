/**
 * 
 */
package com.ibm;

/**
 * @author Ritam
 *
 */
public class MultipleInheritenceDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      MyClass myClass = new MyClass();
      myClass.method();
      myClass.m();
      //CE
      //BaseInt1.super.method();
      BaseInt1.statMethod();
	}

}
interface Interface1{
	 int MIN = 10;
	 void print(int a);
	 default void message(){
		 System.out.println("Intface1 default method");
	 }
	 
	
}
interface Interface2{
	 String MAX = "MAX";
	 int MIN = 11;
	  int print();	
	  default void message(){
			 System.out.println("Intface1 default method");
		}
}
class A implements Interface1,Interface2{

	/*@Override
	public void print() {
		// TODO Auto-generated method stub
	}*/
	{
		System.out.println(Interface2.MIN);
		System.out.println(MAX);
	}

	@Override
	public int print() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void print(int a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void message() {
		// TODO Auto-generated method stub
		Interface1.super.message();
	}
	
	
}

interface BaseInt1{
	int a=10;
	 default void method(){System.out.println("method of BaseInt1");}
	 static void statMethod(){System.out.println("baseint 1 static method");};
	default void method2(){
		
	}
	default void method3(){
		
	}
}
interface BaseInt2{
	 default void method(){System.out.println("method of BaseInt2"); }
}
interface MyInt extends BaseInt1,BaseInt2{

	@Override	
    default void method(){
		System.out.println("method of MyInt"); 
        BaseInt2.super.method();
    }
	@Override
	default void method3(){
		MyInt.this.method();
	}
	
}
class MyClass implements BaseInt1,BaseInt2{

	@Override
	public void method() {
		// TODO Auto-generated method stub
		System.out.println("Child default method");
		//BaseInt1.super.method();
		
	}
	public void m(){
		//BaseInt2.super.method();
		//method2();
	}
	
}

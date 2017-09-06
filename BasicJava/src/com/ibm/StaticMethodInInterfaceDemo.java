/**
 * 
 */
package com.ibm;

/**
 * @author Ritam
 *
 */
public class StaticMethodInInterfaceDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OldInterface oldInterface = new OldInterfaceImpl();
		oldInterface.newDefaultMethod(4);
		ABstractClass abstractClass = new AbstractClassImpl();
		System.out.println(abstractClass.m());
		
	}

}
interface OldInterface{
	public void existingMethod1();
	default public void newDefaultMethod(int i) {
        System.out.println("New default method is added in interface "+i);
    }
	
}
class OldInterfaceImpl implements OldInterface{

	@Override
	public void existingMethod1() {
		
	}
	
}
abstract class ABstractClass{
	abstract  int m();
}
class AbstractClassImpl extends ABstractClass{

	@Override
	protected int m() {
		return 0;
	}
	
}
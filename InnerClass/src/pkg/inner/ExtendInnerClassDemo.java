package pkg.inner;

/**
 * 1. Another outer class can access a nested static class.
 * 2. Another class cannot extend a Inner class for that we need to write a default constructor like
 * public ExtendInnerClassDemo() {
		new MyOuter().super();
	}
 * 3. If  ExtendInnerClassDemo extends  MyOuter then any inner or nested class of 	ExtendInnerClassDemo can extend
 *  Inner or nested class for MyOuter, otherwise not possible
 *  Reason is any class in its constructor tries to call super(), but cannot call that as no instance of MyOuter is available
 * @author ritsarka
 *
 */
public class ExtendInnerClassDemo extends MyOuter.MyInnerClass{
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
	}
	public ExtendInnerClassDemo() {
		new MyOuter().super();
	}
}

class MyOuter{
	
	private int x =10;
	private static int y =100;
	public int getX() {
		MyInnerClass inner = new MyInnerClass();
		return inner.getX();
	}
	class MyInnerClass {
		
		public int getX() {
			return x;
		}
	}
	class MyInnerClass2{
		
	}
    static class MyNestedClass  {
    	public int getY() {
			return y;
		}
	}
}

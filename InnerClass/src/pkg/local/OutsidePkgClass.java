/**
 * 
 */
package pkg.local;

import pkg.inner.Outer;
import pkg.inner.Outer.Inner;

/**
 * @author Ritam
 *
 */
public class OutsidePkgClass {

	Inner inner;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Outer outer = new Outer();
		Inner inner = outer.getInner();
		inner.display();

	}
	public OutsidePkgClass(){
		Outer outer = new Outer();
		inner = outer.new Inner();
	}

}

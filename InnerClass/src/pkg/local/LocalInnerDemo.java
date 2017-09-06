/**
 * 
 */
package pkg.local;

/**
 * @author Ritam
 *
 */
public class LocalInnerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalOuter outer = new LocalOuter();
		outer.m();
	}

}
class LocalOuter{
	int x=9;
	public void m(){
		int y=2;
		System.out.println("Inside method m()");
		class LocalInner{
			int x =0;
			void dispaly(){
				int z =8;
				System.out.println("x ="+x+" y = "+y+" z= "+z);
			}
		}
		LocalInner inner = new LocalInner();
		inner.dispaly();
	}
	
}

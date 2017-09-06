/**
 * 
 */
package pkg.anonymous;

/**
 * @author Ritam
 *
 */
public class AnonymousDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Ano{	
	Object test2(){
		int a =10;
		final int finalInt =9;
		return new Ano(){
			public String toString(){
				System.out.println(a);
				return "anonymous";
			}
		};
	}
	void test1(){
		int a =10;
		final int finalInt =9;		
		Animal animal = new Animal(){
			@Override
			public void run() {
				System.out.println(a);
				System.out.println(finalInt);
			}		
		};
		
	}
	
}
interface Animal {
	void run();
}
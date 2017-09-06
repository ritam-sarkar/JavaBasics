/**
 * 
 */
package pkg.staticmember;

/**
 * @author Ritam
 *
 */
public class NestedClassDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Nested nested = new Nested();
		Nested.Inner inner = new Nested.Inner();
		inner.dispaly();
		Nested.MemberInner memInner = nested.new MemberInner();
		AnonymousInner anInner = new AnonymousInner()/*{
			public void method(){
				System.out.println(" inside anonymous");
			}
		}*/;
		
		anInner.method();
		System.out.println(anInner.getClass().getSuperclass().getName());
		
	    
	}

}

class Nested{
	static int z =80;
	public static void outerm(){
		System.out.println("this is outer ,method");
	}
	static class Inner{
		int x =0;
		void dispaly(){	
			outerm();
			System.out.println("x ="+x+" z= "+z);
		}
	}
	public Inner getInner(){
		return new Inner();
	}
	class MemberInner{
		void display(){
			
			System.out.println("Insid member inner");
		}
	}
	
}
 class AnonymousInner{

	public void method() {
		System.out.println(" inside anonymous");
	}
}
/**
 * 
 */
package generics.inheritance.main;

/**
 * @author Ritam
 *
 */
public class TypeInterfaceDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
      Parent<String> p = new Parent(new StringBuilder());
      
		
	}

}
class Parent<T>{
	
	T t;
	public <X> Parent(X x){
		
	}
	public Parent() {
		super();
	}
	
}

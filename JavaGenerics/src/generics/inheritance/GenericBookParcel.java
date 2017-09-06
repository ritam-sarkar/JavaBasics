/**
 * 
 */
package generics.inheritance;

/**
 * @author Ritam
 *
 */
public class GenericBookParcel<X,T> extends Parcel<T> {

	public void test(){System.out.println("test");};
	
	T t;
	X x;
	
	public <E>GenericBookParcel(E e){
		System.out.println("constructor "+e);
	}
	public GenericBookParcel(){
		
	}
    
    public T getT() {
		return t;
	}


	public void setT(T t) {
		this.t = t;
	}


	public X getX() {
		return x;
	}


	public void setX(X x) {
		this.x = x;
	}


	public <X,V> void genericMethod1(T t,V v){
    	System.out.println("generic method"+v);
    	System.out.println("generic method"+t);
    	System.out.println("generic method"+x);
    }
	

}

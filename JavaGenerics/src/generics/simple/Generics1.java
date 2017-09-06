/**
 * 
 */
package generics.simple;

/**
 * @author Ritam
 *
 */
public class Generics1 <T>{

	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public Generics1(T obj) {
		this.obj = obj;
	}
	public Generics1(){
		super();
	}
	
	public void showType(){
		System.out.println("type is "+this.obj.getClass().getName());
	}
}

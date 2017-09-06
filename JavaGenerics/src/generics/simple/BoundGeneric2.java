/**
 * 
 */
package generics.simple;

/**
 * @author Ritam
 *
 */
//first class then interface
public class BoundGeneric2 <T extends MyClass & MyInterface >{

	private T obj;

	public BoundGeneric2(T obj) {
		super();
		this.obj = obj;
	}
	public T getObj(){
		return obj;
	}
	public void display(int val){
		
		if(obj.isGreater(val)){
			System.out.println(val+" is greater than "+obj.MAX_VAL);
		}
		if(obj.isLesser(val)){
			System.out.println(val+" is lesser than "+obj.MAX_VAL);

		}
	}
	
}

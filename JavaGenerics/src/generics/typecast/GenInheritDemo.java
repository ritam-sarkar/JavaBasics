/**
 * 
 */
package generics.typecast;



/**
 * @author Ritam
 *
 */
public class GenInheritDemo {
	
	public static void main(String arags[]){
		GenChild<Integer,String> childOb = new GenChild<Integer,String>(2,"child");
		GenParent<Double> parentOb = new GenParent<Double>(5.0);
		System.out.println("child >> "+childOb.getOb()+" "+childOb.getOb2());
		System.out.println("child >> "+parentOb.getOb());
		NonGenChild nonGenOb = new NonGenChild(3,"non gen");
		System.out.println("getob called from non gen child class "+nonGenOb.getOb());
		GenChild2<String> genChild2 = new GenChild2("xyz",2);
		System.out.println(" gen child class extends non gen parent class  "+genChild2.getOb());

	}

}

class GenParent<T>{
	
	private T ob;
	public GenParent(T ob){
		this.ob = ob;
	}
	public T getOb(){
		return ob;
	}
	
}
class NonGenParent{
	private int i;
	public NonGenParent(int i ){
		this.i = i;
	}
	public int getI(){
		return i;
	}
}
class GenChild<T,V> extends GenParent<T>{
	private V ob2;
	public GenChild(T ob1,V ob2){
		super(ob1);
		this.ob2 = ob2;		
	}
	
	public V getOb2() {
		return ob2;
	}	
	
}
class NonGenChild extends GenParent<Integer>{

	private String st;
	public NonGenChild(Integer ob,String st) {
		super(ob);
		this.st = st;
	}	
}
class GenChild2<T> extends NonGenParent{

	private T ob;
	public GenChild2(T ob,int i) {
		super(i);
		this.ob = ob;
		// TODO Auto-generated constructor stub
	}
	public T getOb(){
		return this.ob;
	}
	
}

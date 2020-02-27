/**
 * 
 */
package enums;

/**
 * @author Ritam
 *
 */
public enum Level{
	BEGINEER("begineer"),INTERMEDIATE("intermediate"),PRO("pro");
	
	static{
		System.out.println("static init block");
	}
	 String value;
	Level(){
		System.out.println("constructor");
	}
	Level(String s){
		this.value = s;
	}
	String value(){
		return this.value;
	}
	// This method is called implicitly , cannot overroide this method
	/*@Override
	public static Level valueOf(String value){
		
	}*/
	
	@Override
	public String toString(){
		return this.value();
	}
	public static void main(String[] args){
		System.out.println(Level.BEGINEER.value);
	}
	

}

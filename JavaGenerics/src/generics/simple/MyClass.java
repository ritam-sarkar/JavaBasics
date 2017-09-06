/**
 * 
 */
package generics.simple;

/**
 * @author Ritam
 *
 */
public class MyClass implements MyInterface{

	@Override
	public boolean isLesser(int num) {
		if(num < MAX_VAL){
			return true;
		}
		return false;
	}

	public boolean isGreater(int num){
		if(num > MAX_VAL){
			return true;
		}else{
			return false;
		}
	}
	
}

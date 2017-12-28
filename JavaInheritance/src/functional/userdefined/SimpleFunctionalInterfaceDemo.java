/**
 * 
 */
package functional.userdefined;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author Ritam
 *
 */
public class SimpleFunctionalInterfaceDemo {
	
	public static void main(String[] args){
		List<String> list = Arrays.asList("a","b","c");
		UserDefined1<List<String>> obj1 = (l)->{for(String s : l) System.out.println(s);};
		ColonClassTest colonClassTest = new ColonClassTest();
		UserDefined1<List<String>> obj2 = colonClassTest :: method;
		//obj1.apply(list);
		obj2.apply(list);
		Func2  f = colonClassTest ::method2;
		f.m();
	}

	
}
class ColonClassTest{
	public void method(List<String> list){
		for(String s : list){
			if(s.equalsIgnoreCase("a"))
				System.out.println("A");
		}
	}
	public void method2(){
		System.out.println("method2"); 
	}
}

interface Func2{
	public void m();
}
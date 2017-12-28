/**
 * 
 */
package functional.userdefined;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Ritam
 *
 */
public class FilterMapdemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = Arrays.asList("ab","bc","ca");
		Implement implement = new Implement();
	    Stream<String> streamAfterFilter =  list.stream().filter(implement :: test); // filter argument is Predicate type
		Set<String> set = streamAfterFilter.collect(Collectors.toSet());
		//List<Integer> hashcodeList = streamAfterFilter.map(String :: hashCode).collect(Collectors.toList()); // map argument is Function<T,R> type, T is target and R is return type
		System.out.println(set);
		//System.out.println(hashcodeList);
		int number = 23;
		System.out.println(IntStream.range(2, number).noneMatch(index -> number%index == 0));
		

	}
	
	static class Implement {
		
		public boolean test(String s){
			return s.contains("a");
		}
	}

}


/**
 * 
 */
package com.ibm.stream;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Ritam
 *
 */
public class MapperDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		Employee e1 = new Employee(1, 10000, "A");
		Employee e2 = new Employee(2, 20000, "B");
		Employee e3 = new Employee(3, 30000, "C");
		Employee e4 = new Employee(4, 40000, "D");
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		/** string mapper */
		Stream<String> stringStream = myList.stream().filter((x)->x.equals("c1"));
		//Stream<Employee> empStream = empList.stream().filter((e)->e.getId()==1);
		
		Stream<Employee> empStream = Stream.of(e1,e2,e3,e4);
		Function<String,Integer> mapperString = String :: hashCode;
		int hashCode = stringStream.map(mapperString).findAny().orElse(0);
		//String value = stringStream.map(String :: toUpperCase).findAny().orElse("");
		Function<Employee,String> mapperEmp = Employee :: getName;
		String name = empStream.map(mapperEmp).findAny().orElse("default");
		//String name2 = empStream.map(Employee :: getName).findAny().orElse("default");
		
		/**
		 * Stream generate
		 */
		Stream<String> stream = Stream.generate(() -> "test").limit(10);
		String[] strArr = stream.toArray(String[]::new);
		System.out.println(Arrays.toString(strArr));
		
		/**
		 * Stream, iterate
		 */
		Stream<BigInteger> bigIntStream = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE)).limit(10);
		BigInteger[] bigIntArr = bigIntStream.toArray(BigInteger[]::new);
		System.out.println(Arrays.toString(bigIntArr));
	}
	
    static class Employee{
    	int id;
    	long salary;
    	String name;
		public Employee(int id, long salary, String name) {
			super();
			this.id = id;
			this.salary = salary;
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public long getSalary() {
			return salary;
		}
		public void setSalary(long salary) {
			this.salary = salary;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
    	
    }
}

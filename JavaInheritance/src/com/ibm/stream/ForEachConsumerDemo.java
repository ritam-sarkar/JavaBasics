/**
 * 
 */
package com.ibm.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @author Ritam
 *
 */
public class ForEachConsumerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		Map<Integer,String> map1 = new HashMap<Integer,String>();
		map1.put(2,"Two");
		map1.put(1, "One");
		Map<String,Integer> map2 = new HashMap<String,Integer>();
		map2.put("Two", 2);
		map2.put("One", 1);
		
		Employee e1 = new Employee(1, 10000, "A");
		Employee e2 = new Employee(2, 20000, "Abc");
		Employee e3 = new Employee(3, 30000, "Cba");
		Employee e4 = new Employee(4, 40000, "Dac");
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		Stream<Employee> streamEmpA = empList.stream().filter((e)->e.getName().startsWith("A"));
		Stream<String> streamString = myList.stream().filter((x)->x.endsWith("1"));
		Consumer<String> stringConsumer = (x)->System.out.println(x);
		Consumer<String> stringConsumer2 = System.out :: println;
		Consumer<Employee> empConsumer = (emp)->System.out.println(emp.getId());
		Consumer<Employee> empConsumer2 = Employee :: printName;
		streamString.forEach(stringConsumer);
		streamEmpA.forEach(empConsumer2); // forEach is a terminating method
		// sort by keys
		Map<Integer,String> sortedMapWithKey = map1.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(
				Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println(sortedMapWithKey);
		// sort by value
		 Map<String, Integer> sortedmapWithVal = map2.entrySet().stream()
	                .sorted(Map.Entry.comparingByValue())
	                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
	                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println(sortedmapWithVal);
	}	

}
 class Employee{
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
	public void printName(){
		System.out.println(name);
	}
	public void printNameWithArgument(Employee e) {
		System.out.println(e.name);
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

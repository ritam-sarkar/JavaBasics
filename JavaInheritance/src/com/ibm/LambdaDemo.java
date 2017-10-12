/**
 * 
 */
package com.ibm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ritam
 *
 */
public class LambdaDemo {

	public static void main(String [] args){
		
		Emp e1 = new Emp("ritam", 100000, 5);
		Emp e2 = new Emp("sharmistha", 200000, 5);
		Emp e3 = new Emp("X", 30000, 3);
		Emp e4 = new Emp("X", 5000, 4);
		List<Emp> empList = new ArrayList<Emp>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);		
		new LambdaDemo().filter((Emp e,int rating)->e.getRating()>rating,empList);		
		for(Emp e : empList){
			Validate validate3 = (emp,rating)->{return (emp.getRating()>=rating);};  // curly braces is optional
			if(validate3.check(e,3)){
				System.out.println(e.getName());
			}
		}
		
		Predicate<Emp> p = (e)->{System.out.println("name"+e.getName()); System.out.println("salary "+e.getSalary());};
		p.Test(e1);
		//empList.removeIf((e)->e.getName().startsWith("s"));
		List<Emp> result = empList.stream().filter(e-> e.getRating()>4).collect(Collectors.toList());
		result.forEach((n)->{System.out.println(n.getSalary());});
		result.forEach(System.out::println);
		long salary = empList.stream()
				.filter(x -> "ritam".equals(x.getName()))
				.map(Emp::getSalary)						//convert stream to long
				.findAny()
				.orElse(0l);
		System.out.println("after map name is "+salary);
		testCollection(empList);
	}
	private void  filter(Validate validate,List<Emp> eList){
		for(Emp e : eList){
			if(validate.check(e,3)){
				System.out.println(e.getName());
			}
		}
		
	}
	private static void testCollection(List<Emp> empList){
		System.out.println(" testing collection ");
		/** using filter**/
		List<String> empNameList = empList.stream().filter(e->e.getName().equalsIgnoreCase("X")).map(e -> e.getName()).collect(Collectors.toList());
		/** without using filter **/
		//List<String> empNameList = empList.stream().map(e -> e.getName()).collect(Collectors.toList());
		for(String name : empNameList){
			System.out.println(name);
		}
	}

	
}
class Emp{
	private String name;
	private long salary;
	private int rating;
	public Emp(String name, long salary, int rating) {
		super();
		this.name = name;
		this.salary = salary;
		this.rating = rating;
	}
	public String getName() {
		return name;
	}
	public long getSalary() {
		return salary;
	}
	public int getRating() {
		return rating;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}

@FunctionalInterface
interface Validate{
	boolean check(Emp e,int chekingParam);
	
}

@FunctionalInterface
interface Predicate<T>{
	public void Test(T obj);
}

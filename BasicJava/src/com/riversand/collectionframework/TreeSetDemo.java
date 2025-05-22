/**
 * 
 */
package com.riversand.collectionframework;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Ritam
 *
 */
public class TreeSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
       /*Set<Student> ts = new TreeSet<Student>();*/
		Set<Student> ts = new TreeSet<>(new StudentIdComparator());
       ts.add(new Student(1, "ritam"));
       ts.add(new Student(1,"sharmistha"));
       
       for(Student s : ts){
    	   System.out.println(s.getName());
       }
       
       Map<Student,String> treeMap = new TreeMap<Student,String>(new StudentIdComparator());
       treeMap.put(new Student(1, "ritam"), "ritam");
       treeMap.put(new Student(1, "Sharmistha"), "ritam");
       System.out.println(treeMap.keySet());
       
       
		
	}

}
class Student /*implements Comparable*/{
	int id;
	String name;
	
	public Student() {
		super();
	}
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
class StudentIdComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getId()-o2.getId();
		
	}
	
}

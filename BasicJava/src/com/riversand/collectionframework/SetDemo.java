/**
 * 
 */
package com.riversand.collectionframework;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Ritam
 *
 */
public class SetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*		Set<String> linkSet = new LinkedHashSet<String>();
		Set<String> hashSet = new HashSet<String>();
		Set<String> treeSet = new TreeSet<String>();
		linkSet.add("l3");
		linkSet.add("l1");
		linkSet.add("l2");

		hashSet.add("h1");
		hashSet.add("h2");
		hashSet.add("h3");

		treeSet.add(null);
		treeSet.add("t2");
		treeSet.add("t1");
		treeSet.add("t3");
		linkSet.add(null);
		hashSet.add(null);

		for (String s : linkSet) {
			System.out.println(s);
			
		}*/
		Student s1 = new Student(1, "A");
		Student s2 = new Student(2, "B");
		Student s3 = new Student(2, "C");
		Set<Student> studentSet = new HashSet();
		studentSet.add(s1);
		studentSet.add(s2);
		studentSet.add(s3);
		for(Student student : studentSet) {
			System.out.println("id "+student.getId()+" name "+student.getName());
		}
		
		

	}
	
	static final class Student {
		private final int id;
		private final String name;
		public Student(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		public int hashCode() {
			return this.id;
		}
		public boolean equals(Object ob) {
			if(ob == null)
				return false;
			if(ob instanceof Student) {
				Student s = (Student)ob;
				return this.id == s.id;
			}
			return false;
		}
	}

}


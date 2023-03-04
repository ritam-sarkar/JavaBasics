package com.riversand.collectionframework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 */

/**
 * @author Ritam
 *
 */
/**
 * 
 *  
 *
 */
public class HashMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("a", 1);
		map.put("a", 2);
		map.put(null, 3);
		map.put(null, 4);
		System.out.println(map.get("a"));
		Map<Employee,String> empMap = new HashMap<Employee,String>();
		Set<Employee> empSet = new HashSet<Employee>();
		
	    Employee emp1 = new Employee(1,"Emp1");
	    Employee emp2 = new Employee(2, "Emp2");
	    Employee emp3 = new Employee(2, "Emp3");	    
	    empMap.put(emp1, "employee 1");
	    empMap.put(emp2, "employee 2");
	    empMap.put(emp3, "employee 3");	    
        empSet.add(emp1); empSet.add(emp2); empSet.add(emp3);
	    for(Map.Entry<Employee, String> entry : empMap.entrySet()){
	    	System.out.println(entry.getKey().getName());
	    }	
	    for(Employee e : empSet) {
	    	System.out.println(e.getName());
	    }

	}

}
class Employee{
	private int id;
    private String name;
    
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int hashCode(){
		return this.getId();
	}
	@Override
	public boolean equals(Object o){
		if(o == null) {
			return false;
		}else {
			Employee e = (Employee)o;
			return this.id == e.getId();
		}
	}
}

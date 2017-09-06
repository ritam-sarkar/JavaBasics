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
public class HashMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("a", 1);
		map.put("a", 2);
		System.out.println(map.get("a"));
		Map<Employee,String> empMap = new HashMap<Employee,String>();
	    Employee emp1 = new Employee();
	    Employee emp2 = new Employee();
	    Employee emp3 = new Employee();
	    emp1.setId(1);
	    emp2.setId(2);
	    emp3.setId(3);
	    empMap.put(emp1, "employee 1");
	    empMap.put(emp2, "employee 2");
	    empMap.put(emp3, "employee 3");
	    Set<Integer> set = new HashSet<Integer>();
	    set.add(1);	
	    set.add(null);
        System.out.println("set size "+set.size());
	    for(Map.Entry<Employee, String> entry : empMap.entrySet()){
	    	System.out.println(entry.getKey().getId());
	    }		

	}

}
class Employee{
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int hashCode(){
		if(this.getId()>1){
			return 2;
		}else{
			return this.getId();
		}
	}
	@Override
	public boolean equals(Object o){
		Employee e = (Employee)o;
		if(this.id == e.getId()){
			return true;
		}else{
			return false;
		}
	}
}

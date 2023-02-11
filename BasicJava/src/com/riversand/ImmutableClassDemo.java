/**
 * 
 */
package com.riversand;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ritam
 *
 */
public class ImmutableClassDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String,String>();
		int x = 10;
		String s = "original";
		map.put("A", "a");
		AClass a = new AClass("main a class");
		Immute immute = new Immute(x, a, s, map);
		
		System.out.println("before modifying"+immute.getId()+" | "+immute.getS()+" | "+immute.getA().getX()+" "+immute.getMap().size());
		x = 20;
		s = "modified";
		a.setX(" modified a class");
		map.put("B", "b");
		System.out.println("after  modifying"+immute.getId()+" | "+immute.getS()+" | "+immute.getA().getX()+" "+immute.getMap().size());

	}

}

final class Immute{
	private  int id;
	private  AClass a;
	private String s;
	private  Map<String,String> map;
	
	//shallow copy
	/*public Immute(int id, AClass a, String s, Map<String, String> map) {
		super();
		this.id = id;
		this.a = a;
		this.s = s;
		this.map = map;
	}*/
	// deep copy
	public Immute(int id, AClass a, String s, Map<String, String> map) {
		super();
		this.id = id;
		this.a = new AClass(a.getX());
		this.s = s;
		this.map = new HashMap(map);
	}
	public int getId() {
		return id;
	}
	
	public AClass getA() {
		return a;
	}
	
	public String getS() {
		return s;
	}
	
	public Map<String, String> getMap() {
		return map;
	}
	
	
}

class AClass{
	private String x;

	
	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public AClass(String x) {
		super();
		this.x = x;
	}

	public AClass() {
		super();
	}
	
}
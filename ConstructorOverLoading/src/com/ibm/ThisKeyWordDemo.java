package com.ibm;

public class ThisKeyWordDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee e = new Employee();
		System.out.println(e.getAge()+e.getEmpid());

	}

}

class Employee extends Address{
	
	private int empid;
	private int age;
	
	Employee(){
		this(1,2);
		
	}
	Employee(int empId,int age){
		super(empId);
		this.empid = empId;
		this.age = age;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}

class Address {
	
	int add;

	public Address(int add) {
		super();
		this.add = add;
	}
	
}
class Atom {
	int id;
	String name ;
	public Atom(int id){
		System.out.println("Atom"+id);
	}
}
class Granite extends Atom{
	public Granite() {
		super(2);
		// TODO Auto-generated constructor stub
	}

	int id;
	/*public Granite(int id){
		super(id);
		System.out.println("this is granite"+id);
	}*/
}
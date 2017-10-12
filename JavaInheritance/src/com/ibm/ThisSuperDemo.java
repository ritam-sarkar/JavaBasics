/**
 * 
 */
package com.ibm;

/**
 * @author Ritam
 *
 */
public class ThisSuperDemo {

	public static void main(String[] args){
		Employee emp = new Employee("Ritam","Belgharia");
		System.out.println(emp.name);
		System.out.println(emp.address);
		Programmer prog = new Programmer();
		prog.print();
		Employee emp2 = new Programmer("program1", "pragm1 address");
		System.out.println(emp2.name);
		emp2.printName();
		
		Parent p = new Child();
		System.out.println(p.name);
		System.out.println(p.getName());
        p.printName();	
        p.printVal();
        System.out.println(Child.val);
	}
}
class Employee{
	
    String name;
    String address;
	public Employee(){
		this.name = "default";
		this.address = "default";
	}
	public Employee(String name){
		this();
		//this.name = name;
	}
	public Employee(String name, String address){
		this(name);
		this.address = address;
	}
	public void  printName(){
		System.out.println(name);
	}
}
class Programmer extends Employee{
	String name;
	//String address;
	public Programmer(String name,String address){
		//this.name = name;
		super(name,address);
		
	}
	public Programmer(){
		this.name = "Sharmistha";
	}
	public void print(){
		//this();
		System.out.println("name :"+this.name+" address :"+this.address);
		System.out.println("name :"+super.name+" address "+super.address);
	}
	public void  printName(){
		System.out.println(name);
	}
}

class Parent{
	String name = "parent";
	
	static int val = 0;

	void printName(){
		System.out.println("val from paret class "+this.val);		
	}
	public String getName(){
		return this.name;
	}
	void printVal(){
		System.out.println();
	}
}

class Child extends Parent{
	String name = "child";
	//int val =1;
	void printName(){
		System.out.println(name);
	}
	public Child(){
		this.name = "child1";
	}
	public String getName(){
		return this.name;
	}
}

/**
 * 
 */
package com.ibm;

/**
 * @author Ritam
 *
 */
public class InstanceSuperDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JavaBook jvb = new JavaBook();
	}

}

class Book{
	private String name;

	public Book(String name) {
		super();
		this.name = name;
	}

	
	public Book() {
		super();
	}
	
	
}
class JavaBook extends Book{
	private String type="a";

	public JavaBook() {
		this.setType(type);
		//super(type);
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}

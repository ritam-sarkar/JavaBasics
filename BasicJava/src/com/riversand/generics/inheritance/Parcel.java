/**
 * 
 */
package com.riversand.generics.inheritance;

/**
 * @author Ritam
 *
 */
public class Parcel<T> {
protected T ob ;

public Parcel(T ob) {
	super();
	this.setOb(ob);
}



public Parcel() {
	super();
	// TODO Auto-generated constructor stub
}


public T getOb() {
	return ob;
}


public void setOb(T ob) {
	this.ob = ob;
}


}

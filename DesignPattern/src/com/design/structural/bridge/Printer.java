/**
 * 
 */
package com.design.structural.bridge;

import java.util.List;

/**
 * @author ritsarka
 *
 */
public abstract class Printer {
	
	String print(Formatter formatter) {
		return formatter.format(getHeader(), getDetails());
	}

	protected abstract List<Detail> getDetails();

	protected abstract String getHeader();
}

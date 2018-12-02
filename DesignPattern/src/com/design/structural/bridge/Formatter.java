/**
 * 
 */
package com.design.structural.bridge;

import java.util.List;

/**
 * @author ritsarka
 *
 */
public interface Formatter {

	String format(String header, List<Detail> details);
}

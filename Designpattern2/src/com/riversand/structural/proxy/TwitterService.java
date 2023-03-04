/**
 * 
 */
package com.riversand.structural.proxy;

/**
 * @author ritsarka
 *
 */
public interface TwitterService {
	
	public void post(String param1, String param2);
	public void comment(String param1);
	public String readComment();

}

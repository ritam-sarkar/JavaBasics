/**
 * 
 */
package com.design.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author ritsarka
 *
 */
public class ProxypatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TwitterService original = new TwitterServiceImpl();
		InvocationHandler securityPHandler = new SecurityProxy(original);
		TwitterService twitterService = (TwitterService) Proxy.newProxyInstance(TwitterService.class.getClassLoader(),new Class[] { TwitterService.class },securityPHandler);
	    twitterService.post(" Hello ", "Hi" );
	    twitterService.comment("OK");
	}

}

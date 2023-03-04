/**
 * 
 */
package com.riversand.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Collection;

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
		InvocationHandler securityHandler = new SecurityProxy(original);
		TwitterService twitterService = (TwitterService) Proxy.newProxyInstance(TwitterService.class.getClassLoader(),new Class[] { TwitterService.class },securityHandler);
	    //twitterService.post(" Hello ", "Hi" );
	    //twitterService.comment("OK");
		twitterService.readComment();
	}

}

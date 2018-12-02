/**
 * 
 */
package com.design.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ritsarka
 *
 */
public class SecurityProxy implements InvocationHandler{

	private TwitterService twitterService;
	public SecurityProxy(TwitterService twitterService) {
		this.twitterService = twitterService;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before method call"+" method name "+method.getName()+" "+method.getParameters());
		method.invoke(twitterService, args);
		System.out.println(" after method call"+args[0].toString());
		return null;
	}

}

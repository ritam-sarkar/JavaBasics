package com.riversand.creational.factory;

import java.util.Calendar;

import com.design.creational.factory.WebsiteFactory.SiteType;


/**
 * Does not expose instantiation logic
 * Common interface
 * Defer subclasses
 * It�s called a factory because it creates various types of objects without necessarily
 * knowing what kind of object it creates or how to create it.
 * Draw back is hard modify the pattern, but easy to extend 
 * 
 * Example {@link Calendar}
 * 
 * @author ritsarka
 *
 */
public class FactoryPatternDemo {

	public static void main(String[] args) {

		Website amazon = WebsiteFactory.getWebsite(SiteType.AMAZON);
		System.out.println(amazon.getPages());
		Website facebook = WebsiteFactory.getWebsite(SiteType.FACEBOOK);
		System.out.println(facebook.getPages());
		Website myBlog = WebsiteFactory.getWebsite(SiteType.MYBLOG);
		System.out.println(myBlog.getPages());
		
		
	}

}

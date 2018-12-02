package com.design.creational.factory;

public class WebsiteFactory {
	
	public static Website getWebsite(SiteType siteType) {
		switch(siteType) {
		case MYBLOG :
			return new MyBlog();
		case FACEBOOK :
			return new Facebook();
		case AMAZON :
			return new Amazon();
		default :
			return null;			
		}
	}
	
	public static enum SiteType{
		MYBLOG,FACEBOOK,AMAZON;
	}

}

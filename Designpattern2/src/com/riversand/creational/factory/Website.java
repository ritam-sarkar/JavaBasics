package com.riversand.creational.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Website {

	protected List<Page> pages = new ArrayList<Page>();	
	public Website() {
		createWebsite();
	}
	abstract void createWebsite();
	public Website getWebsite() {
		return this;
	}

	public List<Page> getPages() {
		return pages;
	}
}
class MyBlog extends Website{

	@Override
	void createWebsite() {
	   pages.add(new UserPage());
	   pages.add(new BlogPage());
	}	
}
class Facebook extends Website{

	@Override
	void createWebsite() {
       pages.add(new UserPage());
       pages.add(new BlogPage());
	}
	
}
class Amazon extends Website{

	@Override
	void createWebsite() {
		 pages.add(new UserPage());
	     pages.add(new BlogPage());
	     pages.add(new CartPage());
	}
	
}


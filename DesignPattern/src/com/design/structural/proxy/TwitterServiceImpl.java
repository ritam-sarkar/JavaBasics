package com.design.structural.proxy;

public class TwitterServiceImpl implements TwitterService {

	@Override
	public void post(String content) {
		System.out.println("first post"); 
	}

}

package com.riversand.structural.proxy;

public class TwitterServiceImpl implements TwitterService {

	@Override
	public void post(String param1, String param2) {
		System.out.println("first post"); 
	}

	@Override
	public void comment(String param1) {
		System.out.println(" First comment ");
	}

	@Override
	public String readComment() {
		return "Comments read";
	}

}

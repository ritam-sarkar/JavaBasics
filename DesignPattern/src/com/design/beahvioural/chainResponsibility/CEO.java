package com.design.beahvioural.chainResponsibility;

public class CEO extends Handler{
	@Override
	public void handleRequest(Request request) {
		System.out.println(" CEO approves "+request.getReqType()+" amount "+request.getAmount());
	}
}

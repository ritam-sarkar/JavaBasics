package com.riversand.beahvioural.chainResponsibility;

public class Director extends Handler{

	@Override
	public void handleRequest(Request request) {
		if(request.getReqType() == RequestType.CONFERENCE) {
			System.out.println(" Director approves conference ");
		}else {
			successor.handleRequest(request);
		}
	}
}

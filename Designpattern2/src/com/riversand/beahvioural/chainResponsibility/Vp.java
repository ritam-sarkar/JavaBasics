package com.riversand.beahvioural.chainResponsibility;

public class Vp extends Handler{

	@Override
	public void handleRequest(Request request) {
		
		if(request.getReqType() == RequestType.PURCHASE) {
			if(request.getAmount() < 10000) {
				System.out.println(" Vp approves the order of "+request.getReqType()+" amount "+request.getAmount());
			}else {
				successor.handleRequest(request);
			}
		}
	}	
}

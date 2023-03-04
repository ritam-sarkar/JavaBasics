package com.riversand.beahvioural.chainResponsibility;

public class ChainResponsibilityDemo {

	public static void main(String[] args) {

		Request confReq = new Request(RequestType.CONFERENCE, 0);
		Request purchaseSmall = new Request(RequestType.PURCHASE, 9000);
		Request purchaseBig = new Request(RequestType.PURCHASE, 20000);
		
		Director director = new Director();
		Vp vp = new Vp();
		CEO ceo = new CEO();		
		director.setSuccessor(vp);
		vp.setSuccessor(ceo);
		
		// fire the responsiblity
		
		System.out.println(" passing to director ");
		director.handleRequest(confReq);
		director.handleRequest(purchaseSmall);
		director.handleRequest(purchaseBig);
		
		System.out.println(" passing to VP ");
		vp.handleRequest(confReq);
		vp.handleRequest(purchaseSmall);
		vp.handleRequest(purchaseBig);
		
		System.out.println(" passing to CEO ");
		ceo.handleRequest(confReq);
		ceo.handleRequest(purchaseSmall);
		ceo.handleRequest(purchaseBig);
		
		
	}

}

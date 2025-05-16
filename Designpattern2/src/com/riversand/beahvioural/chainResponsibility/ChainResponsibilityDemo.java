package com.riversand.beahvioural.chainResponsibility;

public class ChainResponsibilityDemo {

	/**
	 * The hierarchy sequence is CEO > VP > Director
	 * So approval sequence is Director -> VP -> CEO
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		ChainResponsibilityDemo demo = new ChainResponsibilityDemo();
		Request confReq = demo.new Request(RequestType.CONFERENCE, 0);
		Request purchaseSmall = demo.new Request(RequestType.PURCHASE, 9000);
		Request purchaseBig = demo.new Request(RequestType.PURCHASE, 20000);
		
		Director director = demo.new Director();
		Vp vp = demo.new Vp();
		CEO ceo = demo.new CEO();
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
	enum RequestType {

		PURCHASE, CONFERENCE;
	}
	class Request {
		private RequestType reqType;
		private double amount;
		public Request(RequestType reqType, double amount) {
			super();
			this.reqType = reqType;
			this.amount = amount;
		}
		public RequestType getReqType() {
			return reqType;
		}
		public double getAmount() {
			return amount;
		}
	}
	abstract class Handler {
		protected Handler successor;
		public void setSuccessor(Handler successor) {
			this.successor = successor;
		}
		public abstract void handleRequest(Request request);
	}
	class CEO extends Handler{
		@Override
		public void handleRequest(Request request) {
			System.out.println(" CEO approves "+request.getReqType()+" amount "+request.getAmount());
		}
	}
	class Director extends Handler{

		@Override
		public void handleRequest(Request request) {
			if(request.getReqType() == RequestType.CONFERENCE) {
				System.out.println(" Director approves conference ");
			}else {
				successor.handleRequest(request);
			}
		}
	}
	class Vp extends Handler{

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

}

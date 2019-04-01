package com.design.beahvioural.chainResponsibility;

public class Request {
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

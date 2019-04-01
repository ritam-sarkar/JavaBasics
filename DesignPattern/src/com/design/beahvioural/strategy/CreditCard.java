package com.design.beahvioural.strategy;

import java.util.Date;

public class CreditCard {
	String number;
	int cvv;
	Date expire;
	Strategy strategy;
	
	public Strategy getStrategy() {
		return strategy;
	}
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	public String getNumber() {
		return number;
	}
	public int getCvv() {
		return cvv;
	}
	public Date getExpire() {
		return expire;
	}
	public CreditCard(String number, int cvv, Date expire) {
		super();
		this.number = number;
		this.cvv = cvv;
		this.expire = expire;
	}
	public boolean isValid() {
		return strategy.isValid(this);
	}
	

}

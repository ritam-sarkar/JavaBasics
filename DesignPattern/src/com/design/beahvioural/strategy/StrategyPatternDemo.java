package com.design.beahvioural.strategy;

import java.util.Date;

public class StrategyPatternDemo {

	public static void main(String[] args) {

		CreditCard card1 = new CreditCard("4111111111111111", 123, new Date(2023-1900, 3, 12));
		card1.setStrategy(new VisaStrategy());
		CreditCard card2 = new CreditCard("34852721055858", 321, new Date(2022-1900, 3, 12));
		card2.setStrategy(new AmexStrategy());
		CreditCard card3 = new CreditCard("32345678909876", 123, new Date(2018-1900, 3, 12));
		card3.setStrategy(new AmexStrategy());
		
		System.out.println(" card1 is visa card "+card1.isValid());
		System.out.println(" card2 is amex card "+card2.isValid());
		System.out.println(" card3 is amex card "+card3.isValid());
		
		
		
		
		
	}

}

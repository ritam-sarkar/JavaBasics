package com.riversand.beahvioural.strategy;

import java.util.Date;

public class AmexStrategy extends Strategy{

	@Override
	public boolean isValid(CreditCard creditCard) {
		boolean isValid = false;
		isValid = creditCard.getNumber().length() == 14;
		//isValid = isValid && luhnAlgo(creditCard.getNumber());		
		Date today = new Date();
		isValid = isValid && today.before(creditCard.getExpire());
		return isValid;
	}	
}

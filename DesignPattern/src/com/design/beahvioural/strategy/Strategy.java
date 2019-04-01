package com.design.beahvioural.strategy;

public abstract class Strategy {

	public abstract boolean isValid(CreditCard creditCard);
	
	//https://www.geeksforgeeks.org/luhn-algorithm/
	protected final boolean luhnAlgo(String cardNo) {
		int nDigits = cardNo.length(); 
		  
	    int nSum = 0; 
	    boolean isSecond = false; 
	    for (int i = nDigits - 1; i >= 0; i--)  
	    { 
	  
	        int d = cardNo.charAt(i); 	  
	        if (isSecond == true) 
	            d = d * 2; 
	  
	        // We add two digits to handle 
	        // cases that make two digits  
	        // after doubling 
	        nSum += d / 10; 
	        nSum += d % 10; 
	  
	        isSecond = !isSecond; 
	    } 
	    return (nSum % 10 == 0); 
	}
	
}

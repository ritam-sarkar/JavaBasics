/**
 * 
 */
package com.ibm;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

/**
 * @author Ritam
 *
 */
public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GregorianCalendar calender = new GregorianCalendar(2017, 3, 15);
		Date date = calender.getTime();
    	System.out.println(date);
    	if(getDayGap(date)==0){
    		System.out.println("today");
    	}else{
    		System.out.println(getDayGap(date));
    	}
	}
	public static int getDayGap(Date fromDate){
    	Date today = new Date();
    	long millidiff = fromDate.getTime() - today.getTime();      	
    	int dayGap = (int)TimeUnit.DAYS.convert(millidiff, TimeUnit.MILLISECONDS);    	    		
    	return dayGap;    	
    }

}

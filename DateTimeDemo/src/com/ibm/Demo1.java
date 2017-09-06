/**
 * 
 */
package com.ibm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * @author Ritam
 *
 */
public class Demo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		TimeZone zone = TimeZone.getTimeZone("IST");
		Calendar cal = Calendar.getInstance(zone);
		System.out.println("ist time "+cal.get(Calendar.HOUR));
		Date d = new Date();
		System.out.println(d.getDate());
		System.out.println(d.getDay());
		System.out.println(d.toLocaleString());
		String date1 = "05/03/2017 00:00:00";
		String date2 = "06/03/2017 00:00:00";
		try {
			Date d1 = format.parse(date1);
			Date d2 = format.parse(date2);
			System.out.println("d1 date"+d1.getDate());
			System.out.println("d2 date "+d2.getDate());
			long diff = (d2.getTime() - d1.getTime())/(1000*3600*24);
			System.out.println("diff "+diff);
			Date today = new Date();
			System.out.println("d2 "+d2);
			System.out.println("comapre to "+d2.compareTo(today));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Calendar cal2 = new GregorianCalendar(2017, 1, 4);
		cal2.add(Calendar.DAY_OF_MONTH, 15);
		Date expireDate = cal2.getTime();
		System.out.println("expire date "+expireDate.toLocaleString());
		Date today = new Date();
		System.out.println("today's date "+today.toLocaleString());
		System.out.println(expireDate.before(today));
		long remainingdays = (today.getTime()- expireDate.getTime())/(1000*3600*24);
		System.out.println("remaining days "+remainingdays);
		
		
		
		
		
		
		
		
	}

}

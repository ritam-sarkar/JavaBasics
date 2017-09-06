/**
 * 
 */
package com.ibm.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.service.ExcelWriter;

/**
 * @author Ritam
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/spring-core.xml");
		ExcelWriter excelWriter = ctx.getBean(ExcelWriter.class);
		excelWriter.write();
		
	}

}

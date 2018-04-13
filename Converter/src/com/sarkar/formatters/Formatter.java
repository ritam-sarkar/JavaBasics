/**
 * 
 */
package com.sarkar.formatters;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sarkar.annotations.Convert;

/**
 * @author ritsarka
 *
 */
public class Formatter {
	
	public static void format(Object obj) throws IllegalArgumentException, IllegalAccessException, ParseException {
		SimpleDateFormat df = new SimpleDateFormat();
		Class clz = obj.getClass();
		for(Field field : clz.getDeclaredFields()) {
			Convert convert =  field.getAnnotation(Convert.class);
			if(convert != null) {
				String pattern = convert.pattern();
				Class target = convert.target();
				df.applyPattern(pattern);
				field.setAccessible(true);
				if(target.isInstance(new String())) {
					if(field.getType().isInstance(new Date())) {
						Date val = (Date) field.get(obj);
						System.out.println(df.format(val));
					}
				}else if(target.isInstance(new Date())) {
					String val = (String)field.get(obj);
					System.out.println(df.parseObject(val));
				}			
				
			}
			
		}
	}

}

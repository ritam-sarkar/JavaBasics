/**
 * 
 */
package com.ibm.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.ibm.model.DataProps;
import com.ibm.model.Employee;
import com.ibm.model.XLSHeader;
import com.ibm.util.FillDetails;
import com.ibm.util.Layouter;

/**
 * @author Ritam
 *
 */
@Service
public class ExcelWriter {
	
 public void write(){
	 
	 List<Employee> employeeList = new ArrayList<Employee>();
	 employeeList.add(new Employee(1, "A", "a@gmail.com"));
	 employeeList.add(new Employee(2, "B", "b@gmail.com"));
	 employeeList.add(new Employee(3, "C", "c@gmail.com"));
	 employeeList.add(new Employee(4, "D", "d@gmail.com"));
	 DataProps dataProps = mapDataProps(employeeList);
	 HSSFWorkbook workbook = new HSSFWorkbook();
	  // 2. Create new worksheet
	  HSSFSheet worksheet = workbook.createSheet("Employee Records"); 
	  XLSHeader dataHeader = new XLSHeader(0, 0, worksheet, dataProps.getHeaders());	  
	   
	  // 3. Build layout 
	  // Build title, date, and column headers
	  Layouter.buildReport(dataHeader);

	 
	  // 4. Fill report
	  FillDetails.fillDataSheet(worksheet, dataProps.getValues());
	  
	  // 5. Set the response properties
	  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-YYYY");
	  String fileName ="C:\\employees_"+simpleDateFormat.format(new Date())+".xls";	  
      try {
    	  FileOutputStream outputStream = new FileOutputStream(fileName);
		  workbook.write(outputStream);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
	 
		  
 }

private DataProps mapDataProps(List<Employee> employeeList) {
	
	DataProps dataProps = new DataProps();
	List<String> headers = new ArrayList<String>();
	headers.add("id");
	headers.add("Name");
	headers.add("EmailId");
	List<List<String>> values = new ArrayList<List<String>>();	
	for(Employee emp : employeeList ){
		List<String> value = new ArrayList<String>();
		value.add(emp.getId().toString());
		value.add(emp.getName());
		value.add(emp.getEmailId());
		values.add(value);		
	}
	dataProps.setHeaders(headers);
	dataProps.setValues(values);
	
	return dataProps;
}
 
	  
	 

}

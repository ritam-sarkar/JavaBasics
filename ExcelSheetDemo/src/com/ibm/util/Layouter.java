package com.ibm.util;

import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

import com.ibm.model.XLSHeader;


public class Layouter {
	
   public static void buildReport(XLSHeader headerInfo) {
	  // Set column widths
	  if(headerInfo.getHeaders()!=null){
		 for (int i=0; i<headerInfo.getHeaders().size(); i++) {
			 headerInfo.getWorksheet().setColumnWidth(i, 5000);
		 }
	  }
	   
	  // Build the title and date headers
	  //buildTitle(worksheet, startRowIndex, startColIndex);
	  // Build the column headers
	  buildHeaders(headerInfo);
  }
	  
	 /**
	  * Builds the report title and the date header
	  * 
	  * @param worksheet
	  * @param startRowIndex starting row offset
	  * @param startColIndex starting column offset
	  */
  public static void buildTitle(HSSFSheet worksheet, int startRowIndex, int startColIndex) {
	  // Create font style for the report title
	  Font fontTitle = worksheet.getWorkbook().createFont();
	  fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD);
	  fontTitle.setFontHeight((short) 280);
	   
	        // Create cell style for the report title
	        HSSFCellStyle cellStyleTitle = worksheet.getWorkbook().createCellStyle();
	        cellStyleTitle.setAlignment(CellStyle.ALIGN_CENTER);
	        cellStyleTitle.setWrapText(true);
	        cellStyleTitle.setFont(fontTitle);
	   
	        // Create report title
	  HSSFRow rowTitle = worksheet.createRow((short) startRowIndex);
	  rowTitle.setHeight((short) 500);
	  HSSFCell cellTitle = rowTitle.createCell(startColIndex);
	  cellTitle.setCellValue("APAR Details");
	  cellTitle.setCellStyle(cellStyleTitle);
	   
	  // Create merged region for the report title
	  //worksheet.addMergedRegion(new CellRangeAddress(0,0,0,5));
	   
	  // Create date header
	  HSSFRow dateTitle = worksheet.createRow((short) startRowIndex +1);
	  HSSFCell cellDate = dateTitle.createCell(startColIndex);
	  cellDate.setCellValue("This report was generated at " + new Date());
  }
	  
	 /**
	  * Builds the column headers
	  * 
	  * @param worksheet
	  * @param startRowIndex starting row offset
	  * @param startColIndex starting column offset
	  */
  public static void buildHeaders(XLSHeader headerInfo) {
	  HSSFSheet worksheet = headerInfo.getWorksheet();	 
	  int startRowIndex = headerInfo.getStartRowIndex();
	  // Create font style for the headers
	  Font font = worksheet.getWorkbook().createFont();
	  font.setBoldweight(Font.BOLDWEIGHT_BOLD);
	  font.setFontHeightInPoints((short)14);
	  font.setFontName("Calibri");
	  font.setColor(HSSFColor.BLUE.index);
	 
	        // Create cell style for the headers
	  HSSFCellStyle headerCellStyle = worksheet.getWorkbook().createCellStyle();
	  //headerCellStyle.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
	 // headerCellStyle.setFillPattern(CellStyle.FINE_DOTS);
	  headerCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
	 // headerCellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	  headerCellStyle.setWrapText(false);
	  headerCellStyle.setFont(font);
	  headerCellStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);
	  headerCellStyle.setBorderRight(CellStyle.BORDER_THIN);
	   
	  // Create the column headers
	  HSSFRow rowHeader = worksheet.createRow(headerInfo.getStartRowIndex());
	  rowHeader.setHeight((short) 500);
	  
	  HSSFCell cell = null;
	  if(headerInfo.getHeaders()!=null){
	     for (int i=0; i<headerInfo.getHeaders().size(); i++) {
			 headerInfo.getWorksheet().setColumnWidth(i, 6000);
			 cell = rowHeader.createCell(headerInfo.getStartColIndex()+i);
			 cell.setCellValue(headerInfo.getHeaders().get(i));
			 cell.setCellStyle(headerCellStyle);
		 }
	  } 
  }

}

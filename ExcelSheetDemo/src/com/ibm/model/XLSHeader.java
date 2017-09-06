package com.ibm.model;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;

public class XLSHeader {

	private int startRowIndex;
	private int startColIndex;
	private HSSFSheet worksheet;
	private List<String> headers;
	
	public XLSHeader(int startRowIndex, int startColIndex, HSSFSheet worksheet,
			List<String> headers) {
		super();
		this.startRowIndex = startRowIndex;
		this.startColIndex = startColIndex;
		this.worksheet = worksheet;
		this.headers = headers;
	}
	
	public int getStartRowIndex() {
		return startRowIndex;
	}
	public void setStartRowIndex(int startRowIndex) {
		this.startRowIndex = startRowIndex;
	}
	public int getStartColIndex() {
		return startColIndex;
	}
	public void setStartColIndex(int startColIndex) {
		this.startColIndex = startColIndex;
	}
	public HSSFSheet getWorksheet() {
		return worksheet;
	}
	public void setWorksheet(HSSFSheet worksheet) {
		this.worksheet = worksheet;
	}
	public List<String> getHeaders() {
		return headers;
	}
	public void setHeaders(List<String> headers) {
		this.headers = headers;
	}
	
	
	
	
}

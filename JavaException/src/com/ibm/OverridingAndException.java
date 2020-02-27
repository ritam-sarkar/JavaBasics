package com.ibm;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OverridingAndException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static class Parent {
		void f1() throws IOException{
			
		}
		void f2() throws Exception{
			
		}
		void f3() throws FileNotFoundException{
			
		}
		void f4() throws NullPointerException{
			
		}
		void f5() throws RuntimeException{
			
		}
		
		void f8() {
			
		}
		void f12() throws NullPointerException {
			
		}
	}
	
	static class Child extends Parent{
		
		// Rule1 : Child and only throw the exception or the child class of the exception or  no exception
		@Override
		void f1() throws FileNotFoundException{
			
		}
		// Rule2 : If parent does not throw exception child can throw only runtime exception, not checked exception not even Exception
		@Override
		void f8() throws NullPointerException {
			
		}
		// Rule3 : For unchecked exception  Rule2 does not follow
		@Override
		void f4() throws RuntimeException{
			
		}
		
		
		void f9() {
			try {
				
			}catch(Exception e) {
				// Rule 5 : catch an Exception with empty try block
			}
		}
		void f10() {
			try {
				
			}catch (NullPointerException e) {
				
			}
		}
		void f11() {
			
			// Rule 4: Cannot catch an empty block for Checked exception
			
			/*try {
				
			}catch (FileNotFoundException e) {
				
			}*/
		}
		// Rule 6 : For unchecked exception super class and subclass does not applicable
		void f12() throws RuntimeException {
			
		}			
		
		
		
	}

}

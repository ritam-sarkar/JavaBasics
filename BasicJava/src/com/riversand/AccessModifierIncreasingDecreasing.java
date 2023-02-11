package com.riversand;

public class AccessModifierIncreasingDecreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Parent{
	   
		protected void methodA() {
			
		}
	}
	static class Child extends Parent {
		
		// Increasing allowed, decreasing not allowed
		@Override
		public void methodA() {
			
		}
		/*@Override
		void methodA() {

		}*/
	}

}

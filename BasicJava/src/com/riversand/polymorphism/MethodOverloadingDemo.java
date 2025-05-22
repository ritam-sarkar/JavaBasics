package com.riversand.polymorphism;

public class MethodOverloadingDemo {

	public static void main(String[] args) {

		TicketBooking ticketBoking = new TicketBooking();

		// As overloading is bound at compile time so prints economy class
		Employee e = new CEO();
		CEO c = new CEO();
		ticketBoking.book(e); // call Employee
		ticketBoking.book(c); // call CEO


		/**
		 * remove book(employee) method , as CEO and Engineer are sibling classes of Employee
		 * in method parameter covarient type is not applicable,
		 *
		 */
		
		/*e = new CEO();
		ticketBoking.book(e);*/
		Result result = new Result();
		result.calcAverage(12.0,1);
		/*
		   Here int is typecasting  to double or double is typecasting to int
		   so compiler will be confused which method to call double , int  or int , double

		 */
		// If one of the method is deleted then this call will work as int is default primitive type in java
		//result.calcAverage(12,1);
		// But this method will not work on any scenario, we need to create a method double,double otherwise will not work
		//result.calcAverage(12.0,1.0);

		/**
		 * 1. It try to find exact match int, int or double, double if found it will call the method
		 * 2. If not found for (int,int) argument (double,int) and (int,double) both are eligible so if both are present then at calling method will have compile time error
		 * 3. If only 1 method i.e. either (double,int) or (int,double) present still from calling methid (int,int) is allowed but (double,double) is not allowed
		 */


	}
	static class Employee{
		
	}
	static class CEO extends Employee {
		
	}
	static class Engineer extends Employee{
		
	}
	
	static class TicketBooking{
		
		void book(Employee e){
			 
			System.out.println("3rd class");
		}
		void book(CEO c) {
			System.out.println("business class");
		}
		void book(Engineer e) {
			System.out.println("economy class");
		}

		
	}
	static class Result {

		// Method overloading only with return type change is throwing type erasure error at compile time
		/*double calcAverage(int marks1, int marks2) {
			return (marks1 + marks2)/2;
		}
		int calcAverage(int marks1, int marks2) {
			return (marks1 + marks2)/2;
		}*/


		double calcAverage(double marks1, int marks2) {
			return(marks1 + marks2)/2;
		}
		double calcAverage(int marks1, double marks2) {
			return(marks1 + marks2)/2;
		}
		double calcAverage(int marks1, int marks2) {
			return(marks1 + marks2)/2;
		}

	}

}

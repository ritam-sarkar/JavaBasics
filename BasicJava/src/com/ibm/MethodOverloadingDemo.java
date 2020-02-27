package com.ibm;

public class MethodOverloadingDemo {

	public static void main(String[] args) {

		TicketBooking ticketBokking = new TicketBooking();
		// As overloading is bound at compile time so prints 3rd class
		
		/*Employee e = new CEO();
		ticketBokking.book(e);*/
		
		// Remove book method for Employee
		// cannot pass employee reference to the child class reference covariant type is not allowed in method overloading
		
		/*Employee e = new CEO();
		ticketBokking.book(e);*/
		
		
		
		
		
		
		
	}
	static class Employee{
		
	}
	static class CEO extends Employee {
		
	}
	static class Engineer extends Employee{
		
	}
	
	static class TicketBooking{
		
		/*void book(Employee e){
			 
			System.out.println("3rd class");
		}*/
		void book(CEO c) {
			System.out.println("1st class");
		}
		void book(Engineer e) {
			System.out.println("2nd class");
		}
		
	}

}

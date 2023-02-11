package com.riversand.polymorphism;

public class MethodOverloadingDemo {

	public static void main(String[] args) {

		TicketBooking ticketBoking = new TicketBooking();

		// As overloading is bound at compile time so prints economy class
		Employee e = new CEO();
		CEO c = new CEO();
		ticketBoking.book(e); // call Employee
		ticketBoking.book(c); // call CEO

		
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

}

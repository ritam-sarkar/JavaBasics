package com.riversand.structural.bridge;

/**
 * 
 * @author ritsarka
 * Example Driver classes like jdbc
 * This design is build in such a way that user cannot predict the implementation change. 
 * User only care about the output 
 * 
 * Bridge pattern work as a bridge between this two
 * We can make another formatter like html formatter and make a bridge with movie printer
 *
 *
 */
public class BridgePatternDemo {

	/**
	 * Here we have formatter which does not know the details
	 * 
	 * On other hand  movie printer only knows about movie
	 * If we change anything in formatter printer does not care and vice versa
	 * @param args
	 */
	public static void main(String[] args) {

		Movie movie = new Movie("Comedy", "Pink panther", 2);
		Formatter printFormatter = new PrintFormatter();
		Printer moviPrinter = new MoviePrinter(movie);
		System.out.println(moviPrinter.print(printFormatter));
		
	}

}

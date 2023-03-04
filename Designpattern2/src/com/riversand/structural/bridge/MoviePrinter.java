/**
 * 
 */
package com.riversand.structural.bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ritsarka
 *
 */
public class MoviePrinter extends Printer {

	private Movie movie;
	
	
	public MoviePrinter(Movie movie) {
		super();
		this.movie = movie;
	}


	@Override
	protected List<Detail> getDetails() {
		List<Detail> details = new ArrayList<Detail>();
		details.add(new Detail("Title", movie.getTitle()));
		details.add(new Detail("Runtime", String.valueOf(movie.getRuntime())));		
		return details;
	}

	
	@Override
	protected String getHeader() {
		return movie.getClassification();
	}

}

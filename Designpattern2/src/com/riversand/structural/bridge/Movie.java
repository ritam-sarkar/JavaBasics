/**
 * 
 */
package com.riversand.structural.bridge;

/**
 * @author ritsarka
 *
 */
public class Movie {

	private String classification;
	private String title;
	private int runtime;
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public Movie(String classification, String title, int runtime) {
		super();
		this.classification = classification;
		this.title = title;
		this.runtime = runtime;
	}
	public Movie() {
		super();
	}
	
}

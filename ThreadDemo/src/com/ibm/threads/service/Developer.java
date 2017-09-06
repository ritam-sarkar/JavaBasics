package com.ibm.threads.service;

import com.ibm.threads.ScreenDesign;

public class Developer {
	private ScreenDesign design;

	public Developer(ScreenDesign design) {
		super();
		this.design = design;
	}

	public Developer() {
		super();
	}
	public void develop(){
		System.out.println("waiting for design to complete");
		
		/*try {
			design.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("code");
	}
	
	

}

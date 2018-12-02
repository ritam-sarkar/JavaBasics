package com.design.structural.fyweight;

public class FlyWeightPatternDemo {

	public static void main(String[] args) {

		InventorySystem ivs = new InventorySystem();
		ivs.takeOrder("Iphone se", 30);
		ivs.takeOrder("Iphone 7", 40);
		ivs.takeOrder("Oppo", 60);
		ivs.takeOrder("Vivo", 70);
		ivs.takeOrder("Oppo", 80);
		ivs.takeOrder("Laptop", 90);
		ivs.takeOrder("Laptop", 100);
		ivs.process();
		
	}

}

package main;

import java.util.concurrent.ConcurrentHashMap;

import enums.IceCream;

public class IceCreammain {

	public static void main(String[] args) {
		System.out.println(IceCream.WALLNUT);
		System.out.println(IceCream.VANILLA);
		System.out.println(IceCream.WALLNUT.getDeclaringClass());
		//System.out.println(IceCream.WALLNUT.flavor());
		System.out.println(IceCream.VANILLA.valueOf("VANILLA"));
		
	}

}

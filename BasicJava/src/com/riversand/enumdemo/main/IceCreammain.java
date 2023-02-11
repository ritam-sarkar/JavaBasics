package com.riversand.enumdemo.main;

import com.riversand.enumdemo.enums.IceCream;

public class IceCreammain {

	public static void main(String[] args) {
		System.out.println(IceCream.WALLNUT);
		System.out.println(IceCream.VANILLA);
		System.out.println(IceCream.WALLNUT.getDeclaringClass());
		// cannot call enum methods outside the enum
		//System.out.println(IceCream.WALLNUT.flavor());
		System.out.println(IceCream.VANILLA.valueOf("VANILLA"));
		
	}

}

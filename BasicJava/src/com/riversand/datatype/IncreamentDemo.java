package com.riversand.datatype;

public class IncreamentDemo {

	public static void main(String[] args) {

		byte age1 = 10;
		byte age2 = 12;
		// return type = MAX(int , type1, type2 ...) so int cannot fit into short here
		//short sum = age1 + age2;
		// Here after type casting we can use that
		short sum = (short) (age1 + age2);
		System.out.println("Sum byte as short :: "+sum);

		// without type casting making byte variable final
		final byte age3 = 20;
		final byte age4 = 21;
		byte sumByte = age3 + age4;
		System.out.println("After final summation age :: "+sumByte);

		byte b = 1;
		b++;
		System.out.println(b);
		// This is not possible as return type is again int
		//b = b + 1;
		// Correct way is this
		b = (byte)(b + 1);


	}

}

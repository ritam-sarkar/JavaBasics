package com.riversand.datatype;

public class TwistTaleForDataType {
    public static void main(String[] args) {
        int myChar = 97;
        int yourChar = 98;
        // char + char returns Max(int , char) = int so it will call sout(int) method
        System.out.println((char) myChar + (char) yourChar);
        System.out.println("value "+ (myChar+yourChar));

        // char + char = int , but we deliberately converted the returned int type to char , so sout(char) will be called
        System.out.println((char) (myChar+yourChar));
        // here concatination is happening not addition
        System.out.println("value :: "+myChar+yourChar);

        int age = 12;
        System.out.println("age :: "+(float)age);

        int a =10;
        int b = 20;
        int c = 30;
        //concatination
        System.out.println("value::"+ ++a + b++ * c);
        // summation
        System.out.println(++a + b++ * c);

    }
}

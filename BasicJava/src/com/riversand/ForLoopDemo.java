package com.riversand;

public class ForLoopDemo {
    public static void main(String[] args) {

        //infiniteLoop();
        multipleInitialization();
        withoutCombination();

    }
    private static void infiniteLoop(){
        for (;;){
            System.out.println("infinite");
        }
    }
    private static void multipleInitialization(){
        // Cannot define different types in initialization
        /*for(int i=10,long j =20; i< 13 && j < 22 ; i++,j++){

        }*/
        for(int i=10, j =20; i< 13 && j < 22 ; i++,j++){
            System.out.println("i "+i+" j "+j);
        }
    }
    private static void withoutCombination(){
        for(int a =10; ;++a){
            System.out.println("a");
        }
    }
}

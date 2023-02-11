package com.riversand.inheritence;

public class AbstractDemo {
    public static void main(String[] args) {

    }

    static abstract class Animal {

        protected String food;
        protected double avgLife;
        Animal(String food, double avgLife) {
            this.food = food;
            this.avgLife = avgLife;
        }

    }
    static class Deer extends Animal{
        /**
         * If we define a argumentative constructor in parent abstract from every constructor has to call super(String, double)
         * abstract is forcing concrete class to initiate few variables
         * @param food
         * @param avgLife
         */
        Deer(String food, double avgLife) {
            super(food, avgLife);
        }
        Deer(){
            super("",0.0);
        }
    }
}

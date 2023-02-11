package com.riversand;

public class TypeCastDemo {
    static interface Scavenger{}
    static class Bird{}
    static class Parrot extends Bird{}
    static class Vulture extends Bird implements Scavenger{}

    public static void main(String[] args) {
        Bird bird = new Bird();
        Parrot parrot = new Parrot();
        Vulture vulture = new Vulture();

        // Class cast exception as downcast not allowed at runtime
        //Parrot parrot2 = (Parrot)bird;

        // Scavanger is top of vulture in same hierarchy so allowed
        Scavenger sc = (Scavenger)vulture;
    }
}

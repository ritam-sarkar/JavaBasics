package com.riversand.inheritence;

public class InitializationDEmo {
    /**
     * 1. Call own static block not aprent's static block
     * 2. Parent's initializer block
     * 3. parent constructor
     * 4. Child initializer block
     * 5. Child constructor
     *
     * call --> static --> parent -> child
     *
     */
    public static void main(String[] args) {
        new Instrument();
        new Piano();
    }
}

/**
 * Initialization blocks are called each time any constructor is called
 * like here its called 2 times
 */
class Pencil {
    public Pencil() {
        System.out.println("Pencil:constructor");
    }
    public Pencil(String a) {
        System.out.println("Pencil:constructor2");
    }
    {
        System.out.println("Pencil:init1");
    }
    {
        System.out.println("Pencil:init2");
    }
    public static void main(String[] args) {
        new Pencil();
        new Pencil("aValue");
    }
}
class Instrument {

    static {
        System.out.println("Instrument static initializer block");
    }
    {
        System.out.println("Intrument initializer block");
    }
    Instrument() {
        System.out.println("Instrument:constructor");
    }
}
class Piano extends Instrument{
    static {
        System.out.println("Piano static initializer block");
    }
    {
        System.out.println("Piano initializer block");
    }
    Piano() {
        System.out.println("Piano:constructor");
    }
}


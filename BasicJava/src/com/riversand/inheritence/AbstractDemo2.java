package com.riversand.inheritence;

public class AbstractDemo2 {

    static abstract class MyClass {
       // public final int finalVar;


    }
    static class MyDerivedClass extends MyClass {
        MyDerivedClass() {
            super();
            // does not matter if we define it in derived class, in parent class or constructor we have to define
            //finalVar = 1000;
        }
    }
}

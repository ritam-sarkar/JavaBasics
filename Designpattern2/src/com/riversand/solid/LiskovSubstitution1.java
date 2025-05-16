package com.riversand.solid;

/**
 * his principle ensures that any class that is the child of a parent class should be usable in place of its parent without any unexpected behaviour.
 */
public class LiskovSubstitution1 {

    class Bird {
        void fly() {}
    }

    /**
     * If Ostrich fly method is unsupported , where the parent class method fly is not throwing any exception
     */
    class Ostrich extends Bird {
        void fly() { throw new UnsupportedOperationException(); }
    }

    /**
     * Better to use this structure
     */

    interface Flyable {
        void fly();
    }

    class Parrot implements Flyable {
        public void fly() { /* fly */ }
    }

    class Ostrich2 { /* no fly */ }


}

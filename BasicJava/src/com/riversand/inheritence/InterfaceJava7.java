package com.riversand.inheritence;

import java.util.Collections;

public class InterfaceJava7 {

    interface Livable {
        int x = 10;
        void live();
    }
    interface GuestHouse {
        int x =20;
        void welcome();

        // the same live() methods should be properly overloaded , otherwise Home can only implement any one of them
       // String live();
        void live();
    }


    static class Home implements Livable, GuestHouse {
        public void live() {
            System.out.println("live");
        }

        // If x is defined in both interfaces , to resolve the anbiguity need to mention Inrfacename.x otherwise we can directly use x
        public void welcome() {
            System.out.println("welcome"+GuestHouse.x);
        }
    }

    public static void main(String[] args) {
        Home home = new Home();
        home.live();
    }
}

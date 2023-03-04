package com.riversand.inheritence;

public class InterfaceJava7 {

    interface Livable {
        void live();
    }
    interface GuestHouse {
        void welcome();

        // the same live() methods should be properly overloaded , otherwise Home can only implement any one of them
       // String live();
        void live();
    }


    static class Home implements Livable, GuestHouse {
        public void live() {
            System.out.println("live");
        }
        public void welcome() {
            System.out.println("welcome");
        }
    }

    public static void main(String[] args) {
        Home home = new Home();
        home.live();
    }
}

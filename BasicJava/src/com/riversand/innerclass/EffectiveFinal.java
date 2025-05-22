package com.riversand.innerclass;

public class EffectiveFinal {
    int y=30;
    Runnable r = new Runnable() {
        @Override
        public void run() {
            System.out.println(y);
        }
    };
    // effective final case will never happen in class level
    //y=40;


    public static void main(String[] args) {

        int x = 20;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(x);
            }
        };
        f1(()-> System.out.println(x));

        /* as x is changed so it is not effective final , if I commen ot this line then both local anonymous class and lambda will work */
        //x=30;

    }
    static void f1(Runnable r){
        r.run();
    }


}


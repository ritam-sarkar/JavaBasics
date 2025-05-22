package com.riversand.inheritence;

public class StaticInitBlocks {
    static int staticVar = 10;
    static {
        System.out.println("First");
        ++staticVar;
    }
    static {
        System.out.println("Second");
        ++staticVar;
    }
    static void modifyStaticVar() {
        ++staticVar;
    }

    public StaticInitBlocks() {
        System.out.println("Constructor:" + staticVar);
    }
    //Rule : static blocks are called in sequence how they are written , like here first initialized , then +1 , then +1
    public static void main(String args[]) {

        new StaticInitBlocks();
        modifyStaticVar();
        /* Rule : static blocks are initialized only one time(during class load not class initialization)
        even if you initialize the class object multiple times
        as new StaticInitBlocks is the
        */
        new StaticInitBlocks();
    }
}

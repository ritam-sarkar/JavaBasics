package com.riversand.innerclass;

public class AccessModifier {
    private int x = 20;
    public static void main(String[] args) {
      AccessModifier accessModifier = new AccessModifier();
      accessModifier.display();
      AccessModifier.Inner inner = accessModifier.new Inner();
      inner.display();
    }

    void display(){
        // Cannot access directly
        //System.out.println("a of inner class"+a);
        // Need an object
        System.out.println("a of inner class "+new Inner().a);
    }
    class Inner {
        private int a = 10;
        void display(){
            System.out.println("x of outer class "+x);
        }
    }
}

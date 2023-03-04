package com.riversand.innerclass;

import java.util.ArrayList;

public class OuterClass {

    private static int a =10;
    private int b = 20;
    private int c = 30;

    static class StaticNested {
        private String name;
        StaticNested(String name){
            this.name = name;
        }
        public String name(){
            System.out.println("accessing static members from  "+this.getClass().getName()+"  "+a);
            // directly we cannot access it, have to create outer class object to access
            System.out.println("accessing non static members from static nested "+this.getClass().getName()+" "+new OuterClass().b);
            return this.name;
        }
    }
    class InnerClass {
        private String name;
        private static String staticVariable = "abc";
        private int c = 300;
        public static String innerMethod(){
            return staticVariable;
        }
        InnerClass(String name){
            this.name = name;
        }
        public String name(){
            System.out.println("accessing static members from inner class "+this.getClass().getName()+" "+a);
            // directly we can access it
            System.out.println("accessing non static members from inner class "+this.getClass().getName()+" "+b);
            return this.name;
        }
        public void methodInner(){
            System.out.println("Outerclass c ::"+OuterClass.this.c+" Inner class c :: "+c);
        }
    }
    public Object getObject(){
       return new Object(){
           @Override
           public String toString(){
              System.out.println(this.getClass().getSimpleName());
              return "This is called from anonymous "+ this.getClass().getSimpleName();
          }
       };
    }
    public String myMethod(){
        class LocalInner {
           private String name = "Local inner";
           public String name(){
               System.out.println("Called from Local inner class "+ this.getClass().getName()+" "+b);
               return this.name;
           }
        }
        return new LocalInner().name();
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        // Cannot define like this need an instance of outer class
        //InnerClass innerClass = new InnerClass("");
        InnerClass inner = outer.new InnerClass("Inner class");
        System.out.println(inner.name());
        StaticNested staticNested = new StaticNested("Static nested");
        System.out.println(staticNested.name());
        System.out.println(outer.myMethod());

    }
}
class AnotherClass {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.StaticNested staticNested = new OuterClass.StaticNested("Static nested");
        OuterClass.InnerClass innerClass = outerClass.new InnerClass("Inner class");
        System.out.println("Calling from another class "+ OuterClass.InnerClass.innerMethod());
        innerClass.methodInner();
    }
}

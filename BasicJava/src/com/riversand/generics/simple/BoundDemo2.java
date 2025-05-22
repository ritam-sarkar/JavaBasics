package com.riversand.generics.simple;


public class BoundDemo2 {
    static interface Wrappable{}
    static interface Exchangeable{}
    static class Gift{}
    static class Phone extends Gift implements Exchangeable,Wrappable{ }
    static class Parcel <T extends Gift & Exchangeable & Wrappable>{  }
    public static void main(String[] args) {
        Parcel<Phone> p = new Parcel<>();
    }

}

package com.riversand;

import java.lang.ref.*;
import java.util.HashMap;
import java.util.WeakHashMap;
import java.util.Map;

public class ObjectReferenceDemo {
    public static void main(String[] args) {

        //weakmap();
        Map<Object, String> strongMap = new HashMap<>();
        Map<Object, String> weakMap = new WeakHashMap<>();

        MyObject key = new MyObject();

        strongMap.put(key, "HashMap Value");
        weakMap.put(key, "WeakHashMap Value");

        System.out.println("Before GC:");
        System.out.println("HashMap: " + strongMap); // {key=HashMap Value}
        System.out.println("WeakHashMap: " + weakMap); // {key=WeakHashMap Value}

        // Remove strong reference
        key = null;
        System.gc();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nAfter GC:");
        System.out.println("HashMap: " + strongMap); // Still contains entry
        System.out.println("WeakHashMap: " + weakMap); // Empty (entry removed)

    }

    private static void weakmap() {
        Map<Object, String> weakMap = new WeakHashMap<>();
        MyObject key1 = new MyObject();
        MyObject key2 = new MyObject();

        // Add entries
        weakMap.put(key1, "Value1");
        weakMap.put(key2, "Value2");

        System.out.println("Before GC: " + weakMap); // {key1=Value1, key2=Value2}

        // Remove strong reference
        key1 = null;

        // Suggest GC to run (not guaranteed)
        System.gc();

        try {
            Thread.sleep(1000); // Give GC time to work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("After GC: " + weakMap); // Only key2 remains (key1 was GC'd)
    }

    private static class MyObject {
        @Override
        public void finalize(){
            System.out.println("Finalize called");
        }
    }

}

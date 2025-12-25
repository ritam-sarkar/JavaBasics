package com.riversand.serialization;

import java.io.*;

public class CyclicDEmo {
    static class A implements Serializable {
        int x = 20;
    }
    public static void main(String[] args) {
        try {
            String filename = "object.ser";

            A a1 = new A();
            System.out.println("Serialized first time: x = " + a1.x);
            a1.x = 30;
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(a1);
            System.out.println("Serialized second time: x = " + a1.x);
            oos.close();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            A a2 = (A) ois.readObject();
            System.out.println("Deserialized object: x = " + a2.x);
            ois.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void serialize(A obj, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(obj);
        }
    }

    private static A deserialize(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (A) ois.readObject();
        }
    }
}

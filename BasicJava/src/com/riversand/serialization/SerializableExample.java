package com.riversand.serialization;


import java.io.*;

public class SerializableExample implements Serializable {
    transient final int x = 1;
    transient final int y = getY();

    private int getY() {
        return 10;
    }

    public int getX() {
        return 2;
    }

    @Override
    public String toString() {
        return "SerializableExample{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.ser"));
        SerializableExample e1 = new SerializableExample();
        System.out.println("before serialization "+e1);
        oos.writeObject(e1);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.ser"));
        SerializableExample e2 = (SerializableExample) ois.readObject();
        ois.close();
        System.out.println("After deserialization "+e2);
        System.out.println(e2.y);//0
        System.out.println(e2.getY());//10
        System.out.println(e2.x);//1
        System.out.println(e2.getX());//2
    }
}

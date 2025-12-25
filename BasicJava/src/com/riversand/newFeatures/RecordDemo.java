package com.riversand.newFeatures;

public class RecordDemo {

    public static void main(String[] args) {
        MyREcord myREcord = new MyREcord("",3,4);

    }
    static record MyREcord(String x , int y , int z){


    }
}

package com.riversand.structural.proxy;

public class MyServiceImpl implements MyService {
    public void doTask() {
        System.out.println("Task executed.");
    }

    public String getData(String key) {
        return "Data for " + key;
    }
}


package com.riversand.beahvioural.observer;

import java.util.concurrent.CopyOnWriteArrayList;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        Channel channel = new Channel();

        Observer alice = new Subscriber("Alice");
        Observer bob = new Subscriber("Bob");

        channel.subscribe(alice);
        channel.subscribe(bob);

        channel.uploadVideo("Multithreaded Design");
        channel.unsubscribe(bob);
        channel.uploadVideo("design pattern");
    }
}
interface Observer {
    void update(String message);
}

// Subject Interface
interface Subject {
    void subscribe(Observer o);
    void unsubscribe(Observer o);
    void notifyObservers(String message);
}

class Channel implements Subject {
    // Thread-safe list for concurrent reads/writes
    private final CopyOnWriteArrayList<Observer> observers = new CopyOnWriteArrayList<>();

    public void subscribe(Observer o) {
        observers.addIfAbsent(o);
    }

    public void unsubscribe(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message); // No need for sync — list is safe
        }
    }

    public void uploadVideo(String title) {
        System.out.println(Thread.currentThread().getName() + " uploaded: " + title);
        notifyObservers("New video: " + title);
    }
}

// Concrete Observer
class Subscriber implements Observer {
    private final String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

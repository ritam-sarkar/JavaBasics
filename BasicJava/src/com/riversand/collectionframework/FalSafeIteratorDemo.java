package com.riversand.collectionframework;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class FalSafeIteratorDemo {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);list.add(2);list.add(3);list.add(4);
        ListIterator<Integer> it = list.listIterator(1);
        System.out.println(it.next());
        System.out.println("removed "+list.remove(2));
        // Even index 2 is removed iterator is still giving as the result on first copy
        System.out.println(it.next());
        // It looses the functionality of remove from iterator
        it.remove();


    }
}

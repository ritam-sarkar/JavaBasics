package com.riversand.collectionframework;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);list.add(20);list.add(30);list.add(40);list.add(50);

        ListIterator<Integer> listIterator = list.listIterator(1);
       /* System.out.println(listIterator.hasPrevious());
        System.out.println(listIterator.previous());*/
        System.out.println(listIterator);
        while (listIterator.hasNext()) {
            int num = listIterator.next();
            if (num == 2) {
                listIterator.remove();       // Remove current
                listIterator.add(20);         // Add after current
            } else if (num == 4) {
                listIterator.set(40);         // Replace current
            }
        }
        // cursor crossed last element so will throw NoSuchElementException
        //System.out.println(listIterator.next());

// Can also traverse backward
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }



    }
}

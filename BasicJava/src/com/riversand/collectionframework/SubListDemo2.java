package com.riversand.collectionframework;

import java.util.ArrayList;
import java.util.List;

public class SubListDemo2 {
    static void main() {
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add(i+1);
        }
        List<Integer> sub1 = list.subList(0,5);
        List<Integer> sub2 = list.subList(7,10);
        sub1.add(20);
        sub1.add(21);
        /*sub2.remove(0);
        System.out.println(sub2.get(0));*/
    }
}

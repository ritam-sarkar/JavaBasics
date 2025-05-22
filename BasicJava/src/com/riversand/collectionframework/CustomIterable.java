package com.riversand.collectionframework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomIterable implements Iterable<Person>{

    PersonIterator personIterator = new PersonIterator();
    @Override
    public Iterator<Person> iterator() {
        return personIterator;
    }
    public void add(Person p){
        personIterator.add(p);
    }
    class PersonIterator implements Iterator<Person>{

        private Person[] persons = new Person[4];
        private int cursor = 0;
        private int i = 0;
        @Override
        public boolean hasNext() {
            return i < cursor;
        }

        @Override
        public Person next() {
            return persons[i++];
        }
        public void add(Person p){
            persons[cursor++] = p;
        }
    }

    public static void main(String[] args) {
        CustomIterable customIterable = new CustomIterable();
        customIterable.add(new Person("A"));
        customIterable.add(new Person("B"));
        customIterable.add(new Person("C"));
        for (Person p : customIterable){
            System.out.println(p.name);
        }
    }

}

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }
}

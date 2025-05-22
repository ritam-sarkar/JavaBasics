package com.riversand.generics.simple;

import java.util.Comparator;

public class UpperBoundDemo {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {

        // Upper bound with one interface
        UpperBound<String> upc = new UpperBound<>();
        upc.test("xyz","XYZ");
        UpperBound<Long> upc2 = new UpperBound<>();
        upc2.test(2L,2L);
        UpperBound<Integer> upc3 = new UpperBound<>();
        upc3.test(1,2);

        // upper bound with multiple interface
        UpperBound2<PhoneComparator> upc4 = new UpperBound2<>();
        upc4.test(new PhoneComparator(), new MobilePhone("rosegold","iphone"),new MobilePhone("grey","iphone"));
        UpperBound2<PhoneComparator> upc5 = new UpperBound2<>();
        upc5.test(new PhoneComparator(), new MobilePhone("grey","android"),new LandPhone("grey","iphone"));



    }
    static class MobilePhone extends Phone{

        public MobilePhone(String color, String brand) {
            super(color, brand);
        }
    }
    static class LandPhone extends Phone {

        public LandPhone(String color, String brand) {
            super(color, brand);
        }
    }
    static class PhoneComparator implements AutoCloseable, Comparator<Phone> {

        @Override
        public void close() throws Exception {
            System.out.println("Calling close");
        }

        @Override
        public int compare(Phone o1, Phone o2) {
            return o1.color.compareTo(o2.color);
        }
    }
    static class UpperBound<T extends Comparable<T> > {
        T t;
        public void test(T t1, T t2){
            int compare = t1.compareTo(t2);
            if(compare == 0){
                System.out.println("Both same");
            } else if(compare > 0){
                System.out.println("t1 > t2");
            } else {
                System.out.println("t1 < t2");
            }
        }

    }
    static class UpperBound2 <T extends AutoCloseable & Comparator<Phone>>{

        public void test(T t, Phone t1, Phone t2) throws Exception {
            t.close();
            int compare = t.compare(t1,t2);
            if(compare == 0){
                System.out.println("Both same");
            } else if(compare > 0){
                System.out.println("phone 1 > phone 2");
            } else {
                System.out.println("phone1  < phone2");
            }
        }
    }
    static class Phone {
        String color;
        String brand;

        public Phone(String color, String brand) {
            this.color = color;
            this.brand = brand;
        }
    }

}

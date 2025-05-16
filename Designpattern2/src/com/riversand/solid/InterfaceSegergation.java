package com.riversand.solid;

/**
 * We can't force an implementaion class to implement all methods
 * better to segregate the abstraction layer , so that reducndant code can be removed
 *
 *  M1  can do print + fax
 *  M2  can do print + fax
 *  M3  can do print + scan
 *  we should not force M1 to implement scan() method
 *
 */
public class InterfaceSegergation {
    interface Machine {
        void print();
        void scan();
        void fax();
    }
    interface Printer {
        void print();
    }

    interface Scanner {
        void scan();
    }

    interface Faxing {
        void fax();
    }

    class Machine1 implements Machine {

        @Override
        public void print() {
            System.out.println("Machine 1 prints");
        }

        @Override
        public void scan() {
          // It cannot scan
        }

        @Override
        public void fax() {
            System.out.println("Machine 1 fax");
        }
    }
    class Machine2 implements Printer,Faxing{

        @Override
        public void print() {
            System.out.println("Machine 2 prints");
        }

        @Override
        public void fax() {
            System.out.println("Machine 2 fax");
        }
    }
    class Machine3 implements Scanner,Printer{

        @Override
        public void print() {
            System.out.println("Machine 3 prints");
        }

        @Override
        public void scan() {
            System.out.println("Machine 3 scan");
        }
    }

}

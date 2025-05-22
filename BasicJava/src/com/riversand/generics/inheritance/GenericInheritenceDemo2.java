/**
 *
 */
package com.riversand.generics.inheritance;

/**
 * @author Ritam
 *
 */
public class GenericInheritenceDemo2 {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // Generic child parcel 1
        GenericChildParcel1<Double, Integer> gkb = new GenericChildParcel1<Double, Integer>();
        gkb.setT(1);
        gkb.setX(2.0);
        gkb.genericMethod1(2, "abc");
        //GenericChildParcel1<String,Integer> gkb2 = new GenericChildParcel1<String,Integer>("str");

        // generic child parcel 2
        GenericChildParcel2<Double> gkb2 = new GenericChildParcel2<>(new Book("Physic", "Dinesh"), 2.0);
        System.out.println(gkb2.x + " | " + gkb2.getOb().author);


    }

    static class GenericChildParcel1<X, T> extends Parcel<T> {

        public void test() {
            System.out.println("test");
        }

        ;

        T t;
        X x;

        public <E> GenericChildParcel1(E e) {
            System.out.println("constructor " + e);
        }

        public GenericChildParcel1() {

        }

        public T getT() {
            return t;
        }


        public void setT(T t) {
            this.t = t;
        }


        public X getX() {
            return x;
        }


        public void setX(X x) {
            this.x = x;
        }


        public <X, V> void genericMethod1(T t, V v) {
            System.out.println("generic method" + v);
            System.out.println("generic method" + t);
            System.out.println("generic method" + x);
        }


    }

    static class GenericChildParcel2<X> extends Parcel<Book> {

        X x;

        public GenericChildParcel2(Book book, X x) {
            super(book);
            this.x = x;
        }

        public X getX() {
            return this.x;
        }

    }

    public static class Parcel<T> {
        protected T ob;

        public Parcel(T ob) {
            super();
            this.setOb(ob);
        }


        public Parcel() {
            super();
            // TODO Auto-generated constructor stub
        }


        public T getOb() {
            return ob;
        }


        public void setOb(T ob) {
            this.ob = ob;
        }


    }
	static class Book {
		String subject;
		String author;

		public Book(String subject, String author) {
			this.subject = subject;
			this.author = author;
		}
	}

}


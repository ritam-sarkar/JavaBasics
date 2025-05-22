/**
 *
 */
package com.riversand.exception;

/**
 * @author Ritam
 *
 */
public class ExceptionDemo1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = new A().method1();
        System.out.println(s);
        System.out.println(new A().method2().a);
		System.out.println(new A().method3());
    }
	static class CustomException extends Exception {

	}

	static class CustomObject {
		int a = 10;
	}

	static class A {
		/**
		 * Flow of execution
		 * 1. find a exception in try block, do not execute anything after that and go to the relevant catch block
		 * 2. After catch block execution go to finally block
		 * 3. If we return anything inside catch block and assign it again in finally block then there will be two copies of the same object.
		 *    If it is a primitive value or immutable class then finally cannot modify the value, if it is an object or mutable class it can modify the value.
		 *
		 *
		 */
		public String method1() {
			String x = null;
			try {
				System.out.println("try block");
				x = "XX";
				throw new CustomException();

			} catch (CustomException e) {
				System.out.println("catch block");
				return x;
			} finally {
				System.out.println("finally");
				x = "YY";
				// Rule1 : If I return here it will return the immidiate assignment of x i.e. YY, otherwise it cannot change x as it is immutable string
				//return x;
			}
		}

		public CustomObject method2() {
			CustomObject ob = new CustomObject();
			try {
				System.out.println("try block");
				ob.a = 11;
				throw new CustomException();
			} catch (CustomException e) {
				System.out.println("catch block");
				return ob;
			} finally {
				System.out.println("finally");
				// Rule2 : customobject in mutable so finally can change the state of the object
				ob.a = 12;
			}
		}
		public int method3() {
			int x = 2;
			try {
				System.out.println("try block");
				x = 11;
				throw new CustomException();
			} catch (CustomException e) {
				System.out.println("catch block");
				x = 12;
				return x;
			} finally {
				System.out.println("finally");
				// Rule3 : just like immutable string int also do the same thing
				x =3;
			}
		}


	}

}



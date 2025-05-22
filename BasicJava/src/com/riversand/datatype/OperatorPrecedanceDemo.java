/**
 * 
 */
package com.riversand.datatype;

/**
 * @author Ritam
 *
 */
public class OperatorPrecedanceDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 *  Postfix(++, --) > unary (?: --a) > multiplication(/ , * %) > summation (+, -) >
		 *  Relation (<, >) > equality (== , !=) > && > || >
		 *  assignment (= , +=)
		 */
		System.out.println(false || false && true && false && true && true || true); // true
		System.out.println(false && true &&  false || false || true || true && false); // true
		System.out.println(true && false || false); // false
		int a = 10;
		int b=12;
		System.out.println(a++ > b && ++b >a || b-- <++a || b++>a-- && a++>b--); // 10 > 12 && 13>11 || 13 < 12 || 12 > 12 && 11 > 13
		System.out.println("a "+a+" b "+b);
		
		

	}

}

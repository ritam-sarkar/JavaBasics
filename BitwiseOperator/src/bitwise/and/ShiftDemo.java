/**
 * 
 */
package bitwise.and;

/**
 * @author Ritam
 *
 */
public class ShiftDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
      int a =13;
      int b = -13;
      int c = a>>2;
      int d = b>>>2;
      int e = a<<2;
      int f = b<<2;
      int g = a>>33;
      int h = a >> 34;
      boolean sameSign = (a>=0) ^(b<=0);
      
      System.out.println(" a>>2 "+c+" b>>>2 "+d);
      System.out.println(" a<<2 "+e+" b<<2 "+f);
      System.out.println(" a>>33 "+g);
      System.out.println(" a>>34 "+h);
      System.out.println(" same sign "+sameSign);
      
	}

}

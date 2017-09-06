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
		// TODO Auto-generated method stub
      int a =13;
      int b = -13;
      int c = a>>2;
      int d = b>>2;
      int e = a<<2;
      int f = b<<2;
      int g = a>>33;
      boolean sameSign = (a>=0) ^(b<=0);
      
      System.out.println(" a>>2 "+c+" b>>2 "+d);
      System.out.println(" a<<2 "+e+" b<<2 "+f);
      System.out.println(" a>>33 "+g);
      System.out.println(" same sign "+sameSign);
      
	}

}

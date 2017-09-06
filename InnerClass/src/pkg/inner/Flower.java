/**
 * 
 */
package pkg.inner;

/**
 * @author Ritam
 *
 */
public class Flower {

	String color = "red";
	Petal[] petals;
	Petal petal;
	
	private class Petal{
		public Petal(){
			System.out.println(Flower.this.color);
		}
		String color = "purple";
		static  final int count =3;		
	}
	Flower(){
		petals = new Petal[2];
		petal = new Petal();
	}
	public static void main(String[] args) {
		new Flower();
	}

}

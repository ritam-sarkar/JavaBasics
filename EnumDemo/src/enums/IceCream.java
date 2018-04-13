/**
 * 
 */
package enums;

/**
 * @author Ritam
 *
 */
public enum IceCream {	
	VANILLA("white"),
	WALLNUT("brown"){
		
		@Override
		public String toString(){
			//inspite of constructor this.color or any other attributes are not accesable here
			return "wallnut is brown in color "+falvour();
		}
		public String falvour(){
			return "great";
		}
	};
	//cannot define before constant declaration
	private String color;
	IceCream(String color){
		this.color = color;
	}
	public String getColor() {
		return color;
	}	
	
}


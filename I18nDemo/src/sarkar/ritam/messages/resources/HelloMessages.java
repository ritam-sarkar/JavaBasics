/**
 * 
 */
package sarkar.ritam.messages.resources;

/**
 * @author ritsarka
 *
 */
public enum HelloMessages {
	
	HELLO("Hellomessages.hello"),
	HI("Hellomessages.hi");
	String value;

	HelloMessages(String value) {
		this.value = value;
	}
	public String value() {
		return this.value;
	}

}
	

/**
 * 
 */
package messages;

/**
 * @author ritsarka
 *
 */
public class CommunicationMessage {
	private String message;
	private boolean fromChild=false;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CommunicationMessage(String message) {
		super();
		this.message = message;
	}

	public boolean isFromChild() {
		return fromChild;
	}

	public void setFromChild(boolean fromChild) {
		this.fromChild = fromChild;
	}

	public CommunicationMessage(String message, boolean fromChild) {
		super();
		this.message = message;
		this.fromChild = fromChild;
	}

}

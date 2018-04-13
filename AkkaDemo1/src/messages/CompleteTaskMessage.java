/**
 * 
 */
package messages;

import java.util.List;

/**
 * @author ritsarka
 *
 */
public class CompleteTaskMessage {
	
	private boolean complete =false;

	public CompleteTaskMessage(boolean complete) {
		super();
		this.complete = complete;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	
	
	
	

	
}

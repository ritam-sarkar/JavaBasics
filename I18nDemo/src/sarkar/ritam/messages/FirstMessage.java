/**
 * 
 */
package sarkar.ritam.messages;

import sarkar.ritam.messages.resources.HelloMessages;

/**
 * @author ritsarka
 *
 */
public class FirstMessage {
	
	private String language = null;
	public FirstMessage(String language) {
		this.language = language;
	}
	public void printMessage() {
		Messages.applyBundleLanguage(this.language);
		System.out.println(Messages.getString(HelloMessages.HELLO.value())); //$NON-NLS-1$
		System.out.println(Messages.getString(HelloMessages.HI.value())); //$NON-NLS-1$
		
	}

}

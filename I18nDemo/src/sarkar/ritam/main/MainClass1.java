/**
 * 
 */
package sarkar.ritam.main;

import java.util.Locale;
import java.util.ResourceBundle;

import sarkar.ritam.messages.FirstMessage;
import sarkar.ritam.messages.Messages;
import sarkar.ritam.messages.resources.HelloMessages;

/**
 * @author ritsarka
 *
 */
public class MainClass1 {

	static final String LANGUAGE = "TR";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FirstMessage firstMessage = new FirstMessage(LANGUAGE);
		firstMessage.printMessage();
		FirstMessage secondMessage = new FirstMessage(null);
		secondMessage.printMessage();
		ResourceBundle resourceBundle = ResourceBundle.getBundle(Messages.BUNDLE_NAME, new Locale(LANGUAGE));
		System.out.println(resourceBundle.getString(HelloMessages.HI.value()));

	}

}

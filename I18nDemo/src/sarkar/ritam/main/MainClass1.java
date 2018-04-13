/**
 * 
 */
package sarkar.ritam.main;

import sarkar.ritam.messages.FirstMessage;

/**
 * @author ritsarka
 *
 */
public class MainClass1 {

	static final String LANGUAGE = "EN";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FirstMessage firstMessage = new FirstMessage(LANGUAGE);
		firstMessage.printMessage();

	}

}

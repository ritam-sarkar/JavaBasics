package sarkar.ritam.messages;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	public static final String BUNDLE_NAME = "sarkar.ritam.messages.resources.messages"; //$NON-NLS-1$

	private static  ResourceBundle RESOURCE_BUNDLE = null; 

	private Messages() {
	}
	public static void applyBundleLanguage(String language) {
		if(language != null && !language.isEmpty()) {
			RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME,new Locale(language));
		}else {
			RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME,new Locale("EN"));
		}
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}

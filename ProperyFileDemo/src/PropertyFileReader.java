import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 */

/**
 * @author Ritam
 *
 */
public class PropertyFileReader {
	
	private Properties properties;
	private InputStream input = null;
	public PropertyFileReader(String filePath) {
		super();
		properties = new Properties();
		try {
			input = new FileInputStream(filePath);
			properties.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException i){
			i.printStackTrace();
		}
	}
	
	public String read(String key){		
		return properties.getProperty(key);
	}
	public boolean getBoolean(String key){
		return Boolean.parseBoolean(read(key));
	}
	public int getInteger(String key){
		return Integer.parseInt(read(key));
	}
	

}

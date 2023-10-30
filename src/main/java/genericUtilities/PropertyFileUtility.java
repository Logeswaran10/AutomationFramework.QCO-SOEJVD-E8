package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class consist of generic method to read the data from property file
 * @author loges
 *
 */

public class PropertyFileUtility {
	
	/**
	 * this method will read the data from property file and return value to the caller
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String Value = p.getProperty(key);
		return Value;
	}

}

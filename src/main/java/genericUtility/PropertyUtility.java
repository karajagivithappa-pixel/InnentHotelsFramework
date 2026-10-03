package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyUtility {
	
	public String getPropertyData(String key) throws Exception {
		FileInputStream fis=new FileInputStream("./src/test/resources/propertyFile.properties");
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
}

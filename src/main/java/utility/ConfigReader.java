package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;
    String configfilepath = System.getProperty("user.dir")+ "//config//file.properties";

	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(configfilepath);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}

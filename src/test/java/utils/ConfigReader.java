package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	static Properties prop;

	public static void initPropertyFile() throws IOException {

		File file = new File("D:\\eclipse-workspace\\corejavalearning\\src\\test\\resources\\config.properties");
		FileInputStream fis = new FileInputStream(file);
		prop = new Properties();
		prop.load(fis);
		fis.close();
	}

	public static String getValue(String key) {
		return prop.getProperty(key);

	}

}

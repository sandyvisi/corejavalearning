package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	static Properties prop;
	static File file;
	static FileInputStream fis;

	public static void initPropertyFile() throws IOException {

		try {
			file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
			fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		} finally {
			fis.close();
		}

	}

	public static String getValue(String key) {
		return prop.getProperty(key);
	}

}

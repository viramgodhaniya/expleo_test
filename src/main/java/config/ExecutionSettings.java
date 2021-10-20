package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ExecutionSettings {
	
	public static String CHROME_DRIVER_PATH;
	public static String IE_DRIVER_PATH;
	public static String EXECUTION_BROWSER;
	public static String CODE_VERSION;
	public static String EXECUTION_ENV;
	
	public static void loadSettings(String executionSettingsFilePath){
		Properties prop = new Properties();
		
		File executionFile = new File(executionSettingsFilePath);
		FileInputStream executionFileStream = null;
		try {
			executionFileStream = new FileInputStream(executionFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(executionFileStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CHROME_DRIVER_PATH = prop.getProperty("chrome.driver.path");
		EXECUTION_BROWSER = prop.getProperty("default.browser");
		CODE_VERSION = prop.getProperty("code.version");
		IE_DRIVER_PATH = prop.getProperty("ie.driver.path");
		EXECUTION_ENV = prop.getProperty("execution.env");
	}
}

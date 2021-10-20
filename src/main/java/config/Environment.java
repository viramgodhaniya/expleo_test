package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Environment {
	
	public String WEB_URL; 
	
	public Environment loadEnv(String envSettingsPath){
		Properties prop = new Properties();
		
		File envFile = new File(envSettingsPath);
		FileInputStream envFileStream = null;
		try {
			envFileStream = new FileInputStream(envFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(envFileStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WEB_URL = prop.getProperty("web.Url");
		
		return this;		
	}
	
	public static Environment getEnvironment(String envFilePath){
		return new Environment().loadEnv(envFilePath);
	}

}

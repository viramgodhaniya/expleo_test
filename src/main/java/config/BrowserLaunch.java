package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserLaunch {

	public static WebDriver launch(){
		
		switch (ExecutionSettings.EXECUTION_BROWSER.toLowerCase()) {
		case "chrome":
			return launchChromeDriver();	
		
		case "ie":
			return launchIeDriver();

		default:
			return launchChromeDriver();			
		}
		
	}
	
	
	public static WebDriver launchChromeDriver(){
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", ExecutionSettings.CHROME_DRIVER_PATH);		
		driver = new ChromeDriver();
		driver.manage().window().maximize();			
		return driver;
	}
	
	public static WebDriver launchIeDriver(){
		WebDriver driver;
		System.setProperty("webdriver.ie.driver", ExecutionSettings.IE_DRIVER_PATH);
		driver = new InternetExplorerDriver();
		return driver;
	}
	
}

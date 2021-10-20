package extend;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonUIFunctions {
	
	public static void click(WebDriver driver, WebElement element, String elementName){		
		element.click();
	}

	public static void sendKeys(WebDriver driver, WebElement element, String textToBeEntered, String elementName){
		element.sendKeys(textToBeEntered);
	}
	
	public static String getText(WebElement element){		
		return element.getText();
	}
}

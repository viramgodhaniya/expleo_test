package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import extend.CommonUIFunctions;

public class XeCurrencyConvertorHomePage {
	
protected WebDriver driver;
	
	public XeCurrencyConvertorHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(id = "amount")
	private WebElement txtbxAmount;
	
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	private WebElement btnAcceptCookiesOK;
	
	@FindBy(id = "from")
	private WebElement txtbxFrom;
	
	@FindBy(id = "to")
	private WebElement txtbxTo;
	
	@FindBy(xpath = "//button[@aria-label='Convert']")
	private WebElement btnConvert;
	
	
	public void acceptCookies(){
		CommonUIFunctions.click(driver, btnAcceptCookiesOK, "Accept Cookies OK");
	}
	
	public void enterConvertionDetails(String amount, String fromCcy, String toCcy){
		CommonUIFunctions.sendKeys(driver, txtbxAmount, amount, "amount");		
		CommonUIFunctions.sendKeys(driver, txtbxFrom, fromCcy, "from");
		txtbxFrom.sendKeys(Keys.RETURN);
		CommonUIFunctions.sendKeys(driver, txtbxTo, toCcy, "to");
		txtbxTo.sendKeys(Keys.RETURN);
	}
	
	public void clickConvertButton(){
		CommonUIFunctions.click(driver, btnConvert, "Convert");
	}

}

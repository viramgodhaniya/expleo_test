package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import extend.CommonUIFunctions;

public class XeCurrencyConvertorConvertionPage {
	
protected WebDriver driver;
	
	public XeCurrencyConvertorConvertionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(className = "converterresult-toAmount")
	private WebElement txtToAmount;
	
	@FindBy(className = "converterresult-toCurrency")
	private WebElement txtToCcy;
	
	@FindBy(className = "converterresult-fromAmount")
	private WebElement txtFromAmount;
	
	@FindBy(className = "converterresult-fromCurrency")
	private WebElement txtFromCcy;
	
	String conversionRate = "//span[contains(text(),'1 @fromCcy@ =')]";
	
	public String getCurrentConvertionRate(String fromCcy){
		WebElement eleConversionRate = driver.findElement(By.xpath(conversionRate.replaceAll("@fromCcy@", fromCcy)));
		return CommonUIFunctions.getText(eleConversionRate);
	}
	
	public String getToAmount(){
		return CommonUIFunctions.getText(txtToAmount);
	}
	
	public String getToCcy(){
		return CommonUIFunctions.getText(txtToCcy);
	}
	
	public String getFromAmount(){
		return CommonUIFunctions.getText(txtFromAmount);
	}
	
	public String getFromCcy(){
		return CommonUIFunctions.getText(txtFromCcy);
	}

}

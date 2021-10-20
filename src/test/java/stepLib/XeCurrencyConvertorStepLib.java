package stepLib;

import java.math.BigDecimal;
import java.math.MathContext;

import org.openqa.selenium.WebDriver;


import config.BrowserLaunch;
import config.Environment;
import junit.framework.Assert;
import pom.XeCurrencyConvertorConvertionPage;
import pom.XeCurrencyConvertorHomePage;
import support.PropertiesLoader;

public class XeCurrencyConvertorStepLib {
	
	public static Environment xeEnv;
	//protected static ExtentTest test;

	static{
		xeEnv = PropertiesLoader.loadAll();
	}
	
	public static WebDriver xeWebDriver;
	public String fromCcy;
	public String toCcy;
	public String amount;

	
	//////////////////////////Step Defn Implementations/////////////////////////////
	
	public void user_is_on_Xe_currency_convertor_Landing_Page(){
		navigateToXeCurrencyConvertorHomePage();
	}
	
	public void user_selects_the_from_currency_as_x_to_currency_as_x_and_amount_as_x(String fromCcy, String toCcy, String amount){
		try{
			this.fromCcy = fromCcy; 
			this.toCcy = toCcy;
			this.amount = amount;
			XeCurrencyConvertorHomePage objXeCurrencyConvertorHomePage = new XeCurrencyConvertorHomePage(xeWebDriver);
			objXeCurrencyConvertorHomePage.acceptCookies();
			objXeCurrencyConvertorHomePage.enterConvertionDetails(amount, fromCcy, toCcy);			
		}catch(Exception e){
			Assert.fail("Error while selecting Convertion Details on Home Page");
		}
	}
	
	public void user_clicks_on_convert_button(){
		XeCurrencyConvertorHomePage objXeCurrencyConvertorHomePage = new XeCurrencyConvertorHomePage(xeWebDriver);
		objXeCurrencyConvertorHomePage.clickConvertButton();
	}
	
	public void user_verifies_the_converted_currency_on_the_proceeding_page(){
		XeCurrencyConvertorConvertionPage objXeCurrencyConvertorConvertionPage = new XeCurrencyConvertorConvertionPage(xeWebDriver);
		String convertionRate = objXeCurrencyConvertorConvertionPage.getCurrentConvertionRate(fromCcy);
		String rate = convertionRate.split("=")[1].trim().split(" ")[0];
		
		MathContext m = new MathContext(6);
		BigDecimal expectedToAmount = new BigDecimal(amount).multiply(new BigDecimal(rate),m);				
		
		Reporter.addStepLog("Verifying 'From Amount': Expected {"+amount+"}. Actual {"+objXeCurrencyConvertorConvertionPage.getFromAmount() + "}");
		Assert.assertEquals(amount, objXeCurrencyConvertorConvertionPage.getFromAmount());
		
		Reporter.addStepLog("Verifying 'From Currency': Expected {"+fromCcy+"}. Actual {"+objXeCurrencyConvertorConvertionPage.getFromCcy() + "}");
		Assert.assertEquals(fromCcy, objXeCurrencyConvertorConvertionPage.getFromCcy());
		
		Reporter.addStepLog("Verifying 'To Amount': Expected {"+expectedToAmount+"}. Actual {"+objXeCurrencyConvertorConvertionPage.getToAmount() + "}");
		Assert.assertEquals(expectedToAmount, new BigDecimal(objXeCurrencyConvertorConvertionPage.getToAmount()));
		
		Reporter.addStepLog("Verifying 'To Currency': Expected {"+toCcy+"}. Actual {"+objXeCurrencyConvertorConvertionPage.getToCcy() + "}");
		Assert.assertEquals(toCcy, objXeCurrencyConvertorConvertionPage.getToCcy());
		
		
	}
	
	public void user_closes_the_web_browser(){
		xeWebDriver.quit();
	}
	
	////////////////////////Step Defn - Library Functions///////////////////////////
	public void navigateToXeCurrencyConvertorHomePage(){
		xeWebDriver = BrowserLaunch.launch();
		xeWebDriver.navigate().to(xeEnv.WEB_URL);	
		
		if(xeWebDriver.getTitle().equals("XE Currency Converter - Live Rates"))			
			Reporter.addStepLog("XE Currency Converter Home Page Loaded Sucessfully");
		else{			
			Reporter.addStepLog("XE Currency Converter Home Page not Loaded Sucessfully");
			Assert.fail("Unable to load XE Currency Converter Home Page");
		}						
	}
}

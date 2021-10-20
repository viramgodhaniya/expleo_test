package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import stepLib.XeCurrencyConvertorStepLib;

public class XeCurrencyConvertorDefn {
	
	XeCurrencyConvertorStepLib objXeCurrencyConvertorStepLib = new XeCurrencyConvertorStepLib();			
	
	@Given("^user is on Xe currency convertor Landing Page$")
	public void user_is_on_Xe_currency_convertor_Landing_Page() throws Throwable {	    
		objXeCurrencyConvertorStepLib.user_is_on_Xe_currency_convertor_Landing_Page();
	}

	@When("^user selects the from currency as '(.+)', to currency as '(.+)' and amount as '(.+)'$")
	public void user_selects_the_from_currency_as_x_to_currency_as_x_and_amount_as_x(String fromCcy, String toCcy, String amount) throws Throwable {
		objXeCurrencyConvertorStepLib.user_selects_the_from_currency_as_x_to_currency_as_x_and_amount_as_x(fromCcy, toCcy, amount);
	}

	@Then("^user clicks on convert button$")
	public void user_clicks_on_convert_button() throws Throwable {	    
		objXeCurrencyConvertorStepLib.user_clicks_on_convert_button();
	}

	@Then("^user verifies the converted currency on the proceeding page$")
	public void user_verifies_the_converted_currency_on_the_proceeding_page() throws Throwable {	    
	    objXeCurrencyConvertorStepLib.user_verifies_the_converted_currency_on_the_proceeding_page();
	}
	
	@Then("^user closes the web browser$")
	public void user_closes_the_web_browser() throws Throwable {	    
		objXeCurrencyConvertorStepLib.user_closes_the_web_browser();
	}


}
